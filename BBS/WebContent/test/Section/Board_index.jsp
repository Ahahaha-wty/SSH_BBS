<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link  rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css"  />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" >
</head>
<body>
<p>板块主页面</p>
<p>版块的帖子信息</p>
<%-- <%= request.getAttribute("postLists") %> --%>
<s:debug></s:debug>


<table border="0" cellpadding="0" cellspacing="0" width="70%" align="center">
    <tbody>
      <tr valign="top">
        <td width="99%">
		<div class="jive-thread-list">
          <div class="jive-table">
<table summary="List of threads" cellpadding="0" cellspacing="0" width="100%">
                <thead>
                  <tr>
                    <th class="jive-first" colspan="3"> 主题 </th>
                    <th class="jive-author"> <nobr> 作者
                      &nbsp; </nobr> </th>
                    <th class="jive-view-count"> <nobr> 浏览
                      &nbsp; </nobr> </th>
                    <th class="jive-search-results" nowrap="nowrap"> 回复 </th>
                    <th class="jive-last" nowrap="nowrap"> 发表时间 </th>
                  </tr>
                </thead>
                <tbody>
				
				
				<s:iterator var="posts" value="postLists">
					<tr class="jive-even">
                    <td class="jive-first" nowrap="nowrap" width="1%"><div class="jive-bullet"> <img src="${pageContext.request.contextPath}/images/read-16x16.gif" alt="已读" border="0" height="16" width="16">
                        <!-- div-->
                      </div></td>
     
                    <td class="jive-thread-name" width="95%" colspan=2><a id="jive-thread-1" href="getDetailPostAction?postId=<s:property value="postId"></s:property>"><s:property value="title"></s:property></a></td>
                    <td class="jive-author" nowrap="nowrap" width="1%"><span class=""> <a href="personInfoAction?personUsername=<s:property value="postPeople"></s:property>"><s:property value="postPeople"></s:property></a> </span></td>
                    <td class="jive-view-count" width="1%"> 104</td>
                    <td class="jive-msg-count" width="1%"> 5</td>
                    <td class="jive-last" nowrap="nowrap" width="1%"><div class="jive-last-post"> 2007-9-13 上午9:31 <br>
                        by: <a href="http://bbs.chinajavaworld.com/thread.jspa?messageID=780182#780182" title="jingjiangjun" style="">jingjiangjun &#187;</a> </div></td>
                  </tr>
			</s:iterator>
				
				
				<%-- 
				<s:iterator var="posts" value="postLists">

 					<tr class="jive-even">
                    <td class="jive-first" nowrap="nowrap" width="1%"><div class="jive-bullet"> <img src="。。/images/read-16x16.gif" alt="已读" border="0" height="16" width="16">
                        <!-- div-->
                      </div></td>
     
                    <td class="jive-thread-name" width="95%" colspan=2><a id="jive-thread-1" href="getDetailPostAction?postId=<s:property value="postId"></s:property>"><s:property value="title"></s:property></a></td>
                    <td class="jive-author" nowrap="nowrap" width="1%"><span class=""> <a href="personInfoAction?personUsername=<s:property value="postPeople"></s:property>"><s:property value="postPeople"></s:property></a> </span></td>
                    <td class="jive-view-count" width="1%"><s:property value="publishTime"></s:property></td>
                   <td class="jive-msg-count" width="1%">123</td>
                    <td class="jive-last" nowrap="nowrap" width="1%"><div class="jive-last-post">123<br>
                        <a href="#" title="jingjiangjun" style="">123 &#187;</a> </div></td>
                  </tr>
</s:iterator> --%>
				  
				  
				  
				  
				  
				  
				  
				  
				  
                </tbody>
              </table>
            </div>
          </div>
          <div class="jive-legend"></div></td>
      </tr>
    
    </tbody>
</table>
</body>
</html>