package com.youzan.easyranking.dao;

import java.util.List;

import com.youzan.easyranking.entity.Candidate;

public interface ICandidateDao {

	public void save(Candidate candidate);
	public Candidate getCandidate(long id);
	
}
