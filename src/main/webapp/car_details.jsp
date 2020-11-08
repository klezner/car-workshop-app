<%--
  Created by IntelliJ IDEA.
  User: Kris
  Date: 08.11.2020
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Car Details</title>
    <jsp:include page="headers.jsp"/>
</head>
<body>
    <div class="container">
        <jsp:include page="navigator.jsp"/>
        <h1>Car: ${requestScope.carToDisplay.name} / ${requestScope.carToDisplay.registrationNumber}</h1>
        <div>
            <div>
                <table>
                    <tr>
                        <th>Car name</th>
                        <td>${requestScope.carToDisplay.name}</td>
                    </tr>
                    <tr>
                        <th>Registration number</th>
                        <td>${requestScope.carToDisplay.registrationNumber}</td>
                    </tr>
                    <tr>
                        <th>Engine type</th>
                        <td>${requestScope.carToDisplay.engineType.commonName}</td>
                    </tr>
                    <tr>
                        <th>Engine capacity</th>
                        <td>${requestScope.carToDisplay.engineCapacity}</td>
                    </tr>
                    <tr>
                        <th>Mileage</th>
                        <td>${requestScope.carToDisplay.mileage}</td>
                    </tr>
                    <tr>
                        <th>VIN number</th>
                        <td>${requestScope.carToDisplay.vinNumber}</td>
                    </tr>
                    <tr>
                        <th>Actions</th>
                        <td>
                            <a href="${pageContext.request.contextPath}/car/edit?id=${carToDisplay.id}">Edit</a><br/>
                            <a>Remove</a>
                        </td>
                    </tr>
                </table>
            </div>
            <a href="${pageContext.request.contextPath}/cars">Back to cars list</a>
        </div>
    </div>
</body>
</html>
