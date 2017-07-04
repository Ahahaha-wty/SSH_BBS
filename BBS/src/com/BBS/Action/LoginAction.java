package com.BBS.Action;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.core.ApplicationContext;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.BBS.Bean.User;
import com.BBS.Bean.UserInformation;
import com.BBS.ServiceImp.AuthorityService;
import com.BBS.ServiceImp.LoginService;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.glass.ui.Application;

public class LoginAction extends ActionSupport implements SessionAware {
	private String username;
	private String password;
	private LoginService loginService;
	private User user;
	private Map session;
	private String userCookie;

	public String getUserCookie() {
		return userCookie;
	}

	public void setUserCookie(String userCookie) {
		this.userCookie = userCookie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
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

	private String checkCode;

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	@Override
	public String execute() throws Exception {
		user = loginService.find(username);
		if (user != null) {

			if (password.equals(user.getPassword())) {
				// session.put("user", user);
				if (userCookie.equals("true")) {
					Cookie userCookie = new Cookie("username", user.getUsername());
					userCookie.setMaxAge(60 * 60 * 24 * 7);
					ServletActionContext.getResponse().addCookie(userCookie);

				}
				session.put("userInfo", loginService.getUserInfo(user.getUserId()));
				session.put("user", user);
				return SUCCESS;
			}
		}
		this.addActionError("密码错误或账号不存在");
		return INPUT;
	}

	public String autoLogin() {
		for (Cookie c : ServletActionContext.getRequest().getCookies()) {
			if (c.getName().equals("username")) {
				session.put("user", loginService.find(c.getValue()));
				return "success";
			}
		}

		return "input";
	}

	// public String execute() {
	//// user = loginService.find(username);
	//// if (password.equals(user.getPassword())) {
	//// session.put("user", user);
	//// return "success";
	//// }
	////
	// return SUCCESS;
	// }
	public String indexAction() {

		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;

	}

	@Override
	public void validate() {
		HttpSession session = ServletActionContext.getRequest().getSession();

		String checkCode2 = (String) session.getAttribute("checkCode");

		if (!checkCode.equals(checkCode2)) {
			this.addActionError("输入的验证码不正确，请重新输入！");
		}
	}

}
