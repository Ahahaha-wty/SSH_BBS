package com.BBS.DaoImp;

import com.BBS.Bean.User;


public class RegisterDao extends BaseDao {
	
	public void save(User user) {		
		getSession().saveOrUpdate(user);
	}
	
}
