<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".delEmp").click(function(){
			var hrefValue = $(this).attr("href");
			var flag = confirm("确定要删除吗？");
			if(flag) {
				$("#delForm").attr("action", hrefValue).submit();
			}
			return false;
		});

	});
</script>
<title>Insert title here</title>
</head>
<body>
	<form id="delForm" action="" method="post">
		<input type="hidden" name="_method" value="DELETE">
	</form>
	<center>
		<c:if test="${empty requestScope.emps }">
			<h2 align="center">还没有添加员工信息</h2>
		</c:if>
		<c:if test="${not empty requestScope.emps }">
			<table border="1" cellpadding="10" cellspacing="0" style="text-align: center">
				<thead>所有员工的信息</thead>
				<tr>
					<th>ID</th>
					<th>LastName</th>
					<th>Email</th>
					<th>Gender</th>
					<th>Department</th>
					<th colspan="2">Operation</th>
				</tr>
			<c:forEach items="${requestScope.emps }" var="emp">
				<tr>
					<td>${emp.id }</td>
					<td>${emp.lastName }</td>
					<td>${emp.email }</td>
					<td>${emp.gender == 1 ? '男' : '女' }</td>
					<td>${emp.department.name }</td>
					<td><a class="uptEmp" href="${pageContext.request.contextPath }/emp/${emp.id }">修改</a></td>
					<td><a class="delEmp" href="${pageContext.request.contextPath }/emp/${emp.id }">删除</a></td>
				</tr>
			</c:forEach>
			</table>
		</c:if>
		<a href="${pageContext.request.contextPath }/emp">添加新员工</a>
	</center>
</body>
</html>