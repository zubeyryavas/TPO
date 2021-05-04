<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add 2 numbers</title>
</head>
<body>
<h1 style="">Add Get</h1>

<!-- Get method  -->
<form action="MyServlet" method="GET">
    <label>First number: </label> <input type="text" name="n1" /> <br />
    <label>Second number : </label> <input type="text" name="n2" /> <br />
    <input type="submit" value="Add" /><br />
    <br />Res : <input
        type="text" name="res" value="${requestScope.res}" />

</form>

<!-- Post method  -->
<h1 style="">Add Post</h1>
<form action="MyServlet" method="POST">   <!-- Posting to Servlet named MyServlet  -->
    <label>First number: </label> <input type="text" name="n3" /> <br /> 	<!-- Input for n1 (First number for calculating)  -->
    <label>Second number : </label> <input type="text" name="n4" /> <br />  <!-- Input for n2 (Second number for calculating)  -->
    <input type="submit" value="Add" /><br />   <!-- Submiting to Servlet  -->
    <br />Res :<input
            type="text" name="res2" value="${requestScope.res2}" />  <!-- Getting result  -->

</form>
</body>
</html>