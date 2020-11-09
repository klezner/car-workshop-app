<%--
  Created by IntelliJ IDEA.
  User: Kris
  Date: 08.11.2020
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Mechanic Form</title>
    <jsp:include page="headers.jsp"/>
</head>
<body>
<div class="container">
    <jsp:include page="navigator.jsp"/>
    <form action="${pageContext.request.contextPath}/mechanic/form" method="post">
        <input type="hidden" value="${requestScope.modifiedMechanic.id}" readonly name="modifiedMechanicId">
        <div>
            <label>First name:</label>
            <input type="text" value="${requestScope.modifiedMechanic.firstName}" name="first_name"/>
        </div>
        <div>
            <label>Last name:</label>
            <input type="text" value="${requestScope.modifiedMechanic.lastName}" name="last_name"/>
        </div>
        <div>
            <label>Date of birth:</label>
            <input type="date" value="${requestScope.modifiedMechanic.birthDate}" name="birth_date">
        </div>
        <div>
            <label>Employment level:</label>
            <select name="employment_level">
                <c:forEach items="${requestScope.availableEmploymentLevels}" var="employmentLevel">
                    <option value="${employmentLevel}"
                        <c:if test="${requestScope.modifiedMechanic.employmentLevel==employmentLevel}">
                            selected
                        </c:if>>
                            ${employmentLevel.commonName}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label>Salary:</label>
            <input type="number" value="${requestScope.modifiedMechanic.salary}" step="1" min="0" max="20000" name="salary"/>
        </div>
        <button type="reset">Reset</button>
        <button type="submit">Submit</button>
    </form>
    <a href="${pageContext.request.contextPath}/index.jsp">Back to main page</a>
</div>
<jsp:include page="footers.jsp"/>
</body>
</html>
