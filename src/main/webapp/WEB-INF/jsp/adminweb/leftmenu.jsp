<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
+ request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/page.css" />
</head>

<body>
	<table width="144" border="0" cellpadding="4" cellspacing="0">
		<tr>
			<th class="menu_title" width="139" align="center">课程管理</th>
		</tr>
		<tr>
			<td align="center"><a href="mycourse" target="mainFrame">我的教学</a>
			</td>
		</tr>
		<tr>
			<th class="menu_title" width="139" align="center">基础信息</th>
		</tr>

		<tr>
			<td align="center"><a href="myinfo" target="mainFrame">我的信息</a>
			</td>
		</tr>

		<tr>
			<td align="center"><a href="showlogin" target="_top">退出</a>
			</td>
		</tr>
	</table>
</body>
</html>
