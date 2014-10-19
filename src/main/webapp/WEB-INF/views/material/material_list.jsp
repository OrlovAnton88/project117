<%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 19.10.14
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><spring:message code="page.title"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
          type="text/css">
    <link rel="stylesheet" href="<c:url value="/static/css/style.css" />" type="text/css"/>
</head>
<body>
<div class="container">
<jsp:include page="../navigation.jsp"/>
<div class="messages">
    <c:if test="${feedbackMessage != null}">
        <div class="messageblock"><c:out value="${feedbackMessage}"/></div>
    </c:if>
    <c:if test="${errorMessage != null}">
        <div class="errorblock"><c:out value="${errorMessage}"/></div>
    </c:if>
</div>
<h1><spring:message code="material.list.page.title"/></h1>
<c:if test="${not empty materials}">
    <div class="row">
        <table class="table col-md-12">
        <thead>
        <tr>
            <td>#</td>
            <td><spring:message code="material.label.name"/></td>
            <td> Описание</td>
            <td> Категория</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${materials}" var="material" varStatus="status">
            <tr>
                <td><c:out value="${status.index+1}"/></td>
                <td><c:out value="${material.name}"/></td>
                <%--<td><c:out value="${person.firstName}"/></td>--%>
                <td>
                    <%--<a href="/person/edit/<c:out value="${person.id}"/>"><spring:message code="person.edit.link.label"/></a>--%>
                todo
                </td>
                <td>
                    todo
                    <%--<a href="/person/delete/<c:out value="${person.id}"/>"><spring:message code="person.delete.link.label"/></a>--%>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
        </div>
<c:if test="${empty materials}">
    <p>
        <spring:message code="material.list.page.label.no.material.found"/>
    </p>
</c:if>
    </div>
</body>
</html>