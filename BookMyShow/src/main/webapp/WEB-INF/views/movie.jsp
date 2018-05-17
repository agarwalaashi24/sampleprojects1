<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${message}
<form action="movie" method="post">
Id:<input type="text" name="m_id">
<br/>
<br/>
Name:<input type="text" name="m_name">
<br/>
<br/>
Date:<input type="text" name="m_date">
<br/>
<br/>
time:<input type="text" name="m_time">
<br/>
<br/>
<input type="submit" value="Submit"> 
</form>


</body>
</html>