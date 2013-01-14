<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Checking numbers</title>
</head>
<body>
<h1>Checking numbers</h1>
<hr/>
<c:set var="upperLimit" value="20"/>
<c:forEach var="i" begin="3" end="${upperLimit - 5}">

    <c:choose>
        <c:when test="${i%2 == 0}">
            <c:out value="${i} is even"/><br/>
        </c:when>
        <c:otherwise>
            <c:out value="${i} is odd"/><br/>
        </c:otherwise>
    </c:choose>

</c:forEach>
</body>
<hr/>
<em>APress - Beginning Java EE 7</em>
</html>

