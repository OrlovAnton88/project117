<%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 18.10.14
  Time: 1:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title><spring:message code="page.title"/></title>
    <link rel="stylesheet" href="<c:url value="/static/css/style.css" />" type="text/css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="../navigation.jsp"/>
<div class="messages">
    <c:if test="${feedbackMessage != null}">
        <div class="messageblock"><c:out value="${feedbackMessage}"/></div>
    </c:if>
    <c:if test="${errorMessage != null}">
        <div class="errorblock"><c:out value="${errorMessage}"/></div>
    </c:if>
</div>
<h1><spring:message code="material.create.page.title"/></h1>

<div>
    <form:form action="${pageContext.request.contextPath}/material/create" commandName="material" method="POST">
        <div>
            <form:label path="name"><spring:message code="material.label.name"/>:</form:label>
            <form:input path="name" size="100" placeholder="Название"/>
            <form:errors path="name" cssClass="error" element="div"/>
        </div>
        <div>
            <form:label path="category"><spring:message code="material.label.category"/>:</form:label>
            <form:select path="category" items="${categories}" required="true" itemLabel="name" itemValue="categoryId"/>
            <form:errors path="category" cssClass="error" element="div"/>
        </div>
        <div>
            <form:label path="htmlText"><spring:message code="material.label.htmlText"/>:</form:label>
            <form:textarea path="htmlText" class="form-control" rows="5"/>
            <form:errors path="htmlText" cssClass="error" element="div"/>
        </div>
        <div>
            <input type="submit" value="<spring:message code="material.create.page.submit.label"/>"/>
        </div>
    </form:form>
</div>


</body>
</html>
