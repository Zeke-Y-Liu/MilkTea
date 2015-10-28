package com.youzan.easyranking.util;

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

public class WeiXinUtil {
	private static Logger logger = Logger.getLogger(WeiXinUtil.class);
	public static String PARAM_OPEN_IDS="weixin_openids";
	public static List<WeiXinUser> getWeiXinUsersByOpenIds(String weixinKey, String weiXinSecret,  Set<String> openIds) {
		List<WeiXinUser> result = new ArrayList<WeiXinUser>();
		if(openIds == null || openIds.size() == 0) {
			return result;
		}
		try {
			KdtApiClient kdtClient = new KdtApiClient(weixinKey,weiXinSecret);
			StringBuffer openIdBuffer = new StringBuffer();
			for(String id : openIds) {
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
			logger.error(e.getMessage());
		}
		return result;
	}
}
