<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel='stylesheet'  href='${pageContext.request.contextPath}/client/css/post.css' type='text/css' />
<script type="text/javascript">
	function validate() {
		var page = document.getElementsByName("page")[0].value;
		var page1 = document.getElementsByName("page")[1].value;
		if (page > <s:property value="#session.replyPage.totalPage"/>||page1 > <s:property value="#session.replyPage.totalPage"/>) {
			alert("你输入的页数大于最大页数，页面将跳转到首页！");

			window.document.location.href = "postAction";

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
								<div id="page">
									
									<span  class="talk_total"><font size="3">共<font color="red"><s:property
											value="#session.replyPage.allRows" /></font>条回复</span>
									&nbsp;&nbsp;
									<span class="page_total"><font size="3">共<font color="red"><s:property
											value="#session.replyPage.totalPage" /></font>页
								</font>
								
								<s:if test="#session.replyPage.currentPage == 1">
							          &nbsp;  首页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上一页
							        </s:if>

								<s:else>
									<a href="postAction?boardId=<s:property value="#session.detailPost.postId" />">首页</a>
						            &nbsp;
						            <a href="postAction?boardId=<s:property value="#session.detailPost.postId" />&page=<s:property value="#session.replyPage.currentPage - 1"/>">上一页</a>
								</s:else>

								<s:if
									test="#session.replyPage.currentPage != #session.replyPage.totalPage">
									<a
										href="postAction?boardId=<s:property value="#session.detailPost.postId" />&page=<s:property value="#session.replyPage.currentPage + 1"/>">&nbsp;&nbsp;下一页</a>
									          
									  <a href="postAction?boardId=<s:property value="#session.detailPost.postId" />&page=<s:property value="#session.replyPage.totalPage"/>"> &nbsp;尾页 </a>
								</s:if>

								<s:else>
          							&nbsp;&nbsp; 下一页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 尾页
       						 </s:else>
								</span>
								
									<span><center style="float: right;margin-top:-7px ">

								<form action="postAction?boardId=<s:property value="#session.detailPost.postId" />" onsubmit="return validate();">
									<font size="3">跳转至</font> <input
										type="text" style="width: ;height: 15px;margin-top: 5px;" size="2"
										name="page">页 <button type="submit" style="margin-top:-7px ">确定</button>
								</form>

							</center></span>
									
								</div>
								<!-- 后期从数据库导入，此时静态 -->
								<div class="talker_tips">
									<span class="classify" style="font-size: 16px;">标题：</span>
									<span class="title"><s:property value="#session.detailPost.title"/></span>
									
										<button style="float: right; margin-left:4px ;">回复</button>
										<button style="float: right;margin-left:4px ;">收藏</button>
										<button style="float: right;margin-left:4px ;">只看楼主</button>
									
								</div>
								<ul class="articles" style="margin-top:10px ;">
									<li class="article-entry standard a" style="margin-top: 5px;">
										<div class="talker clear">
											<div class="left">
												<div>
													<img src="${pageContext.request.contextPath}/<s:property value="#session.postPeople.headAdd"/>" style="width: 70px;height: 70px;" />
												</div>
												<h3 class="name"  style="text-align: center;"><a class="name" href="#"><s:property value="#session.detailPost.postPeople"/></a></h3>
												<p class="level">等级：<s:property value="#session.postPeople.leavl"/></p>
											</div>
											<div class="right">
												<span style="color:red;font-size:16px">主题内容</span>：<s:property value="#session.detailPost.content"/>
											</div>
											<div class="tip">
												<select style="padding: 0; margin: 0;border: none;width: 60px;">
													<option selected="selected">
														<a>举报</a>
													</option>
													<option>
														<a>原因</a>
													</option>
												</select>
												<span>来自<a>xxx客户端</a></span>
												<%-- <span class="floor">5楼</span> --%>
												<span class="time"><s:property value="#session.detailPost.publishTime"/></span>
												<a>回复</a>
											</div>
										</div>
									</li>
									<s:iterator value="#session.replyPage.list" id="replys">
									<li class="article-entry standard a" style="margin-top: 5px;">
										<div class="talker clear">
											<div class="left">
												<div>
													<img src="${pageContext.request.contextPath}/<s:property value="#replys.headImg"/>" style="width: 70px;height: 70px;" />
												</div>
												<h3 class="name"  style="text-align: center;"><a class="name" href="#"><s:property value="#replys.username"/></a></h3>
												<p class="level">等级:<s:property value="#replys.leavl"/></p>
											</div>
											<div class="right">
												<s:property value="#replys.replyContent"/>
											</div>
											<div class="tip">
												<select style="padding: 0; margin: 0;border: none;width: 60px;">
													<option selected="selected">
														<a>举报</a>
													</option>
													<option>
														<a>原因</a>
													</option>
												</select>
												<span>来自<a>xxx客户端</a></span>
												<%-- <span class="floor">5楼</span> --%>
												<span class="time"><s:property value="#replys.replyTime"/></span>
												<a>回复</a>
											</div>
										</div>
									</li>
								</s:iterator>
								</ul>
								<div style="float: right; margin-top: 10px;">
							<center style="float: right;">

								<form action="postAction?boardId=<s:property value="#session.detailPost.postId" />" onsubmit="return validate();">
									<font size="3">跳转至</font> <input
										style="width: 20px; height: 15px" type="text" size="2"
										name="page">页 <button type="submit">跳转</button>
								</form>

							</center>
							<center style="float: right;">

								<font size="3">共<font color="red"><s:property
											value="#session.replyPage.totalPage" /></font>页
								</font>&nbsp;&nbsp; <font size="3">共<font color="red"><s:property
											value="#session.replyPage.allRows" /></font>条记录
								</font><br> <br>
								
								<s:if test="#session.replyPage.currentPage == 1">
            首页&nbsp;&nbsp;&nbsp;上一页
        </s:if>

								<s:else>
									<a href="postAction?boardId=<s:property value="#session.detailPost.postId" />">首页</a>
            &nbsp;&nbsp;&nbsp;
            <a
										href="postAction?boardId=<s:property value="#session.detailPost.postId" />&page=<s:property value="#session.replyPage.currentPage - 1"/>">上一页</a>
								</s:else>

								<s:if
									test="#session.replyPage.currentPage != #session.replyPage.totalPage">
									<a
										href="postAction?boardId=<s:property value="#session.detailPost.postId" />&page=<s:property value="#session.replyPage.currentPage + 1"/>">下一页</a>
            &nbsp;&nbsp;&nbsp;
            <a
										href="postAction?boardId=<s:property value="#session.detailPost.postId" />&page=<s:property value="#session.replyPage.totalPage"/>">尾页</a>
								</s:if>

								<s:else>
            下一页&nbsp;&nbsp;&nbsp;尾页
        </s:else>

							</center>

						</div>

								<div>
									<s:form action="replyAction" theme="simple"> 
									<h3>回复</h3>
									
									<div style="float: left;width: 600px;">
										内容：<textarea style="border: 1px solid gainsboro;width: 500px;height: 100px;" rows="5" cols="20" name="replyContent"></textarea>
										<input style="margin:  0 50px; width: 60px;" type="submit" value="回复" />
									</div>
									 <s:token></s:token>
									</s:form>
								</div>
							</section>
							</div>
				</div>
				
				<!-- end of page content -->


				<!-- start of sidebar -->
				<jsp:include page="right.jsp"></jsp:include>
				<!-- end of sidebar -->
			</div>
			<span style="display:none" id="wrongMessage"><s:property value="#session.wrongMessage"/></span>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
		<script type="text/javascript">
	var s = document.getElementById("wrongMessage").innerHTML; 
	 if(s!=""){ 
	    alert(s); 
	 } 
	    
</script> 
<% 
	if(session.getAttribute("wrongMessage")!=null)
		session.removeAttribute("wrongMessage");
	
%>
</body>

</html>
