package com.youzan.easyranking.util;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;
import com.youzan.easyranking.entity.WeiXinUser;

public class WeiXinUtilTest {


	@Test
	public void testGetWeiXinUsersByOpenIds() {
		String weixinKey = "e160c63a7c40d4a690";
		String weiXinSecret = "6ebaec64bdae15b8b5c939edf4e789f8";
		Set<String> openIds = new HashSet<String>();
		openIds.add("oXkM9sxi0EhO2GXq0KWUOtaEzuDs");
		List<WeiXinUser> weiXinUserList = WeiXinUtil.getWeiXinUsersByOpenIds(weixinKey, weiXinSecret, openIds);
		Assert.assertTrue(weiXinUserList.get(0).getOpenId().equalsIgnoreCase("oXkM9sxi0EhO2GXq0KWUOtaEzuDs"));
	}
	
}
