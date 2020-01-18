<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>List Numbers</title>
    <%--reference to css--%>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>NRM - Number Relationship Manager</h2>
    </div>
</div>

<div id="container">
    <div id="content">

        <form:form action="check" method="GET">
            Enter numerator: <input type="text" name="checkNumerator"/>
            <input type="submit" value="Check" class="add-button"/>
            <c:url var="checkLink" value="/numerator/check"/>
            ${nr}
        </form:form>

        <form:form action="generate" method="GET">
            Interval: from <input type="text" name="startingPoint"/> to <input type="text" name="endingPoint"/>
            <input type="submit" value="Generate" class="add-button"/>
        </form:form>


        <input type="button" value="Add Numerator" onclick="window.location.href='showFormForAdd'; return false;"
               class="add-button"/>
        <form:form action="search" method="GET">
            Search numerator: <input type="text" name="searchValue"/>
            <input type="submit" value="Search" class="add-button"/>
        </form:form>
        <table>
            <tr>
                <th>Value</th>
                <th>Addition date</th>
                <th>isPalindrome</th>
                <th>Action</th>
            </tr>
            <%--loop over and print numbers--%>
            <c:forEach var="tempNumerator" items="${numerators}">
                <%--costruct an "update" link with number id--%>
                <c:url var="updateLink" value="/numerator/showFormForUpdate">
                    <c:param name="numeratorId" value="${tempNumerator.id}"/>
                </c:url>
                <c:url var="deleteLink" value="/numerator/deleteNumerator">
                    <c:param name="numeratorId" value="${tempNumerator.id}"/>
                </c:url>
                <tr>
                    <td>${tempNumerator.value}</td>
                    <td>${tempNumerator.addition_date}</td>
                    <td>${tempNumerator.palindrome}</td>
                    <td><a href="${updateLink}">Update</a> | <a href="${deleteLink}"
                                                                onclick="if(!(confirm('Are you sure you want to delete this numerator?'))) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>