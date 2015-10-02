package com.youzan.easyranking.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import com.youzan.easyranking.entity.Candidate;

public class CandidateDao implements ICandidateDao {
	private static Logger logger = Logger.getLogger(ICandidateDao.class);
	private SessionFactory sessionFactory;  
	   
    public SessionFactory getSessionFactory() {  
        return sessionFactory;  
    }  
    public void setSessionFactory(SessionFactory sessionFactory) {  
        this.sessionFactory = sessionFactory;  
    }  
	
	public void save(Candidate candidate) {
		sessionFactory.getCurrentSession().save(candidate);
	}

	public Candidate getCandidateById(long id) {
		return sessionFactory.getCurrentSession().get(Candidate.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Candidate> getAllCandidates() {
		List<Candidate> result =  (List<Candidate>)(sessionFactory.getCurrentSession().createQuery("FROM Candidate ORDER BY poll ").list());
		logger.info("Total " + result.size() + " candidate loaded");
		return result;
	}
	public long getTotalCandidateCount() {
		long totalCandidateCount = (Long)sessionFactory.getCurrentSession().createQuery("SELECT COUNT(*) FROM Candidate").uniqueResult();
		logger.info("Total candidate count: " + totalCandidateCount);
		return totalCandidateCount;
	}
	@Override
	public void updateCandidate(Candidate candidate) {
		logger.info("Candidate poll: " + candidate.getPoll());
		sessionFactory.getCurrentSession().merge(candidate);
	}
}
