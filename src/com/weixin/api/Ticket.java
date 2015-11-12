package com.weixin.api;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weixin.data.TicketBean;
import com.weixin.data.TokenBean;

public class Ticket {
	public static final String ticket_url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";

	public static TicketBean instance(String appid, String secret) {
		TokenBean tokenBean = Token.instance(appid, secret);
		String params = "access_token=" + tokenBean.getAccess_token()
				+ "&type=jsapi";

		String returnStr = HttpRequest.sendGet(ticket_url, params);
		ObjectMapper objectMapper = new ObjectMapper();
		TicketBean bean = new TicketBean();
		try {
			bean = objectMapper.readValue(returnStr, TicketBean.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bean;
	}

	public static void main(String[] args) {
		TicketBean ticketBean = Ticket.instance("wx9a4afa543bacda27",
				"d4624c36b6795d1d99dcf0547af5443d");
		System.out.println(ticketBean.getTicket());
	}
}
