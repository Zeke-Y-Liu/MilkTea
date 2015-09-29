package com.youzan.easyranking.dao;

import java.util.List;

import com.youzan.easyranking.entity.Candidate;

public interface ICandidateDao {

	public void save(Candidate candidate);
	public Candidate getCandidateById(long id);
	public List<Candidate> getAllCandidates();
	public long getTotalCandidateCount();
	public void updateCandidate(Candidate candidate);
}
