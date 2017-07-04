package com.BBS.Bean;

public class Post {
	private Integer postId;
	private Integer boardId;
	private String title;
	private String publishTime;
	private String content;
	private String postPeople;
	private Integer browseTime;
	private Integer replyTime;
	private Integer isTop;
	private Integer isessence;

	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public Integer getBoardId() {
		return boardId;
	}
	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPostPeople() {
		return postPeople;
	}
	public void setPostPeople(String postPeople) {
		this.postPeople = postPeople;
	}
	public Integer getBrowseTime() {
		return browseTime;
	}
	public void setBrowseTime(Integer browseTime) {
		this.browseTime = browseTime;
	}
	public Integer getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Integer replyTime) {
		this.replyTime = replyTime;
	}
	public Integer getIsTop() {
		return isTop;
	}
	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}
	public Integer getIsessence() {
		return isessence;
	}
	public void setIsessence(Integer isessence) {
		this.isessence = isessence;
	}
	public Post() {
		super();
	}
	public Post(Integer boardId, String title, String publishTime, String content, String postPeople,
			Integer browseTime, Integer replyTime, Integer isTop, Integer isessence) {
		super();
		this.boardId = boardId;
		this.title = title;
		this.publishTime = publishTime;
		this.content = content;
		this.postPeople = postPeople;
		this.browseTime = browseTime;
		this.replyTime = replyTime;
		this.isTop = isTop;
		this.isessence = isessence;
	}
		
}
