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
<form name="" action="addresource" method="post"
      enctype="multipart/form-data">
    <table width="100%" border="0" align="center" cellpadding="2"
           cellspacing="0">
        <tr>
            <th colspan="2" align="center" height="50px">添加课件</th>
        </tr>
        <tr>
            <td align="right">章节名：</td>
            <td align="left">
                <input type="text" id="title" name="title"
                       size="22" disabled value="${chapter.title}"/>
                <input type="hidden" id="chapterId" name="chapterId"
                       size="22" value="${chapter.id}"/>
            </td>
        </tr>
        <tr>
            <td align="right">课件名：</td>
            <td align="left"><input type="text" id="name" name="name"
                                    size="22"/></td>
        </tr>
        <tr>
            <td align="right">选择文件：</td>
            <td align="left"><input type="file" name="file"/></td>

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
