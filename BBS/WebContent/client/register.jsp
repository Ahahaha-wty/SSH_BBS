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
		<h1>BBS注册</h1>
		<div class="login-form">
			<div class="close"> </div>
			<div class="head-info">
				<label class="lbl-1"> </label>
				<label class="lbl-2"> </label>
				<label class="lbl-3"> </label>
				<a style="font-size: 16px;font-weight: 100;color: #9199aa;" href="${pageContext.request.contextPath}/client/index.jsp">首页</a>
				<a style="font-size: 16px;font-weight: 100;color: #9199aa;" href="${pageContext.request.contextPath}/client/login.jsp">登陆</a>
			</div>
			<div class="clear"> </div>
			<!--<div class="avtar">
		<img src="images/avtar.png" />
	</div>-->
			<s:form action="registerAction" theme="simple" method="post"><s:fielderror>
				<span style=" color: #9199aa;font-size: 18px;font-weight: 100;">用户名:</span><s:textfield name="username" class="text" value="用户名" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '用户名';}"></s:textfield>
				<div class="key" style="height: 60px;">
					<span style=" color: #9199aa;font-size: 18px;font-weight: 100;">密 &nbsp;&nbsp;&nbsp;码:</span><s:password name="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}"></s:password>

				</div>
				<div class="key" style="height: 60px;margin-left: -12px;">
					<span style=" color: #9199aa;font-size: 18px;font-weight: 100;">确认密码:</span><s:password name="repassword" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}"></s:password>

				</div>
				<span style=" color: #9199aa;font-size: 18px;font-weight: 100;margin-left: -65px;">验证码:</span><s:textfield name="checkCode" style="width: 12%;margin-top: -70px;"  class="text" value="验证码"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '验证码';}"></s:textfield>
				<<img src="createImageAction.action"
			onclick="this.src='createImageAction?'+ Math.random()"
			title="点击图片刷新验证码"  id="resImg" alt="验证码" class="key"/>
				<div>
					<span style="color: red;"><s:param >username</s:param></span>
					<span style="color: red;"><s:param>password</s:param></span>
					<span style="color: red;"><s:actionerror /> </span>
					</div>
</s:fielderror>	
			
			<div class="signin">
				<s:submit value="Register"></s:submit>
			</div>
			</s:form>
		</div>
		<div class="copy-rights">
			<p>BBS论坛注册</p>
		</div>
	
	<%-- <s:form action="registerAction" theme="simple" method="post">
	 <s:fielderror>        
        用户名:<s:textfield name="username"></s:textfield><s:param>username </s:param> 
		<br>
        密码    :<s:password name="password"></s:password><s:param>password </s:param>
		<br>
     确认密码 :<s:password name="repassword"></s:password><s:param>password </s:param>
		<br>
        验证码:<s:textfield name="checkCode"></s:textfield>
		
		<!--若要点击图片刷新，重新得到一个验证码，要在后面加上个随机数，这样保证每次提交过去的都是不一样的path，防止因为缓存而使图片不刷新-->
		<img src="createImageAction.action"
			onclick="this.src='createImageAction?'+ Math.random()"
			title="点击图片刷新验证码" />
		<br>
		<s:actionerror cssStyle="color:red"/>
	</s:fielderror>	
		<s:submit value="提交"></s:submit>
	</s:form> --%>
</body>
</html>