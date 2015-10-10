package com.youzan.easyranking.util;

import com.youzan.easyranking.entity.Candidate;

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
		toCandidate.setVoted(fromCandidate.isVoted());
		toCandidate.setWeight(fromCandidate.getWeight());
	}
	
}
