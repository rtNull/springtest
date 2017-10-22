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
<form name="" action="editquestion" method="post"
      enctype="multipart/form-data">
    <table width="100%" border="0" align="center" cellpadding="2"
           cellspacing="0">
        <tr>
            <th colspan="2" align="center" height="50px">修改习题</th>
            <input type="hidden" id="chapterId" name="chapterId"
                   size="22" value="${question.chapterId}"/>
            <input type="hidden" id="id" name="id"
                   size="22" value="${question.id}"/>
        </tr>

        <tr>
            <td align="right">题型：</td>
            <td align="left">
                <input type="radio" id="ischoice" name="ischoice"
                       size="22" value="true"
                        <c:if test="${question.ischoice}">
                            checked
                        </c:if>
                />选择题
                <input type="radio" id="ischoice" name="ischoice"
                       size="22" value="false"
                        <c:if test="${!question.ischoice}">
                            checked
                        </c:if>
                />提空题
            </td>
        </tr>
        <tr>
            <th align="right">题目</th>
            <td align="left">
                <textarea rows="3" cols="50" id="title" name="title">${question.title}</textarea>
            </td>
        </tr>
        <tr>
            <th align="right">答案</th>
            <td align="left">
                <textarea rows="3" cols="50" id="answer" name="answer">${question.answer}</textarea>
            </td>
        </tr>
        <tr>
            <th align="right">解答</th>
            <td align="left">
                <textarea rows="3" cols="50" id="explanation" name="explanation">${question.explanation}</textarea>
            </td>
        </tr>
        <tr>
            <td align="left" colspan="2">
                选项(选择题必填全部4个选项，填空题可不填)
            </td>
        </tr>
        <tr>
            <th align="right">A</th>
            <td align="left">
                <textarea rows="2" cols="50" id="optionA" name="optionA">${question.optionA}</textarea>
            </td>
        </tr>
        <tr>
            <th align="right">B</th>
            <td align="left">
                <textarea rows="2" cols="50" id="optionB" name="optionB">${question.optionB}</textarea>
            </td>
        </tr>
        <tr>
            <th align="right">C</th>
            <td align="left">
                <textarea rows="2" cols="50" id="optionC" name="optionC">${question.optionC}</textarea>
            </td>
        </tr>
        <tr>
            <th align="right">D</th>
            <td align="left">
                <textarea rows="2" cols="50" id="optionD" name="optionD">${question.optionD}</textarea>
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
