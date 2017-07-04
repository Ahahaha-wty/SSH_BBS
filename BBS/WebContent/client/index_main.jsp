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
	<jsp:include page="top.jsp"></jsp:include>
	<div class="page-container">
		<div class="container">
			<div class="row">

				<!-- start of page content -->
				<div class="span page-content">

					<!-- Basic Home Page Template -->
					<div class="row separator">
						<jsp:include page="left.jsp"></jsp:include>


						<section class="span articles-list" style="width: 600px; ">
						<h3>热门内容</h3>
						<ul class="articles">
							<s:iterator value="#session.hotPosts" id="hotPosts">
							<li class="article-entry standard a">
								<h4>
									<img  src="${pageContext.request.contextPath}/client/images/indexImg/fire.jpg" style="width: 20px;height: 20px"><a href="postAction?postId=<s:property value = "#hotPosts.postId" />"><s:property value="#hotPosts.title"/></a>
								</h4> <span class="article-meta"><s:property value="#hotPosts.content"/><span
									style="float: right; margin-right: 70px;"><s:property value="#hotPosts.publishTime"/></span></span>
								<span class="like-count">回帖数：<span><s:property value="#hotPosts.replyTime"/></span></span>
							</li>
							</s:iterator>
						</ul>
						</section>
					</div>
				</div>
				<!-- end of page content -->


				<!-- start of sidebar -->
				<jsp:include page="right.jsp"></jsp:include>
				<!-- end of sidebar -->
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>