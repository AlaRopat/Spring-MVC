<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="container">
            <div class="row">
                <a href="/users" type="button" class="btn btn-default">Back</a>
            </div>
            <div class="row">
                <h2>New User</h2>
                <form class="navbar-form navbar-left" action="/users/add" method="post">
                    <div class="form-group">
                        <input type="text" class="form-control">
                        <input type="text" class="form-control">
                        <input type="text" class="form-control">
                    </div>
                    <button class="btn btn-default">Submit</button>
                </form>
            </div>
        </div>
    </body>
</html>
