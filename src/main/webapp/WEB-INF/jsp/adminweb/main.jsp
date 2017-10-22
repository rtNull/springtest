<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>高校掌上课堂系统</title>
</head>
<frameset rows="100,*" cols="*" frameborder="no" border="0" framespacing="0">
    <frame src="topbar" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame"/>
    <frameset cols="155,*" frameborder="no" border="0" framespacing="0">
        <frame src="leftmenu" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame"/>
        <frame src="mycourse" name="mainFrame" id="mainFrame" title="mainFrame" scrolling="Yes"/>
    </frameset>
</frameset>
</html>
