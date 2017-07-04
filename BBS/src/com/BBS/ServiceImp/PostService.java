package com.BBS.ServiceImp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.id.SequenceIdentityGenerator.Delegate;

import com.BBS.Bean.BoardInfo;
import com.BBS.Bean.DetailReplyInfo;
import com.BBS.Bean.Message;
import com.BBS.Bean.PageBean;
import com.BBS.Bean.Post;
import com.BBS.Bean.PostReply;
import com.BBS.Bean.UserInformation;
import com.BBS.Bean.User;
import com.BBS.DaoImp.PostDao;

public class PostService {
	private PostDao postDao;

	public PostDao getPostDao() {
		return postDao;
	}

	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}

	// public String getBoardInfo(){
	// String s = "";
	// for(BoardInfo b:postDao.getBoardList()){
	// s+="<option value='"+ b.getBoardId()+"'>"+b.getBoardName() +"</option>";
	//
	// }
	// return s;
	// }
	public String publishPost(Post post) {
		postDao.save(post);
		Integer userId = postDao.getUserId(post.getPostPeople());
		postDao.updatePostNum(userId);
		postDao.updateIntegral(userId,5);
		return "success";
	}

	// public String getPosts(String s) {
	// String s1 = "";
	// List<Post> list = postDao.getPosts(Integer.valueOf(s));
	// for(Post p:list){
	// s1 += "<div><a
	// href='postDetailAction?postId="+p.getPostId()+"'>"+p.getTitle()
	// +"</a>..."+
	// p.getContent()+"...."+p.getPublishTime()+"...."+p.getPostPeople()+"</div>";
	// }
	// return s1;
	// }
	public List<Post> getPosts(String s) {
		List<Post> list = postDao.getPosts(Integer.valueOf(s));
		return list;
	}

	public Post getPost(Integer postId) {
		return postDao.detailPost(postId);
	}

	public PageBean getReplyPage(Integer postId, Integer pageSize, Integer page) {
		PageBean pageBean = new PageBean();
		// 设置当前页
		int allRows = postDao.getReplys(postId).size();

		int totalPage = pageBean.getTotalPages(pageSize, allRows);

		int currentPage = pageBean.getCurPage(page);

		int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);

		List<PostReply> list = postDao.getReplyPageList(postId, offset, pageSize);
		List<DetailReplyInfo> rpInfoList = new ArrayList();
		for(PostReply pr: list){
			User user = (User) postDao.getReplyPeopleInfo(pr.getUserId()).get(0);
			UserInformation userInformation = (UserInformation) postDao.getReplyPeopleInfo(pr.getUserId()).get(1);
			DetailReplyInfo replyInfo = new DetailReplyInfo(user.getUsername(), user.getUserId(),
					userInformation.getSex(), userInformation.getHeadAdd(), 
					userInformation.getPostNum(), userInformation.getLeavl(), 
					pr.getReplyContent(), pr.getReplyTime());
			
			rpInfoList.add(replyInfo);
			
		}
		pageBean.setList(rpInfoList);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);

		return pageBean;
	}
	public UserInformation postPeopleInfo(String username) {
		return postDao.getPostPeopleInfo(username);
	}
	public void publishReply(PostReply postReply) {
		postDao.saveReply(postReply);
		postDao.updateReplyTime(postReply.getPostId());
		String username = postDao.detailPost(postReply.getPostId()).getPostPeople();
		Integer postUserId = postDao.getUserId(username);
		
		
		if (postUserId==postReply.getUserId()) {
			postDao.updateIntegral(postUserId, 3);
		}else {
			postDao.updateIntegral(postUserId, 3);
			postDao.updateIntegral(postReply.getUserId(), 3);
		}
	}
	
	public PageBean serchPosts(String serchInfo,Integer pageSize, Integer page) {
		PageBean pageBean = new PageBean();
		// 设置当前页
		int allRows = postDao.Serch(serchInfo).size();

		int totalPage = pageBean.getTotalPages(pageSize, allRows);

		int currentPage = pageBean.getCurPage(page);

		int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);

		List<Post> list = postDao.getSerchPage(serchInfo, offset, pageSize);

		pageBean.setList(list);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);

		return pageBean;
	}
	public void isTop(Integer postId,Integer isTop) {
		if (isTop==0) {
			isTop=1;
		}else {
			isTop=0;
		}
		postDao.isTop(postId, isTop);
	}
	public void isEssence(Integer postId,Integer isEssence) {
		if (isEssence==0) {
			isEssence=1;
		}else {
			isEssence=0;
		}
		postDao.isEssence(postId, isEssence);
	}
	public void deletePost(Integer postId) {
		postDao.deletePost(postId);
	}
	public PageBean moderatorSerchPost(String serchInfo,Integer pageSize, Integer page ,Integer boardId) {
		PageBean pageBean = new PageBean();
		// 设置当前页
		int allRows = postDao.moderatorSerchPost(serchInfo, boardId).size();

		int totalPage = pageBean.getTotalPages(pageSize, allRows);

		int currentPage = pageBean.getCurPage(page);

		int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);

		List<Post> list = postDao.moderatoGetSerchPage(serchInfo, offset, pageSize, boardId);

		pageBean.setList(list);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);

		return pageBean;
	}
	
	public PageBean userPosts(String postPeople,Integer pageSize, Integer page) {
		PageBean pageBean = new PageBean();
		// 设置当前页
		int allRows = postDao.userPost(postPeople).size();

		int totalPage = pageBean.getTotalPages(pageSize, allRows);

		int currentPage = pageBean.getCurPage(page);

		int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);

		List<Post> list = postDao.getUserPostPage(postPeople, offset, pageSize);

		pageBean.setList(list);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);

		return pageBean;
	}
	public void saveMessage(Message message) {
		postDao.saveMessage(message);
	}
	public PageBean getMessagePage(String username,Integer pageSize, Integer page) {
		PageBean pageBean = new PageBean();
		// 设置当前页
		int allRows = postDao.getMessages(username).size();

		int totalPage = pageBean.getTotalPages(pageSize, allRows);

		int currentPage = pageBean.getCurPage(page);

		int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);

		List<Message> list = postDao.getMessagePage(username, offset, pageSize);

		pageBean.setList(list);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);

		return pageBean;
	}
}
