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
        <th>ISBN</th>
        <th>Title</th>
        <th>Price</th>
        <th>Description</th>
        <th>Number of pages</th>
        <th>Illustrations</th>
    </tr>
    <%
        for (Book book : books) {
    %>
    <tr>
        <td><%= book.getIsbn()%>
        </td>
        <td><%= book.getTitle()%>
        </td>
        <td><%= book.getPrice()%>
        </td>
        <td><%= book.getDescription()%>
        </td>
        <td><%= book.getNbOfPage()%>
        </td>
        <td><%= book.getIllustrations()%>
        </td>
    </tr>
    <%
        }
    %>

</table>
<hr/>
<em>APress - Beginning Java EE 7</em>
</body>
</html>