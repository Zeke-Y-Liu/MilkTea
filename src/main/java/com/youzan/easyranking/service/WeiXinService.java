package com.youzan.easyranking.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import com.kdt.api.KdtApiClient;
import com.youzan.easyranking.entity.WeiXinTag;
import com.youzan.easyranking.entity.WeiXinUser;
import com.youzan.easyranking.util.Helper;

public class WeiXinService {
	private static Logger logger = Logger.getLogger(WeiXinService.class);
	public static String PARAM_OPEN_IDS="weixin_openids";
	
	private String weixinKey="";
	private String weiXinSecret="";
	
	public String getWeixinKey() {
		return weixinKey;
	}
	public void setWeixinKey(String weixinKey) {
		this.weixinKey = weixinKey;
	}
	public String getWeiXinSecret() {
		return weiXinSecret;
	}
	public void setWeiXinSecret(String weiXinSecret) {
		this.weiXinSecret = weiXinSecret;
	}
	
	public List<WeiXinUser> getUsersInfo(Set<String> userOpenIdSet) {
		
		List<WeiXinUser> result = new ArrayList<WeiXinUser>();
		if(userOpenIdSet == null || ( (userOpenIdSet.remove("") || userOpenIdSet.remove(null) || true) && userOpenIdSet.size() == 0 )) {
			return result;
		}
		try {
			KdtApiClient kdtClient = new KdtApiClient(weixinKey,weiXinSecret);
			StringBuffer openIdBuffer = new StringBuffer();
			for(String id : userOpenIdSet) {
				openIdBuffer.append(id).append(",");
			}
			openIdBuffer.setLength(openIdBuffer.length()-1);
			HashMap<String, String> params = new HashMap<String, String>();
			params.put("weixin_openids", openIdBuffer.toString());
			CloseableHttpResponse response = kdtClient.post("kdt.users.weixin.follower.gets", params, null, null);
			String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
			JSONObject jsonObj = new JSONObject(jsonStr);
			JSONObject responseObj = jsonObj.getJSONObject("response");
			JSONArray jsonUserList = responseObj.getJSONArray("user");
			for(int i=0; i < jsonUserList.length(); i ++) {
				JSONObject jsonUser = jsonUserList.getJSONObject(i);
				WeiXinUser user = new WeiXinUser();
				user.setUserId(jsonUser.getLong("user_id"));
				user.setOpenId(jsonUser.getString("weixin_openid"));
				user.setCity(jsonUser.getString("city"));
				user.setAvatar(jsonUser.getString("avatar"));
				user.setFollowTime(Helper.fromDateString(jsonUser.getString("follow_time")));
				user.setGender(jsonUser.getString("sex"));
				user.setPronvice(jsonUser.getString("province"));
				user.setUnionId(jsonUser.getString("union_id"));
				JSONArray jsonTagList = jsonUser.getJSONArray("tags");
				for(int j=0; j < jsonTagList.length(); j ++) {
					JSONObject jsonTag = jsonTagList.getJSONObject(i);
					WeiXinTag tag = new WeiXinTag();
					tag.setWeiXinUser(user);
					tag.setTagName(jsonTag.getString("name"));
					user.getTags().add(tag);
				}
				result.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("getUsersInfo", e);
		}
		return result;
	}
}
