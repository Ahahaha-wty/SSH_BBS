package com.BBS.ServiceImp;

import java.util.List;

import com.BBS.Bean.BoardInfo;
import com.BBS.Bean.Message;
import com.BBS.Bean.PageBean;
import com.BBS.Bean.Post;
import com.BBS.DaoImp.BoardDao;
import com.BBS.DaoImp.PostDao;

public class BoardService {
	private BoardDao boardDao;

	public BoardDao getBoardDao() {
		return boardDao;
	}

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	public String add(BoardInfo boardInfo) {
		return boardDao.add(boardInfo);
	}

	public List<BoardInfo> getBoards() {
		List<BoardInfo> list = boardDao.getBoards();
		return list;
	}

	public List<BoardInfo> getBoards(Integer i1, Integer i2) {
		List<BoardInfo> list = boardDao.getBoardPageList(i1, i2);
		return list;
	}

	public PageBean getBoardPages(Integer pageSize, Integer page) {
		// 封装PageBean分页对象数据
		PageBean pageBean = new PageBean();
		// 设置当前页
		int allRows = boardDao.getAllRowCount();

		int totalPage = pageBean.getTotalPages(pageSize, allRows);

		int currentPage = pageBean.getCurPage(page);

		int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);

		List<BoardInfo> list = boardDao.getBoardPageList(offset, pageSize);

		pageBean.setList(list);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);

		return pageBean;

	}
	public List<Post> getBoardPosts(Integer boardId) {
		return boardDao.getBoardPosts(boardId);
	}
	
	//得到当前板块帖子的分页
	public PageBean getPostPage(Integer boardId,Integer pageSize, Integer page) {
		PageBean pageBean = new PageBean();
		// 设置当前页
		int allRows = getBoardPosts(boardId).size();

		int totalPage = pageBean.getTotalPages(pageSize, allRows);

		int currentPage = pageBean.getCurPage(page);

		int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);

		List<Post> list = boardDao.getPostPageList(boardId,offset, pageSize);

		pageBean.setList(list);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);

		return pageBean;

	}
	public PageBean getEssencePostPage(Integer boardId,Integer pageSize, Integer page) {
		PageBean pageBean = new PageBean();
		// 设置当前页
		int allRows = boardDao.getBoardEssencePosts(boardId).size();

		int totalPage = pageBean.getTotalPages(pageSize, allRows);

		int currentPage = pageBean.getCurPage(page);

		int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);

		List<Post> list = boardDao.getEssencePostPageList(boardId, offset, pageSize);

		pageBean.setList(list);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);

		return pageBean;

	}
	public PageBean getAllPostPage(Integer pageSize, Integer page) {
		PageBean pageBean = new PageBean();
		// 设置当前页
		int allRows = boardDao.getAllPostPageList().size();

		int totalPage = pageBean.getTotalPages(pageSize, allRows);

		int currentPage = pageBean.getCurPage(page);

		int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);

		List<Post> list = boardDao.getAllPostPageList(offset, pageSize);

		pageBean.setList(list);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);

		return pageBean;
	}
	
	public BoardInfo getBoardInfo( Integer boardId) {
		return boardDao.getDetailBoard(boardId);
	}
	public void updateBoardInfo(String imgUrl,String boardDesc,Integer boardId) {
		boardDao.updateBoard(imgUrl, boardDesc, boardId);
	}
	public void adDeleteBoard(Integer boardId) {
		boardDao.adDeleteBoard(boardId);
	}
	public Message getAdMessage() {
		return boardDao.getAdminMessage();
	}
	public List<Post> getHotPosts() {
		return boardDao.getHotPost();
	}
	public List<Post> getTopPost(Integer boardId) {
		return boardDao.getTopPosts(boardId);
	}
}
