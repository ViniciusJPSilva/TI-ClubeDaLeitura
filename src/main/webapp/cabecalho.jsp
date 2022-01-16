<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="./style/style.css?v=1"/>
</head>
<body>
	<img class="cabecalho" alt="Cabeçalho" src="./imagens/cabecalho.png">
	<c:if test="${sessionScope.status}">
		<a href="menuPrincipal.jsp"><input type="submit" value="Menu Principal" class="cabecalho-link-menu"/></a>
		<section class="login-informacoes"> 
			Olá, ${sessionScope.nome}!<br>
			Clique <a href="controle?logica=EfetuaLogout">aqui</a> para sair.
		</section><br class="retira-float"/><hr/>
	</c:if>
</body>
</html>