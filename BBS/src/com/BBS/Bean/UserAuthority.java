package com.BBS.Bean;

public class UserAuthority {
	private Integer authorityId;
	private Integer userId;
	private String publishPostAu;
	private String replyAu;
	public Integer getAuthorityId() {
		return authorityId;
	}
	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getPublishPostAu() {
		return publishPostAu;
	}
	public void setPublishPostAu(String publishPostAu) {
		this.publishPostAu = publishPostAu;
	}
	public String getReplyAu() {
		return replyAu;
	}
	public void setReplyAu(String replyAu) {
		this.replyAu = replyAu;
	}
	public UserAuthority(Integer userId, String publishPostAu, String replyAu) {
		super();
		this.userId = userId;
		this.publishPostAu = publishPostAu;
		this.replyAu = replyAu;
	}
	public UserAuthority() {
		super();
	}
	
}
