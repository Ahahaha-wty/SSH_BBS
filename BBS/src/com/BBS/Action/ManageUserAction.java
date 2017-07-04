package com.BBS.Action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.websocket.Session;

import org.apache.catalina.tribes.util.StringManager;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.BBS.Bean.Message;
import com.BBS.Bean.ModeratorAuthority;
import com.BBS.Bean.PageBean;
import com.BBS.Bean.User;
import com.BBS.Bean.UserAuthority;
import com.BBS.Bean.UserInformation;
import com.BBS.ServiceImp.AuthorityService;
import com.BBS.ServiceImp.ManageUserService;
import com.opensymphony.xwork2.ActionSupport;

public class ManageUserAction extends ActionSupport implements SessionAware {
	private ManageUserService manageUserService;
	private Map session;
	private int page;
	private String isForbidden;
	private String userId;
	private String username;
	private String password;
	private String repassword;
	private AuthorityService authorityService;
	private String boardId;
	private String textfield;
	
	public String getTextfield() {
		return textfield;
	}

	public void setTextfield(String textfield) {
		this.textfield = textfield;
	}

	public String getBoardId() {
		return boardId;
	}

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

	public AuthorityService getAuthorityService() {
		return authorityService;
	}

	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIsForbidden() {
		return isForbidden;
	}

	public void setIsForbidden(String isForbidden) {
		this.isForbidden = isForbidden;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public ManageUserService getManageUserService() {
		return manageUserService;
	}

	public void setManageUserService(ManageUserService manageUserService) {
		this.manageUserService = manageUserService;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}

	public String moderatorManUsers() {
		ModeratorAuthority moderatorAuthority = (ModeratorAuthority) session.get("authority");
		PageBean pageBean = manageUserService.getModeratorUserPage(moderatorAuthority.getBoardId(), 6, page);
		session.put("moUserPage", pageBean);
		return SUCCESS;
	}

	public String moForbidden() {
		ModeratorAuthority moderatorAuthority = (ModeratorAuthority) session.get("authority");
		if (isForbidden.equals("0")) {
			manageUserService.moForbidden(moderatorAuthority.getBoardId(), Integer.valueOf(userId));
		} else if (isForbidden.equals("1")) {
			manageUserService.moDeleteForbidden(moderatorAuthority.getBoardId(), Integer.valueOf(userId));
		}
		return SUCCESS;

	}

	public String adManUsers() {
		PageBean pageBean = manageUserService.getAdUserPage(8, page);
		session.put("adUserPage", pageBean);

		return SUCCESS;
	}

	public String adForbidden() {
		if (isForbidden.equals("0")) {
			manageUserService.adChangeAu(Integer.valueOf(userId), "false");
		} else if (isForbidden.equals("1")) {
			manageUserService.adChangeAu(Integer.valueOf(userId), "true");
		}
		return SUCCESS;

	}

	public String adDeleteUser() {
		manageUserService.adDeleteUser(Integer.valueOf(userId));
		return SUCCESS;
	}

	public String getModerator() {
		PageBean pageBean = manageUserService.getModeratorPage(8, page);
		session.put("moPage", pageBean);
		return SUCCESS;
	}

	public String moPostManAu() {
		getManageUserService().moPostManAu(Integer.valueOf(userId), isForbidden);
		return SUCCESS;
	}

	public String moMemManAu() {
		getManageUserService().moMemManAu(Integer.valueOf(userId), isForbidden);
		return SUCCESS;
	}

	public String moBoardManAu() {
		getManageUserService().moBoardManAu(Integer.valueOf(userId), isForbidden);
		return SUCCESS;
	}
	public String deleteMo() {
		getManageUserService().deleteMo(Integer.valueOf(userId));
		return SUCCESS;
	}
	public String addMem() {
		if (username.length()<=0||username.length()>=10) {
			this.addFieldError("username", "请输入0-10位用户名");
			return INPUT;
		}
		if (manageUserService.findUser(username)!=null) {
			this.addFieldError("username", "用户名已存在");
			return INPUT;
		}
		if (password.length()<=0||password.length()>=16) {
			this.addFieldError("password", "请输入0-16位密码");
			return INPUT;
		}
		if (!password.equals(repassword)) {
			this.addFieldError("password", "两次密码输入不一致");
			return INPUT;
		}
		User user = new User(username,password, 1);
		ServletActionContext.getRequest().getSession().setAttribute("user", user);		
		manageUserService.addUser(user);
		user = manageUserService.findUser(username);
		UserAuthority userAuthority = new UserAuthority(user.getUserId(), "true", "true");
		authorityService.saveUserAu(userAuthority);
		Date date=new Date();
		UserInformation userInformation = new UserInformation(user.getUserId(), "", 1, "", "", "", "", "", 0, "files\\default.jpg", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date), 1, 0);
		manageUserService.addUserInfo(userInformation);
		return SUCCESS;
	}
	
	public String addModerator() {
		User user = manageUserService.findUser(username);
		if (user==null){
			this.addActionError("用户不存在");
			return "input";
		}
		ModeratorAuthority moderatorAuthority = new ModeratorAuthority(user.getUserId(), "true", "true", "true", Integer.valueOf(boardId));
		manageUserService.addModerator(moderatorAuthority);
		return SUCCESS;
	}
	public String adminAddMessage() {
		Message message = new Message(0, "", "admin", textfield, "");
		manageUserService.adminAddMessage(message);
		return SUCCESS;
	}
}
