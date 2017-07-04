package com.BBS.Action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.BBS.Bean.BoardInfo;
import com.BBS.Bean.DetailReplyInfo;
import com.BBS.Bean.ForbiddenBoard;
import com.BBS.Bean.Message;
import com.BBS.Bean.ModeratorAuthority;
import com.BBS.Bean.PageBean;
import com.BBS.Bean.Post;
import com.BBS.Bean.PostReply;
import com.BBS.Bean.User;
import com.BBS.Bean.UserInformation;
import com.BBS.ServiceImp.AuthorityService;
import com.BBS.ServiceImp.PostService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.regexp.internal.REUtil;

public class PostAction extends ActionSupport implements SessionAware {
	private PostService postService;
	private Map session;
	private String title;
	private String content;
	private String postId;
	private String replyContent;
	private String serchInfo;
	private AuthorityService authorityService;
	private String isEssence;
	private String isTop;
	private String postPeople;

	public String getPosts() {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Post> postList = postService.getPosts(request.getParameter("boardId"));
		ActionContext.getContext().getValueStack().set("postLists", postList);
		// ActionContext.getContext().getValueStack().push(arg0);
		return "success";
	}

	public String publish() {
		HttpServletRequest request = ServletActionContext.getRequest();

		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			User user = (User) session.getAttribute("user");
			BoardInfo boardInfo = (BoardInfo) session.getAttribute("detailBoardInfo");
			if (authorityService.getUserAu(user.getUserId()).getPublishPostAu().equals("false")) {
				session.setAttribute("wrongMessage", "对不起，您被禁止发帖，请联系管理员");
				return SUCCESS;
			}
			if (authorityService.getForbiddenBoards(user.getUserId()) != null) {
				for (ForbiddenBoard f : authorityService.getForbiddenBoards(user.getUserId())) {
					if (f.getBoardId() == boardInfo.getBoardId()) {
						session.setAttribute("wrongMessage", "对不起，您被禁止发帖，请联系管理员");
						return SUCCESS;
					}

				}
			}

			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = format.format(date);
			Post post = new Post(boardInfo.getBoardId(), title, time, content, user.getUsername(), 0, 0, 0, 0);
			postService.publishPost(post);
			return SUCCESS;
		}

		return LOGIN;
	}

	public String getReplys() {
		Post post = null;
		HttpSession session = ServletActionContext.getRequest().getSession();
		if (postId != null) {
			post = postService.getPost(Integer.valueOf(postId).intValue());
			session.setAttribute("detailPost", post);
		} else {
			post = (Post) session.getAttribute("detailPost");
		}

		PageBean pageBean = postService.getReplyPage(post.getPostId(), 5, page);
		UserInformation postPeople = postService.postPeopleInfo(post.getPostPeople());

		session.setAttribute("replyPage", pageBean);
		session.setAttribute("postPeople", postPeople);

		return SUCCESS;

	}

	public String reply() {
		HttpServletRequest request = ServletActionContext.getRequest();

		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			User user = (User) session.getAttribute("user");
			Post post = (Post) session.getAttribute("detailPost");
			if (authorityService.getUserAu(user.getUserId()).getReplyAu().equals("false")) {
				session.setAttribute("wrongMessage", "对不起，您被禁止回复，请联系管理员");
				return SUCCESS;
			}
			if (authorityService.getForbiddenBoards(user.getUserId()) != null) {
				for (ForbiddenBoard f : authorityService.getForbiddenBoards(user.getUserId())) {
					if (f.getBoardId() == post.getBoardId()) {
						session.setAttribute("wrongMessage", "对不起，您被禁止回复，请联系管理员");
						return SUCCESS;
					}

				}
			}
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = format.format(date);
			Message message = new Message(post.getPostId(), post.getTitle(), user.getUsername(), replyContent, post.getPostPeople());
			postService.saveMessage(message);
			PostReply postReply = new PostReply(post.getPostId(), user.getUserId(), replyContent, time);
			postService.publishReply(postReply);
			return SUCCESS;
		}

		return LOGIN;
	}

	public String serch() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("serchInfo", serchInfo);
		PageBean pageBean = postService.serchPosts(serchInfo, 6, page);
		session.setAttribute("serchPageBean", pageBean);
		return SUCCESS;
	}
	public String getMessagePage() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		PageBean pageBean = postService.getMessagePage(user.getUsername(), 6, page);
		session.setAttribute("messagePage", pageBean);
		return SUCCESS;
	}
	public String userPosts() {
		User user = (User) session.get("user");
		postPeople = user.getUsername();
		HttpSession session = ServletActionContext.getRequest().getSession();
		PageBean pageBean = postService.userPosts(postPeople, 6, page);
		session.setAttribute("userPostPageBean", pageBean);
		return SUCCESS;
	}

	public String deletePost() {
		postService.deletePost(Integer.valueOf(postId));
		return SUCCESS;
	}

	public String isTop() {
		postService.isTop(Integer.valueOf(postId), Integer.valueOf(isTop));
		return SUCCESS;
	}

	public String isEssence() {
		postService.isEssence(Integer.valueOf(postId), Integer.valueOf(isEssence));
		return SUCCESS;
	}
	

	public String moderatorSerchPost() {
		ModeratorAuthority moderatorAuthority = (ModeratorAuthority) session.get("authority");
		session.put("serchInfo", serchInfo);
		PageBean pageBean = postService.moderatorSerchPost(serchInfo, 3, page, moderatorAuthority.getBoardId());
		session.put("moSerPageBean", pageBean);
		return SUCCESS;
	}

	public String getIsEssence() {
		return isEssence;
	}

	public void setIsEssence(String isEssence) {
		this.isEssence = isEssence;
	}

	public String getIsTop() {
		return isTop;
	}

	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}

	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {

		this.session = arg0;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	private int page;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getSerchInfo() {
		return serchInfo;
	}

	public void setSerchInfo(String serchInfo) {
		this.serchInfo = serchInfo;
	}

	public AuthorityService getAuthorityService() {
		return authorityService;
	}

	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}

	public String getPostPeople() {
		return postPeople;
	}

	public void setPostPeople(String postPeople) {
		this.postPeople = postPeople;
	}
	
}
