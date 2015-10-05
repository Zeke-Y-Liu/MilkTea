package com.youzan.easyranking.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import com.youzan.easyranking.entity.WeiXinUser;

public class WeiXinUserDao implements  IWeiXinUserDao {
	private static Logger logger = Logger.getLogger(VoteDao.class);
	private SessionFactory sessionFactory;  
	   
    public SessionFactory getSessionFactory() {  
        return sessionFactory;  
    }  
    public void setSessionFactory(SessionFactory sessionFactory) {  
        this.sessionFactory = sessionFactory;  
    } 
	public void saveUsers(List<WeiXinUser> userList) {
		logger.info("VoteDao:saveVotes:size=" + userList.size());
		for(WeiXinUser user : userList) {
			sessionFactory.getCurrentSession().save(user);
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllUserOpenIds() {
		List<String> allUserOpenIds = sessionFactory.getCurrentSession().createQuery("SELECT openId FROM WeiXinUser").list();
		logger.info("Total open id count: " + allUserOpenIds.size());
		return allUserOpenIds;
	}
}
