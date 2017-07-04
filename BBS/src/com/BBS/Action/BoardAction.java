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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.BBS.Bean.BoardInfo;
import com.BBS.Bean.ModeratorAuthority;
import com.BBS.Bean.PageBean;
import com.BBS.ServiceImp.BoardService;
import com.opensymphony.xwork2.ActionSupport;

public class BoardAction extends ActionSupport implements SessionAware{

	private BoardService boardService;
	private String boardId;
	private String boardname;
	private String boardDesc;
	private List<File> file;
	private List<String> fileFileName;
	private Map session;
	private List<String> fileContentType;

	private String dataUrl;

	private String imgUrl;

	public BoardService getBoardService() {
		return boardService;
	}

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	public String addBoard() throws Exception {
		if (boardname.length() <= 0) {
			this.addActionError("请输入板块名称");
			return INPUT;
		}
		if (boardDesc.length() <= 0) {
			this.addActionError("请输入板块介绍");
			return INPUT;
		}
		if (file == null) {
			this.addActionError("请为板块添加图片");
			return INPUT;
		}
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String time = format.format(date);
		if (file != null) {
			for (int i = 0; i < file.size(); ++i) {
				InputStream is = new FileInputStream(file.get(i));

				String path = ServletActionContext.getServletContext().getRealPath("/files/boards");
				System.out.println(path);
				// String root = "D:\\";
				System.out.println(this.getFileFileName().get(i));
				dataUrl = this.getBoardname() + time + this.getFileFileName().get(i);
				File destFile = new File(path, dataUrl);
				System.out.println(dataUrl);
				OutputStream os = new FileOutputStream(destFile);
				imgUrl = "files\\boards\\"+ this.getBoardname() + time + this.getFileFileName().get(i);
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
		time = format.format(date);
		BoardInfo boardInfo = new BoardInfo(boardname, time, boardDesc, imgUrl);
		boardService.add(boardInfo);
		return "success";
	}

//	public String getBoards() {
//		for (BoardInfo b : boardService.getBoards(0, 3))
//			System.out.println(b.getBoardName());
//		return "success";
//	}
	
	public String getPages() {
		PageBean pageBean = boardService.getBoardPages(4, page);

		HttpSession session = ServletActionContext.getRequest().getSession();

		session.setAttribute("pageBean", pageBean);

		return SUCCESS;
	}
	public String getBoardPages() {
		PageBean pageBean = boardService.getBoardPages(6, page);

		HttpSession session = ServletActionContext.getRequest().getSession();

		session.setAttribute("pageBean", pageBean);

		return SUCCESS;
	}
	
	public String getPostPages() {
//		if (session.get("wrongMessage")!=null) {
//			session.remove("wrongMessage");
//		}
		BoardInfo boardInfo=null;
		HttpSession session = ServletActionContext.getRequest().getSession();
		if (boardId!=null) {
			boardInfo = boardService.getBoardInfo(Integer.valueOf(boardId).intValue());
			session.setAttribute("detailBoardInfo", boardInfo);
		}
		else {
			 boardInfo = (BoardInfo) session.getAttribute("detailBoardInfo");
		}
		
		PageBean pageBean = boardService.getPostPage(boardInfo.getBoardId(), 5, page);
		
		
		session.setAttribute("pageBean", pageBean);
		session.setAttribute("topPosts", boardService.getTopPost(boardInfo.getBoardId()));				
		return SUCCESS;
	}
	public String getEssencePostPages() {
//		if (session.get("wrongMessage")!=null) {
//			session.remove("wrongMessage");
//		}
		BoardInfo boardInfo=null;
		HttpSession session = ServletActionContext.getRequest().getSession();
		if (boardId!=null) {
			boardInfo = boardService.getBoardInfo(Integer.valueOf(boardId).intValue());
			session.setAttribute("detailBoardInfo", boardInfo);
		}
		else {
			 boardInfo = (BoardInfo) session.getAttribute("detailBoardInfo");
		}
		
		PageBean pageBean = boardService.getEssencePostPage(boardInfo.getBoardId(), 6, page);
		
		
		session.setAttribute("pageBean", pageBean);
						
		return SUCCESS;
	}
	public String moderatorPosts() {
		ModeratorAuthority moderatorAuthority = (ModeratorAuthority) session.get("authority");
		PageBean pageBean = boardService.getPostPage(moderatorAuthority.getBoardId(), 8, page);	
		session.put("pageBean", pageBean);						
		return SUCCESS;
	}
	
	public String adminPosts() {
		PageBean pageBean = boardService.getAllPostPage(8, page);	
		session.put("pageBean", pageBean);						
		return SUCCESS;
	}
	
	public String moUpBoardPage() {
		ModeratorAuthority moderatorAuthority = (ModeratorAuthority) session.get("authority");
		BoardInfo boardInfo = boardService.getBoardInfo(moderatorAuthority.getBoardId());
		session.put("moBoardInfo", boardInfo);		
		return SUCCESS;
	}
	public String adUpBoardPage() {
		BoardInfo boardInfo = boardService.getBoardInfo(Integer.valueOf(boardId));
		session.put("moBoardInfo", boardInfo);		
		return SUCCESS;
	}
	public String moUpBoard() throws Exception {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String time = format.format(date);
		ModeratorAuthority moderatorAuthority = (ModeratorAuthority) session.get("authority");
		if (file != null) {
			for (int i = 0; i < file.size(); ++i) {
				InputStream is = new FileInputStream(file.get(i));

				String path = ServletActionContext.getServletContext().getRealPath("/files/boards");
				System.out.println(path);
				// String root = "D:\\";
				System.out.println(this.getFileFileName().get(i));
				dataUrl = moderatorAuthority.getBoardId() + time + this.getFileFileName().get(i);
				File destFile = new File(path, dataUrl);
				System.out.println(dataUrl);
				OutputStream os = new FileOutputStream(destFile);
				imgUrl = "files\\boards\\"+ moderatorAuthority.getBoardId() + time + this.getFileFileName().get(i);
				byte[] buffer = new byte[400];

				int length = 0;

				while ((length = is.read(buffer)) > 0) {
					os.write(buffer, 0, length);
				}

				is.close();

				os.close();

			}
		}
		boardService.updateBoardInfo(imgUrl, boardDesc, moderatorAuthority.getBoardId());
		
		
		return SUCCESS;
	}
	public String adUpBoard() throws Exception {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String time = format.format(date);
		BoardInfo boardInfo = (BoardInfo) session.get("moBoardInfo");
		if (file != null) {
			for (int i = 0; i < file.size(); ++i) {
				InputStream is = new FileInputStream(file.get(i));

				String path = ServletActionContext.getServletContext().getRealPath("/files/boards");
				System.out.println(path);
				// String root = "D:\\";
				System.out.println(this.getFileFileName().get(i));
				dataUrl = boardInfo.getBoardId() + time + this.getFileFileName().get(i);
				File destFile = new File(path, dataUrl);
				System.out.println(dataUrl);
				OutputStream os = new FileOutputStream(destFile);
				imgUrl = "files\\boards\\"+ boardInfo.getBoardId() + time + this.getFileFileName().get(i);
				byte[] buffer = new byte[400];

				int length = 0;

				while ((length = is.read(buffer)) > 0) {
					os.write(buffer, 0, length);
				}

				is.close();

				os.close();

			}
		}
		boardService.updateBoardInfo(imgUrl, boardDesc, boardInfo.getBoardId());
		
		
		return SUCCESS;
	}
	public String indexAction() {
		session.put("adminMessage", boardService.getAdMessage());
		session.put("hotPosts", boardService.getHotPosts());
		return SUCCESS;
	}
	public String getBoards() {
		List<BoardInfo> list = boardService.getBoards();
		session.put("boardInfo", list);
		return SUCCESS;
	}
	public String adDleteBoard() {
		boardService.adDeleteBoard(Integer.valueOf(boardId));
		return SUCCESS;
	}
	
	
	public String getBoardname() {
		return boardname;
	}

	public void setBoardname(String boardname) {
		this.boardname = boardname;
	}

	public String getBoardDesc() {
		return boardDesc;
	}

	public void setBoardDesc(String boardDesc) {
		this.boardDesc = boardDesc;
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

	private int page;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getBoardId() {
		return boardId;
	}

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
		
	}

}
