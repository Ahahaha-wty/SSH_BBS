<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section class="span articles-list"
		style="width: 200px; border-right: 1px solid black;">
	<h3>主要板块</h3>
	<ul class="articles">
		<li class="article-entry standard a">

			<h4>
				<a href="indexBoardAction?boardId=1" style="font-size: 16px;"><img
					src="${pageContext.request.contextPath}/client/images/indexImg/learn.jpg"
					style="height: 50px; width: 50px; border-radius: 25px;" />学习天地</a>
			</h4>


		</li>
		<li class="article-entry standard a">
			<h4>
				<a href="indexBoardAction?boardId=2" style="font-size: 16px;"><img
					src="${pageContext.request.contextPath}/client/images/indexImg/timg.jpg"
					style="height: 50px; width: 50px; border-radius: 25px;" />校园生活</a>
			</h4>


		</li>
		<li class="article-entry standard a">
			<h4>
				<a href="indexBoardAction?boardId=3" style="font-size: 16px;"><img
					src="${pageContext.request.contextPath}/client/images/indexImg/view.jpg"
					style="height: 50px; width: 50px; border-radius: 25px;" />人文自然</a>
			</h4>


		</li>
		<li class="article-entry standard a">
			<h4>
				<a href="indexBoardAction?boardId=4" style="font-size: 16px;"><img
					src="${pageContext.request.contextPath}/client/images/indexImg/star.jpg"
					style="height: 50px; width: 50px; border-radius: 25px;" />娱乐明星</a>
			</h4>


		</li>
		<li class="article-entry standard a">
			<h4>
				<a href="indexBoardAction?boardId=5" style="font-size: 16px;"><img
					src="${pageContext.request.contextPath}/client/images/indexImg/cinema.jpg"
					style="height: 50px; width: 50px; border-radius: 25px; border: 1px solid beige;" />动漫电影</a>
			</h4>


		</li>
		<li class="article-entry standard a">
			<h4>
				<a href="indexBoardAction?boardId=6" style="font-size: 16px;"><img
					src="${pageContext.request.contextPath}/client/images/indexImg/sports.jpg"
					style="height: 50px; width: 50px; border-radius: 25px; border: 1px solid beige;" />体育运动</a>
			</h4>


		</li>
		<li>
			<h4 style="font-size: 13px;">
				<a href="getBPagesAction" style="margin-left: 50px; color: dodgerblue;">更多板块>></a>
			</h4>

		</li>
	</ul>
	</section>
</body>
</html>