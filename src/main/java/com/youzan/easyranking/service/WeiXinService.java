package com.youzan.easyranking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.youzan.easyranking.entity.WeiXinUser;

public class WeiXinService {

	public List<WeiXinUser> getUsersInfo(Set<String> userOpenIdSet) {
		WeiXinUser user = new WeiXinUser();
		user.setOpenId("tetOpenId");
		user.setNickName("nickName");
		return new ArrayList<WeiXinUser>();
	}
}
