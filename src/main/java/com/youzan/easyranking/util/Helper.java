package com.youzan.easyranking.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.youzan.easyranking.entity.Candidate;
import com.youzan.easyranking.vo.CandidateVo;

public class Helper {
	private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
	
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
	
	public static CandidateVo toCandidateVo(Candidate candidate) {
		CandidateVo candidateVo = new CandidateVo();
		candidateVo.setId(candidate.getId());
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
	
	public static Candidate toCandidate(CandidateVo candidateVo) {
		Candidate candidate = new Candidate();
		candidate.setAge(candidateVo.getAge());
		candidate.setCandidateName(candidateVo.getCandidateName());
		candidate.setHeight(candidateVo.getHeight());
		candidate.setImageFileName(candidateVo.getImageFileName());
		candidate.setPhoneNumber(candidateVo.getPhoneNumber());
		candidate.setPoll(candidateVo.getPoll());
		candidate.setSelfRemark(candidateVo.getSelfRemark());
		candidate.setVoteAllowed(candidateVo.isVoteAllowed());
		return candidate;
	}
	
	public static List<CandidateVo> fromCandidateList(List<Candidate> candidateList) {
		List<CandidateVo> candidateVoList = new ArrayList<CandidateVo>();
		for(Candidate candiate : candidateList) {
			candidateVoList.add(toCandidateVo(candiate));
		}
		return candidateVoList;
	}

  public static Date fromDateString(String dateString) throws ParseException {
	return df.parse(dateString);
  }
	
}
