<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add Category Form</title>
</head>
<body>

<form:form method="post" modelAttribute="category">
    <div>
        <label for="name">Category name: </label>
        <form:input path="name"/>
        <form:errors path="name" cssStyle="color: red"/>
    </div>

    <div>
        <label for="description">Description: </label>
        <form:input path="description" />
        <form:errors path="description" cssStyle="color: red"/>
    </div>

    <input type="submit" value="Save" />

</form:form>

</body>
</html>
