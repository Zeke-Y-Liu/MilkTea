package com.youzan.easyranking.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.CharSet;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.youzan.easyranking.cache.CacheManager;

public class CouponAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(CouponAction.class);
	private CacheManager cacheManager;

	public String coupon() {
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse externalResponse = null;
		try {
			httpclient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet("http://wap.koudaitong.com/v2/ump/promocard/fetch?alias=l2r13mgn");
			externalResponse = httpclient.execute(httpGet);
			HttpServletResponse response = ServletActionContext.getResponse();
			String content = EntityUtils.toString(externalResponse.getEntity());
			String partContent = content.substring(content.indexOf("<body class=\" promocard\">"), content.indexOf("<div class=\"text-center\">"));
			response.getWriter().append(partContent);
			response.getWriter().flush();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			try {
				 externalResponse.close();
			} catch (IOException ioe) {
				logger.error(ioe);
			}
		}

		return SUCCESS;
	}

	public CacheManager getCacheManager() {
		return cacheManager;
	}

	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

}
