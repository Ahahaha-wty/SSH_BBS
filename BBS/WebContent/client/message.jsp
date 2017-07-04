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

		if (page > <s:property value="#session.messagePage.totalPage"/>) {
			alert("你输入的页数大于最大页数，页面将跳转到首页！");

			window.document.location.href = "messageAction";

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
				
				<ul class="articles" style="margin-top: 20px;">
				<s:iterator value="#session.messagePage.list" id="message">
					<li class="article-entry standard a">
						<h4>
							<a href="postAction?postId=<s:property value="#message.postId"/>"><s:property value="#message.postTitle"/> </a>
						</h4> <span class="article-meta"><s:property value="#message.content"/></span> <span
						class="like-count">回帖人：<span><s:property value="#message.username"/></span></span>
					</li>
				</s:iterator>
				</ul>
				<div style="float: right; margin-top: 10px;">
					<center style="float: right;">

						<form
							action="messageAction/>"
							onsubmit="return validate();">
							<font size="3">跳转至</font> <input
								style="width: 20px; height: 15px" type="text" size="2"
								name="page">页 <input style="" type="submit" value="跳转">
						</form>

					</center>
					<center style="float: right;">

						<font size="3">共<font color="red"><s:property
									value="#session.messagePage.totalPage" /></font>页
						</font>&nbsp;&nbsp; <font size="3">共<font color="red"><s:property
									value="#session.messagePage.allRows" /></font>条记录
						</font><br> <br>

						<s:if test="#session.messagePage.currentPage == 1">
            首页&nbsp;&nbsp;&nbsp;上一页
        </s:if>

						<s:else>
							<a
								href="messageAction">首页</a>
            &nbsp;&nbsp;&nbsp;
            <a
								href="messageAction?page=<s:property value="#session.messagePage.currentPage - 1"/>">上一页</a>
						</s:else>

						<s:if
							test="#session.messagePage.currentPage != #session.messagePage.totalPage">
							<a
								href="messageAction?page=<s:property value="#session.messagePage.currentPage + 1"/>">下一页</a>
            &nbsp;&nbsp;&nbsp;
            <a
								href="messageAction?page=<s:property value="#session.messagePage.totalPage"/>">尾页</a>
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