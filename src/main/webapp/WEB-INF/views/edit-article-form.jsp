<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Article</title>
</head>
<body>
<form:form method="post" action="/article/savechanges" modelAttribute="article">
    <h3>Edit the fields to make changes in the category of id= ${articleToEdit.id}:</h3>
    <form:input path="id" type="hidden" value="${articleToEdit.id}"/>
    <div>
        <label for="name">Title:</label>
        <form:input path="title" value="${articleToEdit.title}"/>
    </div>

    <div>
    <label for="author">Author: </label>
        <form:select path="author" items="${authorsList}" var="a" id="author" itemValue="id"/>
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
        <label for="content">Description:</label>
        <form:input path="content" rows="20" cols="100" value="${articleToEdit.content}"/><br/>
    </div>

    <input type="submit" value="Save Changes">
</form:form>

</body>
</html>
