<%@page import="com.sun.org.apache.xalan.internal.xsltc.compiler.sym" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.zyq.springtest.bean.Course" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'showCar.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/page.css"/>

    <script type="text/javascript">
        function addcourse() {
            window.location.href = "showaddcourse";
        }
    </script>

</head>
<body>

<form name="search" action="searchcourse" method="post">
    <table width="100%" border="0" align="center" cellpadding="2"
           cellspacing="0">
        <tr>
            <th colspan="10" height="50px">课程列表</th>
        </tr>
        <tr>
            <td colspan="9"> 课程名<input width="100%" type="text" name="courseName"/>
                <input type="submit" name="submit" value="查询"/>
            </td>
            <td><input type="button" name="add" value="添加新课程" onclick="addcourse()"/></td>
        </tr>
    </table>
</form>
<div
        style="overflow-x: auto; overflow-y: auto; height: 100%; width:100%;">
    <table width="100%" border="0" align="center" cellpadding="2"
           cellspacing="0">
        <tr>
            <th width="90px">学科</th>
            <th width="90px">课程名</th>
            <th width="200px">简述</th>
            <th width="90px">删除</th>
            <th width="90px">编辑</th>
            <th width="90px">详情</th>
            <th width="90px">讨论</th>

        </tr>
        <c:forEach var="coursePair" items="${requestScope.coursePairList}">
            <tr>
                <td width="90px">${coursePair.subject.subjectName }</td>
                <td width="90px">${coursePair.course.courseName }</td>
                <td width="200px" height="90px">${coursePair.course.introduction }</td>
                <td width="90px"><a href="deletecourse?id=${coursePair.course.id}">删除</a></td>
                <td width="90px"><a href="showeditcourse?id=${coursePair.course.id}">编辑</a></td>
                <td width="90px"><a href="coursedetail?id=${coursePair.course.id}">详情</a></td>
                <td width="90px"><a href="coursecomment?id=${coursePair.course.id}">讨论</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
