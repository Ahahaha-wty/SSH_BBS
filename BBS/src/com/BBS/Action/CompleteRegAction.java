package com.BBS.Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.websocket.Session;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.BBS.Bean.User;
import com.BBS.Bean.UserInformation;
import com.BBS.ServiceImp.CompleteRegService;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.glass.ui.Application;

public class CompleteRegAction extends ActionSupport implements SessionAware{
	private String email;
	private Integer sex;
	private String birthday;
	private String nativePlace;
	private String qq;
	private String selfInfo;
	private String psersonalIsign;
	private String headAdd;
	private List<File> file;
	private Map session;
	private CompleteRegService completeRegService;
	public CompleteRegService getCompleteRegService() {
		return completeRegService;
	}

	public void setCompleteRegService(CompleteRegService completeRegService) {
		this.completeRegService = completeRegService;
	}

	private List<String> fileFileName;

	private List<String> fileContentType;

	private String dataUrl;

	private String imgUrl;

	@Override
	public String execute() throws Exception {
		imgUrl = "files\\default.jpg";
		// dataUrl = new ArrayList<String>();
		
		Date date=new Date();		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String time=format.format(date);
		User user = (User) ServletActionContext.getRequest().getSession().getValue("user");
//		System.out.println(1);
//		System.out.println(user.getUsername());
		if (file!=null) {		
		for (int i = 0; i < file.size(); ++i) {
			InputStream is = new FileInputStream(file.get(i));

			String path = ServletActionContext.getServletContext().getRealPath("/files");
			System.out.println(path);
			// String root = "D:\\";
			System.out.println(this.getFileFileName().get(i));
			dataUrl = user.getUsername()+ time + this.getFileFileName().get(i);
			File destFile = new File(path, dataUrl);
			System.out.println(dataUrl);
			OutputStream os = new FileOutputStream(destFile);
			imgUrl = "files\\"+ user.getUsername()
					+ time + this.getFileFileName().get(i);
			byte[] buffer = new byte[400];

			int length = 0;

			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}

			is.close();

			os.close();
			
		}
		}
		format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		time=format.format(date);
		
		headAdd = imgUrl;
		UserInformation userInfo = new UserInformation(user.getUserId(), email, sex, birthday, nativePlace, qq, selfInfo, psersonalIsign, 0, headAdd, time, 1,0);
		completeRegService.save(userInfo);
		session.put("userInfo", userInfo);
		return SUCCESS;
	}
	public String updateUserInfo() throws Exception {
		User user = (User) session.get("user");
		UserInformation oldUserInfo = (UserInformation) session.get("userInfo");
		imgUrl = oldUserInfo.getHeadAdd();
		// dataUrl = new ArrayList<String>();
		
		Date date=new Date();		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String time=format.format(date);
//		System.out.println(1);
//		System.out.println(user.getUsername());
		if (file!=null) {		
		for (int i = 0; i < file.size(); ++i) {
			InputStream is = new FileInputStream(file.get(i));

			String path = ServletActionContext.getServletContext().getRealPath("/files");
			dataUrl = user.getUsername()+ time + this.getFileFileName().get(i);
			File destFile = new File(path, dataUrl);
			OutputStream os = new FileOutputStream(destFile);
			imgUrl = "files\\"+ user.getUsername()
					+ time + this.getFileFileName().get(i);
			byte[] buffer = new byte[400];

			int length = 0;

			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}

			is.close();

			os.close();
			
		}
		}
		UserInformation newUserInfo = new UserInformation(user.getUserId(), email, sex, birthday, nativePlace, qq, selfInfo, psersonalIsign, imgUrl);
		session.put("userInfo", newUserInfo);
		completeRegService.updateUserInfo(newUserInfo);
		return SUCCESS;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getSelfInfo() {
		return selfInfo;
	}

	public void setSelfInfo(String selfInfo) {
		this.selfInfo = selfInfo;
	}

	public String getPsersonalIsign() {
		return psersonalIsign;
	}

	public void setPsersonalIsign(String psersonalIsign) {
		this.psersonalIsign = psersonalIsign;
	}

	public String getHeadAdd() {
		return headAdd;
	}

	public void setHeadAdd(String headAdd) {
		this.headAdd = headAdd;
	}

	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<String> getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}

	public List<String> getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getDataUrl() {
		return dataUrl;
	}

	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
		
	}

}
