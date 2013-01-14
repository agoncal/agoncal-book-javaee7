<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Use JSTL Functions</title>
</head>
<body>
<h1>Use JSTL Functions</h1>
<hr/>

Should be true : ${ fn:contains("H2G2", "H2") }<br/>
Should be false : ${ fn:contains("H2G2", "h2") }<br/>
Should be true : ${ fn:containsIgnoreCase("H2G2", "h2") }<br/>
Should be false : ${ fn:endsWith("H2G2", "H2") }<br/>
Should be true : ${ fn:endsWith("H2G2", "G2") }<br/>
Should be 2 : ${fn:indexOf("H2G2", "G2")}<br/>
Should be 4 : ${fn:length("H2G2")}<br/>

<c:set var="sentence" value="Hitchhiker's Guide to the Galaxy"/>
<c:out value="${fn:toLowerCase(sentence)}"/>
<c:if test="${fn:length('H2G2') == 4}">
    It is four characters long
</c:if>

<hr/>
<em>APress - Beginning Java EE 7</em>
</body>
</html>

