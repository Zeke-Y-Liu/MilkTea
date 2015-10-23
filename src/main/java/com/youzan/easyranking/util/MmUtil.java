package com.youzan.easyranking.util;

import java.util.Collections;
import java.util.List;

import com.youzan.easyranking.action.AppInfoBean;
import com.youzan.easyranking.action.UserInfoBean;
import com.youzan.easyranking.entity.Vote;
import com.youzan.easyranking.entity.VoteTimeComparator;

public class MmUtil {
	public static boolean isVoteAllowed(List<Vote> voteList, UserInfoBean userInfo, AppInfoBean appInfo) {
		Vote lastVote = null;
		if(voteList != null && voteList.size() > 0) {
			Collections.sort(voteList, new VoteTimeComparator());
			lastVote = voteList.get(0);
		}
		long voteInterval = 0;
		if (userInfo.isAnonymous()) {
			if (!appInfo.isAnonymousAllowed()) {
				return false;
			} else {
				voteInterval = appInfo.getAnonymousVoteInternal();
			}
		} else {
			voteInterval = appInfo.getVoteInterval();
		}
		if (lastVote == null) { // never voted before
			return true;
		} else {
			return System.currentTimeMillis() - lastVote.getVoteTime().getTime() > voteInterval;
		}
	}
}
