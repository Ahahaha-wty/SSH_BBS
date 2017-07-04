<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

			window.document.location.href = "getBPagesAction";

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
						<h3>板块分类</h3>
						<ul class="articles" style="margin-top: 20px;">
							<!-- 
							<li class="article-entry standard a">

								<div id="content">
									<div class="top">
										<div class="img">
											<img src="images/indexImg/learn.jpg"
												style="width: 100px; height: 100px;" />
										</div>
										<div class="top_right">
											<h2>
												<a href="#">红豆哎哎问吧</a>
											</h2>
											<a>1111111</a> <a>86869</a>
											<p>明星动态，只是搜读辅导老师今后了红色的合法 好我的私房</p>
										</div>
									</div>
									<div class="bottom">
										<div class="tip">大家正在讨论</div>
										<ul>
											<li><span class="classify">【红豆通话】</span> <span
												class="title">古装女纸温文尔雅</span></li>
											<li><span class="classify">【红豆通话】</span> <span
												class="title">古装女纸温文尔雅</span></li>
										</ul>
									</div>
								</div>
							<li class="article-entry standard a">
								<div id="content">
									<div class="top">
										<div class="img">
											<img src="images/indexImg/learn.jpg"
												style="width: 100px; height: 100px;" />
										</div>
										<div class="top_right">
											<h2>
												<a href="#">红豆哎哎问吧</a>
											</h2>
											<a>1111111</a> <a>86869</a>
											<p>明星动态，只是搜读辅导老师今后了红色的合法 好我的私房</p>
										</div>
									</div>
									<div class="bottom">
										<div class="tip">大家正在讨论</div>
										<ul>
											<li><span class="classify">【红豆通话】</span> <span
												class="title">古装女纸温文尔雅</span></li>
											<li><span class="classify">【红豆通话】</span> <span
												class="title">古装女纸温文尔雅</span></li>
										</ul>
									</div>
								</div>
							</li>
							<li class="article-entry standard a">
								<div id="content">
									<div class="top">
										<div class="img">
											<img src="images/indexImg/learn.jpg"
												style="width: 100px; height: 100px;" />
										</div>
										<div class="top_right">
											<h2>
												<a href="#">红豆哎哎问吧</a>
											</h2>
											<a>1111111</a> <a>86869</a>
											<p>明星动态，只是搜读辅导老师今后了红色的合法 好我的私房</p>
										</div>
									</div>
									<div class="bottom">
										<div class="tip">大家正在讨论</div>
										<ul>
											<li><span class="classify">【红豆通话】</span> <span
												class="title">古装女纸温文尔雅</span></li>
											<li><span class="classify">【红豆通话】</span> <span
												class="title">古装女纸温文尔雅</span></li>
										</ul>
									</div>
								</div>
							</li> -->
							<s:iterator value="#session.pageBean.list" id="board">

								<li class="article-entry standard a">
									<div id="content">
										<div class="top">
											<div class="img">
												<img
													src="${pageContext.request.contextPath}/<s:property value="#board.boardPic"/>"
													style="width: 100px; height: 100px;" />
											</div>
											<div class="top_right">
												<h2>
													<a href="indexBoardAction?boardId=<s:property value="#board.boardId" />"><s:property value="#board.boardName" /></a>
												</h2>
												<p>
													板块介绍：
													<s:property value="#board.boardDesc" />
												</p>
											</div>
										</div>
										<div class="bottom">
											<div class="tip">大家正在讨论</div>
											<ul>
												<li><span class="classify">【红豆通话】</span> <span
													class="title">古装女纸温文尔雅</span></li>
												<li><span class="classify">【红豆通话】</span> <span
													class="title">古装女纸温文尔雅</span></li>
											</ul>
										</div>
									</div>
								</li>

							</s:iterator>

						</ul>
						<div style="float: right; margin-top: 10px;">
							<center style="float: right;">

								<form action="getBPagesAction" onsubmit="return validate();">
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
								</font><br>
								<br>

								<s:if test="#session.pageBean.currentPage == 1">
            首页&nbsp;&nbsp;&nbsp;上一页
        </s:if>

								<s:else>
									<a href="getBPagesAction">首页</a>
            &nbsp;&nbsp;&nbsp;
            <a
										href="getBPagesAction?page=<s:property value="#session.pageBean.currentPage - 1"/>">上一页</a>
								</s:else>

								<s:if
									test="#session.pageBean.currentPage != #session.pageBean.totalPage">
									<a
										href="getBPagesAction?page=<s:property value="#session.pageBean.currentPage + 1"/>">下一页</a>
            &nbsp;&nbsp;&nbsp;
            <a
										href="getBPagesAction?page=<s:property value="#session.pageBean.totalPage"/>">尾页</a>
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
