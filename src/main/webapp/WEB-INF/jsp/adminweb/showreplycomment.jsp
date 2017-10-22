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
<form name="addcomment" action="addcomment" method="post"
      enctype="multipart/form-data">
    <table width="100%" border="0" align="center" cellpadding="2"
           cellspacing="0">
        <tr>
            <th colspan="2" align="center" height="50px">回复评论</th>
        </tr>
        <tr>
            <td align="right">${user.name}:</td>
            <td align="left"><textarea id="replycontent" name="replycontent" rows="5" cols="100"
                                       disabled>${comment.content}</textarea></td>
        </tr>
        <tr>
            <td align="right">内容：</td>
            <td align="left">
                <input type="hidden" name="courseId" id="courseId" value="${comment.courseId}"/>
                <input type="hidden" name="toUserId" id="toUserId" value="${user.id}"/>
                <textarea id="content" name="content" rows="5" cols="100">@${user.name}:</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input onclick="return validateCarInfo();" type="submit" name="submit"
                       value="回复"/> &nbsp;&nbsp;&nbsp;&nbsp;
                <input name="reset"
                       type="reset" value="重 置"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
