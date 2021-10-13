<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
* {box-sizing: border-box;}



body {
margin: 0;
font-family: Arial, Helvetica, sans-serif;
background-color:#F7CAC9;

}

h1{
  font-family: Georgia, sans-serif;
  font-size: 2em;
  letter-spacing: -1px;
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
<h1 align="center">Blood Donation Camp Details</h1>
<div class="header-left">
<a href="addDonationCamp">Add Camp</a>
<a href="addDonor">Register For Camp</a>
</div>
</div>
<br>
<br>
<table class="main-table" style="cellspacing:0;cellpadding:0">
<tr>
<th>
<form action="/searchcampbyarea" >
<label for="">Search Camp by city</label>
<input type="text" name="location">
<input type="submit">
</form></th>
<th>
<form action="/unregister" >
<label for="">  Enter DonorId : </label>
<input type="text" name="value">
<input type="submit" value="Unregister">
</form></th>
<th>
<form action="/getByCity">
<label>  Enter City : </label>
<input type="text" name="searchbycity">
<input type="submit" value="get Donors by Camp">
</form>
</th>
</tr>
</table><br><br>
<table class="styled-table" style="text-align:center">
<tr style="text-align:center">
<th>Camp Id</th>
<th>Camp Location</th>
<th>Camp Organizing Date</th>
<th>Start Time</th>
<th>End Time</th>
</tr>
<c:forEach items="${details}" var="each">
<tr style="text-align:center">
<td>${each.campId}</td>
<td>${each.location}</td>
<td>${each.date}</td>
<td>${each.startTime}</td>
<td>${each.endTime}</td>
</tr>
</c:forEach>
</table>
</body>
</html>