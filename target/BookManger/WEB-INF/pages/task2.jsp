<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>
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


<h1>Author who have more than 1 book</h1>

<%
    int  data=0;
    String genre = "";

    Connection conn= null;

    Statement st;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/sombra","root","Jackson75063");


        String query = "select book_author.author_id  from book_author  group by book_author.author_id   having COUNT(book_author.author_id) > 1";

        st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while(rs.next())
        {
            data = rs.getInt("book_author.author_id");

            out.println( "Author id: "+data +"<br/>" );
        }
    }
    catch (Exception e) {
        e.printStackTrace();
    }
%>






<%--

<c:if test="${!empty task2}">
    <table class="tg">
        <tr>
            <th width="80">author_id</th>
            <th width="80">author_id</th>
            <th width="80">author_id</th>
        </tr>

        <c:forEach items="${task2}" var="author">
            <tr>
                <td>${author.author_id}</td>
                <td>${author.id}</td>
                <td>${author.book_id}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

--%>



</body>
</html>
