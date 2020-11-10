<%--
  Created by IntelliJ IDEA.
  User: Kris
  Date: 10.11.2020
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Order Form</title>
    <jsp:include page="headers.jsp"/>
</head>
<body>
    <div class="container">
        <jsp:include page="navigator.jsp"/>
        <form action="${pageContext.request.contextPath}/order/form" method="post">
            <input type="hidden" value="${requestScope.carId}" readonly name="carId"/>
            <div>
                <label>Order contens:</label>
                <input type="text" name="order_contents"/>
            </div>
            <div>
                <label>Order closed:</label>
                <input type="checkbox" name="order_closed"/>
                <span/>
            </div>
            <button type="reset">Reset</button>
            <button type="submit">Submit</button>
        </form>
    </div>
    <jsp:include page="footers.jsp"/>
</body>
</html>
