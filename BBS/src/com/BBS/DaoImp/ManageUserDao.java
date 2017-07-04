package com.BBS.DaoImp;

import java.util.List;

import com.BBS.Bean.BoardInfo;
import com.BBS.Bean.ForbiddenBoard;
import com.BBS.Bean.Message;
import com.BBS.Bean.ModeratorAuthority;
import com.BBS.Bean.User;
import com.BBS.Bean.UserAuthority;
import com.BBS.Bean.UserInformation;

public class ManageUserDao extends BaseDao{
	public List<UserInformation> getUserInformations() {
		String hql = "from UserInformation";
		return getSession().createQuery(hql).list();
	}
	public List<User> getUsers() {
		String hql = "from User";
		return getSession().createQuery(hql).list();
	}
	/*public UserAuthority getUserAu() {
			
	}*/
	public ForbiddenBoard getForbBoard(Integer userId,Integer boardId) {
		String hql = "from ForbiddenBoard f where f.userId = ? and f.BoardId = ?";
		List<ForbiddenBoard> list = getSession().createQuery(hql).setInteger(0, userId).setInteger(1, boardId).list();
		if (list.size()!=0) {
			return list.get(0);
		}
		return null;
	}
	
	public List<User> getUsers(Integer offset,Integer pageSize) {
		String hql = "from User";
		return getSession().createQuery(hql).setFirstResult(offset)
				.setMaxResults(pageSize).list();
	}
	public UserInformation getUserInfo(Integer userId) {
		String hql = "from UserInformation u where u.userId = ?";
		return (UserInformation) getSession().createQuery(hql).setInteger(0, userId).list().get(0);
	}
	public List<UserInformation> getUserInfoList(Integer userId) {
		String hql = "from UserInformation u where u.userId = ?";
		return getSession().createQuery(hql).setInteger(0, userId).list();
	}
	public void moForbidden(Integer boardId,Integer userId) {
		ForbiddenBoard forbiddenBoard = new ForbiddenBoard(userId, boardId);
		getSession().save(forbiddenBoard);
	}
	public void moDeleteForbidden(Integer boardId,Integer userId) {
		String hql = "delete from ForbiddenBoard f where f.userId = ? and f.BoardId = ?";
		getSession().createQuery(hql).setInteger(0, userId).setInteger(1, boardId).executeUpdate();
	}
	
	public void adDeleteUser(Integer userId) {
		String hql = "from User u where u.userId = ?";
		User user = (User) getSession().createQuery(hql).setInteger(0, userId).list().get(0);
		hql = "delete from User u where u.userId = ?";
		getSession().createQuery(hql).setInteger(0, userId).executeUpdate();
		hql = "delete from UserInformation u where u.userId = ?";
		getSession().createQuery(hql).setInteger(0, userId).executeUpdate();
		hql = "delete from Post p where p.postPeople = ?";
		getSession().createQuery(hql).setString(0, user.getUsername()).executeUpdate();
		hql = "delete from PostReply p where p.userId = ?";
		getSession().createQuery(hql).setInteger(0, userId).executeUpdate();
		
	}
	public void adChangeUserAu(Integer userId , String au) {
		String hql = "update UserAuthority u set u.publishPostAu = ?,u.replyAu = ? where  u.userId = ?";
		getSession().createQuery(hql).setString(0, au).setString(1, au).setInteger(2, userId).executeUpdate();
	}
	public UserAuthority getUserAu(Integer userId) {
		String hql = "from UserAuthority u where u.userId = ?";
		List<UserAuthority> list = getSession().createQuery(hql).setInteger(0, userId).list();
		if (list.size()!=0) {
			return list.get(0);
		}
		return null;
	}
	public List<ModeratorAuthority> getModerator() {
		String hql = "from ModeratorAuthority ";
		return getSession().createQuery(hql).list();
	}
	public List<ModeratorAuthority> getMoPage(Integer offset,Integer pageSize) {
		String hql = "from ModeratorAuthority";
		return getSession().createQuery(hql).setFirstResult(offset)
				.setMaxResults(pageSize).list();
	}
	public User getUser(Integer userId) {
		String hql = "from User u where u.userId = ?";
		List<User> list = getSession().createQuery(hql).setInteger(0, userId).list();
		if (list.size()!=0) {
			return list.get(0);
		}
		return null;
	}
	public BoardInfo getBoard(Integer boardId) {
		String hql = "from BoardInfo b where b.boardId = ?";
		List<BoardInfo> list = getSession().createQuery(hql).setInteger(0, boardId).list();
		if (list.size()!=0) {
			return list.get(0);
		}
		return null;
	}
	public void moPostManAu(Integer userId,String au){
		String hql = "update ModeratorAuthority m set m.postManageAu = ? where  m.userId = ?";
		getSession().createQuery(hql).setString(0, au).setInteger(1, userId).executeUpdate();
	}
	public void moMemManAu(Integer userId,String au){
		String hql = "update ModeratorAuthority m set m.memberManageAu = ? where  m.userId = ?";
		getSession().createQuery(hql).setString(0, au).setInteger(1, userId).executeUpdate();
	}
	public void moBoardManAu(Integer userId,String au){
		String hql = "update ModeratorAuthority m set m.boardManageAu = ? where  m.userId = ?";
		getSession().createQuery(hql).setString(0, au).setInteger(1, userId).executeUpdate();
	}
	public void deleteMo(Integer userId){
		String hql = "delete from ModeratorAuthority m where m.userId = ?";
		getSession().createQuery(hql).setInteger(0, userId).executeUpdate();
		hql = "update User u set u.typeId = 1 where u.userId = ?";
		getSession().createQuery(hql).setInteger(0, userId).executeUpdate();
	}
	public void addUser(User user) {		
		getSession().saveOrUpdate(user);
	}
	public void addUserInfo(UserInformation userInformation) {		
		getSession().saveOrUpdate(userInformation);
	}
	public User findUser(String username) {
		String hql = "from User u where u.username = ?";
		List<User> list = getSession().createQuery(hql).setString(0, username).list();
		if (list.size()!=0) {
			return list.get(0);	
		}
			return null;
	}
	public User findUser(Integer userId) {
		String hql = "from User u where u.userId = ?";
		List<User> list = getSession().createQuery(hql).setInteger(0, userId).list();
		if (list.size()!=0) {
			return list.get(0);	
		}
			return null;
	}
	public void addMo(ModeratorAuthority moderatorAuthority) {
		getSession().saveOrUpdate(moderatorAuthority);
		String hql = "update User u set u.typeId = ? where u.userId = ?";
		getSession().createQuery(hql).setInteger(0, 2).setInteger(1, moderatorAuthority.getUserId()).executeUpdate();
	}
	public void updateMo(ModeratorAuthority moderatorAuthority) {
		String hql = "update ModeratorAuthority m set m.boardId = ? where m.userId = ?";
		getSession().createQuery(hql).setInteger(0, moderatorAuthority.getBoardId()).setInteger(1, moderatorAuthority.getUserId()).executeUpdate();
	}
	public void adminAddMessage(Message message) {
		getSession().saveOrUpdate(message);
	}
}
