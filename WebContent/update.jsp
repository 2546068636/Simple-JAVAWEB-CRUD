<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改</title>
</head>
<body>
	<div align="center">
		<h1>修改</h1>
		<a href="index.jsp">返回主页</a>
		<form action="servlet?method=update" method="post">
			<div>
				id<input type="text" id="id" name="id" readonly="true"
					value="${param.id}" />
			</div>
			<div>
				name<input type="text" id="name" name="name" readonly="true"
					value="${param.name}" />
			</div>
			<div>
				password<input type="text" id="password" name="password"
					value="${param.password}" />
			</div>
			<div>
				sex<input type="radio" id="sex" name=sex  value="男" />男 <input
					type="radio" id="sex" name="sex" value="女" />女
			</div>




			<div>
				<button type="submit">修&nbsp;&nbsp;&nbsp;改</button>
			</div>
		</form>
	</div>
</body>
</html>