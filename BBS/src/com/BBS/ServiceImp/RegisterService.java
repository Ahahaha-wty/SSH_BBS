package com.BBS.ServiceImp;

import com.BBS.Bean.User;
import com.BBS.DaoImp.RegisterDao;


public class RegisterService {
	private RegisterDao registerDao;
	
	public RegisterDao getRegisterDao() {
		return registerDao;
	}

	public void setRegisterDao(RegisterDao registerDao) {
		this.registerDao = registerDao;
	}

	public void save(User user) {
		registerDao.save(user);
		
	}
	
	
}
