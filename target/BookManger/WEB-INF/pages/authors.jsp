<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Authors Page</title>

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
<br/>
<br/>



<h1>Author List</h1>

<c:if test="${!empty listAuthors}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">name</th>
            <th width="120">gender</th>
            <th width="120">born</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <%--    change list to sratuy--%>
        <c:forEach items="${listAuthors}" var="author">
            <tr>
                <td>${author.id}</td>
                <td>${author.name}</td>
                <td>${author.gender}</td>
                <td>${author.born}</td>

                <td><a href="<c:url value='/edit1/${author.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove1/${author.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Author</h1>

<c:url var="addAction" value="/authors/add"/>


<form:form action="${addAction}" commandName="author">
    <table>
        <c:if test="${!empty author.id}">
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
                <form:label path="gender">
                    <spring:message text="Gender"/>
                </form:label>
            </td>
            <td>
                <form:input path="gender"/>
            </td>
        </tr>



        <tr>
            <td>
                <form:label path="born">
                    <spring:message text="Born"/>
                </form:label>
            </td>
            <td>
                <form:input path="born"/>
            </td>
        </tr>



        <tr>
            <td colspan="2">
                <c:if test="${!empty author.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Author"/>"/>
                </c:if>
                <c:if test="${empty author.name}">
                    <input type="submit"
                           value="<spring:message text="Add Author"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>






</body>
</html>
