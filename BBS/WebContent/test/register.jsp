<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
	 
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />

		<title>用户注册</title>
		<link type="text/css" rel="stylesheet" href="css/register.css" />

		</script>
	</head>
	
 
	<body  style="overflow-y:hidden; ">
	
	 
			
			
	<div class="mod-header grid-96">
		<!--
        <div class="logo">
            <a href="#"   >
				<img alt="header blog" src="images/headerlogo.png" style="border:none 0px #fff">
			</a>
        </div>
		-->
    </div>
	<!-- <div class="mod-bread  ">
        <div class="grid-96">
            <div class="bread-left">
                填写注册信息
            </div>
            <div class="bread-right">
                已有帐号？<a  href="javascript:void(0)" onclick="openLogin()">马上登录</a>
            </div>
        </div>
    </div> -->
	
	<div class="regoutter" >
		<div class="reginner" >
			<form action="registerAction"  id="regform" name="regform">
				<table width="100%" >
					<tr>
						<td class="fronttd" >登录账号</td>
						<td style="width:200px">
							<input type="text" name="username" id="usr" class="inputtext"/>
						</td>
						<td align="left"><div id="usrdiv"></div></td>
					</tr>
					<!-- <tr >
						<td class="fronttd">昵称</td>
						<td >
							<input type="text" name="nickname" id="nickname" class="inputtext"/>
						</td>
						<td align="left"><div id="nicknamediv"></div></td>
					</tr> -->
					<tr >
						<td class="fronttd">密码</td>
						<td >
							<input type="password" name="password" id="pwd" class="inputtext"/>
						</td>
						<td align="left"><div id="pwddiv"></div></td>
					</tr>
				<!-- 	<tr >
						<td class="fronttd">确认密码</td>
						<td >
							<input type="password" name="repwd" id="repwd" class="inputtext"/>
						</td>
						<td align="left"><div id="repwddiv"></div></td>
					</tr> -->
					<tr >
						<td class="fronttd">邮箱</td>
						<td >
							<input type="password" name="email"  class="inputtext"/>
						</td>
						<td align="left"></td>
					</tr>
				<!-- 	<tr >
						<td class="fronttd">验证码</td>
						<td >
							<input type="text" name="codein" id="codein" class="inputtext codeintext"/>
						</td>
						<td align="left"><div id="codeindiv"></div></td>
					</tr> -->
					
					<tr>
						<td class="fronttd">&nbsp;</td>
						<td >
							<input type="submit" value="注册" class="submitbutton"/>
						</td>
						<td>&nbsp;</td>
					</tr>
				<table>
			</form>
		</div>
	</div>
	
	<div  class="regFooter" >
		<!-- &copy;2012 Header Blog  --> 
	</div>
	
 
 
	 
	
	</body>
</html>