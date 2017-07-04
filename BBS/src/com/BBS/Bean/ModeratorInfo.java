package com.BBS.Bean;

public class ModeratorInfo {
	private Integer userId;
	private String moName;
	private String boardName;
	private String postManageAu;
	private String boardManageAu;
	private String memberManageAu;
	public String getMoName() {
		return moName;
	}
	public void setMoName(String moName) {
		this.moName = moName;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public String getPostManageAu() {
		return postManageAu;
	}
	public void setPostManageAu(String postManageAu) {
		this.postManageAu = postManageAu;
	}
	public String getBoardManageAu() {
		return boardManageAu;
	}
	public void setBoardManageAu(String boardManageAu) {
		this.boardManageAu = boardManageAu;
	}
	public String getMemberManageAu() {
		return memberManageAu;
	}
	public void setMemberManageAu(String memberManageAu) {
		this.memberManageAu = memberManageAu;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public ModeratorInfo(Integer userId, String moName, String boardName, String postManageAu, String boardManageAu,
			String memberManageAu) {
		super();
		this.userId = userId;
		this.moName = moName;
		this.boardName = boardName;
		this.postManageAu = postManageAu;
		this.boardManageAu = boardManageAu;
		this.memberManageAu = memberManageAu;
	}
	public ModeratorInfo() {
		super();
	}
	
}
