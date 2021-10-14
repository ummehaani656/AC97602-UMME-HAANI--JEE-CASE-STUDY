<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blood Camp</title>
<style>
* {box-sizing: border-box;}

h1{
font-size: 50px;
font-style:oblique;
color:#fa8072}




body {
margin: 0;
font-family: Arial, Helvetica, sans-serif;
background-color:#ffc6c4;
}



.header {
overflow: hidden;
background-color: #D75C5C;
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
background-color: dodgerblue;
color: black;
}



.header a.active {
background-color: dodgerblue;
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
font-size:70px;
font-style: oblique;
color: red;
}
table {
border:2px solid red;
margin-left:auto;
margin-right:auto;
border-collapse:collapse;
}
tr,td,th {
border:2px solid red;
}
</style>
</head>
<body>

<div class="header">
<h1 align="center">${majHeading}</h1>
<div class="header-left">
<a href="addDonor">Register As Donor</a>
<a href="getAllDonors">List Of Donors</a>
<a href="getAllDonationCamps">Camp Details</a>
</div>
</div>

<!--
<td>
<form action="/updateById">
<a>
<label>Enter DonorId : </label>
<input type="text" name="id">
<br>
<label>Update DonationDate : </label>
<input type="date" name="updateDate">
<br>
<input type="submit" value="Update">
</a>
</form>
</td>
-->
<div>
<p align="center">Donate Blood And Save Lives!</p>
<p align="center">BE A LIFE SAVER</p>
</div>
</body>