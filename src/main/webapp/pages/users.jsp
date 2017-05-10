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
                <a href="/users/add" type="button" class="btn btn-default">Add user</a>
            </div>
            <div class="row">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">

                            <ul class="list-group">
                                <c:forEach items="${all_users}" var="users">
                                    <li class="list-group-item">${users.name} with total seats: ${users.email}</li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
