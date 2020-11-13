<%--
  Created by IntelliJ IDEA.
  User: Kris
  Date: 13.11.2020
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Order list</title>
    <jsp:include page="headers.jsp"/>
</head>
<body>
    <div class="container">
        <jsp:include page="navigator.jsp"/>
        <table>
            <tr>
                <th>Order contents</th>
                <th>Car</th>
                <th>Car registration number</th>
                <th>Creation date</th>
                <th>Order closed</th>
                <th>Closing date</th>
                <th>Mechanic</th>
                <th>Actions</th>
                <th>Add mechanic for order</th>
            </tr>
            <c:forEach items="${requestScope.orders}" var="order">
            <tr>
                <td>
                    ${order.orderContents}
                </td>
                <td>
                    ${order.car.name}
                </td>
                <td>
                    ${order.car.registrationNumber}
                </td>
                <td>
                    ${order.creationDate}
                </td>
                <td>
                    <c:choose>
                        <c:when test="${order.orderClosed==true}">Yes</c:when>
                        <c:otherwise>No</c:otherwise>
                    </c:choose>
                </td>
                <td>
                    ${order.closingDate}
                </td>
                <td>
                    <c:forEach items="${order.mechanicSet}" var="mechanic">
                        ${mechanic.firstName} ${mechanic.lastName}<br/>
                    </c:forEach>
                </td>
                <td>
                    <c:if test="${order.orderClosed==false}">
                        <a href="${pageContext.request.contextPath}/order/edit?id=${order.id}">Edit/Close</a>
                    </c:if><br/>
                    <a href="${pageContext.request.contextPath}/order/remove?id=${order.id}">Remove</a>
                </td>
                <td>
                    <c:if test="${order.orderClosed==false}">
                        <a href="${pageContext.request.contextPath}/order/mechanic/edit?id=${order.id}">Add mechanic</a><br/>
                    </c:if>
                </td>
            </tr>
            </c:forEach>
    </div>
    <jsp:include page="footers.jsp"/>
</body>
</html>

