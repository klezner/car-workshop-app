<%--
  Created by IntelliJ IDEA.
  User: Kris
  Date: 07.11.2020
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Index page</title>
    <jsp:include page="headers.jsp"/>
</head>
<body>
    <div class="container">
        <jsp:include page="navigator.jsp"/>
        <h1>
            <%
                // JAVA CODE
                String nameParam = request.getParameter("username");
                if(nameParam == null) {
                    out.println("Hello user!");
                } else {
                    out.println("Hello " + nameParam + "!");
                }
            %>
        </h1>
    </div>
    <jsp:include page="footers.jsp"/>
</body>
</html>
