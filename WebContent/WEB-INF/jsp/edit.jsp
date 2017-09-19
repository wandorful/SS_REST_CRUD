<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改员工信息</title>
</head>
<body>
	<h2>更新员工信息</h2>
	<form:form action="${pageContext.request.contextPath }/emp" 
		method="post" modelAttribute="employee">
		<form:hidden path="id"/>
		<input type="hidden" name="_method" value="PUT">
		邮箱：<form:input path="email"/><br>
		部门：<form:select path="deptId" items="${requestScope.depts }"
			itemLabel="name" itemValue="id"></form:select><br>
		<input type="submit" value="更新">
	</form:form>
</body>
</html>