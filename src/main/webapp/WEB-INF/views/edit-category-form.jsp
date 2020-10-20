<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Category</title>
</head>
<body>
<form:form method="post" action="/category/savechanges" modelAttribute="category">
    <h3>Edit the fields to make changes in the category of id= ${categoryToEdit.id}:</h3>
    <form:input path="id" type="hidden" value="${categoryToEdit.id}"/>
    <label for="name">Name:</label>
    <form:input path="name" value="${categoryToEdit.name}"/><br/>
    <label for="description">Description:</label>
    <form:input path="description" value="${categoryToEdit.description}"/><br/>
    <input type="submit" value="Save Changes">
</form:form>

</body>
</html>
