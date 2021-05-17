<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>

</head>
<body><% 
Object message =request.getAttribute("message");
if(message!=null&&!"".equals(message)){
%>
	<script type="text/javascript">
	alert("<%=request.getAttribute("message")%>");
	</script>
<%}%>



	<div align="center">
		<h1>简单的增删改查</h1>
		<div>
			<a href="insert.jsp">添加学生</a>
		</div>
		<div>
			<a href="servlet?method=list">删除</a>
		</div>
		<div>
			<a href="servlet?method=list">修改</a>
		</div>
		<div>
			<a href="servlet?method=list">查询</a>
		</div>


	</div>
</body>
</html>