package com.BBS.DaoImp;

import com.BBS.Bean.UserInformation;

public class CompleteRegDao extends BaseDao{
	public void save(UserInformation userInformation) {		
		getSession().saveOrUpdate(userInformation);
	}
	public void updateUserInfo(UserInformation userInformation) {
		String hql = "update UserInformation u set u.email = ?,u.sex = ?,u.birthday = ?,u.nativePlace = ?"
				+ ",u.qq = ?,u.selfInfo = ?,u.psersonalIsign = ?,u.headAdd = ? where  u.userId = ?";
		getSession().createQuery(hql).setString(0, userInformation.getEmail()).setInteger(1, userInformation.getSex())
		.setString(2, userInformation.getBirthday()).setString(3, userInformation.getNativePlace())
		.setString(4, userInformation.getQq()).setString(5, userInformation.getSelfInfo()).
		setString(6, userInformation.getPsersonalIsign()).setString(7, userInformation.getHeadAdd()).
		setInteger(8, userInformation.getUserId()).executeUpdate();
	}
}
