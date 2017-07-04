package com.BBS.DaoImp;



import java.util.List;

import com.BBS.Bean.ForbiddenBoard;
import com.BBS.Bean.ModeratorAuthority;
import com.BBS.Bean.UserAuthority;

public class AuthorityDao extends BaseDao{
	public UserAuthority getUserAu(Integer userId) {
		String hql = "from UserAuthority u where u.userId = ?";
		List<UserAuthority> list =  getSession().createQuery(hql).setInteger(0, userId).list();
		if (list.size()!=0) {
			return list.get(0);
		}
		return null ;
	}
	public ModeratorAuthority getModertorAu(Integer userId) {
		String hql = "from ModeratorAuthority m where m.userId = ?";
		List<ModeratorAuthority> list = getSession().createQuery(hql).setInteger(0, userId).list();
		if (list.size()!=0) {
			return list.get(0);
		}
		return null ;
	}
	public void saveUserAu(UserAuthority userAuthority) {
		getSession().save(userAuthority);
	}
	public void saveModeratorAu(ModeratorAuthority moderatorAuthority) {
		getSession().save(moderatorAuthority);
	}
	public void saveForbiddenUser(ForbiddenBoard forbiddenBoard) {
		getSession().save(forbiddenBoard);
	}
	public List<ForbiddenBoard> getForbiddenBoards(Integer userId) {
		String hql = "from ForbiddenBoard f where f.userId = ?";
		List<ForbiddenBoard> list = getSession().createQuery(hql).setInteger(0, userId).list();
		if (list.size()!=0) {
			return list;
		}
		return null;
	}
}
