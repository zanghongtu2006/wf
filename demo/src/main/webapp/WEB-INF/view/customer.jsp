<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="BASE" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Customer Manage</title>
</head>
<body>
    <h1>Customer List</h1>
    <table border=1>
        <tr>
            <th>Name</th>
            <th>Contact</th>
            <th>Telephone</th>
            <th>Email</th>
            <th>Operation</th>
        </tr>
        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td>${customer.name}</td>
                <td>${customer.contact}</td>
                <td>${customer.telephone}</td>
                <td>${customer.email}</td>
                <td>
                    <a href="${BASE}/customer_edit?id=${customer.id}">Edit</a>
                    <a href="${BASE}/customer_delete?id=${customer.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>