package com.javaweb.web.eo.module;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModuleListResponse implements Serializable {
	
	private static final long serialVersionUID = 7615231208220978387L;

	private String moduleId;//模块ID
	
	private String moduleName;//模块名称
	
	private String pageUrl;//页面URL
	
	private String apiUrl;//API请求URL
	
	private String moduleType;//模块类型
	
	private String alias;//别名
	
	private String createDate;//注册日期

}
