<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
</head>

<body>
<% request.setCharacterEncoding("UTF-8");%>
<h2>Employee info</h2>
<br>
<form:form action="saveEmployee" modelAttribute="employee">

<%--    данная форма не отоброжается, позволяет увидеть поле id--%>
    <form:hidden path="id"/>

    Name <form:input path="name"/>
    <br>
    Surname <form:input path="surname"/>
    <br>
    Department <form:input path="department"/>
    <br>
    Salary <form:input path="salary"/>
    <br>
    <input type="submit" value="OK">
    <input type="reset" value="CLEAN">


</form:form>

</body>

</html>
