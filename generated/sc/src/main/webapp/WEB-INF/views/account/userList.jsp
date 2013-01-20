<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<title>综合演示用例</title>
	<script>
		$(document).ready(function() {
			$("#account-tab").addClass("active");
		});
	</script>
</head>

<body>
	<h1>帐号管理</h1>
	<c:if test="${not empty message}">
		<div id="message" class="success">${message}</div>	
	</c:if>
			
		<table class="table table-striped table-bordered table-condensed">
			<thead><tr>
				<th>登录名</th>
				<th>姓名</th>
				<th>电邮</th>
				<th>角色</th>
				<th>状态</th>
				<th>操作</th>
			</tr></thead>
			<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.loginName}&nbsp;</td>
					<td>${user.name}&nbsp;</td>
					<td>${user.email}&nbsp;</td>
					<td>${user.roleNames}&nbsp;</td>
					<td>${user.status}&nbsp;</td>
					<td>
						<shiro:hasPermission name="user:edit">
							<a href="${ctx}/account/user/update/${user.id}" id="editLink-${user.loginName}">修改</a>
						</shiro:hasPermission>
					</td>
				</tr>
			</c:forEach>
			</tbody>		
		</table>
</body>
</html>
