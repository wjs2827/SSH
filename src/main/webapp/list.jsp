<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
  
<body>
	 <a href="<s:url value='/add.do'></s:url>">新增</a>
	<table>
	
		<thead>
			<tr>
				<th>用户名称</th>
				<th>用户密码</th>
				<th>注册时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="#request.userList">
				<tr>
					<td><s:property value="username" /></td>
					<td><s:property value="password" /></td>
					<td><s:property value="regtime" /></td>
					<td>
					<a href="<s:url value='/queryById.do'><s:param name='id' value='id'/></s:url>">编辑</a>
					<a href="<s:url value='/delete.do'><s:param name='id' value='id'/></s:url>">删除</a>
					</td>
				</tr>
           </s:iterator>
		</tbody>

	</table>

	  
</body>
 
</html>