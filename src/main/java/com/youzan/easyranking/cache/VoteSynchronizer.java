package com.youzan.easyranking.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import com.youzan.easyranking.entity.Vote;
import com.youzan.easyranking.entity.WeiXinUser;
public class VoteSynchronizer implements Runnable {
	private static Logger logger = Logger.getLogger(VoteSynchronizer.class);
	private CacheManger cache;
	private List<Vote> voteList = new ArrayList<Vote>();
	private long lastsynchTime = System.currentTimeMillis();
	
	public VoteSynchronizer(CacheManger cache) {
		this.cache = cache;
	}
	
	@Override
	public void run() {
		while(true) {
			// this working thread has be to very robust
			try {
				Vote vote = null;
				try {
					logger.info("VoteSynchronizer:run:poll vote from cache queue");
					vote = cache.getNewVotes().poll(10*1000, TimeUnit.MILLISECONDS);
				} catch (InterruptedException e) {
					logger.error(e);
				}
				// last synchronization occurs 30 seconds before OR there are more than 100 votes
				if(vote != null ) {
					voteList.add(vote);
				}
				if(voteList.size() > 10 || (voteList.size() > 0 && System.currentTimeMillis() - lastsynchTime >= 30*1000)) {
					logger.info("VoteSynchronizer:run:flushing votes");
					flushVotes();
					lastsynchTime = System.currentTimeMillis();
				}
				
			} catch( Exception any) {
				logger.error(any);
			}
		}
	}
	
	private void flushVotes() {
		Set<String> existingUserIdSet = cache.getUserOpenIdSet();
		Set<String> newUserIdSet = new HashSet<String>();
		Map<Long, Long> candidatePKPollMap = new HashMap<Long,Long>(); 
		for(Vote vote : voteList) {
			if(!existingUserIdSet.contains(vote.getUserOpenId())) {
				newUserIdSet.add(vote.getUserOpenId());
			}
			if(candidatePKPollMap.get(vote.getCandidateId()) == null) {
				candidatePKPollMap.put(vote.getCandidateId(), 1L);
			} else {
				candidatePKPollMap.put(vote.getCandidateId(),candidatePKPollMap.get(vote.getCandidateId()) +1);
			}
		}
		logger.info("VoteSynchronizer:run:save votes");
		cache.getVoteDao().saveVotes(voteList);
		voteList.clear();
		// update candidate
		logger.info("VoteSynchronizer:run:updaet candidates:" + candidatePKPollMap);
		cache.getCandidateDao().updateCandidatePolls(candidatePKPollMap);
		// save new users
		List<WeiXinUser> userList = cache.getWeiXinService().getUsersInfo(newUserIdSet);
		cache.getWeiXinUserDao().saveUsers(userList);
		// update cache with synched data, DB generated PKs
		cache.afterFlush(voteList);
	}
}
