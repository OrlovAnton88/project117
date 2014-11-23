<%--
  Created by IntelliJ IDEA.
  User: antonorlov
  Date: 23/11/14
  Time: 01:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title><spring:message
            code="label.user.userDetails.title"/></title>
</head>
<body>
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal.id"/> <br>
    <sec:authentication property="principal.firstName"/> <br>
    <sec:authentication property="principal.lastName"/> <br>
    <%--<sec:authentication property="principal.role>"/>--%>
</sec:authorize>
</body>
</html>
