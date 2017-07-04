package com.BBS.Bean;

public class PostReply {
	private Integer replyId;
	private Integer postId;
	private Integer userId;
	private String replyContent;
	private String replyTime;
	
	public Integer getReplyId() {
		return replyId;
	}
	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
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
	
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public PostReply(Integer postId, Integer userId, String replyContent, String replyTime) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
	}
	public PostReply() {
		super();
	}
	
}
