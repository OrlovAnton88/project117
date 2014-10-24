<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Рейтинг группы 117 </title>
    <link rel="stylesheet" href="<c:url value="/static/bootstrap/css/bootstrap.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/static/css/style.css"/>" type="text/css">
</head>
<body>
<jsp:include page="navigation.jsp"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-9">
            <c:forEach items="${userList}" var="user" varStatus="status">
                <div class="col-md-12 user-block">
                    <div class="row">
                        <div class="col-md-6 user-name">
                            <h4>
                                <small>#<c:out value="${status.index+1}"/></small>
                                <a
                                        href="<c:out value="${user.htmlAcademyLink}"/>" target="_blank"> <c:out
                                        value="${user.userName}"/></a></h4>
                        </div>
                        <div class="col-md-6">
                            <div class="row">
                                <div class="col-md-6">
                                    <h4><b id="scores">
                                        <c:out value="${user.scores}"/>
                                    </b>
                                        <small>баллов</small>
                                    </h4>
                                </div>
                                <div class="col-md-6">
                                    <h4><b id="finished">
                                            <fmt:parseNumber var="cf" type="number" value="${user.coursesFinished}"/>
                                            <c:out value="${cf}"/>
                                        <c:choose>
                                        <c:when test="${cf == 1}">
                                        <small>курс пройден</small>
                                        </c:when>
                                        <c:when test="${(cf >= 2) && (cf <=4)}">
                                        <small>курса пройдено</small>
                                        </c:when>
                                        <c:otherwise>
                                        <small>курсов пройдено</small>
                                        </c:otherwise>
                                        </c:choose>
                                    </h4>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 cource-lables">
                            <c:set var="cources" value="${user.userApproofs}"/>
                                <%--<ul class="list-group">--%>
                            <c:forEach items="${cources}" var="cource">
                                <c:if test="${cource.passedTasks > 2}">
                                    <%--<li class="list-group-item">--%>
                                    <c:choose>
                                        <c:when test="${cource.approof.totalTasks == cource.passedTasks}">
                                    <span class="label label-success spacedTop" style="margin: 5px 5px 5px 5px;"> <c:out
                                            value="${cource.userApproofName}"/>
                                    ( <c:out
                                                value="${cource.passedTasks}"/> /<c:out
                                                value=" ${cource.approof.totalTasks}"/>) </span>
                                        </c:when>
                                        <c:otherwise>
                                    <span class="label label-default spacedTop" style="margin: 5px 5px 5px 5px;">
                               <c:out value="${cource.userApproofName}"/> (
                                            <c:out value="${cource.passedTasks}"/> / <c:out
                                            value="${cource.approof.totalTasks}"/>)
                            </span>
                                        </c:otherwise>

                                    </c:choose>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="col-md-3">
            <div class="row">
                <div class="col-md-12 text-center">
                    <a href="<spring:url value="/index/rescan"/>" class="btn btn-primary btn-lg">
                        <i class="icon-white glyphicon glyphicon-refresh"></i>
                        <br>
                        Я прошел задание!
                        <br>Обновить результаты!</a>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    &nbsp;
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 text-center">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <h1>
                                <span id="lesson_num">?</span> <br>
                                <small>Занятие</small>
                            </h1>
                            <i id="lessond_date">dd-mm-yyyy</i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
    $("document").ready(function () {
                $.ajax({
                    type: "POST",
//        contentType: "application/json",
                    url: '<spring:url value="/get_lesson_json"/>',
//        data: { name: 'norm' },
//        dataType: "json"
                    success: function (data) {
                        $('#lesson_num').empty().html(data.number);
                        $('#lessond_date').empty().html(data.date);
                    },
                    fail: function () {
                        alert("fail to request json");
                    }
                });

            }
    );

</script>
</body>
</html>