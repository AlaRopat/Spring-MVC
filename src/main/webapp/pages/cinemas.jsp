<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="container">
            <div class="row">
                <div class="col-md-12">

                    <ul class="list-group">
                        <c:forEach items="${all_cinemas}" var="cinema">
                            <li class="list-group-item">${cinema.name} with total seats: ${cinema.numberOfSeats}</li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>
