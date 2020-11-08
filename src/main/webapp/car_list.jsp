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
            <th>Id</th>
            <th>Car name</th>
            <th>Registration number</th>
            <th>Engine type</th>
            <th>Engine capacity</th>
            <th>Mileage</th>
            <th>VIN number</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${requestScope.cars}" var="car">
            <tr>
                <td>
                    ${car.id}
                </td>
                <td>
                    ${car.name}
                </td>
                <td>
                    ${car.registrationNumber}
                </td>
                <td>
                    ${car.engineType.commonName}
                </td>
                <td>
                    ${car.engineCapacity}
                </td>
                <td>
                    ${car.mileage}
                </td>
                <td>
                    ${car.vinNumber}
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/car/details?id=${car.id}">Details</a>
                    <a>Edit</a>
                    <a>Remove</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<jsp:include page="footers.jsp"/>
</body>
</html>

