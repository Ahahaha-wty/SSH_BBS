<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function validate() {
		var page = document.getElementsByName("page")[0].value;

		if (page > <s:property value="#session.moUserPage.totalPage"/>) {
			alert("你输入的页数大于最大页数，页面将跳转到首页！");

			window.document.location.href = "showMoUserAction";

			return false;
		}

		return true;
	}
</script>
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
        <div class="tab-content default-tab" id="tab1" style="display: block;">
          <!-- This is the target div. id must match the href of this div's tab -->
          <div class="notification attention png_bg"> <a href="#" class="close"><img src="${pageContext.request.contextPath}/admin/resources/images/icons/cross_grey_small.png" title="Close this notification" alt="close"></a>
            <div> 请妥善修改 </div>
          </div>
          <table>
            <thead>
            <tr><form action="#">
            		用户名：<input type="text" name="serchInfo"/>
            		<button type="submit" style="margin-left:10px ;">Serch</button>
            	</form> </tr> 
              <tr>               
                <th>用户名</th>
                <th>性别</th>
                <th>注册时间</th>
                <th>发帖数</th>
                <th>操作</th>
              </tr>
            </thead>
            <tfoot>
              <tr>
                <td colspan="6">
                  <!--<div class="bulk-actions align-left">
                    <select name="dropdown">                    
                      <option value="option2">编辑</option>                    
                    </select>
                    <a class="button" href="#">Apply to selected</a> </div>-->
<!--                   <div class="pagination"> <a href="#" title="First Page">首页</a><a href="#" title="Previous Page">上一页</a> <a href="#" class="number" title="1">1</a> <a href="#" class="number" title="2">2</a> <a href="#" class="number current" title="3">3</a> <a href="#" class="number" title="4">4</a> <a href="#" title="Next Page">下一页</a><a href="#" title="Last Page">尾页</a> </div>
 -->                  <!-- End .pagination -->
 <div style="float: right; margin-top: 10px;">
							<center style="float: right;">

								<form action="showMoUserAction" onsubmit="return validate();">
									<font size="3">跳转至</font> <input
										style="width: 20px; height: 15px" type="text" size="2"
										name="page">页 <input style="" type="submit" value="跳转">
								</form>

							</center>
							<center style="float: right;">

								<font size="3">共<font color="red"><s:property
											value="#session.moUserPage.totalPage" /></font>页
								</font>&nbsp;&nbsp; <font size="3">共<font color="red"><s:property
											value="#session.moUserPage.allRows" /></font>条记录
								</font><br> <br>

								<s:if test="#session.moUserPage.currentPage == 1">
            首页&nbsp;&nbsp;&nbsp;上一页
        </s:if>

								<s:else>
									<a href="showMoUserAction">首页</a>
            &nbsp;&nbsp;&nbsp;
            <a
										href="showMoUserAction?page=<s:property value="#session.moUserPage.currentPage - 1"/>">上一页</a>
								</s:else>

								<s:if
									test="#session.moUserPage.currentPage != #session.moUserPage.totalPage">
									<a
										href="showMoUserAction?page=<s:property value="#session.moUserPage.currentPage + 1"/>">下一页</a>
            &nbsp;&nbsp;&nbsp;
            <a
										href="showMoUserAction?page=<s:property value="#session.moUserPage.totalPage"/>">尾页</a>
								</s:if>

								<s:else>
            下一页&nbsp;&nbsp;&nbsp;尾页
        </s:else>

							</center>

						</div>
                  <div class="clear"></div>
                </td>
              </tr>
            </tfoot>
            <tbody>
            	<s:iterator value="#session.moUserPage.list" id="user">
              <tr class="alt-row" >         
                <td><a href="# " title="title"><s:property value="#user.username" /></a></td>
                <td>
                	<s:if test="#user.sex==1">男</s:if><s:else>女</s:else>              	
                </td>
                <td><s:property value="#user.registerTime" /></td>
                <td><s:property value="#user.postTimes" /></td>
                <td><a href="isForbiddenAction?userId=<s:property value = "#user.userId" />&isForbidden=<s:property value = "#user.isForbidden" />"><s:if test="#user.isForbidden==0">禁言</s:if><s:else>解除禁言</s:else></a></td> 
                <td>
                  <!-- Icons -->
                   </td>
              </tr>
             </s:iterator >
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
    
</body>
</html>