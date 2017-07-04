package com.BBS.Bean;

public class BoardInfo {
	private Integer boardId;
	private String boardName;
	private String createTime;
	private String boardDesc;
	private String boardPic;
	public String getBoardPic() {
		return boardPic;
	}
	public void setBoardPic(String boardPic) {
		this.boardPic = boardPic;
	}
	public Integer getBoardId() {
		return boardId;
	}
	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getBoardDesc() {
		return boardDesc;
	}
	public void setBoardDesc(String boardDesc) {
		this.boardDesc = boardDesc;
	}
	
	public BoardInfo(String boardName, String createTime, String boardDesc, String boardPic) {
		super();
		this.boardName = boardName;
		this.createTime = createTime;
		this.boardDesc = boardDesc;
		this.boardPic = boardPic;
	}
	public BoardInfo() {
		super();
	}
}
