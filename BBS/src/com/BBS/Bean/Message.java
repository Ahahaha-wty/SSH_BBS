package com.BBS.Bean;

public class Message {
	private Integer messageId;
	private Integer postId;
	private String postTitle;
	private String username;
	private String content;
	private String postUsername;
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getPostUsername() {
		return postUsername;
	}
	public void setPostUsername(String postUsername) {
		this.postUsername = postUsername;
	}
	
	public Message(Integer postId, String postTitle, String username, String content, String postUsername) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.username = username;
		this.content = content;
		this.postUsername = postUsername;
	}
	public Message() {
		super();
	}
	
	
}
