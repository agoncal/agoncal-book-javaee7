<%@ page import="org.agoncal.book.javaee6.chapter11.Book" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%!
    List<Book> books = new ArrayList<Book>();
%>
<html>
<head>
    <title>List all the books</title>
</head>
<body>
<h1>Lists all the books</h1>
<hr/>
<%
    books.add(new Book("H2G2", 12f, "Scifi IT book", "1234-234", 241, true));
    books.add(new Book("Robots", 18.5f, "Best seller", "564-694", 317, true));
    books.add(new Book("Dune", 23.25f, "The trilogy", "256-6-56", 529, true));
%>
<table border="1">
    <tr>
        <td>ISBN</td>
        <td>Title</td>
        <td>Price</td>
        <td>Description</td>
        <td>Number of pages</td>
        <td>Illustrations</td>
    </tr>
    <%
        for (Book book : books) {

    %>
    <tr>
        <td>${book.isbn}</td>
        <td>${book.title}</td>
        <td>${book.price}</td>
        <td>${book.description}</td>
        <td>${book.nbOfPage}</td>
        <td>${book.illustrations}</td>
    </tr>
    <%
        }
    %>

</table>
<hr/>
<em>APress - Beginning Java EE 7</em>
</body>
</html>