<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Formatting data</title>
</head>
<body>
<h1>Formatting data</h1>
<hr/>
Dates<br/>
<c:set var="now" value="<%=new java.util.Date()%>"/>
<fmt:formatDate type="time" value="${now}"/><br/>
<fmt:formatDate type="date" value="${now}"/><br/>
<fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${now}"/><br/>
<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${now}"/><br/>

Currency<br/>
<fmt:setLocale value="en_us"/>
<fmt:formatNumber value="20.50" type="currency"/><br/>
<fmt:setLocale value="en_gb"/>
<fmt:formatNumber value="20.50" type="currency"/><br/>

</body>
<hr/>
<em>APress - Beginning Java EE 7</em>
</html>

