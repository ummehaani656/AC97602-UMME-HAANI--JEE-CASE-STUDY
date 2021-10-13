<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Donor Details</title>
<style>
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
  text-align:center;
  color:#f6807b;
}
</style>
</head>
<body>
<h1>Edit Donor  Details </h1>
<br>
<br>
<table class="styled-table">
<tr>
<th>Edit Donor Name</th>
<th>Edit Donor Gender</th></tr>
<tr>
<td>
<form action="/updateName" >
<label for="">Enter Donor Id</label>
<input type="text" name="id">
<label for="">Enter Donor New Name</label>
<input type="text" name="name">
<input type="submit">
</form>
</td>
<td>
<form action="/updateGender" >
<label for="">Enter Donor Id</label>
<input type="text" name="id">
<label for="">Enter Donor Gender</label>
<input type="text" name="gender">
<input type="submit">
</form>
</td></tr>
<tr><th>Edit Donor City</th>
<th>Edit Donor Blood Group</th></tr>
<tr>
<td>
<form action="/updateAddress" >
<label for="">Enter Donor Id</label>
<input type="text" name="id">
<label for="">Enter Donor City </label>
<input type="text" name="address">
<input type="submit">
</form>
</td>
<td style="text-align:center">
<form action="/updateGroup" >
<label for=""> Enter Donor Id</label>
<input type="text" name="id">
<label for="">Enter Donor Blood Group</label>
<input type="text" name="grp">
<input type="submit">
</form>
</td></tr>
<tr><th>Edit Donor Phone Number</th>
<th>Edit Blood Donated Date</th></tr><tr>
<td >
<form action="/updateNumber" >
<label for="">Enter Donor Id</label>
<input type="text" name="id">
<label for="">Enter Donor new  Phone Number</label>
<input type="text" name="num">
<input type="submit"><br>
</form>
</td>
<td >
<form action="/updateDate" >
<label for="">Enter Donor Id</label>
<input type="text" name="id">
<label for="">Enter new Blood Donated Date</label>
<input type="date" name="date">
<input type="submit">
</form>
</td></tr></table>
</body>
</html>