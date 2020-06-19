<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica Digimon</title>
</head>
<body>
<form:form action="salva" method="post" modelAttribute="digimon">
<form:hidden path="id"/>
<label>Nome</label>
<form:input path="nome"/>
<label>HP</label>
<form:input path="hp"/>
<label>Attacco</label>
<form:input path="atk"/>
<label>Difesa</label>
<form:input path="def"/>
<label>Resistenza</label>
<form:input path="res"/>
<label>Evoluzione</label>
<form:input path="evoluzione"/>
<input type="submit" value="Aggiungi">
</form:form>
</body>
</html>