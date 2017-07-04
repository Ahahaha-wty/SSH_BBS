<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<meta name="keywords" content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
<link href="${pageContext.request.contextPath}/client/css/style.css" rel='stylesheet' type='text/css' />
<title>Insert title here</title>

</head>
<body>
<script>$(document).ready(function(c) {
	$('.close').on('click', function(c){
		$('.login-form').fadeOut('slow', function(c){
	  		$('.login-form').remove();
		});
	});	  
});
</script>
 <!--SIGN UP-->
 <h1>BBS登陆</h1>
<div class="login-form">
	<div class="close"> </div>
		<div class="head-info">
			<label class="lbl-1"> </label>
			<label class="lbl-2"> </label>
			<label class="lbl-3"> </label>
			<a style="font-size: 16px;font-weight: 100;color: #9199aa;" href="${pageContext.request.contextPath}/client/index.jsp">首页</a>
			<a style="font-size: 16px;font-weight: 100;color: #9199aa;" href="${pageContext.request.contextPath}/client/register.jsp">注册</a>
		</div>
			<div class="clear"> </div>
	<!--<div class="avtar">
		<img src="images/avtar.png" />
	</div>-->
			 <s:form action="loginAction" theme="simple" method="post">
					<span style=" color: #9199aa;font-size: 18px;font-weight: 100;">用户名:</span><s:textfield name="username"  class="text" value="用户名" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '用户名';}"></s:textfield>
					<div class="key" style="height: 60px;">
					<span style=" color: #9199aa;font-size: 18px;font-weight: 100;">密 &nbsp;&nbsp;&nbsp;码:</span><s:password name="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}"></s:password>
					</div>
	
					<span style=" color: #9199aa;font-size: 18px;font-weight: 100;">验证码:</span><s:textfield name="checkCode" style="width: 12%;margin-top: -70px;"  class="text" value="验证码"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '验证码';}"></s:textfield>
					<img src="createImageAction.action" id="resImg" class="key"
			onclick="this.src='createImageAction?'+ Math.random()"
			title="点击图片刷新验证码" />	
			<s:checkbox label="自动登录" name="userCookie" value="false"></s:checkbox>						
					<span style="color: orange;">自动登录</span>
					<div>
					<span style="color: red;"><s:actionerror /></span>
					</div>
					<%-- <input type="text" style="color: red;margin-top:-10px ;" disabled="disabled" value="<s:actionerror />"  /> --%>
					<div class="signin">
		
		<s:submit value="Login"></s:submit>
	</div>
			</s:form>
	
</div>
 <div class="copy-rights">
					<p>BBS论坛登陆</p>
			</div>
	<%-- <s:form action="loginAction" theme="simple" method="post">   
        用户名:<s:textfield name="username"></s:textfield>
		<br>
        密码    :<s:password name="password"></s:password>
		<br>
        验证码:<s:textfield name="checkCode"></s:textfield>
	自动登录：	<s:checkbox label="自动登录" name="userCookie" value="false"></s:checkbox>
		<!--若要点击图片刷新，重新得到一个验证码，要在后面加上个随机数，这样保证每次提交过去的都是不一样的path，防止因为缓存而使图片不刷新-->
		<img src="createImageAction.action"
			onclick="this.src='createImageAction?'+ Math.random()"
			title="点击图片刷新验证码" />
		<br>
		<s:actionerror cssStyle="color:red"/>
		
		<s:submit value="提交"></s:submit>
	</s:form> --%>
</body>
</html>