package com.youzan.easyranking.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.youzan.easyranking.entity.Candidate;

public class CandidateDao implements ICandidateDao {

	private SessionFactory sessionFactory;  
	   
    public SessionFactory getSessionFactory() {  
        return sessionFactory;  
    }  
    public void setSessionFactory(SessionFactory sessionFactory) {  
        this.sessionFactory = sessionFactory;  
    }  
	
	@Override
	public void save(Candidate candidate) {
		sessionFactory.openSession().save(candidate);
	}

	@Override
	public Candidate getCandidateById(long id) {
		return sessionFactory.openSession().get(Candidate.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Candidate> getAllCandidates() {
		return (List<Candidate>)(sessionFactory.openSession().createQuery("FROM Candidate ORDER BY poll ").list());
	}
	@Override
	public long getTotalCandidateCount() {
		return (Long)sessionFactory.openSession().createQuery("SELECT COUNT(*) FROM Candidate").uniqueResult();
	}

}
