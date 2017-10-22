<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>showlogin</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/page.css" />
<script language="javascript">
    function check(){
        if(document.forms[0].username.value==""|| document.forms[0].password.value==""){
            alert("请输入用户名密码");
            return false;
        }
        return true;
    }
</script>
</head>
<body>
	<%
		session.invalidate();
	%>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<h3 align="center">高校掌上课堂系统</h3>
	<br />
	<div align="center">
		<form name="login" action="login" method="post">
			<table width="300" border="0" align="center" cellpadding="2"
				cellspacing="0">
				<tr>
					<th colspan="2" align="center">教师登录</th>
				</tr>

				<tr>
					<td align="right">手机号：</td>
					<td><input type="text" id="tel" name="tel" size="22" />
					</td>
				</tr>
				<tr>
					<td align="right">密码：</td>
					<td><input type="password" name="password" id="password"
						size="22" maxlength="16" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input
						onclick="return check();" type="submit" name="Submit" value="登 录" />
						&nbsp;&nbsp;&nbsp;&nbsp; <input name="Submit2" type="reset"
						value="重 置" />
				</tr>
			</table>
		</form>
	</div>
</body>
</html>