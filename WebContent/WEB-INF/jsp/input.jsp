<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加员工信息</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath }/emp" method="post" modelAttribute="employee">
		员工姓名：<form:input path="lastName"/><br>
		邮箱：<form:input path="email"/><br>
		性别：<form:radiobutton path="gender" value="1"/>男
			<form:radiobutton path="gender" value="0"/>女<br>
		部门：<form:select path="deptId" items="${requestScope.depts }"
				itemLabel="name"
				itemValue="id"></form:select><br>
		<input type="submit" value="添加">
	</form:form>
</body>
</html>