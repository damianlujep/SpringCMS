<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add Category Form</title>
</head>
<body>

<form:form method="post" modelAttribute="article">
    <div>
        <label for="title">Title: </label>
        <form:input path="title"/><br/>
    </div>

    <div>
        <label for="author">Author: </label>
        <form:select path="author" items="${authorsList}" var="a" id="author" itemValue="id"/>
<%--        <form:select path="author" >--%>
<%--            <form:option value="-" label="-- Please Select --"/>--%>
<%--            <form:options items="${authorsList}"/>--%>
<%--        </form:select>--%>

    </div>
    <div>
        <label>Categories: </label>
        <c:forEach items="${categoriesList}" var="category">
            <div>
                &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                <form:checkbox path="categories" label="${category.name}" value="${category.id}"/>
            </div>
        </c:forEach>


    </div>
    <div>
        <label for="content">Content: </label>
        <div>
            <form:textarea path="content" rows="10" cols="100"/>

        </div>
    </div>

    <input type="submit" value="Save"/>
</form:form>

</body>
</html>
