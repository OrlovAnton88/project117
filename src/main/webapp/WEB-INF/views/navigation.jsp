<%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 18.10.14
  Time: 2:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--Example http://getbootstrap.com/examples/navbar-fixed-top/--%>
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<spring:url value="/"/>">&#60;HTML race&#47;&#62;</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="<spring:url value="/"/>">Главная</a></li>
                <li><a href="<spring:url value="/study_materials"/>">Учебные материалы</a></li>
                <li><a href="#">Расписание</a></li>
                <%--<li class="dropdown">--%>
                <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <span class="caret"></span></a>--%>
                <%--<ul class="dropdown-menu" role="menu">--%>
                <%--<li><a href="#">Action</a></li>--%>
                <%--<li><a href="#">Another action</a></li>--%>
                <%--<li><a href="#">Something else here</a></li>--%>
                <%--<li class="divider"></li>--%>
                <%--<li class="dropdown-header">Nav header</li>--%>
                <%--<li><a href="#">Separated link</a></li>--%>
                <%--<li><a href="#">One more separated link</a></li>--%>
                <%--</ul>--%>
                <%--</li>--%>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <sec:authorize access="isAuthenticated()">
                    <li> <a href="<spring:url value="/user_details"/>">
                        <sec:authentication property="principal.firstName"/>
                        <sec:authentication property="principal.lastName"/>
                        </a>
                    </li>
                    <li><a href="<spring:url value="/logout"/>">Выход</a></li>
                </sec:authorize>
                <%--<li><a href="#">Контакты</a></li>--%>
                <sec:authorize access="isAnonymous()">
                    <li><a href="<spring:url value="/login"/>">Вход</a></li>
                </sec:authorize>
                <li class="active"><a href="http://vk.com/osnovarabotavinternete" target="_blank">VK</a></li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</div>
