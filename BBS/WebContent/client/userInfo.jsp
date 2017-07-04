<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/ion.calendar.css">
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
						<div style="padding: 10px; ">
									<div style="height: 70px;">
										<img src='${pageContext.request.contextPath}/<s:property value="#session.userInfo.headAdd"/>' style="width: 70px; height: 70px;" />
										<span style="font-size: 20px;margin-left: 50px;"><s:property value="#session.user.username"/></span>
									</div>
									<div>
										<div style="float: right; height: 30px; margin-top: 60px;">

										</div>
										

									</div>

								</div>
								<s:form action="updateUserInfoAction" theme="simple" enctype="multipart/form-data">
								<div >
									邮箱：
									<input type="text" value="<s:property value="#session.userInfo.email"/>" disabled="disabled" class="input_info" name="email"/>
								</div>
								<div >
									性别：
									<select disabled="disabled" class="input_info" name="sex">
									<s:if test="#session.userInfo.sex==0">
										<option value="1">男</option>
										<option value="0" selected="selected">女</option>
									</s:if>
									<s:else>
										<option value="1" selected="selected">男</option>
										<option value="0" >女</option>
									</s:else>
									</select>
								</div>
								<div class="jq22" >
									生日：
									<input type="text" name="birthday" class="date input_info" placeholder="请选择日期" disabled="disabled" value="<s:property value="#session.userInfo.birthday"/>">
								</div>
								<div >
									住址：
									<input type="text" name="nativePlace" value="<s:property value="#session.userInfo.nativePlace"/>" disabled="disabled" class="input_info"/>
								</div>
								<div >
									Q Q：
									<input type="text" name="qq" value="<s:property value="#session.userInfo.qq"/>" disabled="disabled" class="input_info"/>
								</div>
								<div >
									介绍：
									<input type="text" name="selfInfo" value="<s:property value="#session.userInfo.selfInfo"/>" disabled="disabled" class="input_info"/>
								</div>
								<div >
									签名：
									<input type="text" name="psersonalIsign" value="<s:property value="#session.userInfo.psersonalIsign"/>" disabled="disabled" class="input_info"/>
								</div>
								<div style="display: none;"class="head">
									头像：
									<!-- <input type="file" name="file" class="text"  /> -->
									<s:file name="file" class="text"></s:file>
								</div>
								<div style="margin-left: 220px;"class="change">
									<input type="button" id="change" value="修改"/>
								</div>
								<div style="margin-left: 220px;display: none;" class="sub">
									<input type="submit" value="保存"/>
								</div>
								</s:form>
						
						
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
	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
		<script src="${pageContext.request.contextPath}/client/js/moment.min.js"></script>
		<script src="${pageContext.request.contextPath}/client/js/moment.zh-cn.js"></script>
		<script src="${pageContext.request.contextPath}/client/js/ion.calendar.min.js"></script>
		<script>
			$(function() {
				$('.date').each(function() {
					$(this).ionDatePicker({
						lang: 'zh-cn',
						format: 'YYYY-MM-DD'
					});
				});
			});
		</script>
		<script>
			var inputs = document.getElementsByClassName("input_info");
			var sub = document.getElementsByClassName("sub")[0];
			var change = document.getElementById("change");
			var change1 = document.getElementsByClassName("change")[0];
			var head = document.getElementsByClassName("head")[0];
			change.onclick = function(){
				for (var i=0;i<inputs.length;i++) {
					inputs[i].removeAttribute("disabled");
				}
				change1.style.display="none";
				sub.style.display="block";
				head.style.display="block";
			}
		</script>
</body>

</html>