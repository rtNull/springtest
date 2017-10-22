<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.zyq.springtest.bean.User" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'top2.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style type="text/css">
div {
	font-size: 30px;
	color: #333333;
	padding-top: 10px;
	padding-right: 30px
}
</style>
</head>

<body
	style="background-color:#A3CBE0;background-image:url('images/cars.jpg')">
	<%
		User user = (User) session.getAttribute("user");
	%>
	<div align="right">高校掌上课堂系统</div>
	<h5 align="right" style="padding-right: 30px;color:#333333;">
		当前用户：<%=user.getName()%></h5>

</body>
</html>
