<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Author</title>
</head>
<body>
<form:form method="post" action="/author/savechanges" modelAttribute="author">
    <h3>Edit the fields to make changes in the category of id= ${authorToEdit.id}:</h3>
    <form:input path="id" type="hidden" value="${authorToEdit.id}"/>
    <div>
        <label for="firstName">Name:</label>
        <form:input path="firstName" value="${authorToEdit.firstName}"/>
    </div>
    <div>
        <label for="lastName">Description:</label>
        <form:input path="lastName" value="${authorToEdit.lastName}"/>
    </div>

    <input type="submit" value="Save Changes">
</form:form>

</body>
</html>
