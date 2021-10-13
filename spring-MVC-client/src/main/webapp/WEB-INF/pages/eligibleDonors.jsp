<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
<script>  
function eligible(){
var dob = new Date(${eachItem.donatedDate});  
//calculate month difference from current date in time  
var month_diff = Date.now() - dob.getTime();  
  
//convert the calculated difference in date format  
var age_dt = new Date(month_diff);   
  
//extract year from date      
var year = age_dt.getUTCFullYear();  
  
//now calculate the age of the user  
var age = Math.abs(agedt -);  
  
//display the calculated age  
return  
</script>  </script>
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

<%! String i =(new java.util.Date()).toLocaleString(); %>
<c:forEach items="${data}" var="eachItem">
<c:if test=${(eachitem.donatedDate.toLocaleString-i)>180} >
<c:out value=<tr><td>${eachItem.id}</td>
<td>${eachItem.donorname}</td>
<td>${eachItem.gender}</td>
<td>${eachItem.address}</td>
<td>${eachItem.bloodGrp}</td>
<td>${eachItem.phoneNumber}</td>
<td>${eachItem.donatedDate}</td></tr>>
</c:out>
</c:if>
</c:forEach>
</table>
</body>
</html>