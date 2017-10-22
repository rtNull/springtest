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
        function addResource(chapterId) {
            window.location.href = "showaddresource?id=" + chapterId;
        }
        function addQuestion(chapterId) {
            window.location.href = "showaddquestion?id=" + chapterId;
        }
    </script>

</head>
<body>

<table width="100%" border="0" align="center" cellpadding="2"
       cellspacing="0">
    <tr>
        <th colspan="8" height="50px">&lt;&lt;${chapter.title}&gt;&gt;--章节课件习题</th>
    </tr>
</table>

<table width="100%" border="0" align="center" cellpadding="2"
       cellspacing="0" style="margin-top:20px">
    <tr>
        <th colspan="2">课件资源</th>
        <th colspan="1"><input type="button" name="add" value="添加课件" onclick="addResource(${chapter.id})"/></th>

    </tr>

    <c:forEach var="resource" items="${requestScope.resourceList}">
        <tr>
            <td width="90px" colspan="2"><a href="<%=basePath%>${resource.url}" target="_blank">${resource.name}</a>
            </td>
            <td width="90px" colspan="1"><a href="deleteresource?id=${resource.id}">删除</a></td>
        </tr>
    </c:forEach>
    <c:if test="${empty requestScope.resourceList}">
        <tr>
            <td width="90px" colspan="3">无</td>
        </tr>
    </c:if>
</table>
<table width="100%" border="0" align="center" cellpadding="2"
       cellspacing="0" style="margin-top:20px">
    <tr>
        <th colspan="9">习题</th>
        <th><input type="button" name="add" value="添加习题" onclick="addQuestion(${chapter.id})"/></th>

    </tr>
    <tr>
        <th width="90px">题目</th>
        <th width="90px">题型</th>
        <th width="90px">答案</th>
        <th width="90px">解答</th>
        <th width="90px">选项A</th>
        <th width="90px">选项B</th>
        <th width="90px">选项C</th>
        <th width="90px">选项D</th>
        <th width="90px">删除</th>
        <th width="90px">编辑</th>
    </tr>
    <c:forEach var="question" items="${requestScope.questionList}">
        <tr>
            <td width="90px">${question.title}</td>
            <td width="90px">
                <c:if test="${question.ischoice}">
                    选择题
                </c:if>
                <c:if test="${!question.ischoice}">
                    填空题
                </c:if>
            </td>
            <td width="90px">${question.answer}</td>
            <td width="90px">${question.explanation}</td>

            <c:if test="${question.ischoice}">
                <td width="90px">${question.optionA}</td>
                <td width="90px">${question.optionB}</td>
                <td width="90px">${question.optionC}</td>
                <td width="90px">${question.optionD}</td>
            </c:if>
            <c:if test="${!question.ischoice}">
            <td width="90px" colspan="4">
                </c:if>
            <td width="90px"><a href="deletequestion?id=${question.id}&chapterId=${chapter.id}">删除</a></td>
            <td width="90px"><a href="showeditquestion?id=${question.id}">编辑</a></td>
        </tr>
    </c:forEach>
    <c:if test="${empty requestScope.questionList}">
        <tr>
            <td width="90px" colspan="10">无</td>
        </tr>
    </c:if>

</table>
</body>
</html>
