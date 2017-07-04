package com.BBS.DaoImp;

import java.util.ArrayList;
import java.util.List;

import com.BBS.Bean.BoardInfo;
import com.BBS.Bean.Message;
import com.BBS.Bean.Post;
import com.BBS.Bean.PostReply;
import com.BBS.Bean.User;
import com.BBS.Bean.UserInformation;
import com.BBS.Utils.levelUtil;

import javafx.geometry.Pos;

public class PostDao extends BaseDao {

	public void save(Post post) {
		getSession().saveOrUpdate(post);
	}

	public List<BoardInfo> getBoardList() {
		String hql = "from BoardInfo ";
		List<BoardInfo> list = getSession().createQuery(hql).list();
		return list;
	}

	public List<Post> getPosts(Integer i) {
		String hql = "from Post p where p.boardId = ?";
		List<Post> list = getSession().createQuery(hql).setInteger(0, i).list();
		return list;
	}

	public List<PostReply> getReplys(Integer postId) {
		String hql = "from PostReply rp where rp.postId = ?";
		List<PostReply> list = getSession().createQuery(hql).setInteger(0, postId).list();

		return list;
	}

	public List<PostReply> getReplyPageList(Integer postId, Integer offset, Integer pageSize) {
		// String hql = "from BoardInfo b order by b.boardId desc";
		String hql = "from PostReply rp where rp.postId = ? ";
		List<PostReply> list = getSession().createQuery(hql).setInteger(0, postId).setFirstResult(offset)
				.setMaxResults(pageSize).list();

		return list;
	}

	public Post detailPost(Integer postId) {
		String hql = "from Post p where p.postId = ? ";
		List list = getSession().createQuery(hql).setInteger(0, postId).list();
		if (list.size() != 0) {
			return (Post) list.get(0);
		}
		return null;
	}

	public UserInformation getPostPeopleInfo(String username) {
		String hql = "from User u where u.username = ? ";
		User user = (User) getSession().createQuery(hql).setString(0, username).list().get(0);
		hql = "from UserInformation uf where uf.userId = ?";

		return (UserInformation) getSession().createQuery(hql).setInteger(0, user.getUserId()).list().get(0);
	}

	public List getReplyPeopleInfo(Integer userId) {
		String hql = "from User u where u.userId = ? ";
		User user = (User) getSession().createQuery(hql).setInteger(0, userId).list().get(0);
		hql = "from UserInformation uf where uf.userId = ?";
		UserInformation userInformation = (UserInformation) getSession().createQuery(hql).setInteger(0, userId).list()
				.get(0);
		List list = new ArrayList();
		list.add(user);
		list.add(userInformation);
		return list;
	}

	public void saveReply(PostReply postReply) {
		getSession().save(postReply);
	}

	public UserInformation getPeopleInfo(Integer userId) {
		String hql = "from UserInformation uf where uf.userId = ? ";
		UserInformation userInformation = (UserInformation) getSession().createQuery(hql).setInteger(0, userId).list()
				.get(0);
		return userInformation;
	}

	public Integer getUserId(String username) {
		String hql = "from User u where u.username = ? ";
		User user = (User) getSession().createQuery(hql).setString(0, username).list().get(0);
		return user.getUserId();
	}

	public void updatePostNum(Integer userId) {
		Integer postNum = getPeopleInfo(userId).getPostNum() + 1;
		String hql = "update UserInformation uf set uf.postNum = ? where uf.userId = ?";
		getSession().createQuery(hql).setInteger(0, postNum).setInteger(1, userId).executeUpdate();
	}

	public void updateReplyTime(Integer postId) {
		Post post = detailPost(postId);
		Integer replyTime = post.getReplyTime() + 1;
		String hql = "update Post p set p.replyTime = ?  where  p.postId = ?";
		getSession().createQuery(hql).setInteger(0, replyTime).setInteger(1, postId).executeUpdate();
	}

	public void updateIntegral(Integer userId, Integer pubIntegral) {
		UserInformation userInformation = getPeopleInfo(userId);
		Integer integral = userInformation.getLevelIntegral() + pubIntegral;
		Integer level = levelUtil.getLevel(integral);
		System.out.println(level);
		String hql = "update UserInformation uf set uf.levelIntegral = ?,uf.leavl = ? where uf.userId = ?";
		getSession().createQuery(hql).setInteger(0, integral).setInteger(1, level).setInteger(2, userId)
				.executeUpdate();

	}

	public List<Post> Serch(String serchInfo) {
		String hql = "from Post p where p.title like '%" + serchInfo + "%'";
		List<Post> list = getSession().createQuery(hql).list();
		return list;
	}

	public List<Post> getSerchPage(String serchInfo, Integer offset, Integer pageSize) {
		String hql = "from Post p where p.title like '%" + serchInfo + "%'";
		List<Post> list = getSession().createQuery(hql).setFirstResult(offset).setMaxResults(pageSize).list();
		return list;
	}

	public void deletePost(Integer postId) {
		String hql = "Delete from Post p where p.postId = ?";
		getSession().createQuery(hql).setInteger(0, postId).executeUpdate();
		hql = "Delete from PostReply rp where rp.postId = ?";
		getSession().createQuery(hql).setInteger(0, postId).executeUpdate();
	}

	public void isTop(Integer postId, Integer isTop) {
		String hql = "update Post p set p.isTop = ? where p.postId = ?";
		getSession().createQuery(hql).setInteger(0, isTop).setInteger(1, postId).executeUpdate();
	}

	public void isEssence(Integer postId, Integer isEssence) {
		String hql = "update Post p set p.isessence = ? where p.postId = ?";
		getSession().createQuery(hql).setInteger(0, isEssence).setInteger(1, postId).executeUpdate();
	}

	public List<Post> moderatorSerchPost(String title, Integer boardId) {
		String hql = "from Post p where p.title like '%" + title + "%' and boardId = ?";
		List<Post> list = getSession().createQuery(hql).setInteger(0, boardId).list();

		return list;
	}

	public List<Post> moderatoGetSerchPage(String serchInfo, Integer offset, Integer pageSize, Integer boardId) {

		String hql = "from Post p where p.title like '%" + serchInfo + "%' and boardId=? ";
		// List<Post> list = getSession().createQuery(hql).setInteger(0,
		// boardId).setFirstResult(offset).setMaxResults(pageSize).list();
		List<Post> list = getSession().createQuery(hql).setInteger(0, boardId).setFirstResult(offset)
				.setMaxResults(pageSize).list();
		return list;
	}

	public List<Post> userPost(String postPeople) {
		String hql = "from Post p where p.postPeople = ?";
		List<Post> list = getSession().createQuery(hql).setString(0, postPeople).list();
		return list;

	}
	public List<Post> getUserPostPage(String postPeople, Integer offset, Integer pageSize) {
		String hql = "from Post p where p.postPeople = ?";
		List<Post> list = getSession().createQuery(hql).setString(0, postPeople).setFirstResult(offset).setMaxResults(pageSize).list();
		return list;
	}
	public void saveMessage(Message message) {
		getSession().saveOrUpdate(message);
	}
	public List<Message> getMessages(String username) {
		String hql = "from Message m where m.postUsername = ?";
		List<Message> list = getSession().createQuery(hql).setString(0, username).list();
		return list;
	}
	public List<Message> getMessagePage(String username,Integer offset, Integer pageSize) {
		String hql = "from Message m where m.postUsername = ?";
		List<Message> list = getSession().createQuery(hql).setString(0, username).setFirstResult(offset).setMaxResults(pageSize).list();
		return list;
	}
}
