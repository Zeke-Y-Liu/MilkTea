package com.youzan.easyranking.entity;

import java.util.Comparator;

public class CandidatePollComparator implements Comparator<Candidate> {

	@Override
	public int compare(Candidate c1, Candidate c2) {
		return c2.getPoll() - c1.getPoll();
	}

}
