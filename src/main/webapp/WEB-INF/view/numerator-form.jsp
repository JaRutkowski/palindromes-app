 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
    <h3>Save Customer</h3>
    <form:form action="saveNumerator" modelAttribute="numerator" method="POST">
        <form:hidden path="id" />
        <table>
            <tbody>
            <tr>
                <td><label>Value:</label></td>
                <td><form:input path="value"/></td>
            </tr>
            <tr>
                <td><label>Submit</label></td>
                <td><input type="submit" value="Save" class="save"/></td>
            </tr>
            </tbody>
        </table>
    </form:form>

    <div style="clear: both;"></div>
    <p>
        <a href="${pageContext.request.contextPath}/numerator/list">Back to list</a>
    </p>
</div>
</body>
</html>