<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
	<form action="update.do" method="post">
	<input type="hidden" id="id" name="id"  value="${user.id}"/>
		<table width="207" border="0" align="center">
			<tr>
				<td colspan="2" align="center" nowrap="nowrap">用户编辑</td>
			</tr>
			<tr>
				<td width="68" nowrap="nowrap">用户名</td>
				<td width="127" nowrap="nowrap"><label> <input
						name="username" type="text" id="username" size="20" value="${user.username}" />
				</label></td>
			</tr>
			<tr>
				<td nowrap="nowrap">密 码</td>
				<td nowrap="nowrap"><input name="password" type="password"
					id="password" size="20" maxlength="10" value="${user.password}"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center" nowrap="nowrap"><label>
						<input type="submit" value="保存" /> <input type="reset" value="重填" />
				</label></td>
			</tr>
		</table>
	</form>
</body>
</html>