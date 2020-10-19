<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Category</title>
</head>
<body>
<form:form method="post" action="/article/savechanges" modelAttribute="article">
    <h3>Edit the fields to make changes in the category of id= ${articleToEdit.id}:</h3>
    <form:input path="id" type="hidden" value="${articleToEdit.id}"/>
    <label for="name">Title:</label>
    <form:input path="title" value="${articleToEdit.title}"/><br/>
    <label for="content">Description:</label>

    <form:textarea path="content" rows="20" cols="100" value="${articleToEdit.content}"/><br/>

    <c:out value="${articleToEdit.content}"/>
    <input type="submit" value="Save Changes">
</form:form>

</body>
</html>
