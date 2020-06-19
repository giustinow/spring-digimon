<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profilo</title>
</head>
<body>
<form action="digimonDaAggiungere" method="post">
<input type="hidden" name="id" value="${id}">
<input type="submit" value="Aggiungi Nuovo Digimon">
</form>
<table>
		<tr>
			<th>Nome</th>
			<th>HP</th>
			<th>Attacco</th>
			<th>Difesa</th>
			<th>Resistenza</th>
			<th>Evoluzione</th>
			<th></th>
		</tr>
		<c:forEach items="${lista}" var="digimon">
		<tr>
			<td>${digimon.nome}</td>
			<td>${digimon.hp}</td>
			<td>${digimon.atk}</td>
			<td>${digimon.def}</td>
			<td>${digimon.res}</td>
			<td>${digimon.evoluzione}</td>
			<td>
				<a href="rimuovi?digimon=${digimon.id}&id=${id}">Rimuovi</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<form action="home">
	<input type="submit" value="Torna Alla Home">
	</form>
</body>
</html>