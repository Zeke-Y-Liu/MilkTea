package com.youzan.easyranking.dao;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import com.youzan.easyranking.entity.WeiXinTag;
import com.youzan.easyranking.entity.WeiXinUser;

public class WeiXinUserDaoTest {

//	@Test
//	public void testSaveWeiXinUsers() {
//		WeiXinUser user1 = new WeiXinUser();
//		user1.setAvatar("test1 avatar");
//		user1.setCity("test1 浦东");
//		user1.setFollowTime(new Date());
//		user1.setGender("F");
//		user1.setNickName("test1 nickName");
//		user1.setOpenId("test1 OpenId");
//		user1.setPronvice("test1 上海");
//		user1.setUnionId("test1 unionId");
//		user1.setUserId(1L);
//		
//		WeiXinTag tag1 = new WeiXinTag();
//		tag1.setTagName("test1 tagName");
//		tag1.setWeiXinUser(user1);
//		
//		WeiXinTag tag2 = new WeiXinTag();
//		tag2.setTagName("test1 tagName");
//		tag2.setWeiXinUser(user1);
//		user1.getTags().add(tag1);
//		user1.getTags().add(tag2);
//		
//		WeiXinUser user2 = new WeiXinUser();
//		user2.setAvatar("test2 avatar");
//		user2.setCity("test2 浦东");
//		user2.setFollowTime(new Date());
//		user2.setGender("F");
//		user2.setNickName("test3 nickName");
//		user2.setOpenId("test3 OpenId");
//		user2.setPronvice("test3 上海");
//		user2.setUnionId("test3 unionId");
//		user2.setUserId(2L);
//		List<WeiXinUser> weiXinUserList = new ArrayList<WeiXinUser>();
//		weiXinUserList.add(user1);
//		weiXinUserList.add(user2);
//		ApplicationContext ctx = new  ClassPathXmlApplicationContext("applicationContext.xml"); 
//		IWeiXinUserDao  weiXinUserDao = (IWeiXinUserDao)ctx.getBean("weiXinUserDao"); 
//		weiXinUserDao.saveUsers(weiXinUserList);
//		
//		List<WeiXinUser> allWeiXinUserList=weiXinUserDao.getAllWeiXinUsers();
//		for(WeiXinUser u : allWeiXinUserList) {
//			try {
//				System.out.println(new String(u.toString().getBytes("utf8")));
//			} catch (UnsupportedEncodingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//	}
	
}
