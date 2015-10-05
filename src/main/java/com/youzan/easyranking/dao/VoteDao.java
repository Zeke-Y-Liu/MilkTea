package com.youzan.easyranking.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import com.youzan.easyranking.entity.Vote;

public class VoteDao implements IVoteDao {
	private static Logger logger = Logger.getLogger(VoteDao.class);
	private SessionFactory sessionFactory;  
	   
    public SessionFactory getSessionFactory() {  
        return sessionFactory;  
    }  
    public void setSessionFactory(SessionFactory sessionFactory) {  
        this.sessionFactory = sessionFactory;  
    } 
	public void saveVotes(List<Vote> voteList) {
		logger.info("VoteDao:saveVotes:size=" + voteList.size());
		for(Vote vote : voteList) {
			sessionFactory.getCurrentSession().save(vote);
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Vote> getAllVotes() {
		List<Vote> result =  (sessionFactory.getCurrentSession().createQuery("FROM Vote").list());
		logger.info("Total " + result.size() + " Votes loaded");
		return result;
	}
}
