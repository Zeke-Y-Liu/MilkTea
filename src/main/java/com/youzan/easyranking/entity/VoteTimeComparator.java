package com.youzan.easyranking.entity;

import java.util.Comparator;
/**
 * 
 * @author Administrator
 * compare the two vote, the latest one wins
 *
 */
public class VoteTimeComparator implements Comparator<Vote> {

	@Override
	public int compare(Vote v1, Vote v2) {
		return (int)(v2.getVoteTime().getTime() - v1.getVoteTime().getTime());
	}
	
}
