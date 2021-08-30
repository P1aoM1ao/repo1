<%--
  Created by IntelliJ IDEA.
  User: zhongcheng
  Date: 2021/8/25
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>查询所有账户信息成功!</h2>
    ${list}</br>
    <c:forEach items="${success}" var="account">
        ${account.name}
        ${account.money}
    </c:forEach>
</body>
</html>
