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
    <meta charset="UTF-8">
    <title><spring:message
            code="label.user.userDetails.title"/></title>
</head>
<body>
<sec:authorize access="isAuthenticated()">
    <%--<sec:authentication property="principal.id"/> <br>--%>
    <%--<sec:authentication property="principal.firstName"/> <br>--%>
    <%--<sec:authentication property="principal.lastName"/> <br>--%>
    <%--&lt;%&ndash;<sec:authentication property="principal.role>"/>&ndash;%&gt;--%>
    <c:choose>
        <c:when test="${type == 'vkontakte'}">
            <h3>Your VK Profile</h3>
            <img src="<c:out value="${profile.photoMedium}"/> ">

            <p>Hello, <c:out value="${profile.firstName}"/>!</p>
            <dl>
                <dt>VKontakte ID:</dt>
                <dd><c:out value="${profile.uid}"/></dd>
                <dt>Name:</dt>
                <dd><c:out value="${profile.screenName}"/></dd>
            </dl>
        </c:when>
        <c:otherwise>
            <h1> FACEBOOK is not supported yet... </h1>
        </c:otherwise>


    </c:choose>


</sec:authorize>
</body>
</html>
