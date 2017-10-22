<%@page import="com.sun.org.apache.xalan.internal.xsltc.compiler.sym" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
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
<form name="" action="editinfo" method="post"
      enctype="multipart/form-data">
    <table width="100%" border="0" align="center" cellpadding="2"
           cellspacing="0">
        <tr>
            <th colspan="2" align="center" height="50px">我的信息</th>
            <input type="hidden" id="id" name="id"
                   size="22" value="${user.id}"/>
        </tr>

        <tr>
            <td align="right">手机号：</td>
            <td align="left">
                <input type="text" id="tel1" name="tel1"
                       size="22" value="${user.tel}" disabled/>
                <input type="hidden" id="tel" name="tel"
                       size="22" value="${user.tel}"/>
            </td>
        </tr>
        <tr>
            <th align="right">姓名</th>
            <td align="left">
                <input type="text" id="name" name="name"
                       size="22" value="${user.name}"/>
            </td>
        </tr>
        <tr>
            <th align="right">性别</th>
            <td align="left">
                <input type="radio" id="sex" name="sex"
                       size="22" value="0"
                        <c:if test="${user.sex==0}">
                            checked
                        </c:if>
                />男
                <input type="radio" id="sex" name="sex"
                       size="22" value="1"
                        <c:if test="${user.sex==1}">
                            checked
                        </c:if>
                />女
            </td>
        </tr>
        <tr>
            <th align="right">简介</th>
            <td align="left">
                <textarea rows="3" cols="50" id="introduction" name="introduction">${user.introduction}</textarea>
            </td>
        </tr>
        <tr>
            <th align="right">头像</th>
            <td align="left">
                <img src="<%=basePath%>${user.headImg}" alt="" width="80px" height="120px"/><br/>
                <input type="file" name="file" value="上传头像"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input onclick="return validateCarInfo();" type="submit" name="Submit"
                       value="保存"/> &nbsp;&nbsp;&nbsp;&nbsp;
                <input name="reset" type="reset" value="重 置"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
