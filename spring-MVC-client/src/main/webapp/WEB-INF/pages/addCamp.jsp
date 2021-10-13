<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Camp</title>
<style>
body {font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #ffcccb;
        font-size: large;
        text-align:center;
   }

h2{
    text-align: center;
	font-weight: bold;
   color: ff726f;
   font-size: 50px;
}

input[type="text"],input[type="date""]
{
    border: none;
    background-color:silver;
    height: 80px;
    font-size: 20px;
	padding:15px;
	width:60%;	
	border-radius: 30px;
	margin-left:20%;
}
.copywrite1 {
    background-color: lightgrey;
  text-align: center;
  color: black;
  padding: 16px 20px;
  margin: 8px 0;
  width: 100%;
  opacity: 0.9; 
   
}

</style>
</head>
<body>
<h1 "text-align:center">Add New Camp, Save Lives</h1>
<br>
<br>
<div>
<form:form action="/addDonationCamp" modelAttribute="command" method="post">
<div>
<label for="">Camp Id</label><br>
<form:input  path="campId"/><br>
<form:errors path="campId" cssStyle="color:red;"></form:errors>
</div>
<div>
<label for="">Camp Location</label><br>
<form:input  path="location"/><br>
<form:errors path="location" cssStyle="color:red;"></form:errors> </div>
<div>
<label for="">Camp Organisation Date</label><br>
<form:input  type="date"  path="date"/><br>
<form:errors path="date" cssStyle="color:red;"></form:errors>
</div>
<div>
<label for="">Start Time</label><br>
<form:input  path="startTime"/><br>
</div>
<div>
<label for="">End Time</label><br>
<form:input path="endTime"/><br>
</div>
<div>
<input type="submit" value="Add"/><br>
</div>
<div class="copywrite1">
        <p> All Right Reserved @ Blood bank Management:: 2021  </p>
        </div>
       
</form:form>
</div>
</body>
</html>