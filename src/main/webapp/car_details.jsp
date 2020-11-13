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
        <h1>${requestScope.carToDisplay.name} / ${requestScope.carToDisplay.registrationNumber}</h1>
        <div>
            <input type="hidden" value="${requestScope.carToDisplay.id}" readonly name="carId">
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
                            <a href="${pageContext.request.contextPath}/car/edit?id=${requestScope.carToDisplay.id}">Edit</a><br/>
                            <a href="${pageContext.request.contextPath}/car/remove?id=${requestScope.carToDisplay.id}">Remove</a>
                        </td>
                    </tr>
                    <tr>
                        <th>Add order for car</th>
                        <td>
                            <a href="${pageContext.request.contextPath}/order/form?carId=${requestScope.carToDisplay.id}">Add order</a>
                        </td>
                    </tr>
                </table>
            </div>
            <div>
                <h1>Orders:</h1>
                <table>
                    <tr>
                        <th>Order contents</th>
                        <th>Creation date</th>
                        <th>Order closed</th>
                        <th>Closing date</th>
                        <th>Mechanic</th>
                        <th>Actions</th>
                        <th>Add mechanic for order</th>
                    </tr>
                    <c:forEach items="${requestScope.carToDisplay.repairOrderSet}" var="repairOrder">
                        <tr>
                            <td>${repairOrder.orderContents}</td>
                            <td>${repairOrder.creationDate}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${repairOrder.orderClosed==true}">Yes</c:when>
                                    <c:otherwise>No</c:otherwise>
                                </c:choose>
                            </td>
                            <td>${repairOrder.closingDate}</td>
                            <td>
                                <c:forEach items="${repairOrder.mechanicSet}" var="mechanic">
                                    ${mechanic.firstName} ${mechanic.lastName}<br/>
                                </c:forEach>
                            </td>
                            <td>
                                <c:if test="${repairOrder.orderClosed==false}">
                                    <a href="${pageContext.request.contextPath}/order/edit?id=${repairOrder.id}">Edit/Close</a>
                                </c:if><br/>
                                <a href="${pageContext.request.contextPath}/order/remove?id=${repairOrder.id}">Remove</a>
                            </td>
                            <td>
                                <c:if test="${repairOrder.orderClosed==false}">
                                    <a href="${pageContext.request.contextPath}/order/mechanic/edit?id=${repairOrder.id}">Add mechanic</a><br/>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
    <jsp:include page="footers.jsp"/>
</body>
</html>
