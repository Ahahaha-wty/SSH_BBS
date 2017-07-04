package com.BBS.Bean;

public class ManageUser {
	private Integer userId;
	private String username;
	private Integer sex;
	private String registerTime;
	private Integer postTimes;
	private Integer isForbidden;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
	public Integer getPostTimes() {
		return postTimes;
	}
	public void setPostTimes(Integer postTimes) {
		this.postTimes = postTimes;
	}


	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getIsForbidden() {
		return isForbidden;
	}
	public void setIsForbidden(Integer isForbidden) {
		this.isForbidden = isForbidden;
	}
	public ManageUser() {
		super();
	}
	public ManageUser(Integer userId, String username, Integer sex, String registerTime, Integer postTimes,
			Integer isForbidden) {
		super();
		this.userId = userId;
		this.username = username;
		this.sex = sex;
		this.registerTime = registerTime;
		this.postTimes = postTimes;
		this.isForbidden = isForbidden;
	}
	
}
