<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profilo</title>
</head>
<body>
<form:form action="nuovoAllenatore" method ="post" modelAttribute="allenatore">
<label>Username:</label>
<form:input path="username"/>
<input type="submit" value="Aggiungi Allenatore">
</form:form>
<table>
		<tr>
			<th>Nome Allenatore</th>
			<th></th>
		</tr>
		<c:forEach items="${lista}" var="allenatore">
		<tr>
			<td>${allenatore.username}</td>
			<td>
				<a href="digimonDaAggiungere?id=${allenatore.id}">Aggiungi Digimon</a>
			</td>
			<td>
				<a href="digimonAllenatore?id=${allenatore.id}">Digimon</a>
			</td>
			<td>
				<a href="rimuoviAllenatore?id=${allenatore.id}">Rimuovi</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<form action="home">
	<input type="submit" value="Torna Alla Home">
	</form>
</body>
</html>