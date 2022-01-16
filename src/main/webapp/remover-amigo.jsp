<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="autenticacao.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clube da Leitura - Remover Amigo</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<section class="titulo-pag">Remover Amigo</section>
	
	<section class="formulario formulario-revista">
		<form action="controle" method="post">			
			<div><p>ID</p> <input type="number" name="id" class="input-txt"  value="${amigo.id}" readonly/><br/><br/></div>
			<div><p>Nome</p> <input type="text" name="nome" class="input-txt"  value="${amigo.nome}" readonly/><br/><br/></div>
			<div><p>Telefone</p> <input type="text" name="telefone" class="input-txt" value="${amigo.telefone}" readonly/><br/><br/></div>
			
			<input type="hidden" name="logica" value="RemoveAmigo">
			<input type="submit" value="Confirmar" class="botao"/>
		</form><br/><br/>
		<h6>OBS: Todos os empréstimos também serão removidos.</h6>
	</section>
	
	<c:import url="rodape.jsp"/>
</body>
</html>