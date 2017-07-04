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
	<s:form action="addBoardAction" theme="simple" enctype="multipart/form-data">
	板块名称：<s:textfield name="boardname" ></s:textfield>
	板块介绍：<s:textarea rows="5" cols="10" name="boardDesc"></s:textarea>
	板块头像：<s:file name="file"></s:file>
	<s:submit value="submit"></s:submit>
		<s:actionerror cssStyle="color:red"/>
	</s:form>

</body>
</html>