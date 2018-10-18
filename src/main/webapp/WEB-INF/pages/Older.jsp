<%@ page import="net.proselyte.bookmanager.model.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.Session" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Books Page</title>

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
<a href="../../index.jsp">Back to main menu</a>
<a href="authors.jsp">Back to main menu</a>
<br/>
<br/>

<h1>Book List</h1>

<c:if test="${!empty }">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">name</th>
            <th width="120">published</th>
            <th width="120">genre</th>
            <th width="120">rating</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listBooks}" var="book">
            <tr>
                <td>${book.id}</td>
                <td><a href="/bookdata/${book.id}" target="_blank">${book.name}</a></td>
                <td>${book.published}</td>
                <td>${book.genre}</td>
                <td>${book.rating}</td>
                <td><a href="<c:url value='/edit/${book.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${book.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Book</h1>

<c:url var="addAction" value="/books/add"/>


<form:form action="${addAction}" commandName="book">
    <table>
        <c:if test="${!empty book.id}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="published">
                    <spring:message text="Published"/>
                </form:label>
            </td>
            <td>
                <form:input path="published"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="genre">
                    <spring:message text="Genre"/>
                </form:label>
            </td>
            <td>
                <form:input path="genre"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="rating">
                    <spring:message text="Rating"/>
                </form:label>
            </td>
            <td>
                <form:input path="rating"/>
            </td>
        </tr>



        <tr>
            <td colspan="2">
                <c:if test="${!empty book.rating}">
                    <input type="submit"
                           value="<spring:message text="Edit Book"/>"/>
                </c:if>
                <c:if test="${empty book.rating}">
                    <input type="submit"
                           value="<spring:message text="Add Book"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>



<c:forEach var="user" items="${listBooks}">
    <c:out value="${user.id}"/>
    <c:out value="${user.name}"/>
    <c:out value="${user.genre}"/>
    <c:out value="${user.rating}"/>
    <c:out value="${user.published}"/>
</c:forEach>


<h1>Old</h1>

<%--<c:if test="${!empty }">--%>
<%--<table class="tg">--%>
<%--<tr>--%>
<%--<th width="80">ID</th>--%>
<%--<th width="120">Title</th>--%>
<%--<th width="120">Author</th>--%>
<%--<th width="120">Price</th>--%>
<%--<th width="120">born</th>--%>
<%--<th width="60">Edit</th>--%>
<%--<th width="60">Delete</th>--%>
<%--</tr>--%>
<%--<c:forEach items="${listBooks}" var="book1">--%>
<%--<tr>--%>
<%--<td>${book1.id}</td>--%>
<%--<td><a href="/bookdata/${book1.id}" target="_blank">${book1.bookTitle}</a></td>--%>
<%--<td>${book1.bookAuthor}</td>--%>
<%--<td>${book1.price}</td>--%>
<%--<td>${book1.born}</td>--%>
<%--<td><a href="<c:url value='/edit/${book1.id}'/>">Edit</a></td>--%>
<%--<td><a href="<c:url value='/remove/${book1.id}'/>">Delete</a></td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--</table>--%>
<%--</c:if>--%>




</body>
</html>
