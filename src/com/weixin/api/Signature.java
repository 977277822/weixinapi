package com.weixin.api;

import com.weixin.data.TicketBean;

public class Signature {
	
	public static WeiXinApi instace(String appid, String secret , String url){
		TicketBean ticketBean = Ticket.instance(appid, secret);
		String noncestr = Noncestr.getUUID();
		String jsapi_ticket = ticketBean.getTicket();
		String timestamp = ticketBean.getExpires_in();
		
		String string1 = "jsapi_ticket=" + jsapi_ticket + "&noncestr" + noncestr + "&timestamp" + timestamp + "&url=" + url;
		
		String signature = SHA1.getSha1(string1);
		
		WeiXinApi weiXinApi = new WeiXinApi();
		weiXinApi.setNoncestr(noncestr);
		weiXinApi.setTimestamp(timestamp);
		weiXinApi.setSignature(signature);
		return weiXinApi;
	}
	
	public static void main(String[] args) {
		WeiXinApi weiXinApi = Signature.instace("wx9a4afa543bacda27", "d4624c36b6795d1d99dcf0547af5443d" , "url=http://mp.weixin.qq.com");
		System.out.println(weiXinApi.getNoncestr());
		System.out.println(weiXinApi.getSignature());
		System.out.println(weiXinApi.getTimestamp());
	}
}
