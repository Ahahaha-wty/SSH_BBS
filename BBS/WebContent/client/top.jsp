<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Knowledge Base Theme</title>

<link rel="shortcut icon" href="${pageContext.request.contextPath}/client/images/favicon.png" />

<!-- Style Sheet-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/client/style.css" />
<link rel='stylesheet' id='${pageContext.request.contextPath}/client/bootstrap-css-css'
	href='${pageContext.request.contextPath}/client/css/bootstrap5152.css?ver=1.0' type='text/css' media='all' />
<link rel='stylesheet' id='responsive-css-css'
	href='${pageContext.request.contextPath}/client/css/responsive5152.css?ver=1.0' type='text/css' media='all' />
<link rel='stylesheet' id='pretty-photo-css-css'
	href='${pageContext.request.contextPath}/client/js/prettyphoto/prettyPhotoaeb9.css?ver=3.1.4' type='text/css'
	media='all' />
<link rel='stylesheet' id='main-css-css' href='${pageContext.request.contextPath}/client/css/main5152.css?ver=1.0'
	type='text/css' media='all' />
<link rel='stylesheet' id='custom-css-css'
	href='${pageContext.request.contextPath}/client/css/custom5152.html?ver=1.0' type='text/css' media='all' />
<link rel='stylesheet' href='${pageContext.request.contextPath}/client/css/boards.css' type='text/css' />
<style>
.a {
	background-color: white;
}

.a:hover {
	background-color: #fcfcfc;
}
</style>
</head>

<body>

	<!-- Start of Header -->
	<div class="header-wrapper">
		<header>
		<div class="container">


			<div class="logo-container">
				<!-- Website Logo -->
				<a href="${pageContext.request.contextPath}/client/index.jsp" title="Knowledge Base Theme"> <img
					src="${pageContext.request.contextPath}/client/images/logo.png" alt="Knowledge Base Theme">
				</a> <span class="tag-line">BBS</span>
			</div>

		<%-- 	<%
				String s = null;
				if (session.getAttribute("user") != null) {
					User user =  (User)session.getAttribute("user");
					s = "<a href='user/user_information.jsp'>" + user.getUsername() + "</a>"
							+ "丨<a href='loginOutAction'>注销</a>";
				} else {
					s = "<a href='register.jsp'>注册</a>丨<a href='login.jsp'>登陆</a>";
				}
			%> --%>
			<!-- Start of Main Navigation -->
			<nav class="main-nav">
			<div class="menu-top-menu-container">
				<ul id="menu-top-menu" class="clearfix">
					<li class="current-menu-item"><a href="${pageContext.request.contextPath}/client/index.jsp">首页</a></li>
					<li><a href="getBPagesAction">板块分类
							 <ul class="sub-menu">
                                    <li><a href="indexBoardAction?boardId=1"><img
					src="${pageContext.request.contextPath}/client/images/indexImg/learn.jpg"
					style="height: 20px; width: 20px; border-radius: 10px;" />学习天地</a></li>
                                     <li>
				<a href="indexBoardAction?boardId=2""><img
					src="${pageContext.request.contextPath}/client/images/indexImg/timg.jpg" 
					style="height: 20px; width: 20px; border-radius: 10px;" />校园生活</a>
			</li>
                                      <li><a href="indexBoardAction?boardId=3" ><img
					src="${pageContext.request.contextPath}/client/images/indexImg/view.jpg"
					style="height: 20px; width: 20px; border-radius: 10px;" />人文自然</a></li>
					<li><a href="getBPagesAction" style="margin-left: 20px">更多板块</a></li>
                          </ul>
					
					</a></li>
					<s:if test="#session.user==null"><li><a href="register.jsp">注册</a></li>
					<li><a href="login.jsp">登陆</a>					
					</li> </s:if>
					<s:else><li><a href="${pageContext.request.contextPath}/client/userInfo.jsp"><img
							src="${pageContext.request.contextPath}/<s:property value="#session.userInfo.headAdd"/>"
							style="width: 25px; height: 25px; border-radius: 12px; margin-right: 5px"><s:property value="#session.user.username"/>
							 <ul class="sub-menu">
                                    <li><a href="messageAction">消息管理</a></li>
                                     <li><a href="ownPostAction?postPeople=<s:property value="#session.user.username"/>">我的帖子</a></li>
                                      <li><a href="${pageContext.request.contextPath}/client/userInfo.jsp">个人信息</a></li>
                          </ul>
							
							</a></li>
					
					<li style="margin-left: -10px"><a href="loginOutAction">注销</a></li></s:else>					
					
					<!--<li><a href="faq.html">FAQs</a></li>
                                                                <li><a href="#">Skins</a>
                                                                        <ul class="sub-menu">
                                                                                <li><a href="blue-skin.html">Blue Skin</a></li>-->
					<!--<li><a href="green-skin.html">Green Skin</a></li>
                                                                                <li><a href="red-skin.html">Red Skin</a></li>
                                                                                <li><a href="index-2.html">Default Skin</a></li>
                                                                        </ul>
                                                                </li>
                                                                <li><a href="#">More</a>
                                                                        <ul class="sub-menu">
                                                                                <li><a href="full-width.html">Full Width</a></li>
                                                                                <li><a href="elements.html">Elements</a></li>
                                                                                <li><a href="page.html">Sample Page</a></li>
                                                                        </ul>
                                                                </li>
                                                                <li><a href="contact.html">Contact</a></li>-->
				</ul>
			</div>
			</nav>
			<!-- End of Main Navigation -->

		</div>
		</header>
	</div>
	<!-- End of Header -->

	<!-- Start of Search Wrapper -->
	<div class="search-area-wrapper">
		<div class="search-area container" style="height: 70px;">
			<h3 class="search-header" style="margin-top: -20px;">帖子搜索</h3>
			<form id="search-form" class="search-form clearfix" method="get"
				action="serchAction" autocomplete="off">
				<input class="search-term required" type="text" id="s" name="serchInfo"
					placeholder="Type your search terms here"
					title="* Please enter a search term!" /> <input class="search-btn"
					type="submit" value="Search" />
				<!--<div id="search-error-container"></div>-->
			</form>
		</div>
	</div>
	
<script type='text/javascript' src='${pageContext.request.contextPath}/client/js/jquery-1.8.3.min.js'></script>
                <script type='text/javascript' src='${pageContext.request.contextPath}/client/js/jquery.easing.1.3.js'></script>
                <script type='text/javascript' src='${pageContext.request.contextPath}/client/js/prettyphoto/jquery.prettyPhoto.js'></script>
                <script type='text/javascript' src='${pageContext.request.contextPath}/client/js/jflickrfeed.js'></script>
				<script type='text/javascript' src='${pageContext.request.contextPath}/client/js/jquery.liveSearch.js'></script>
                <script type='text/javascript' src='${pageContext.request.contextPath}/client/js/jquery.form.js'></script>
                <script type='text/javascript' src='${pageContext.request.contextPath}/client/js/jquery.validate.min.js'></script>
                <script type='text/javascript' src='${pageContext.request.contextPath}/client/js/custom.js'></script>
</body>
</html>