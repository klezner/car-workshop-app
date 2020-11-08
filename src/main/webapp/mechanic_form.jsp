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
        <div>
            <label>First name:</label>
            <input type="text" name="first_name"/>
        </div>
        <div>
            <label>Last name:</label>
            <input type="text" name="last_name"/>
        </div>
        <div>
            <label>Date of birth:</label>
            <input type="date" name="birth_date">
        </div>
        <div>
            <label>Employment level:</label>
            <select name="employment_level">
                <c:forEach items="${requestScope.availableEmploymentLevels}" var="employmentLevel">
                    <option value="${employmentLevel}">
                            ${employmentLevel.commonName}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label>Salary:</label>
            <input type="number" step="1" min="0" max="20000" name="salary"/>
        </div>
        <button type="reset">Reset</button>
        <button type="submit">Submit</button>
    </form>
</div>
<jsp:include page="footers.jsp"/>
</body>
</html>
