package com.weixin.util;

import com.weixin.api.Signature;
import com.weixin.api.Ticket;
import com.weixin.data.TicketBean;
import com.weixin.data.WeiXinApiBean;

/**
 * 微信服务号接口工具类
 * 
 * @author 小彬
 * 
 */
public class WeiXinUtil {

	/**
	 * 获取微信票据 票据对象最好在服务器端缓存起来，每隔一个小时自动调用一次刷新票据
	 * 
	 * @param appId
	 * @param secret
	 * @return 票据对象
	 */
	public static TicketBean getTicketBean(String appId, String secret) {
		return Ticket.instance(appId, secret);
	}

	/**
	 * 根据票据计算微信js_config 配置
	 * 
	 * @param ticketBean
	 * @param url
	 *            当前页面完整url
	 * @return 微信js_config配置对象
	 */
	public static WeiXinApiBean getWeiXinApiBean(TicketBean ticketBean,
			String url) {
		return Signature.instance(ticketBean, url);
	}
}
