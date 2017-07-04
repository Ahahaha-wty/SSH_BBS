package com.BBS.DaoImp;



import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import com.BBS.Bean.BoardInfo;
import com.BBS.Bean.Message;
import com.BBS.Bean.Post;

public class BoardDao extends BaseDao {

	public String add(BoardInfo boardInfo) {
		getSession().saveOrUpdate(boardInfo);
		return "success";
	}

	public List<BoardInfo> getBoards() {
		// String hql = "from BoardInfo b order by b.boardId desc";
		String hql = "from BoardInfo";
		List<BoardInfo> list = getSession().createQuery(hql).list();
		return list;
	}
	
	public List<BoardInfo> getBoardPageList(Integer offset, Integer pageSize) {
		// String hql = "from BoardInfo b order by b.boardId desc";
		String hql = "from BoardInfo ";
		List<BoardInfo> list = getSession().createQuery(hql).setFirstResult(offset).setMaxResults(pageSize).list();

		return list;
	}

	public Integer getAllRowCount() {
		String hql = "from BoardInfo ";
		return getSession().createQuery(hql).list().size();
	}

	public List<Post> getBoardPosts(Integer boardId) {
		String hql = "from Post p where p.boardId = ?  order by p.postId desc";
		List<Post> list = getSession().createQuery(hql).setInteger(0, boardId).list();
		return list;
	}
	
	public List<Post> getBoardEssencePosts(Integer boardId) {
		String hql = "from Post p where p.boardId = ? and p.isessence = 1 order by p.postId desc";
		List<Post> list = getSession().createQuery(hql).setInteger(0, boardId).list();
		return list;
	}
	public List<Post> getEssencePostPageList(Integer boardId,Integer offset, Integer pageSize) {
		// String hql = "from BoardInfo b order by b.boardId desc";
		String hql = "from Post p where p.boardId = ? and p.isessence = 1  order by p.postId desc";
		List<Post> list = getSession().createQuery(hql).setInteger(0, boardId).setFirstResult(offset).setMaxResults(pageSize).list();
		return list;
	}
	
	public Integer PostsCounts(Integer boardId) {
		String hql = "from Post p where p.boardId = ? order by p.postId desc";
		List<Post> list = getSession().createQuery(hql).setInteger(0, boardId).list();
		return list.size();
	}
	public List<Post> getPostPageList(Integer boardId,Integer offset, Integer pageSize) {
		// String hql = "from BoardInfo b order by b.boardId desc";
		String hql = "from Post p where p.boardId = ? order by p.postId desc";
		List<Post> list = getSession().createQuery(hql).setInteger(0, boardId).setFirstResult(offset).setMaxResults(pageSize).list();
		return list;
	}
	public BoardInfo getDetailBoard(Integer boardId) {
		String hql = "from BoardInfo b where b.boardId = ?";
		List list =  getSession().createQuery(hql).setInteger(0, boardId).list();
		if (list.size()!=0) {
			return (BoardInfo) list.get(0);
		}
		return null;
	}
	public void updateBoard(String imgUrl,String boardDesc,Integer boardId) {
		String hql = "update BoardInfo b set b.boardPic = ?,b.boardDesc = ? where  b.boardId = ?";
		getSession().createQuery(hql).setString(0, imgUrl).setString(1, boardDesc).setInteger(2, boardId).executeUpdate();
	}
	
	public List<Post> getAllPostPageList(Integer offset, Integer pageSize) {
		// String hql = "from BoardInfo b order by b.boardId desc";
		String hql = "from Post p order by p.postId desc";
		List<Post> list = getSession().createQuery(hql).setFirstResult(offset).setMaxResults(pageSize).list();
		return list;
	}
	public List<Post> getAllPostPageList() {
		// String hql = "from BoardInfo b order by b.boardId desc";
		String hql = "from Post p order by p.postId desc";
		List<Post> list = getSession().createQuery(hql).list();
		return list;
	}
	public void adDeleteBoard(Integer boardId) {
		String hql = "Delete from BoardInfo b where b.boardId = ?";
		getSession().createQuery(hql).setInteger(0, boardId).executeUpdate();
		hql = "Delete from Post p where p.boardId = ?";
		getSession().createQuery(hql).setInteger(0, boardId).executeUpdate();
	}
	public Message getAdminMessage() {
		String hql = "from Message m where m.postId = ? order by m.messageId desc";
		List<Message> list = getSession().createQuery(hql).setInteger(0, 0).list();
		if (list.size()!=0) {
			return list.get(0);
		}
		return null;
	}
	public List<Post> getHotPost() {
		String hql = "from Post p order by p.replyTime desc";
		List<Post> list = getSession().createQuery(hql).setFirstResult(0).setMaxResults(6).list();
		return list;
	}
	public List<Post> getTopPosts(Integer boardId) {
		String hql = "from Post p where p.boardId = ? and p.isTop = 1 order by p.postId desc";
		List<Post> list = getSession().createQuery(hql).setInteger(0, boardId).list();
		return list;
	}
}
