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
<style>

    svg {
        font: 10px sans-serif;
    }

    .area {
        fill: steelblue;
        clip-path: url(#clip);
    }

    .axis path,
    .axis line {
        fill: none;
        stroke: #000;
        shape-rendering: crispEdges;
    }

    .brush .extent {
        stroke: #fff;
        fill-opacity: .125;
        shape-rendering: crispEdges;
    }

</style>

<body>
<jsp:include page="navigation.jsp"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-9">
            <c:forEach items="${userList}" var="user" varStatus="status">
                <div class="col-md-12 user-block">
                    <div class="row">
                        <div class="col-md-4 user-name">
                            <h4>
                            <small>#<c:out value="${status.index+1}"/></small>
                                <a
                                        href="<c:out value="${user.htmlAcademyLink}"/>" target="_blank"> <c:out
                                        value="${user.userName}"/></a></h4>
                        </div>
                        <div class="col-md-8">
                            <div class="row">
                                <div class="col-md-4">
                                    <h4><b id="scores">
                                    <c:out value="${user.scores}"/>
                                    </b>
                                        <small>баллов</small>
                                    </h4>
                                </div>
                                <div class="col-md-4">
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
                                <div class="col-md-4">
                                        <%--<button class="btn btn-primary history-button"--%>
                                        <%--data-toggle="modal"--%>
                                        <%--data-target=".bs-example-modal-lg"--%>
                                        <%--data-id="${user.userId}">--%>
                                    <h4><a class="history-button"
                                           data-toggle="modal"
                                           data-target=".bs-example-modal-lg"
                                           data-id="${user.userId}"
                                           href="#">
                                        График
                                    </a></h4>
                                        <%--</button>--%>
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
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script src="<c:url value="/static/bootstrap/js/bootstrap.js"/>"></script>

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

<script>

    $(".history-button").click(function () {
                var userId = $(this).data('id');
                $.ajax({
                    url: '<spring:url value="/get_history"/>',
                    type: "POST",
                    dataType: "json",
                    contentType: "application/json",
                    mimeType: 'application/json',
                    data: "{ userId: " + userId + "}",

                    success: function (data) {
                        chartHeader(data);
                        drawChart(data);
                    },
                    fail: function () {
                        alert("fail to request json");
                    }
                });

            }
    );

</script>
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-lg" id="chart-modal">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title">Статистика с
                    <span id="char-period-start"></span>
                    по
                    <span id="char-period-end"></span></h4>
            </div>
            <div class="modal-body" id="chart">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
            </div>


        </div>
    </div>
</div>

<script src="http://d3js.org/d3.v3.js"></script>
<script>

    function chartHeader(data) {
        var dates = [];

        var parseDate = d3.time.format("%d-%m-%Y %H").parse;

        data.forEach(function (d) {
            dates.push(parseDate(d.date));

        });
        var max = $.datepicker.formatDate('dd-mm-yy', new Date(Math.max.apply(Math, dates)));
        var min = $.datepicker.formatDate('dd-mm-yy', new Date(Math.min.apply(Math, dates)));

        $('#char-period-start').empty().text(min);
        $('#char-period-end').empty().text(max);

    }
    ;
    function drawChart(data) {
        $('#chart').empty();
        var divwidth = $('#chart-modal').width() * 0.9;
        $('#chart-modal').height(700);

        var margin = {top: 20, right: 20, bottom: 30, left: 50},
                width = divwidth - margin.left - margin.right,
                height = 300 - margin.top - margin.bottom;

        var parseDate = d3.time.format("%d-%m-%Y %H").parse;

        var x = d3.time.scale()
                .range([0, width]);

        var y = d3.scale.linear()
                .range([height, 0]);

        var xAxis = d3.svg.axis()
                .scale(x)
                .orient("bottom");

        var yAxis = d3.svg.axis()
                .scale(y)
                .orient("left");

        var area = d3.svg.area()
                .x(function (d) {
                    return x(d.date);
                })
                .y0(height)
                .y1(function (d) {
                    return y(d.taskSum);
                });

        var svg = d3.select("#chart").append("svg")
                .attr("width", width + margin.left + margin.right)
                .attr("height", height + margin.top + margin.bottom)
                .append("g")
                .attr("transform", "translate(" + margin.left + "," + margin.top + ")");


        data.forEach(function (d) {
            d.date = parseDate(d.date);
            d.taskSum = +d.taskSum;
        });

        x.domain(d3.extent(data, function (d) {
            return d.date;
        }));
        y.domain([0, d3.max(data, function (d) {
            return d.taskSum;
        })]);

        svg.append("path")
                .datum(data)
                .attr("class", "area")
                .attr("d", area);

        svg.append("g")
                .attr("class", "x axis")
                .attr("transform", "translate(0," + height + ")")
                .call(xAxis);

        svg.append("g")
                .attr("class", "y axis")
                .call(yAxis)
                .append("text")
                .attr("transform", "rotate(-90)")
                .attr("y", 6)
                .attr("dy", ".71em")
                .style("text-anchor", "end")
                .text("Заданий выполнено");

    }
</script>


</body>
</html>