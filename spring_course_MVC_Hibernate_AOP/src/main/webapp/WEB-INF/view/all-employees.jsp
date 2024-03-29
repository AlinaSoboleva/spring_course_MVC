<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
</head>

<body>
<% request.setCharacterEncoding("UTF-8");%>
<h2>All Employees</h2>
<br><br>
<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operations</th>
    </tr>

    <c:forEach var="emp" items="${allEmps}">
<%--        сохранение информации об id в кнопке--%>
        <c:url var="updateButton" value="/updateInfo">
            <c:param name="empId" value="${emp.id}"></c:param>
        </c:url>

        <c:url var="deleteButton" value="/deleteEmployee">
            <c:param name="empId" value="${emp.id}"></c:param>
        </c:url>
        <tr>
            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
            <td><input type="button" value="UPDATE"
                       onclick="window.location.href='${updateButton}'">
                <input type="button" value="DELETE"
                       onclick="window.location.href='${deleteButton}'"></td>
        </tr>

    </c:forEach>
</table>
<br>
<input type="button" value="Add"
       onclick="window.location.href='addNewEmployee'">

</body>

</html>
