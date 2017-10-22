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
            window.location.href = "showaddchapter?id=" + courseId;
        }
    </script>

</head>
<body>
<form name="addcomment" action="addcomment" method="post">

    <table width="100%" border="0" align="center" cellpadding="2"
           cellspacing="0">
        <tr>
            <th colspan="10" height="50px">${course.courseName}--课程讨论</th>
        </tr>
        <tr>
            <td colspan="9" align="left">
                <textarea rows="3" cols="100" name="content" id="content"></textarea>
                <br/>
                <input type="hidden" name="courseId" id="courseId" value="${course.id}"/>
                <input type="submit" name="submit" value="快速评论"/>
                <input type="reset" name="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form>

<div
        style="overflow-x: auto; overflow-y: auto; height: 100%; width:100%;">
    <table width="100%" border="0" align="center" cellpadding="2"
           cellspacing="0">
        <tr>
            <th width="40px" height="60px"></th>
            <th width="40px">姓名</th>
            <th width="190px">内容</th>
            <th width="90px">时间</th>
            <th width="40px">回复</th>
            <th width="40px">删除</th>

        </tr>
        <c:forEach var="commentPair" items="${requestScope.commentPairList}">
            <tr>
                <td width="40px" height="60px"><img width="40px" height="60px"
                                                    src="<%=basePath%>${commentPair.user.headImg }" alt=""></
                ></td>
                <td width="40px">${commentPair.user.name }</td>
                <td width="190px">${commentPair.comment.content }</td>
                <th width="90px">${commentPair.comment.commentTime }</th>
                <td width="40px"><a
                        href="showreplycomment?id=${commentPair.comment.id }">回复</a>
                </td>
                <td width="40px"><a href="deletecomment?id=${commentPair.comment.id }&courseId=${course.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
