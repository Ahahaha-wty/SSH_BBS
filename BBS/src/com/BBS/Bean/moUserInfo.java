package com.BBS.Bean;

public class moUserInfo {
	private Integer userId;
	private String username;
	private Integer sex;
	private String registTime;
	private Integer postNum;
	private String isForbidden;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
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
	public String getRegistTime() {
		return registTime;
	}
	public void setRegistTime(String registTime) {
		this.registTime = registTime;
	}
	public Integer getPostNum() {
		return postNum;
	}
	public void setPostNum(Integer postNum) {
		this.postNum = postNum;
	}
	public String getIsForbidden() {
		return isForbidden;
	}
	public void setIsForbidden(String isForbidden) {
		this.isForbidden = isForbidden;
	}
	public moUserInfo(Integer userId, String username, Integer sex, String registTime, Integer postNum,
			String isForbidden) {
		super();
		this.userId = userId;
		this.username = username;
		this.sex = sex;
		this.registTime = registTime;
		this.postNum = postNum;
		this.isForbidden = isForbidden;
	}
	public moUserInfo() {
		super();
	}
	
}
