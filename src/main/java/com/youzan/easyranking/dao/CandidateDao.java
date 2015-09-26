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
	public Candidate getCandidate(long id) {
		return sessionFactory.openSession().get(Candidate.class, id);
	}

}
