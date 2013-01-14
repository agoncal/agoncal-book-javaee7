<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<html>
<head>
    <title>Lists all the books</title>
</head>
<body>
<h1>Lists all the books</h1>
<hr/>

<table border="1">
    <tr>
        <th>ISBN</th>
        <th>Title</th>
        <th>Price</th>
        <th>Description</th>
        <th>Number of pages</th>
        <th>Illustrations</th>
    </tr>

    <c:import url="books.xml" var="bookUrl"/>
    <x:parse xml="${bookUrl}" var="doc"/>

    <x:forEach var="b" select="$doc/books/book">
        <tr>
            <td><x:out select="$b/@isbn"/></td>
            <td><x:out select="$b/title"/></td>
            <td><x:out select="$b/@price"/></td>
            <td><x:out select="$b/description"/></td>
            <td><x:out select="$b/@nbOfPage"/></td>
            <td><x:out select="$b/@illustrations"/></td>
        </tr>
    </x:forEach>
</table>
<hr/>
<em>APress - Beginning Java EE 7</em>
</body>
</html>

