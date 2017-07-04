package com.BBS.DaoImp;

import java.util.List;



import com.BBS.Bean.User;
import com.BBS.Bean.UserInformation;

public class LoginDao extends BaseDao  {

	public User find(String username) {
		String hql = "from User u where u.username = ?";
		List<User> list = getSession().createQuery(hql).setString(0, username).list();
		if (list.size()!=0) {
			return list.get(0);	
		}
			return null;
	}
	public UserInformation getUserInfo(Integer userId) {
		String hql = "from UserInformation u where u.userId = ?";
		List<UserInformation> list = getSession().createQuery(hql).setInteger(0, userId).list();
		if (list.size()!=0) {
			return list.get(0);	
		}
			return null;
	}
	public List<User> getUsers() {
		String hql = "from User";
		List<User> list = getSession().createQuery(hql).list();
		return list;
	}
}
