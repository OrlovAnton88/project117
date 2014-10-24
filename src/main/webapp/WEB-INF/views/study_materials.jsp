<%--
  Created by IntelliJ IDEA.
  User: oav
  Date: 24.10.14
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Учебные материалы</title>
    <link rel="stylesheet" href="<c:url value="/static/bootstrap/css/bootstrap.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/static/css/style.css"/>" type="text/css">
</head>
<body>
<jsp:include page="navigation.jsp"/>
<div class="container-fluid">
    <div class="row fill">
        <div class="col-md-3 fill" style="border-right: 1px solid #e7e7e7;">
            <h3></h3>
            <ul class="nav nav-pills nav-stacked">
                <c:forEach items="${materialList}" var="item" varStatus="status">
                    <li class="active">
                        <a href="<spring:url value="/study_materials&material=${item.meterialId}"/>">
                            <c:out value="${item.name}"/>
                        </a>
                    </li>
                </c:forEach>
            </ul>

        </div>
        <div class="col-md-8 fill" style="border-right: 1px solid #e7e7e7;">
            <h1><c:out value="${material.name}"/></h1>
            <c:out value="${material.htmlText}"/>
        </div>

    </div>
</div>

<jsp:include page="footer.jsp"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</body>
</html>
