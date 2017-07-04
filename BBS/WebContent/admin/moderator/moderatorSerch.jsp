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
	<jsp:include page="moderatorTop.jsp"></jsp:include>
	<div class="content-box">
		<!-- Start Content Box -->
		<div class="content-box-header">
			<h3 style="cursor: s-resize;">帖子</h3>
			<ul class="content-box-tabs">
				<li><a href="#tab1" class="default-tab current">Table</a></li>
				<!-- href must be unique and match the id of target div -->
				<!--<li><a href="#tab2">Forms</a></li>-->
			</ul>
			<div class="clear"></div>
		</div>
		<!-- End .content-box-header -->
		<div class="content-box-content">
			<div class="tab-content default-tab" id="tab1"
				style="display: block;">
				<!-- This is the target div. id must match the href of this div's tab -->
				<div class="notification attention png_bg">
					<a href="#" class="close"><img
						src="${pageContext.request.contextPath}/admin/resources/images/icons/cross_grey_small.png"
						title="Close this notification" alt="close"></a>
					<div>请妥善修改</div>
				</div>
				<table>
					<thead>
						<tr>
							<form action="moSerchPostsAction">
								标题名：<input type="text" name="serchInfo" />
								<button type="submit" style="margin-left: 10px;">Serch</button>
							</form>
						</tr>
						<tr>
							<th>标题</th>
							<th>回复数</th>
							<th>发帖人</th>
							<th>发帖时间</th>
							<th>精华帖</th>
							<th>置顶帖</th>
							<th>操作</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<td colspan="6">

								<div style="float: right; margin-top: 10px;">
									<center style="float: right;">

										<form action="#"">
											<font size="3">跳转至</font> <input
												style="width: 20px; height: 15px" type="text" size="2"
												name="page">页 <input style="" type="submit"
												value="跳转">
										</form>

									</center>
									<center style="float: right;">

										<font size="3">共<font color="red"></font>页
										</font>&nbsp;&nbsp; <font size="3">共<font color="red"></font>条记录
										</font><br> <br> <a href="#">首页</a> &nbsp;&nbsp;&nbsp; <a
											href="#">上一页</a> <a href="#">下一页</a> &nbsp;&nbsp;&nbsp; <a
											href="#">尾页</a>

									</center>

								</div>
								<div class="clear"></div>
							</td>
						</tr>
					</tfoot>
					<tbody>

					</tbody>
				</table>
			</div>

			<!-- End #tab2 -->
		</div>
		<!-- End .content-box-content -->
		<div id="footer"> <small>
      <!-- Remove this notice or replace it with whatever you want -->
      &#169; Copyright 2017 Your Company | Powered by <a href="#">wty</a> | <a href="#">Top</a> </small>
					<a href="#" target="_blank">www.baidu.com</a>
				</div>
				<!-- End #footer -->
			</div>
	</div>

</body>
</html>