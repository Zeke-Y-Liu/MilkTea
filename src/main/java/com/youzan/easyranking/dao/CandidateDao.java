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
	
	public void save(Candidate candidate) {
		sessionFactory.openSession().save(candidate);
	}

	public Candidate getCandidateById(long id) {
		return sessionFactory.openSession().get(Candidate.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Candidate> getAllCandidates() {
		return (List<Candidate>)(sessionFactory.openSession().createQuery("FROM Candidate ORDER BY poll ").list());
	}
	public long getTotalCandidateCount() {
		return (Long)sessionFactory.openSession().createQuery("SELECT COUNT(*) FROM Candidate").uniqueResult();
	}

}
