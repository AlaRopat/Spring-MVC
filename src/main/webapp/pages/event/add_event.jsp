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
                <h2>New Move</h2>
                <form action="<c:url value="/events/add" />" method="post">
                    <div class="form-group">
                        <label for="eventName">Name</label>
                        <input type="text" class="form-control" id="eventName" placeholder="Move Name" name="name">
                    </div>
                    <div class="form-group">
                        <label for="basePrice">Base Price</label>
                        <input type="text" class="form-control" id="basePrice" placeholder="Base Price" name="basePrice">
                    </div>
                    <div class="form-group">
                        <label for="ratings">Email</label>
                        <select class="form-control" id="ratings" name="rating">
                            <c:forEach items="${ratings}" var="rating">
                                <option>${rating}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <input class="btn btn-default" type="submit" value="Submit">
                </form>
            </div>
        </div>
    </body>
</html>
