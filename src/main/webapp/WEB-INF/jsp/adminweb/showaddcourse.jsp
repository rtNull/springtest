<%@page import="com.sun.org.apache.xalan.internal.xsltc.compiler.sym" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'showCar.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="../css/page.css"/>

    <script type="text/javascript">
        function validateCarInfo() {
        }
    </script>

</head>
<body>
<form name="" action="addcourse" method="post"
      enctype="multipart/form-data">
    <table width="100%" border="0" align="center" cellpadding="2"
           cellspacing="0">
        <tr>
            <th colspan="2" align="center" height="50px">添加新课程信息</th>
        </tr>
        <tr>
            <td align="right">学科：</td>
            <td align="left">
                <select name="subjectId">
                    <c:forEach var="subject" items="${requestScope.subjectList}">
                        <option value="${subject.id}">
                                ${subject.subjectName}
                        </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td align="right">课程名：</td>
            <td align="left"><input type="text" id="courseName" name="courseName"
                                    size="22"/></td>
        </tr>
        <tr>
            <td align="right">简介：</td>
            <td align="left">
                <textarea id="introduction" name="introduction" rows="5" cols="50"></textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input onclick="return validateCarInfo();" type="submit" name="Submit"
                       value="添加"/> &nbsp;&nbsp;&nbsp;&nbsp;
                <input name="Submit2"
                       type="reset" value="重 置"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
