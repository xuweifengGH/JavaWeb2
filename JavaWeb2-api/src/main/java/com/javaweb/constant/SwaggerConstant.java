package com.javaweb.constant;

public class SwaggerConstant {

	/* ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ swagger-基础常量 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ */
	public static final String SWAGGER_TITLE = "SpringBoot使用Swagger构建API文档";
	public static final String SWAGGER_HEAD_USERID = "用户ID";
	public static final String SWAGGER_HEAD_TOKEN = "TOKEN";
	public static final String SWAGGER_HEAD_TYPE = "登录类型";
	/* ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ swagger-基础常量 ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ */
	
	/* ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ swagger-AllOpenController ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ */
	public static final String SWAGGER_ALL_OPEN_CONTROLLER_TAGS = "无需登录即可访问模块";
	
	public static final String SWAGGER_LOGIN_VALUE = "用户登录接口";
	public static final String SWAGGER_LOGIN_NOTES = "输入用户名、密码和登录类型来进行登录（kaptcha和uuid当前可以不传）";
	public static final String SWAGGER_LOGIN_PARAM_VALUE = "用户登录实体类";
	
	public static final String SWAGGER_REQUEST_PARAMETER_LOST_VALUE = "请求参数缺失接口";
	public static final String SWAGGER_INVALID_REQUEST_VALUE = "请求失效接口";
	public static final String SWAGGER_REQUEST_PARAMETER_ERROR_VALUE = "请求参数错误接口";
	public static final String SWAGGER_NO_AUTHORY_VALUE = "没有权限接口";
	public static final String SWAGGER_NOT_FOUND_VALUE = "请求接口不存在接口";
	public static final String SWAGGER_INTERNAL_ERROR_VALUE = "系统异常接口";
	/* ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ swagger-AllOpenController ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ */
	
	/* ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ swagger-LoginAccessController ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ */
	public static final String SWAGGER_LOGIN_ACCESS_CONTROLLER_TAGS = "需登录后才可访问模块";
	
	public static final String SWAGGER_LOGOUT_VALUE = "用户登出接口";
	public static final String SWAGGER_GET_REDIS_TOKEN_DATA = "获取redis中的token信息接口";
	/* ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ swagger-LoginAccessController ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ */
	
}