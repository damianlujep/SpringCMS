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
        <th>Name</th>
        <th>Description</th>
        <th>&emsp;&emsp;&emsp;&emsp;</th>
        <th>&emsp;&emsp;&emsp;&emsp;&emsp;</th>
    </tr>

    <c:forEach items="${categoriesList}" var="category" varStatus="stat">
        <tr>
            <td style="text-align: center">${stat.count}</td>
            <td style="text-align: center">${category.name}</td>
            <td style="text-align: center">${category.description}</td>
            <td style="text-align: center"><a href="/category/edit/${category.id}" class="button"> Edit </a></td>
            <td style="text-align: center"><a href="/category/delete/${category.id}" class="button">Delete</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
