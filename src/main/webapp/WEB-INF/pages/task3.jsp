<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<html>
<head>
    <title>Title</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>





<h1>Author List</h1>

    <c:if test="${!empty task3}">
        <table class="tg">
            <tr>
                <th width="120">id</th>
                <th width="120">name</th>
                <th width="120">gender</th>
                <th width="120">born</th>

            </tr>


            <c:forEach items="${task3}" var="author">
                <tr>

                    <td>${author.id}</td>
                    <td>${author.name}</td>
                    <td>${author.gender}</td>
                    <td>${author.born}</td>

                </tr>
            </c:forEach>
        </table>
    </c:if>

</body>
</html>
