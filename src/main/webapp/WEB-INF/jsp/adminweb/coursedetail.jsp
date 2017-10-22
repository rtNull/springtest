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
        function addChapter(courseId) {
            window.location.href = "showaddchapter?id="+courseId;
        }
    </script>

</head>
<body>

<form name="search" action="searchapter" method="post">
    <table width="100%" border="0" align="center" cellpadding="2"
           cellspacing="0">
        <tr>
            <th colspan="10" height="50px">${course.courseName}--课程详情</th>
        </tr>
        <tr>
            <td colspan="9"> 章节名<input width="100%" type="text" name="courseName"/>
                <input type="submit" name="submit" value="查询"/>
            </td>
            <td><input type="button" name="add" value="添加新章节" onclick="addChapter(${course.id})"/></td>
        </tr>
    </table>
</form>
<div
        style="overflow-x: auto; overflow-y: auto; height: 100%; width:100%;">
    <table width="100%" border="0" align="center" cellpadding="2"
           cellspacing="0">
        <tr>
            <th width="90px">章节名</th>
            <th width="200px">创建时间</th>
            <th width="90px">删除</th>
            <th width="90px">编辑</th>
            <th width="90px">课件习题</th>

        </tr>
        <c:forEach var="chapter" items="${requestScope.chapterList}">
            <tr>
                <td width="90px">${chapter.title }</td>
                <td width="90px">${chapter.createDate }</td>
                <td width="90px"><a href="deletechapter?id=${chapter.id}&courseId=${course.id}">删除</a></td>
                <td width="90px"><a href="showeditchapter?id=${chapter.id}">编辑</a></td>
                <td width="90px"><a href="chapterdetail?id=${chapter.id}">详情</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
