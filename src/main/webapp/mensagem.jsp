<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="autenticacao.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Clube da Leitura</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<br><br>
	<h1 class="mensagem">${mensagem}</h1>
	
	<c:import url="rodape.jsp"/>
</body>
</html>