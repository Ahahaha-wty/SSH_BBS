package com.BBS.ServiceImp;

import com.BBS.Bean.User;
import com.BBS.Bean.UserInformation;
import com.BBS.DaoImp.LoginDao;


public class LoginService {
	private LoginDao loginDao;
	public LoginDao getLoginDao() {
		return loginDao;
	}
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	public User find(String username) {
		return loginDao.find(username);		
	}
	public UserInformation getUserInfo(Integer userId) {
		return loginDao.getUserInfo(userId);
	}
}
