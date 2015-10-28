package com.youzan.easyranking.util;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.youzan.easyranking.action.AppInfoBean;
import com.youzan.easyranking.action.UserInfoBean;
import com.youzan.easyranking.entity.Vote;
import com.youzan.easyranking.entity.VoteTimeComparator;

public class MmUtil {
	private static Logger logger = Logger.getLogger(MmUtil.class);
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
	
	public static String getCouponContent(List<Vote> voteList, UserInfoBean userInfo, AppInfoBean appInfo) {
		String result = "";
		String couponResopnse = "";
		String couponUrl = "";
		try {
			if(StringUtils.isBlank(userInfo.getOpenId())) {
				result = "<div class=\"apply\" style=\"background: rgb(255,193,37);\"><p style=\"color: rgb(226,131,151);\">您未关注微信公众号,无法获得优惠券</p><div class=\"blank10\"></div>";
			} else {
				if (voteList.size() >= 5) {
					couponUrl = appInfo.getCouponUrls().get(4);
				} else {
					couponUrl = appInfo.getCouponUrls().get(voteList.size() - 1);
				}
				CloseableHttpClient httpclient = HttpClients.createDefault();
				HttpGet httpGet = new HttpGet(couponUrl);
				CloseableHttpResponse response = httpclient.execute(httpGet);
				couponResopnse = EntityUtils.toString(response.getEntity(), "UTF-8");
				if (couponResopnse.contains("<body class=\" promocard\">")
						&& couponResopnse.contains("<div class=\"text-center\">")) {
					result = couponResopnse.substring(couponResopnse.indexOf("<body class=\" promocard\">"),
							couponResopnse.indexOf("<div class=\"text-center\">"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn(e);
		}
		return result;
	}
	
}
