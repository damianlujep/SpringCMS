<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add Category Form</title>
</head>
<body>

<form:form method="post" modelAttribute="category">
    <label for="name">Category name: </label>
    <form:input path="name"/><br/>
    <label for="description">Description: </label>
    <form:input path="description" /><br/>
    <input type="submit" value="Save" />
</form:form>

</body>
</html>
