<%--
  Created by IntelliJ IDEA.
  User: Kris
  Date: 17.10.2020
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%--  http://serwer.com/kontekst/minionki  --%>
<%--        =->   multiplication.jsp ->  http://serwer.com/kontekst/minionki/multiplication.jsp --%>
<%--        =->   /multiplication.jsp ->  http://serwer.com/kontekst/multiplication.jsp --%>
<%--        =->   / ->  http://serwer.com/ --%>
<%--        =->   / ->  http://serwer.com/kontekst/ --%>
<ul>
    <li>
        <a href="${pageContext.request.contextPath}/">Home</a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/cars">Car list</a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/car/form">Car adding form</a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/mechanics">Mechanic list</a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/mechanic/form">Mechanic adding form</a>
    </li>
</ul>