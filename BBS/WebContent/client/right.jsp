<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <aside class="span page-sidebar"style="width: 150px;margin-right:10px ;float: right;">

                                              

                                                <section class="widget" ">
                                                        <div class="quick-links-widget">
                                                                <h3 class="title">快速链接</h3>
                                                                <ul >
                                                                        <li><a href="index_main.jsp">首页</a></li>
                                                                        <li><a href="getBPagesAction">板块分类</a></li>
                                                                        
                                                                </ul>
                                                        </div>
                                                         <div class="quick-links-widget" style="margin-top: 20px">
                                                                 <p class="title" style="color: red;">公告<img src="images/indexImg/1.jpg"  style="width: 20px;height: 20px;margin-top: -5px"/>:</p>
                                                                 <div  style="overflow: hidden;word-break: break-all;height: 100px;"><s:property value="#session.adminMessage.content"/> </div>
                                                                 
                                                                 
                                                        </div>
                                                </section>

                                             

                                        </aside>
</body>
</html>