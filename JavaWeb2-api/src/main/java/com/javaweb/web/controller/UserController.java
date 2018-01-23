package com.javaweb.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.base.BaseController;
import com.javaweb.base.BaseResponseResult;
import com.javaweb.constant.SystemConstant;
import com.javaweb.web.eo.PageData;
import com.javaweb.web.eo.user.UserListRequest;
import com.javaweb.web.service.UserService;

@RequestMapping("/web/sys/user")
@RestController
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/list")
	public BaseResponseResult userList(@RequestBody UserListRequest userListRequest){
		PageData pageData = userService.userList(userListRequest);
		return new BaseResponseResult(SystemConstant.SUCCESS,getMessage("user.list.success"),pageData);
	}
	
}