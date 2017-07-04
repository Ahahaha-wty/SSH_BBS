package com.BBS.Bean;

public class ForbiddenBoard {
	private Integer forbiddenId;
	private Integer userId;
	private Integer BoardId;
	public Integer getForbiddenId() {
		return forbiddenId;
	}
	public void setForbiddenId(Integer forbiddenId) {
		this.forbiddenId = forbiddenId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getBoardId() {
		return BoardId;
	}
	public void setBoardId(Integer boardId) {
		BoardId = boardId;
	}
	public ForbiddenBoard(Integer userId, Integer boardId) {
		super();
		
		this.userId = userId;
		BoardId = boardId;
	}
	public ForbiddenBoard() {
		super();
	}
	
}
