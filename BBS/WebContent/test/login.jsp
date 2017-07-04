<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
 <link type="text/css" rel="stylesheet" href="css/login-min.css" />
</head>
<body>
<center>
<div id="forlogin"  class="forlogin" style="display:block;width:350px;height:190px;">
		<form action="loginAction">
			<table >
					 <tr >
						<td class="firsttr_td">&nbsp;&nbsp;</td>
						<td class="firsttr_td" >
							 <span><font color="red" size="2">用户不存在!</font></span> 
						</td>
						<td  class="firsttr_td">&nbsp;</td>
					</tr>
					<tr>
						<td class="fronttr_td" >账号</td>
						<td style="width:200px">
							<input type="text" class="inputtext" name="username"/>
						</td>
						<td>&nbsp;</td>
					</tr>
					<tr >
						<td class="fronttr_td">密码</td>
						<td >
							<input type="password"  class="inputtext" name="password"/>
						</td>
						<td>&nbsp;</td>
					</tr>
					<!-- <tr >
						<td class="lasttr_td"  >&nbsp;</td>
						<td class="lasttr_td"  >
							<input type="checkbox" value="1"/>
							<font  size="2">自动登录</font>
						</td>
						<td class="lasttr_td"  >&nbsp;</td>
					</tr> -->
					<tr height="32px">
						<td   class="extratr_td">&nbsp;</td>
						<td  class="extratr_td">
							 <input type="submit" value="登录" class="submitbutton"/> 
							 <input type="reset" value="重置" class="submitbutton"/> 

						</td>
						<td   class="extratr_td">&nbsp;</td>
					</tr>
			</table>
		</form>
</div>
 </center>
</body>
</html>
