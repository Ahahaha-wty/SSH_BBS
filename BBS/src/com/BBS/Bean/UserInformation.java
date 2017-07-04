package com.BBS.Bean;

public class UserInformation {
	private Integer userId;
	private String email;
	private Integer sex;
	private String birthday;
	private String nativePlace;
	private String qq;
	private String selfInfo;
	private String psersonalIsign;
	private Integer postNum;
	private String headAdd;
	private String registTime;
	private Integer leavl;
	private User user;
	private	Integer levelIntegral;
	
	public Integer getLevelIntegral() {
		return levelIntegral;
	}
	public void setLevelIntegral(Integer levelIntegral) {
		this.levelIntegral = levelIntegral;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getSelfInfo() {
		return selfInfo;
	}
	public void setSelfInfo(String selfInfo) {
		this.selfInfo = selfInfo;
	}
	public String getPsersonalIsign() {
		return psersonalIsign;
	}
	public void setPsersonalIsign(String psersonalIsign) {
		this.psersonalIsign = psersonalIsign;
	}
	public Integer getPostNum() {
		return postNum;
	}
	public void setPostNum(Integer postNum) {
		this.postNum = postNum;
	}
	public String getHeadAdd() {
		return headAdd;
	}
	public void setHeadAdd(String headAdd) {
		this.headAdd = headAdd;
	}
	public String getRegistTime() {
		return registTime;
	}
	public void setRegistTime(String registTime) {
		this.registTime = registTime;
	}
	public Integer getLeavl() {
		return leavl;
	}
	public void setLeavl(Integer leavl) {
		this.leavl = leavl;
	}

	public UserInformation(Integer userId, String email, Integer sex, String birthday, String nativePlace, String qq,
			String selfInfo, String psersonalIsign, Integer postNum, String headAdd, String registTime, Integer leavl,
			 Integer levelIntegral) {
		super();
		this.userId = userId;
		this.email = email;
		this.sex = sex;
		this.birthday = birthday;
		this.nativePlace = nativePlace;
		this.qq = qq;
		this.selfInfo = selfInfo;
		this.psersonalIsign = psersonalIsign;
		this.postNum = postNum;
		this.headAdd = headAdd;
		this.registTime = registTime;
		this.leavl = leavl;
		this.levelIntegral = levelIntegral;
	}
	public UserInformation() {
		super();
	}
	public UserInformation(Integer userId, String email, Integer sex, String birthday, String nativePlace, String qq,
			String selfInfo, String psersonalIsign, String headAdd) {
		super();
		this.userId = userId;
		this.email = email;
		this.sex = sex;
		this.birthday = birthday;
		this.nativePlace = nativePlace;
		this.qq = qq;
		this.selfInfo = selfInfo;
		this.psersonalIsign = psersonalIsign;
		this.headAdd = headAdd;
	}
	
}	
