<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

* {box-sizing: border-box;}



body {
margin: 0;
font-family: Arial, Helvetica, sans-serif;
background-color:#F7CAC9;

}

h1{
  font-family: Georgia, sans-serif;
  font-size: 2em;
  letter-spacing: 2px;
}


.header {
overflow: hidden;
background-color:#fad1d0;
padding: 20px 10px;
}
.header a {
float: left;
color: black;
text-align: center;
padding: 12px;
text-decoration: none;
font-size: 18px;
line-height: 25px;
border-radius: 4px;
}



.header a.logo {
font-size: 25px;
font-weight: bold;
}

.header a:hover {
background-color: white;
color: black;
}



.header a.active {
background-color:white;
color: white;
}



.header-left {
float: left;
}



@media screen and (max-width: 500px) {
.header a {
float: none;
display: block;
text-align: left;
}

}
p {
font-size: 30px;
font-style: oblique;
color: green;
}
.styled-table tbody tr {
    border-bottom: 1px solid #dddddd;
}

.styled-table tbody tr:nth-of-type(even) {
    background-color: #f3f3f3;
}

.styled-table tbody tr:last-of-type {
    border-bottom: 2px solid #009879;
}
.styled-table {
    border-collapse: collapse;
     margin-left: auto;
    margin-right: auto;
    font-size: 0.9em;
    font-family: sans-serif;
    min-width: 400px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}
.styled-table thead tr {
    background-color: #009879;
    color: #ffffff;
    text-align: left;
}
.styled-table th,
.styled-table td {
    padding: 12px 15px;
}
.main-table {
    border-collapse: collapse;
}
.main-table th, td {
    padding: 0;
}
 button[type=submit] {
    background-color: #024488 
    border-color: #024488 ;
    color: #fff ;
}
 
 button[type=submit]:hover {
    background-color: #022B57 ;
}
</style>
</head>
<body>
<div class="header">
<h1 align="center"> Blood Donors Details</h1>
<div class="header-left">
<a href="editDetails">Edit Donor Details</a>
</div>
</div>
<br>
<br>
<table class="main-table" style="cellspacing:0;cellpadding:0">
<tr>
<th>
<form action="/getBloodGroup" >
<label for="">Search By Blood Group  </label>
<input type="text" name="searchbybloodgroup">
<input type="submit">
</form>
</th>
<th>
<form action="/getByCity">
<label>Search Donors by city :  </label>
<input type="text" name="searchbycity">
<input type="submit" value="searchbycity">
</form></th></tr>
</table><br><br>
<table  class="styled-table" style="text-align:center">
<tr>
<th>Donor Id</th>
<th>Donor Name</th>
<th>Gender</th>
<th>Address</th>
<th>Blood Group</th>
<th>Phone Number</th>
<th>Last Blood Donated Date</th>
</tr>
<c:forEach items="${data}" var="eachItem">
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