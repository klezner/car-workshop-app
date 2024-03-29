<%--
  Created by IntelliJ IDEA.
  User: Kris
  Date: 07.11.2020
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Car list</title>
    <jsp:include page="headers.jsp"/>
</head>
<body>
    <div class="container">
        <jsp:include page="navigator.jsp"/>
        <table>
            <tr>
                <th>Car name</th>
                <th>Registration number</th>
                <th>Actions</th>
                <th>Add order for car</th>
            </tr>
            <c:forEach items="${requestScope.cars}" var="car">
                <tr>
                    <td>
                        ${car.name}
                    </td>
                    <td>
                        ${car.registrationNumber}
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/car/details?id=${car.id}">Details</a>
                        <a href="${pageContext.request.contextPath}/car/edit?id=${car.id}">Edit</a>
                        <a href="${pageContext.request.contextPath}/car/remove?id=${car.id}">Remove</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/order/form?carId=${car.id}">Add order</a>
                    </td>
                </tr>
            </c:forEach>
    </div>
    <jsp:include page="footers.jsp"/>
</body>
</html>

