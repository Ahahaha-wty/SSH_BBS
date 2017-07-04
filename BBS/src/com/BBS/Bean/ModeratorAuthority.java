package com.BBS.Bean;

public class ModeratorAuthority {
	private Integer authorityId;
	private Integer userId;
	private String postManageAu;
	private String memberManageAu;
	private String boardManageAu;
	private Integer boardId;
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
	public String getPostManageAu() {
		return postManageAu;
	}
	public void setPostManageAu(String postManageAu) {
		this.postManageAu = postManageAu;
	}
	public String getMemberManageAu() {
		return memberManageAu;
	}
	public void setMemberManageAu(String memberManageAu) {
		this.memberManageAu = memberManageAu;
	}
	public String getBoardManageAu() {
		return boardManageAu;
	}
	public void setBoardManageAu(String boardManageAu) {
		this.boardManageAu = boardManageAu;
	}
	public Integer getBoardId() {
		return boardId;
	}
	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}
	public ModeratorAuthority(Integer userId, String postManageAu, String memberManageAu, String boardManageAu,
			Integer boardId) {
		super();
		this.userId = userId;
		this.postManageAu = postManageAu;
		this.memberManageAu = memberManageAu;
		this.boardManageAu = boardManageAu;
		this.boardId = boardId;
	}
	public ModeratorAuthority() {
		super();
	}
	
}
