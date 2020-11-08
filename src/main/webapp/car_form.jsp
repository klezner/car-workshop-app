<%--
  Created by IntelliJ IDEA.
  User: Kris
  Date: 08.11.2020
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Pet Form</title>
    <jsp:include page="headers.jsp"/>
</head>
<body>
<div class="container">
    <jsp:include page="navigator.jsp"/>
    <form action="${pageContext.request.contextPath}/car/form" method="post">
        <div>
            <label>Name:</label>
            <input type="text" name="name"/>
        </div>
        <div>
            <label>Registration number:</label>
            <input type="text" name="registration_number"/>
        </div>
        <div>
            <label>Engine type:</label>
            <select name="engine_type">
                <c:forEach items="${requestScope.availableEngineTypes}" var="engineType">
                    <option value="${engineType}">
                            ${engineType.commonName}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label>Engine capacity:</label>
            <input type="number" step="0.001" min="0" max="20" name="engine_capacity"/>
        </div>
        <div>
            <label>Mileage:</label>
            <input type="number" step="1" min="0" max="2999999" name="mileage"/>
        </div>
        <div>
            <label>VIN number:<br/>
                <input type="text" minlength="11" maxlength="11" name="vin_number"/>
            </label>
        </div>
        <button type="reset">Reset</button>
        <button type="submit">Submit</button>
    </form>
</div>
<jsp:include page="footers.jsp"/>
</body>
</html>
