<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<!DOCTYPE html>  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homepage</title>
</head>
<body>
<form:form action="azione" method="post" modelAttribute="prodotto">
<input type="submit" name="azione" value="Entra">
<input type="submit" name="azione" value="Digimon">
</form:form>
</body>
</html>