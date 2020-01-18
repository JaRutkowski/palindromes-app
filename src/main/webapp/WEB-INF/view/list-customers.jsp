<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>List Customers</title>
    <%--reference to css--%>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>
<div id="container">
    <div id="content">
        <%--put new button: Add Customer--%>
        <input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;"
               class="add-button"/>
        <form:form action="search" method="GET">
            Search customer: <input type="text" name="searchName"/>
            <input type="submit" value="Search" class="add-button"/>
        </form:form>
        <%--add out html table here--%>
        <table>
            <tr>
                <th>Value</th>
                <th>Addition date</th>
                <th>isPalindrome</th>
                <th>Action</th>
            </tr>
            <%--loop over and print customers--%>
            <c:forEach var="tempNumerator" items="${numerators}">
                <%--costruct an "update" link with customer id--%>
                <%--<c:url var="updateLink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>
                <c:url var="deleteLink" value="/customer/deleteCustomer">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>--%>
                <tr>
                    <td>${tempNumerator.value}</td>
                    <td>${tempNumerator.addition_date}</td>
                    <td>${tempNumerator.palindrome}</td>
                    <td><a href="${updateLink}">Update</a> | <a href="${deleteLink}"
                                                                onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>