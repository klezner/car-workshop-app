<%--
  Created by IntelliJ IDEA.
  User: Kris
  Date: 08.11.2020
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Mechanic Details</title>
    <jsp:include page="headers.jsp"/>
</head>
<body>
    <div class="container">
        <jsp:include page="navigator.jsp"/>
        <h1>${requestScope.mechanicToDisplay.firstName} ${requestScope.mechanicToDisplay.lastName}</h1>
        <div>
            <div>
                <table>
                    <tr>
                        <th>First name</th>
                        <td>${requestScope.mechanicToDisplay.firstName}</td>
                    </tr>
                    <tr>
                        <th>Last name</th>
                        <td>${requestScope.mechanicToDisplay.lastName}</td>
                    </tr>
                    <tr>
                        <th>Date of birth</th>
                        <td>${requestScope.mechanicToDisplay.birthDate}</td>
                    </tr>
                    <tr>
                        <th>Employment level</th>
                        <td>${requestScope.mechanicToDisplay.employmentLevel.commonName}</td>
                    </tr>
                    <tr>
                        <th>Salary</th>
                        <td>${requestScope.mechanicToDisplay.salary}</td>
                    </tr>
                    <tr>
                        <th>Actions</th>
                        <td>
                            <a href="${pageContext.request.contextPath}/mechanic/edit?id=${mechanicToDisplay.id}">Edit</a><br/>
                            <a href="${pageContext.request.contextPath}/mechanic/remove?id=${mechanicToDisplay.id}">Remove</a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <jsp:include page="footers.jsp"/>
</body>
</html>
