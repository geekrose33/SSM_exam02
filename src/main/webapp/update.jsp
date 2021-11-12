<%--
  Created by IntelliJ IDEA.
  User: 83480
  Date: 2021-11-10
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=path%>"/>
</head>
<body>
<div align="center">
    <h3>修改城市名称 / 所属省份id</h3>
    <form id="myform" action="city/update.do">
        城市id: <input type="text" name="cid"> <br>
        城市名称: <input type="text" name="cname"> <br>
        所属省份id: <input type="text" name="pid"> <br>
        <input type="submit" value="修改">
    </form>
    <br>
    提示信息： ${msg}
    <br>
    <a href="index.jsp">主页</a>
</div>

</body>
</html>
