<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">
		<script type="application/x-javascript">
			addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);

			function hideURLbar() { window.scrollTo(0, 1); }
		</script>
		<meta name="keywords" content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
		<link href="${pageContext.request.contextPath}/client/css/style.css" rel='stylesheet' type='text/css' />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/ion.calendar.css">
		<style>
			/*.jq22 {
				margin-top: 0px;
				text-align: center;
			}*/
			
			.date {
				width: 200px;
				padding: 5px;
				font-family: Arial, Helvetica, sans-serif;
			}
		</style>
		<!--webfonts-->
		<!--<link href='http://fonts.useso.com/css?family=PT+Sans:400,700,400italic,700italic|Oswald:400,300,700' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Exo+2' rel='stylesheet' type='text/css'>-->
		<!--//webfonts-->
		<!--<script src="http://ajax.useso.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>-->
	</head>

	<body>
		<script>
			$(document).ready(function(c) {
				$('.close').on('click', function(c) {
					$('.login-form').fadeOut('slow', function(c) {
						$('.login-form').remove();
					});
				});
			});
		</script>
		<!--SIGN UP-->
		<h1>BBS完善个人信息</h1>
		<div class="login-form">
			<div class="close"> </div>
			<div class="head-info">
				<label class="lbl-1"> </label>
				<label class="lbl-2"> </label>
				<label class="lbl-3"> </label>
			</div>
			<div class="clear"> </div>
			<!--<div class="avtar">
		<img src="images/avtar.png" />
	</div>-->
			<s:form action="completeRegAction" theme="simple" enctype="multipart/form-data">
				<div>
					<span style=" color: #9199aa;font-size: 18px;font-weight: 100;">用户名:</span><s:textfield name="username" disabled="true" class="text"></s:textfield>
				</div>
				<div>
					<span style=" color: #9199aa;font-size: 18px;font-weight: 100;">邮&nbsp;&nbsp;&nbsp;箱:</span><s:textfield name="email" class="text"></s:textfield>
				</div>
				<div style=" color: #9199aa;font-size: 18px;font-weight: 100;">
					<span style=" color: #9199aa;font-size: 18px;font-weight: 100;float: left;margin-left: 65px;">性&nbsp;&nbsp;&nbsp;别:</span><span style="margin-left:-100px"><s:radio style="margin-left:10px" class="text" list="#{'1':'男','0':'女'}" name="sex" value="1"/></span>
				</div>
				<div class="jq22" style="margin-left: -15px;">
					<span style=" color: #9199aa;font-size: 18px;font-weight: 100;">生&nbsp;&nbsp;&nbsp;日:</span><s:textfield class="date text" placeholder="请选择日期" name="birthday"></s:textfield>
				</div>
				<div>
					<span style=" color: #9199aa;font-size: 18px;font-weight: 100;">住&nbsp;&nbsp;&nbsp;址:</span><s:textfield name="nativePlace" class="text"></s:textfield>
				</div>
				<div>
					<span style=" color: #9199aa;font-size: 18px;font-weight: 100;">Q&nbsp;&nbsp;&nbsp;Q:</span><s:textfield name="qq" class="text"></s:textfield>
				</div>
				<div>
					<span style=" color: #9199aa;font-size: 18px;font-weight: 100;">介&nbsp;&nbsp;&nbsp;绍:</span><s:textfield name="selfInfo" class="text"></s:textfield>
				</div>
				<div>
					<span style=" color: #9199aa;font-size: 18px;font-weight: 100;">签&nbsp;&nbsp;&nbsp;名:</span><s:textfield name="psersonalIsign" class="text"></s:textfield>
				</div>
				<div style="margin-left: -20px;">
					<span style=" color: #9199aa;font-size: 18px;font-weight: 100;">头&nbsp;&nbsp;&nbsp;像:</span><s:file name="file" class="text"></s:file>
				</div>
<!-- 				<input type="text" value="" style="color: red;margin-top:-10px ;" disabled="disabled" /><a style="float: right;font-size: 12px;color: gray;" href="#">跳过>></a>
 -->
			
			<div class="signin">
				<s:submit value="Complete"></s:submit>
			</div>
			</s:form>
		</div>
		<div class="copy-rights">
			<p>BBS完善个人信息</p>
		</div>

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
	</body>



<%-- 	<s:form action="completeRegAction" theme="simple" enctype="multipart/form-data">
	用户：<s:textfield name="username" disabled="true"></s:textfield>
	邮箱：<s:textfield name="email"></s:textfield>
	性别：<s:radio list="#{'1':'男','0':'女'}" name="sex" value="1"/>
	生日：<s:textfield name="birthday"></s:textfield>
	住址：<s:textfield name="nativePlace"></s:textfield>
	qq：<s:textfield name="qq"></s:textfield>
	自我介绍：<s:textfield name="selfInfo"></s:textfield>
	个性签名:<s:textarea rows="5" cols="10" name="psersonalIsign"></s:textarea>
	头像上传：<s:file name="file"></s:file>
	<s:submit value="submit"></s:submit>
	</s:form> --%>
	
</body>

</html>