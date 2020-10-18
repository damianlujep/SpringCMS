<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories list</title>
    <style>
        a.button {
            -webkit-appearance: button;
            -moz-appearance: button;
            -appearance: button;

            text-decoration: none;
            color: initial;
            width: auto;
        }

        table, th, td {
            border-collapse: collapse;
            border: 1px solid black;
            width: auto;
            height: 35px;
            table-layout: fixed;
        }

    </style>
</head>
<body>
<table>
    <tr>
        <th>Lp.</th>
        <th>Title</th>
        <th>Author</th>
        <th>Categories</th>
        <th>Contend</th>
        <th>Creation Date</th>
        <th>&emsp;&emsp;&emsp;&emsp;</th>
        <th>&emsp;&emsp;&emsp;&emsp;&emsp;</th>
    </tr>

    <c:forEach items="${articleList}" var="article" varStatus="stat">
        <tr>
            <td style="text-align: center">${stat.count}</td>
            <td style="text-align: center">${article.title}</td>
            <td style="text-align: center">${article.author.firstName} ${article.author.lastName}</td>
            <td style="text-align: center">

            <c:forEach items="${article.categories}" var="category">
                ${category.name}<br/>


            </c:forEach>
            </td>
            <td style="text-align: center">${article.content}</td>
            <td style="text-align: center">${article.created.format(formatter)}</td>
            <td style="text-align: center"><a href="/article/edit/${article.id}" class="button"> Edit </a></td>
            <td style="text-align: center"><a href="/article/delete/${article.id}" class="button">Delete</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
