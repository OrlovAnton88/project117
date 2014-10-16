<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Рейтинг группы 117 </title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" type="text/css"></link>
    <%--<link rel="stylesheet" href="static/css/style.css" type="text/css"></link>--%>
</head>
<body>
<div class="container">
    <div class="row">
        <div class ="top_menu">
            <ul class="nav nav-pills" role="tablist">
            <li class="active"><a href="#">Главная</a></li>
            <li><a href="#">Учебные материалы</a></li>
            <li><a href="#">Расписание</a></li>
        </ul>
        </div>
    </div>
    <div class="row">
        <h1 class="page-header">&#60;HTML race&#47;&#62;
            <small>Группа 117</small>
            <small></small>
        </h1>
        <table class="table col-md-12">
            <thead>
            <tr>
                <th>#</th>
                <th>Имя</th>
                <th>Баллов</th>
                <th>Законченных курсов</th>
                <th>Курсы</th>
            </tr>
            </thead>
            <c:forEach items="${userList}" var="user" varStatus="status">
                <tr>
                    <td>${status.index+1}</td>
                    <td><span style="color: green;" class="glyphicon glyphicon-thumbs-up"></span>&nbsp;<a
                            href="<c:out value="${user.htmlAcademyLink}"/>" target="_blank"> <c:out
                            value="${user.userName}"></c:out> </a></td>
                    <td><c:out value="${user.scores}"/></td>
                    <td><c:out value="${user.coursesFinished}"/></td>
                    <td>
                        <c:set var="cources" value="${user.userApproofs}"/>
                            <%--<ul class="list-group">--%>
                        <c:forEach items="${cources}" var="cource">
                            <c:if test="${cource.passedTasks > 2}">
                                <%--<li class="list-group-item">--%>
                                <c:choose>
                                    <c:when test="${cource.approof.totalTasks== cource.passedTasks}">
                                        <h5><span class="label label-success spacedTop"> <c:out value="${cource.userApproofName}"/>
                                    ( <c:out
                                                    value="${cource.passedTasks}"/> /<c:out
                                                    value=" ${cource.approof.totalTasks}"/>) </span></h5>
                                    </c:when>
                                    <c:otherwise>
                                        <h5>  <span class="label label-default spacedTop">
                               <c:out value="${cource.userApproofName}"/> (
                                            <c:out value="${cource.passedTasks}"/> / <c:out
                                                value="${cource.approof.totalTasks}"/>)
                            </span></h5>
                                    </c:otherwise>

                                </c:choose>
                                <%--</li>--%>
                            </c:if>
                        </c:forEach>
                            <%--</ul>--%>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>
<div class="footer">
    <div class="container">
        <p class="text-muted"><a href="admin.html" target="_blank"> Admin page</a></p>
    </div>
</div>
</body>
</html>