package com.weixin.api;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weixin.data.TokenBean;

/**
 * 获取access_token
 * 
 * @author 小彬
 * 
 */
public class Token {

	public static final String access_token_url = "https://api.weixin.qq.com/cgi-bin/token";

	/**
	 * 获取access_token填写client_credential
	 */
	private String grantType = "client_credential";

	/**
	 * 第三方用户唯一凭证
	 */
	private String appId = "";

	/**
	 * 第三方用户唯一凭证密钥
	 */
	private String secret = "";

	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public Token(String appId, String secret) {
		super();
		this.appId = appId;
		this.secret = secret;
	}

	public Token() {
		super();
	}

	public static TokenBean instance(String appid, String secret) {
		Token token = new Token(appid, secret);
		String params = "grant_type=" + token.getGrantType() + "&appid="
				+ token.getAppId() + "&secret=" + token.getSecret();
		// 向指定URL发送GET方法的请求
		String returnStr = HttpRequest.sendGet(access_token_url, params);
		// json to map
		ObjectMapper objectMapper = new ObjectMapper();
		TokenBean bean = new TokenBean();
		try {
			bean = objectMapper.readValue(returnStr, TokenBean.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bean;
	}

	public static void main(String[] args) {
		Token.instance("wx9a4afa543bacda27", "d4624c36b6795d1d99dcf0547af5443d");
	}
}
