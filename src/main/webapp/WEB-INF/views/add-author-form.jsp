<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add Category Form</title>
</head>
<body>

<form:form method="post" modelAttribute="author">
    <div>
        <label for="firstName">Author's First Name: </label>
        <form:input path="firstName"/>
        <form:errors path="firstName" cssStyle="color: red"/>
    </div>
   <div>
       <label for="lastName">Author's Last Name: </label>
       <form:input path="lastName" />
       <form:errors path="lastName" cssStyle="color: red"/>
   </div>

    <input type="submit" value="Save" />
</form:form>

</body>
</html>
