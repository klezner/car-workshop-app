<%--
  Created by IntelliJ IDEA.
  User: Kris
  Date: 12.11.2020
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Order Mechanic Form</title>
    <jsp:include page="headers.jsp"/>
</head>
<body>
<div class="container">
    <jsp:include page="navigator.jsp"/>
    <form action="${pageContext.request.contextPath}/order/mechanic/form" method="post">
        <h1>Repair order details</h1>
        <div>
            <input type="hidden" value="${requestScope.repairOrderToDisplay.id}" readonly name="repairOrderId"/>
            <input type="hidden" value="${requestScope.repairOrderToDisplay.car.id}" readonly name="carId"/>
            <div>
                <table>
                    <tr>
                        <th>Order contents</th>
                        <td>${requestScope.repairOrderToDisplay.orderContents}</td>
                    </tr>
                    <tr>
                        <th>Car name</th>
                        <td>${requestScope.repairOrderToDisplay.car.name}</td>
                    </tr>
                    <tr>
                        <th>Car registration number</th>
                        <td>${requestScope.repairOrderToDisplay.car.registrationNumber}</td>
                    </tr>
                    <tr>
                        <th>Creation date</th>
                        <td>${requestScope.repairOrderToDisplay.creationDate}</td>
                    </tr>
                    <tr>
                        <th>Order closed</th>
                        <td>${requestScope.repairOrderToDisplay.orderClosed}</td>
                    </tr>
                    <tr>
                        <th>Closing date</th>
                        <th>${requestScope.repairOrderToDisplay.closingDate}</th>
                    </tr>
                    <tr>
                        <th>Mechanics</th>
                        <td>
                            <c:forEach items="${requestScope.repairOrderToDisplay.mechanicSet}" var="mechanic">
                                ${mechanic.firstName} ${mechanic.lastName}<br/>
                            </c:forEach>
                        </td>
                    </tr>
                </table>
            </div>
            <div>
                <label>Select mechanic to add for order:</label>
                <select name="mechanicId">
                    <c:forEach items="${requestScope.availableMechanics}" var="mechanic">
                        <option value="${mechanic.id}">
                            ${mechanic.firstName} ${mechanic.lastName}
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <button type="reset">Reset</button>
        <button type="submit">Submit</button>
    </form>
</div>
<jsp:include page="footers.jsp"/>
</body>
</html>
