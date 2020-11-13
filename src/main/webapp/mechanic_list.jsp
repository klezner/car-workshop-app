<%--
  Created by IntelliJ IDEA.
  User: Kris
  Date: 08.11.2020
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Mechanic list</title>
    <jsp:include page="headers.jsp"/>
</head>
<body>
    <div class="container">
        <jsp:include page="navigator.jsp"/>
        <table>
            <tr>
                <th>First name</th>
                <th>Last name</th>
                <th>Employment level</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${requestScope.mechanics}" var="mechanic">
                <tr>
                    <td>
                            ${mechanic.firstName}
                    </td>
                    <td>
                            ${mechanic.lastName}
                    </td>
                    <td>
                            ${mechanic.employmentLevel.commonName}
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/mechanic/details?id=${mechanic.id}">Details</a>
                        <a href="${pageContext.request.contextPath}/mechanic/edit?id=${mechanic.id}">Edit</a>
                        <a href="${pageContext.request.contextPath}/mechanic/remove?id=${mechanic.id}">Remove</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <jsp:include page="footers.jsp"/>
</body>
</html>
