<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function validate() {
		var page = document.getElementsByName("page")[0].value;

		if (page > <s:property value="#session.pageBean.totalPage"/>) {
			alert("你输入的页数大于最大页数，页面将跳转到首页！");

			window.document.location.href = "essencePostAction";

			return false;
		}

		return true;
	}
</script>
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


						<section class="span articles-list" style="width: 700px; ">
						<div
							style="border-bottom: solid 1px gainsboro; padding: 10px; height: 150px;">
							<div style="height: 70px;">
								<img src="${pageContext.request.contextPath}/<s:property value="#session.detailBoardInfo.boardPic"/>"
									style="width: 70px; height: 70px; border-radius:35px;" /> <span
									style="font-size: 20px; margin-left: 50px;"><a href="indexBoardAction"><s:property value="#session.detailBoardInfo.boardName"/> </a></span>
							</div>
							<div>
								<div style="float: right; height: 30px; margin-top: 60px;">
									<span style=" font-size: 12px;">帖子数量：<span><s:property
											value="#session.pageBean.allRows" /></span></span>
								</div>
								<div>
									<a href="essencePostAction?boardId=<s:property value="#session.detailBoardInfo.boardId" />" class="a"
										style="background-color: #778899; color: white; border-radius: 10px; float: right; width: 45px; height: 25px; border: solid 1px black; margin-left: 20px; text-align: center; line-height: 25px; font-size: 16px; font-weight: bold; margin-right: -65px">精华</a>
								</div>
								<div>
									<a href="indexBoardAction?boardId=<s:property value="#session.detailBoardInfo.boardId" />" class="a"
										style="background-color: #778899; color: white; border-radius: 10px; float: right; width: 45px; height: 25px; border: solid 1px black; margin-left: 20px; text-align: center; line-height: 25px; font-size: 16px; font-weight: bold;">看帖</a>
								</div>
								<div
									style=" height: 80px; width: 300px; font-size: 14px; float: left; margin-left: 125px; overflow: hidden; word-break: break-all;">
									板块介绍：<span><s:property value="#session.detailBoardInfo.boardDesc"/></span>
								</div>
							</div>

						</div>

						<ul class="articles" style="margin-top: 20px;">
							<s:iterator value="#session.pageBean.list" id="posts">
								<li class="article-entry standard a">
									<h4>
										<a href="postAction?postId=<s:property value = "#posts.postId" /> "><img src="images/indexImg/essence.jpg" style="width: 15px;height: 15px;margin-top: -5px;"/><s:property value="#posts.title" /> </a>
									</h4> <span class="article-meta"><s:property value="#posts.content" />
									 <span style="float: right; margin-right: 70px; margin-top:-20px;">
									 <a href="#" style="margin-right:10px;"><s:property value="#posts.postPeople" /> </a>   
										<s:property value="#posts.publishTime" /></span></span> 
										<span class="like-count">回帖数：<span>
									<s:property value="#posts.replyTime" /></span></span>
								</li>

							</s:iterator>
							<!-- <li class="article-entry standard a" >
                                                                                <h4><a href="single.html">热门贴1</a></h4>
                                                                                <span class="article-meta">内容。。。。。。。。。。。<span style="float: right;margin-right:70px;">2017年5月5日10:56:01</span></span>
                                                                                <span class="like-count">回帖数：<span >1</span></span> 
                                                                        </li>
                                                                        <li class="article-entry standard a" >
                                                                                <h4><a href="single.html">热门贴1</a></h4>
                                                                                <span class="article-meta">内容。。。。。。。。。。。<span style="float: right;margin-right:70px;">2017年5月5日10:56:01</span></span>
                                                                                <span class="like-count">回帖数：<span >1</span></span> 
                                                                        </li>
                                                                        <li class="article-entry standard a" >
                                                                                <h4><a href="single.html">热门贴1</a></h4>
                                                                                <span class="article-meta">内容。。。。。。。。。。。<span style="float: right;margin-right:70px;">2017年5月5日10:56:01</span></span>
                                                                                <span class="like-count">回帖数：<span >1</span></span> 
                                                                        </li>
                                                                        <li class="article-entry standard a" >
                                                                                <h4><a href="single.html">热门贴1</a></h4>
                                                                                <span class="article-meta">内容。。。。。。。。。。。<span style="float: right;margin-right:70px;">2017年5月5日10:56:01</span></span>
                                                                                <span class="like-count">回帖数：<span >1</span></span> 
                                                                        </li> -->

						</ul>
						<div style="float: right; margin-top: 10px;">
							<center style="float: right;">

								<form action="essencePostAction?boardId=<s:property value="#session.detailBoardInfo.boardId" />" onsubmit="return validate();">
									<font size="3">跳转至</font> <input
										style="width: 20px; height: 15px" type="text" size="2"
										name="page">页 <input style="" type="submit" value="跳转">
								</form>

							</center>
							<center style="float: right;">

								<font size="3">共<font color="red"><s:property
											value="#session.pageBean.totalPage" /></font>页
								</font>&nbsp;&nbsp; <font size="3">共<font color="red"><s:property
											value="#session.pageBean.allRows" /></font>条记录
								</font><br> <br>

								<s:if test="#session.pageBean.currentPage == 1">
            首页&nbsp;&nbsp;&nbsp;上一页
        </s:if>

								<s:else>
									<a href="essencePostAction?boardId=<s:property value="#session.detailBoardInfo.boardId" />">首页</a>
            &nbsp;&nbsp;&nbsp;
            <a
										href="essencePostAction?boardId=<s:property value="#session.detailBoardInfo.boardId" />&page=<s:property value="#session.pageBean.currentPage - 1"/>">上一页</a>
								</s:else>

								<s:if
									test="#session.pageBean.currentPage != #session.pageBean.totalPage">
									<a
										href="essencePostAction?boardId=<s:property value="#session.detailBoardInfo.boardId" />&page=<s:property value="#session.pageBean.currentPage + 1"/>">下一页</a>
            &nbsp;&nbsp;&nbsp;
            <a
										href="essencePostAction?boardId=<s:property value="#session.detailBoardInfo.boardId" />&page=<s:property value="#session.pageBean.totalPage"/>">尾页</a>
								</s:if>

								<s:else>
            下一页&nbsp;&nbsp;&nbsp;尾页
        </s:else>

							</center>

						</div>
						
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