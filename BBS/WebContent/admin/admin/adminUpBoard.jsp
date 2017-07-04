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
	<jsp:include page="adminTop.jsp"></jsp:include>
	<div class="content-box">
		<!-- Start Content Box -->
		<div class="content-box-header">
			<h3 style="cursor: s-resize;">Content box</h3>
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
				<div>
					<s:form action="adUpBoardAction" theme="simple"
						enctype="multipart/form-data">
						板块名称：<input type="text" disabled="disabled" value='<s:property value="#session.moBoardInfo.boardName"/>'>
						板块介绍：<s:textarea rows="5" cols="10" name="boardDesc"><s:property value="#session.moBoardInfo.boardDesc"/></s:textarea>
						板块头像：<s:file name="file"></s:file>
						<s:submit value="提交"></s:submit>
					</s:form>
				</div>
			</div>

			<!-- End #tab2 -->
		</div>
		<!-- End .content-box-content -->
		<div id="footer">
			<small> <!-- Remove this notice or replace it with whatever you want -->
				&#169; Copyright 2017 Your Company | Powered by <a href="#">wty</a>
				| <a href="#">Top</a>
			</small> <a href="#" target="_blank">www.baidu.com</a>
		</div>
		<!-- End #footer -->
	</div>
	</div>


</body>
</html>