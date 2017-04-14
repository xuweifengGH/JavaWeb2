package com.javaweb.dataobject.po;

import com.javaweb.base.BaseEntity;

public class Module extends BaseEntity {
	
	private String moduleId;//模块ID
	
	private String moduleName;//模块名称
	
	private String pageUrl = null;//页面URL
	
	private String apiUrl = null;//API的URL
	
	private String parentId = null;//模块的上级ID
	
	private String fcode = null;//层级关系
	
	private Integer level = 0;//第几级(0表示未定义层级数;层级数1为最高,即根节点)
	
	private Integer orders = 0;//模块顺序(0表示没有顺序;顺序从1开始)
	
	private Integer moduleType = 0;//模块类型(0:未定义模块类型；1：菜单；2：操作)
	
	private String alias = null;//别名
	
	private String parentAlias = null;//上级别名
	
	private String remark = null;//备注
	
	private String icon = null;//图标

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public String getApiUrl() {
		return apiUrl;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getFcode() {
		return fcode;
	}

	public void setFcode(String fcode) {
		this.fcode = fcode;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	public Integer getModuleType() {
		return moduleType;
	}

	public void setModuleType(Integer moduleType) {
		this.moduleType = moduleType;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getParentAlias() {
		return parentAlias;
	}

	public void setParentAlias(String parentAlias) {
		this.parentAlias = parentAlias;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}