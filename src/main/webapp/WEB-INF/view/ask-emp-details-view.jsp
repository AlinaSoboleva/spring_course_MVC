<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>
<h2>Dear Employee, Please enter your details</h2>
<br>
<br>

<form:form action="showDetails" modelAttribute="employee">
    Name <form:input path="name"/>
    <form:errors path="name"/>
    <br><br>
    Surname <from:input path="surname"/>
    <form:errors path="surname"/>
    <br><br>
    Salary <from:input path="salary"/>
    <form:errors path="salary"/>
    <br><br>
    Phone number <from:input path="phoneNumber"/>
    <form:errors path="phoneNumber"/>
    <br><br>
    Email <from:input path="email"/>
    <form:errors path="email"/>
    <br><br>
    Department <form:select path="department">
    <form:options items="${employee.departments}"/>
</form:select>
    <br><br>
    Which car do you want?
    <form:radiobuttons path="carBrand" items="${employee.cars}"/>
    <br><br>
    Foreign Language(s)
    EN <form:checkbox path="languages" value="English"/>
    FR <form:checkbox path="languages" value="French"/>
    DE <form:checkbox path="languages" value="Deutch"/>
    <br><br>
    <input type="submit" value="OK">

</form:form>
</body>

</html>
