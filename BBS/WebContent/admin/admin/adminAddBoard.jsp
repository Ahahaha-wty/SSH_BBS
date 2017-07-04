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
<div class="content-box column-left" id="leftTable">
      <div class="content-box-header">
        <h3 style="cursor: s-resize;">BBS</h3>
      </div>
      <!-- End .content-box-header -->
	      <div class="content-box-content">
		        <div class="tab-content default-tab" style="display: block;">
		          <h4>添加板块</h4>
		      <s:form action="addBoardAction" theme="simple" enctype="multipart/form-data">
	板块名称：<s:textfield name="boardname" ></s:textfield>
	板块介绍：<s:textarea rows="5" cols="10" name="boardDesc"></s:textarea>
	板块头像：<s:file name="file"></s:file>
	<s:submit value="submit"></s:submit>
		<s:actionerror cssStyle="color:red"/>
	</s:form>
		        </div>
	        <!-- End #tab3 -->
	      </div>
      <!-- End .content-box-content -->
	</div>
	<div class="content-box column-right closed-box" id="rightTable">
      <div class="content-box-header">
        <!-- Add the class "closed" to the Content box header to have it closed by default -->
        
      </div>
      <!-- End .content-box-header -->
      <div class="content-box-content" style="display: none;">
        <div class="tab-content default-tab" style="display: block;">
          
        </div>
        <!-- End #tab3 -->
      </div>
      <!-- End .content-box-content -->
    </div>
    <div class="clear"></div>
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