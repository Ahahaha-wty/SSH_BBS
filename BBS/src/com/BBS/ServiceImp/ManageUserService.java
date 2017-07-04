package com.BBS.ServiceImp;

import java.util.ArrayList;
import java.util.List;

import com.BBS.Bean.BoardInfo;
import com.BBS.Bean.ForbiddenBoard;
import com.BBS.Bean.ManageUser;
import com.BBS.Bean.Message;
import com.BBS.Bean.ModeratorAuthority;
import com.BBS.Bean.ModeratorInfo;
import com.BBS.Bean.PageBean;
import com.BBS.Bean.User;
import com.BBS.Bean.UserAuthority;
import com.BBS.Bean.UserInformation;
import com.BBS.DaoImp.ManageUserDao;

public class ManageUserService {
	private ManageUserDao manageUserDao;
	
	public ManageUserDao getManageUserDao() {
		return manageUserDao;
	}

	public void setManageUserDao(ManageUserDao manageUserDao) {
		this.manageUserDao = manageUserDao;
	}

	public PageBean getModeratorUserPage(Integer boardId, Integer pageSize, Integer page) {
		PageBean pageBean = new PageBean();
		// 设置当前页
		int allRows = manageUserDao.getUsers().size();

		int totalPage = pageBean.getTotalPages(pageSize, allRows);

		int currentPage = pageBean.getCurPage(page);

		int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);

		List<User> list = manageUserDao.getUsers(offset, pageSize); 
		
		List<ManageUser> manageUsers = new ArrayList<>();
		for(User u: list){
			UserInformation userInformation = manageUserDao.getUserInfo(u.getUserId());
			ForbiddenBoard forbiddenBoard = manageUserDao.getForbBoard(u.getUserId(), boardId);
			ManageUser m = null;
			if (forbiddenBoard==null) {
				m = new ManageUser(u.getUserId(), u.getUsername(), userInformation.getSex(),
						userInformation.getRegistTime(), userInformation.getPostNum(), 0);
			}else {
				m = new ManageUser(u.getUserId(), u.getUsername(), userInformation.getSex(),
						userInformation.getRegistTime(), userInformation.getPostNum(), 1);
			}
			manageUsers.add(m);
		}
		pageBean.setList(manageUsers);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);

		return pageBean;
	}
	public void moForbidden(Integer boardId,Integer userId) {
		manageUserDao.moForbidden(boardId, userId);
	}
	public void moDeleteForbidden(Integer boardId,Integer userId) {
		manageUserDao.moDeleteForbidden(boardId, userId);
	}
	
	
	public PageBean getAdUserPage(Integer pageSize, Integer page) {
		PageBean pageBean = new PageBean();
		// 设置当前页
		int allRows = manageUserDao.getUsers().size();

		int totalPage = pageBean.getTotalPages(pageSize, allRows);

		int currentPage = pageBean.getCurPage(page);

		int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);

		List<User> list = manageUserDao.getUsers(offset, pageSize); 
		
		List<ManageUser> manageUsers = new ArrayList<>();
		for(User u: list){
			System.out.println("1");
			UserInformation userInformation = manageUserDao.getUserInfo(u.getUserId());
			System.out.println(userInformation.getUserId());
			UserAuthority userAuthority = manageUserDao.getUserAu(u.getUserId());
			ManageUser m = null;
			if (userAuthority.getPublishPostAu().equals("true")) {
				m = new ManageUser(u.getUserId(), u.getUsername(), userInformation.getSex(),
						userInformation.getRegistTime(), userInformation.getPostNum(), 0);
			}else {
				m = new ManageUser(u.getUserId(), u.getUsername(), userInformation.getSex(),
						userInformation.getRegistTime(), userInformation.getPostNum(), 1);
			}
			manageUsers.add(m);
		}
		pageBean.setList(manageUsers);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);

		return pageBean;
	}
	public void adChangeAu(Integer userId,String au) {
		manageUserDao.adChangeUserAu(userId,au);
	}
	public void adDeleteUser(Integer userId) {
		manageUserDao.adDeleteUser(userId);
	}
	
	
	public PageBean getModeratorPage(Integer pageSize, Integer page) {
		PageBean pageBean = new PageBean();
		// 设置当前页
		int allRows = manageUserDao.getModerator().size();

		int totalPage = pageBean.getTotalPages(pageSize, allRows);

		int currentPage = pageBean.getCurPage(page);

		int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);

		List<ModeratorAuthority> list = manageUserDao.getMoPage(offset, pageSize);
		
		List<ModeratorInfo> moderatorInfos = new ArrayList<>();
		for(ModeratorAuthority m: list){
			User user = manageUserDao.getUser(m.getUserId());
			BoardInfo boardInfo = manageUserDao.getBoard(m.getBoardId());
			ModeratorInfo mo = new ModeratorInfo(m.getUserId(), user.getUsername(), boardInfo.getBoardName(), 
					m.getPostManageAu(), m.getBoardManageAu(), m.getMemberManageAu());			
			moderatorInfos.add(mo);
		}
		pageBean.setList(moderatorInfos);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);

		return pageBean;
	}
	public void moPostManAu(Integer userId,String au) {
		String Au = "";
		if (au.equals("false")) {
			Au = "true";
		}else {
			Au = "false";
		}
		manageUserDao.moPostManAu(userId, Au);
	}
	public void moMemManAu(Integer userId,String au) {
		String Au = "";
		if (au.equals("false")) {
			Au = "true";
		}else {
			Au = "false";
		}
		manageUserDao.moMemManAu(userId, Au);
	}
	public void moBoardManAu(Integer userId,String au) {
		String Au = "";
		if (au.equals("false")) {
			Au = "true";
		}else {
			Au = "false";
		}
		manageUserDao.moBoardManAu(userId, Au);
	}
	public void deleteMo(Integer userId) {
		manageUserDao.deleteMo(userId);
	}
	public void addUser(User user) {
		manageUserDao.addUser(user);		
	}
	public void addUserInfo(UserInformation userInformation) {
		manageUserDao.addUserInfo(userInformation);	
	}
	public User findUser(String username) {
		return manageUserDao.findUser(username);		
	}
	public void addModerator(ModeratorAuthority moderatorAuthority) {
		User user = manageUserDao.findUser(moderatorAuthority.getUserId());
		if (user.getTypeId().equals(2)) {
			System.out.println(moderatorAuthority.getBoardId());
			System.out.println(user.getTypeId().equals(2));
			manageUserDao.updateMo(moderatorAuthority);
		}else{
			manageUserDao.addMo(moderatorAuthority);
			System.out.println(user.getTypeId().equals(2));
		}
	}
	public void adminAddMessage(Message message) {
		manageUserDao.adminAddMessage(message);
	}
}
