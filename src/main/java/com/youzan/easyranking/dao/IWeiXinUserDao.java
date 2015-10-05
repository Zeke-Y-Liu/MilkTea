package com.youzan.easyranking.dao;

import java.util.List;

import com.youzan.easyranking.entity.WeiXinUser;

public interface IWeiXinUserDao {

	public void saveUsers(List<WeiXinUser> userList);
	public List<String> getAllUserOpenIds();
}
