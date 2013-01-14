<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
<head>
    <title>Lists all the books</title>
</head>
<body>
<h1>Lists all the books</h1>
<hr/>

<%--<sql:setDataSource dataSource="jdbc/__default"/>--%>
<sql:setDataSource url="jdbc:derby://localhost:1527/chapter11DB" driver="org.apache.derby.jdbc.ClientDriver" user="APP"
                   password="APP"/>
<sql:query var="books">
    select * from book
</sql:query>

<table border="1">
    <tr>
        <th>ISBN</th>
        <th>Title</th>
        <th>Price</th>
        <th>Description</th>
        <th>Number of pages</th>
        <th>Illustrations</th>
    </tr>
    <c:forEach var="row" items="${books.rows}">
        <tr>
            <td><c:out value="${row.isbn}"/></td>
            <td><c:out value="${row.title}"/></td>
            <td><c:out value="${row.price}"/></td>
            <td><c:out value="${row.description}"/></td>
            <td><c:out value="${row.nbOfPage}"/></td>
            <td><c:out value="${row.illustrations}"/></td>
        </tr>
    </c:forEach>
</table>
<hr/>
<em>APress - Beginning Java EE 7</em>
</body>
</html>

