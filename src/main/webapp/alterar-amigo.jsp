<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="autenticacao.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clube da Leitura - Alterar Amigo</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<section class="titulo-pag">Alterar Amigo</section>
	
	<section class="formulario formulario-revista">
		<form action="controle" method="post">			
			<div><p>ID</p> <input type="number" name="id" class="input-txt"  value="${amigo.id}" readonly/><br/><br/></div>
			<div><p>Nome</p> <input type="text" name="nome" class="input-txt"  value="${amigo.nome}"/><br/><br/></div>
			<div><p>Telefone</p> <input type="text" name="telefone" class="input-txt" value="${amigo.telefone}"/><br/><br/></div>
			
			<input type="hidden" name="logica" value="AlteraAmigo">
			<input type="submit" value="Confirmar" class="botao"/>
		</form>
	</section>
	
	<c:import url="rodape.jsp"/>
</body>
</html>