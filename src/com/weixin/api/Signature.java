package com.weixin.api;

import com.weixin.data.TicketBean;
import com.weixin.data.WeiXinApiBean;

/**
 * 签名算法
 * 
 * @author 小彬
 * 
 */
public class Signature {

	public static WeiXinApiBean instance(TicketBean ticketBean, String url) {
		String noncestr = Noncestr.getUUID();
		String jsapi_ticket = ticketBean.getTicket();
		String timestamp = ticketBean.getExpires_in();

		String string1 = "jsapi_ticket=" + jsapi_ticket + "&noncestr="
				+ noncestr + "&timestamp=" + timestamp + "&url=" + url;

		String signature = SHA1.getSha1(string1);

		WeiXinApiBean weiXinApi = new WeiXinApiBean();
		weiXinApi.setAppId(ticketBean.getAppId());
		weiXinApi.setNoncestr(noncestr);
		weiXinApi.setTimestamp(timestamp);
		weiXinApi.setSignature(signature);
		return weiXinApi;
	}

	public static void main(String[] args) {
		TicketBean ticketBean = Ticket.instance("appid", "secret");
		WeiXinApiBean weiXinApi = Signature.instance(ticketBean, "url");
		System.out
				.println("-------------------------------------------------------------------------------");
		System.out.println("appId:" + "appid");
		System.out.println("nonceStr:" + weiXinApi.getNoncestr());
		System.out.println("signature:" + weiXinApi.getSignature());
		System.out.println("timestamp:" + weiXinApi.getTimestamp());
	}
}
