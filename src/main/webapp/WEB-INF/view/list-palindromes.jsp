<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customers form</title>
    <%--reference to css--%>
    <link type="text/css  " rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css  " rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>NRM - Numerator Relationship Manager</h2>
    </div>
</div>
<div id="container">
    <h3>Generated Palindromes</h3>
    <form:form action="saveNumerator" modelAttribute="generatedNumerators" method="POST">
    <c:forEach var="tempNumerator" items="${generatedNumerators}">
        <tr>
            <td>${tempNumerator.value}</td>
        </tr>
    </c:forEach>

    <div style="clear: both;"></div>
    <p>
        <a href="${pageContext.request.contextPath}/numerator/list">Back to list</a>
    </p>
    </form:form>
</div>
</body>
</html>