<%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 12.10.14
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin page</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <a href="<c:url value="/admin/uploadApproofs"/>"> <button type="button" class="btn btn-default" id="uploadApproofs">Load HTMLAcademy tasks</button> </a>
        <a href="<c:url value="/admin/uploadUsers"/>"> <button type="button" class="btn btn-default" id="uploadUsers">upload users</button> </a>
       <a href="<c:url value="/admin/rescan"/>"> <button type="button" class="btn btn-default" id="rescan">Просканировать HTMLAcademy</button> </a>

    </div>
    </div>
</body>
</html>
