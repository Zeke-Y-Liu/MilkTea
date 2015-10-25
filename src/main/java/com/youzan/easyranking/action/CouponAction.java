package com.youzan.easyranking.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.youzan.easyranking.entity.Vote;
import com.youzan.easyranking.util.MmUtil;

public class CouponAction extends AbstractBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(CouponAction.class);

	public String coupon() {
		HttpServletResponse response = ServletActionContext.getResponse();
		List<Vote> voteList = cacheManager.getVoteForUser(userInfo);
		String couponContent = MmUtil.getCouponContent(voteList, userInfo, appInfo);
		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().append(couponContent);
			response.getWriter().flush();
		} catch (IOException e) {
			logger.warn(e);
		}
		return SUCCESS;
	}
}
