package com.youzan.easyranking.cache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

import com.google.common.collect.ArrayListMultimap;
import com.youzan.easyranking.action.UserInfoBean;
import com.youzan.easyranking.dao.ICandidateDao;
import com.youzan.easyranking.dao.IVoteDao;
import com.youzan.easyranking.dao.IWeiXinUserDao;
import com.youzan.easyranking.entity.Candidate;
import com.youzan.easyranking.entity.CandidatePollComparator;
import com.youzan.easyranking.entity.Vote;
import com.youzan.easyranking.service.WeiXinService;
/**
 * 
 * @author Administrator
 * 
 * The basic idea here is that:
 * all the data manipulation from ui will go to data cache, and not DB.
 * another thread will synchronize data cache with DB in batch when 
 * 1. data changes exceeds pre-defined number
 * OR
 * 2. time interval from last synchronization exceeds pre-defined number 
 *
 */
public class CacheManager {
	private static Logger logger = Logger.getLogger(CacheManager.class);
	private ICandidateDao candidateDao;
	private IVoteDao voteDao;
	private IWeiXinUserDao weiXinUserDao;
	private WeiXinService weiXinService;
	private static CacheManager instance = new CacheManager();
	private CacheManager() {
	}
	
	public static CacheManager getInstance() {
		return instance;
	}
	
	private Map<Long, Candidate> candiatePkMap = Collections.synchronizedMap(new HashMap<Long,Candidate>());
			
	// all vote activities, many to many relationship between users and candidates
	// we assume one user can vote for a candidate for more than one time
	//In this circumstance, clearly we differentiate a new user-candidate relationship and
	// and voting up for multiple times. I think for different cases, we can either insert a new row into DB or
	// update and existing vote relationship with DB PK.
	private ArrayListMultimap<String, Vote> allVoteKeyMap = ArrayListMultimap.create();
	
	// for each user vote, we create a new vote object. The data synchronizer will merge the vote with all vote in data cache and then 
	// synchronize the change into DB 
	// why blocking queue here? think about the policy of synchronize data to DB
	// 1. when change repeat some times
	// 2 . Or when specific time interval since last synchronization elapses 
	private BlockingQueue<Vote> newVotes = new LinkedBlockingQueue<Vote>();
	
	// all existing user ids
	private Set<String> userOpenIdSet = Collections.synchronizedSet(new HashSet<String>());
	
	private List<Vote> allVoteList = Collections.synchronizedList(new ArrayList<Vote>());
	
	public synchronized void initCache() {
		logger.info("CacheManager::initCache");
		
		logger.info("CacheManager::initCache::load candidates");
		Set<Candidate> initCandiateSet = new HashSet<Candidate>(candidateDao.getAllCandidates());
		logger.info("CacheManager::initCache::load votes");
		allVoteList = voteDao.getAllVotes();
		logger.info("CacheManager::initCache::load weixin user open Ids");
		Set<String> initUserOpenIdSet = new HashSet<String>(weiXinUserDao.getAllUserOpenIds());
		candiatePkMap.clear();
		for(Candidate candidate : initCandiateSet) {
			candiatePkMap.put(candidate.getId(), candidate);
		}
		allVoteKeyMap.clear();
		for(Vote vote : allVoteList) {
			allVoteKeyMap.put(vote.getVoteKey(), vote);
		}
		userOpenIdSet.clear();
		userOpenIdSet.addAll(initUserOpenIdSet);
		//kick off synchronizing thread here
		Executors.newSingleThreadExecutor().submit(new VoteSynchronizer(this));		
	}
	
	// add to blocking queue, no need to be synchronized
	// but when update the candidate poll, need to be synchronized
	public synchronized Candidate addNewVote(Vote vote){
		Candidate candidate = candiatePkMap.get(vote.getCandidateId());
		candidate.setPoll(candidate.getPoll() +1);
		newVotes.add(vote);
		return candidate;
	}

	// after 
	public synchronized void afterFlush(List<Vote> synchedVoteList) {
		for(Vote vote : synchedVoteList) {
			allVoteList.add(vote);
			allVoteKeyMap.put(vote.getVoteKey(), vote);
			userOpenIdSet.add(vote.getUserOpenId());
		}
	}
	
	// to avoid concurrent modification exception
	public synchronized List<Candidate> getAllCandiateList() {
		List<Candidate> result = new ArrayList<Candidate>(candiatePkMap.values());
		Collections.sort(result, new CandidatePollComparator());
		return result;
	}
	
	public synchronized Candidate getCandidateById(Long candidateId) {
		return candiatePkMap.get(candidateId);
	}
	
	public synchronized void register(Candidate candidate) {
		candidateDao.save(candidate);
		candiatePkMap.put(candidate.getId(), candidate);
	}
	
	public synchronized void updateCandidate(Candidate candidate) {
		candidateDao.updateCandidate(candidate);
		candiatePkMap.put(candidate.getId(), candidate);
	}
	
	public synchronized Set<String> getUserOpenIdSet() {
		return new HashSet<String>(userOpenIdSet);
	}
	

	public synchronized List<Vote> getVoteForUser(UserInfoBean userInfo) {
		return allVoteKeyMap.get(userInfo.getVoteKey());
	}
	
	public synchronized ICandidateDao getCandidateDao() {
		return candidateDao;
	}

	public synchronized IVoteDao getVoteDao() {
		return voteDao;
	}

	public synchronized void setVoteDao(IVoteDao voteDao) {
		this.voteDao = voteDao;
	}

	public synchronized void setCandidateDao(ICandidateDao candidateDao) {
		this.candidateDao = candidateDao;
	}

	public synchronized BlockingQueue<Vote> getNewVotes() {
		return newVotes;
	}

	public IWeiXinUserDao getWeiXinUserDao() {
		return weiXinUserDao;
	}

	public void setWeiXinUserDao(IWeiXinUserDao weiXinUserDao) {
		this.weiXinUserDao = weiXinUserDao;
	}

	public WeiXinService getWeiXinService() {
		return weiXinService;
	}

	public void setWeiXinService(WeiXinService weiXinService) {
		this.weiXinService = weiXinService;
	}

	public List<Vote> getAllVoteList() {
		return allVoteList;
	}

	public void setAllVoteList(List<Vote> allVoteList) {
		this.allVoteList = allVoteList;
	}	
	
}
