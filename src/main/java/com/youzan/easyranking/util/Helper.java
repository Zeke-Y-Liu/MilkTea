package com.youzan.easyranking.util;

import java.util.ArrayList;
import java.util.List;

import com.youzan.easyranking.entity.Candidate;
import com.youzan.easyranking.vo.CandidateVo;

public class Helper {

	public static void copyCandidate(Candidate toCandidate, Candidate fromCandidate) {
		toCandidate.setAge(fromCandidate.getAge());
		toCandidate.setCandidateName(fromCandidate.getCandidateName());
		toCandidate.setGender(fromCandidate.getGender());
		toCandidate.setHeight(fromCandidate.getHeight());
		toCandidate.setImageFileName(fromCandidate.getImageFileName());
		toCandidate.setJob(fromCandidate.getJob());
		toCandidate.setPhoneNumber(fromCandidate.getPhoneNumber());
		toCandidate.setPoll(fromCandidate.getPoll());
		toCandidate.setSelfRemark(fromCandidate.getSelfRemark());
		toCandidate.setStatus(fromCandidate.getStatus());
		toCandidate.setVoteAllowed(fromCandidate.isVoteAllowed());
		toCandidate.setWeight(fromCandidate.getWeight());
	}	
	
	public static CandidateVo copyCandidateToVo(Candidate candidate) {
		CandidateVo candidateVo = new CandidateVo();
		candidateVo.setAge(candidate.getAge());
		candidateVo.setCandidateName(candidate.getCandidateName());
		candidateVo.setHeight(candidate.getHeight());
		candidateVo.setImageFileName(candidate.getImageFileName());
		candidateVo.setPhoneNumber(candidate.getPhoneNumber());
		candidateVo.setPoll(candidate.getPoll());
		candidateVo.setSelfRemark(candidate.getSelfRemark());
		candidateVo.setVoteAllowed(candidate.isVoteAllowed());
		return candidateVo;
	}
	
	public static List<CandidateVo> fromCandidateList(List<Candidate> candidateList) {
		List<CandidateVo> candidateVoList = new ArrayList<CandidateVo>();
		for(Candidate candiate : candidateList) {
			candidateVoList.add(copyCandidateToVo(candiate));
		}
		return candidateVoList;
	}

}
