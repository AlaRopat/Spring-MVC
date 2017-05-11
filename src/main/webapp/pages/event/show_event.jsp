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
                <a href="<c:url value="/events" />" type="button" class="btn btn-default">Back</a>
            </div>
            <div class="row">
                <h2>Hello User, ${event.name}</h2>
                <form>
                    <div class="form-group">
                        <label for="eventName">Name</label>
                        <input type="text" class="form-control" id="eventName" placeholder="Move Name" value="${event.name}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="basePrice">Base Price</label>
                        <input type="text" class="form-control" id="basePrice" placeholder="Base Price" value="${event.basePrice}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="rating">Rating</label>
                        <input class="form-control" id="rating" placeholder="Rating" name="rating" value="${event.rating}" readonly>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
