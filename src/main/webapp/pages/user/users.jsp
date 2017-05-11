<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <a href="<c:url value="/users/add" />" type="button" class="btn btn-default">Add user</a>
                <div>
            </div>
            <div class="row">
                <div class="col-md-12 ">
                    <ul class="list-group">
                        <c:forEach items="${all_users}" var="user">
                            <li class="list-group-item">
                                <div class="row">
                                    <div class="col-md-8">
                                        ${user.name} with total seats: ${user.email}
                                    </div>
                                    <div class="col-md-4">
                                        <form class="form-inline" action="<c:url value="/users/${user.id}/delete" />" method="post">
                                            <a class="btn btn-default" href="<c:url value="/users/${user.id}" />" role="button">Show</a>
                                            <button type="submit" class="btn btn-default">Delete</button>
                                        </form>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>
