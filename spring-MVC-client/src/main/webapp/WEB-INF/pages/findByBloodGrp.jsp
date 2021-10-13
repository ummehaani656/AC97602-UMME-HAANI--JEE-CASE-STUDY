<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table >
<tr>
<th>Donor Id</th>
<th>Donor Name</th>
<th>Gender</th>
<th>Address</th>
<th>Blood Group</th>
<th>Phone Number</th>
<th>Last Blood Donated Date</th>
</tr>
<c:forEach items="${donors}" var="eachItem">
<tr>
<td>${eachItem.id}</td>
<td>${eachItem.donorname}</td>
<td>${eachItem.gender}</td>
<td>${eachItem.address}</td>
<td>${eachItem.bloodGrp}</td>
<td>${eachItem.phoneNumber}</td>
<td>${eachItem.donatedDate}</td>
</tr>
</c:forEach>
</table>
</body>
</html>