package com.javaweb.web.eo.weixin;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccessTokenResponse implements Serializable {
	
	private static final long serialVersionUID = -6169143634854700372L;

	private String access_token;
	
	private String expires_in;
	
	private String refresh_token;
	
	private String openid;
	
	private String scope;

	private String unionid;

}
