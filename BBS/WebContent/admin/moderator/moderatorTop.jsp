<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/resources/css/reset.css" type="text/css" media="screen" />
		<!-- Main Stylesheet -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/resources/css/style.css" type="text/css" media="screen" />
		<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/resources/css/invalid.css" type="text/css" media="screen" />
		<!--                       Javascripts                       -->
		<!-- jQuery -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/admin/resources/scripts/jquery-1.3.2.min.js"></script>
		<!-- jQuery Configuration -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/admin/resources/scripts/simpla.jquery.configuration.js"></script>
		<!-- Facebox jQuery Plugin -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/admin/resources/scripts/facebox.js"></script>
		<!-- jQuery WYSIWYG Plugin -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/admin/resources/scripts/jquery.wysiwyg.js"></script>
		<!-- jQuery Datepicker Plugin -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/admin/resources/scripts/jquery.datePicker.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/admin/resources/scripts/jquery.date.js"></script>
	</head>

	<body>
		<div id="body-wrapper">
			<!-- Wrapper for the radial gradient background -->
			<div id="sidebar">
				<div id="sidebar-wrapper">
					<!-- Sidebar with logo and menu -->
					<h1 id="sidebar-title"><a href="#">Simpla Admin</a></h1>
					<!-- Logo (221px wide) -->
					<a href="#"><img id="logo" src="${pageContext.request.contextPath}/admin/resources/images/logo.png" alt="Simpla Admin logo" /></a>
					<!-- Sidebar Profile links -->
					<div id="profile-links"> Hello,
						<a href="#" title="Edit your profile"><s:property value="#session.admin.username"/> </a>, you have
						<a href="#messages" rel="modal" title="3 Messages">3 Messages</a><br />
						<br />
						<a href="${pageContext.request.contextPath}/client/index_main.jsp" title="View the Site">论坛主页</a> |
						<a href="adminLoginOutAction" title="Sign Out">注销</a>
					</div>
					<ul id="main-nav">
						<!-- Accordion Menu -->
						<s:if test="#session.admin!=null">
						<li>
							<a href="#" class="nav-top-item" id="postManage">
								<!-- Add the class "current" to current menu item -->
								帖子管理 </a>
							<ul>
							<s:if test="#session.authority.postManageAu=='false'">
								<script type="text/javascript">
									document.getElementById('postManage').onclick = function(){
										alert('对不起，您没有权限，请联系管理员');
									}
								</script>
							</s:if>
							<s:else>
							<li>
									<a href="showAllBoardPostsAction">查看帖子</a>
								</li>
								<%-- <li>
									<a href="${pageContext.request.contextPath}/admin/moderator/moderatorSerch.jsp">按标题查找</a>
								</li> --%>
							</s:else>
								
								<!-- Add class "current" to sub menu items also -->
								
							</ul>
						</li>
						<li>
							<a href="#" class="nav-top-item" id="memberManage">板块会员管理 </a>
							<ul>
							<s:if test="#session.authority.memberManageAu=='false'">
								<script type="text/javascript">
									document.getElementById('memberManage').onclick = function(){
										alert('对不起，您没有权限，请联系管理员');
									}
								</script>
							</s:if>
							<s:else>
								<li>
									<a href="showMoUserAction">查看会员</a>
								</li>
								</s:else>
								<!-- <li>
									<a href="#">按用户名查找</a>
								</li> -->
							</ul>
						</li>
						<li>
							<a href="#" class="nav-top-item" id="boardManage"> 板块管理 </a>
							<ul>
							<s:if test="#session.authority.boardManageAu=='false'">
								<script type="text/javascript">
									document.getElementById('boardManage').onclick = function(){
										alert('对不起，您没有权限，请联系管理员');
									}
								</script>
							</s:if>
							<s:else>
								<li>
									<a href="moUpdateBoardAction">板块更新</a>
								</li>
							</s:else>
							</ul>
						</li>
						</s:if>
						<li>
							<a href="#" class="nav-top-item"> 更多功能 </a>
							<ul>
								<li>
									<a href="#">尽请期待</a>
								</li>
								<li>
									<a href="#">尽请期待</a>
								</li>
								<li>
									<a href="#">尽请期待</a>
								</li>
							</ul>
						</li>
						
					</ul>
					<!-- End #main-nav -->
					<div id="messages" style="display: none">
						<!-- Messages are shown when a link with these attributes are clicked: href="#messages" rel="modal"  -->
						<h3>3 Messages</h3>
						<p> <strong>17th May 2009</strong> by Admin<br /> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus magna. Cras in mi at felis aliquet congue. <small><a href="#" class="remove-link" title="Remove message">Remove</a></small> </p>
						<p> <strong>2nd May 2009</strong> by Jane Doe<br /> Ut a est eget ligula molestie gravida. Curabitur massa. Donec eleifend, libero at sagittis mollis, tellus est malesuada tellus, at luctus turpis elit sit amet quam. Vivamus pretium ornare est. <small><a href="#" class="remove-link" title="Remove message">Remove</a></small> </p>
						<p> <strong>25th April 2009</strong> by Admin<br /> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus magna. Cras in mi at felis aliquet congue. <small><a href="#" class="remove-link" title="Remove message">Remove</a></small> </p>
						<form action="#" method="post">
							<h4>New Message</h4>
							<fieldset>
								<textarea class="textarea" name="textfield" cols="79" rows="5"></textarea>
							</fieldset>
							<fieldset>
								<select name="dropdown" class="small-input">
									<option value="option1">Send to...</option>
									<option value="option2">Everyone</option>
									<option value="option3">Admin</option>
									<option value="option4">Jane Doe</option>
								</select>
								<input class="button" type="submit" value="Send" />
							</fieldset>
						</form>
					</div>
					<!-- End #messages -->
				</div>
			</div>
			<!-- End #sidebar -->
			<div id="main-content">
				<!-- Main Content Section with everything -->
	<noscript>
    <!-- Show a notification if the user has disabled javascript -->
    <div class="notification error png_bg">
      <div> Javascript is disabled or is not supported by your browser. Please <a href="http://browsehappy.com/" title="Upgrade to a better browser">upgrade</a> your browser or <a href="http://www.google.com/support/bin/answer.py?answer=23852" title="Enable Javascript in your browser">enable</a> Javascript to navigate the interface properly.
        Download From <a href="http://www.exet.tk">exet.tk</a></div>
    </div>
    </noscript>
				<!-- Page Head -->
				<h2>Welcome</h2>
				<p id="page-intro">What would you like to do?</p>
				<ul class="shortcut-buttons-set">
					<li>
						<a class="shortcut-button" href="#"><span> <img src="${pageContext.request.contextPath}/admin/resources/images/icons/pencil_48.png" alt="icon" /><br />
        Write an Article </span></a>
					</li>
					<li>
						<a class="shortcut-button" href="#"><span> <img src="${pageContext.request.contextPath}/admin/resources/images/icons/paper_content_pencil_48.png" alt="icon" /><br />
        Create a New Page </span></a>
					</li>
					<li>
						<a class="shortcut-button" href="#"><span> <img src="${pageContext.request.contextPath}/admin/resources/images/icons/image_add_48.png" alt="icon" /><br />
        Upload an Image </span></a>
					</li>
					<li>
						<a class="shortcut-button" href="#"><span> <img src="${pageContext.request.contextPath}/admin/resources/images/icons/clock_48.png" alt="icon" /><br />
        Add an Event </span></a>
					</li>
					<li>
						<a class="shortcut-button" href="#messages" rel="modal"><span> <img src="${pageContext.request.contextPath}/admin/resources/images/icons/comment_48.png" alt="icon" /><br />
        Open Modal </span></a>
					</li>
				</ul>
				<!-- End .shortcut-buttons-set -->
				<div class="clear"></div>

</body>
</html>