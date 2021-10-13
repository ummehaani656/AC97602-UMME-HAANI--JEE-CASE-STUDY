<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register as Donor</title>
<style>
body {font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #ffc6c4;
        font-size: large;
        text-align:center;
   }

h2{
    text-align: center;
	font-weight: bold;
   color: ff726f;
   font-size: 50px;
}

input[type="text"],select,input[type="date""],radiobutton,input[type="number"]
{
    border: none;
    background:silver;
    height: 80px;
    font-size: 20px;
	padding:15px;
	width:60%;	
	border-radius: 30px;
	margin-left:20%;
}



</style>
</head>
<body>
<div>
<form:form action="/addDonor" modelAttribute="command" method="post"  >
<h2 align="center" >Enter The Donor Details</h2>
<div class="container" align="center">
<div>
<label for="">Donor Id</label><br>
<form:input type="text"  path="id"/><br>
<form:errors path="id" cssStyle="color:red;"></form:errors>
</div>
<div >
<label for="">Donor Name</label><br>
<form:input  type="text" path="donorname"/><br>
<form:errors path="donorname" cssStyle="color:red;"></form:errors> </div>
<div>
<label for="">Gender :</label><br>
<form:radiobutton path="gender" value="Male"/> Male
<form:radiobutton path="gender" value="Female"/>Female
<form:errors path="gender" cssStyle="color:red;"></form:errors><br>  
</div>
<div>
<label for="">address</label><br>
<form:input  type="text" path="address"/><br>
<form:errors path="address" cssStyle="color:red;"></form:errors> </div>
<div>
<label for="">Blood Group</label><br>
<form:select path="bloodGrp">  
        <form:option value="A+" label="A+"/>  
        <form:option value="B+" label="B+"/>  
        <form:option value="O+" label="O+"/>  
        <form:option value="AB+" label="AB+"/>  
        <form:option value="A-" label="A-"/>  
        <form:option value="B-" label="B-"/>  
        <form:option value="O-" label="O-"/>  
        <form:option value="AB-" label="AB-"/>  
        </form:select> <br>
        <form:errors path="bloodGrp" cssStyle="color:red;"></form:errors> </div>
        <div>
        <label for="">Phone Number</label><br>
       
   <form:input type="number"  path="phoneNumber"/><br>
   <form:errors path="phoneNumber" cssStyle="color:red;"></form:errors> </div>
   <div>
<label for="">Last Blood Donated Date</label><br>
<form:input type="date" path="donatedDate"/><br>
</div>
<div>
<input type="submit" value="Add"/>
</div>
</div>
</form:form>
</div>
</body>
</html>