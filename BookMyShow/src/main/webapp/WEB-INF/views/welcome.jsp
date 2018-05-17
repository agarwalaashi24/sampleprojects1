<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book My Show</title>
<link rel="stylesheet" href="/resources/static/css/style.css" type="text/css">
<script type="text/javascript" src="/resources/static/js/app.js"></script>
</head>
<body>
<form action="welcome" method="post">

Select your role:<select name="choice">
    <option value="admin">Admin</option>
    <option value="user">User</option>
    </select> 
    <br/>
    <br/>
<input type="submit" value="Submit">
</form>

</body>
</html>