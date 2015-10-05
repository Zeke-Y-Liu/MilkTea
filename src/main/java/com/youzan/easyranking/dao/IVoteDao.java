package com.youzan.easyranking.dao;

import java.util.List;

import com.youzan.easyranking.entity.Vote;

public interface IVoteDao {
	public void saveVotes(List<Vote> voteList);
	public List<Vote> getAllVotes();
}
