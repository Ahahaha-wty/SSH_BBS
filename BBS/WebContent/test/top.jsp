<%@page import="com.BBS.Bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link  rel="stylesheet" type="text/css" href="css/index.css"  />
<link rel="stylesheet" type="text/css" href="css/style.css" >
<script src="js/sliderengine/jquery.js"></script>
<script src="js/sliderengine/amazingslider.js"></script>
<script src="js/sliderengine/initslider-1.js"></script>
</head>
<body>
<%
	String s = null;
	if(session.getAttribute("user")!=null){
		User user = (User)session.getAttribute("user");
		s ="<a href='user/user_information.jsp'>"+user.getUsername()+"</a>" +
			"丨<a href='loginOutAction'>注销</a>";
	}else{		
		s ="<a href='register.jsp'>注册</a>丨<a href='login.jsp'>登陆</a>";
	}
%> 

<div class="head">
   <div class="inhead">
     <div class="inheadleft" > 设为首页 | 收藏</div> 
     <div class="inheadright" ><%=s %></div>
   </div>
</div>

</body>
</html>