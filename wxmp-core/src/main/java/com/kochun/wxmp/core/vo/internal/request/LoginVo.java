package com.kochun.wxmp.core.vo.internal.request;

import io.swagger.annotations.ApiModelProperty;

public class LoginVo {

	@ApiModelProperty(value = "用户名", name = "username", example = "test")
	private String username;
	@ApiModelProperty(value = "密码", name = "password", example = "test")
	private String password;
	@ApiModelProperty(value = "角色", name = "role", example = "test")
	private String role;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}