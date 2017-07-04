package com.BBS.Bean;

public class DetailReplyInfo {
	
		
		public DetailReplyInfo() {
		super();
	}
		public DetailReplyInfo(String username, Integer userId, Integer sex, String headImg, Integer postNum, Integer leavl,
			String replyContent, String replyTime) {
		super();
		this.username = username;
		this.userId = userId;
		this.sex = sex;
		this.headImg = headImg;
		this.postNum = postNum;
		this.leavl = leavl;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
	}
		private String username;
		private Integer userId;
		private Integer sex;
		private String headImg;
		private Integer postNum;
		private Integer leavl;
		private String replyContent;
		private String replyTime;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		public Integer getSex() {
			return sex;
		}
		public void setSex(Integer sex) {
			this.sex = sex;
		}
		public String getHeadImg() {
			return headImg;
		}
		public void setHeadImg(String headImg) {
			this.headImg = headImg;
		}
		public Integer getPostNum() {
			return postNum;
		}
		public void setPostNum(Integer postNum) {
			this.postNum = postNum;
		}
		public Integer getLeavl() {
			return leavl;
		}
		public void setLeavl(Integer leavl) {
			this.leavl = leavl;
		}
		public String getReplyContent() {
			return replyContent;
		}
		public void setReplyContent(String replyContent) {
			this.replyContent = replyContent;
		}
		public String getReplyTime() {
			return replyTime;
		}
		public void setReplyTime(String replyTime) {
			this.replyTime = replyTime;
		}
		
		
	}


