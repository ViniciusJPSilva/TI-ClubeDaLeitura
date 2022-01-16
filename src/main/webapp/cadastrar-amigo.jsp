<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="autenticacao.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clube da Leitura - Cadastrar Amigo</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<section class="titulo-pag">Cadastrar Amigo</section>
	
	<section class="formulario formulario-login">
		<form action="controle" method="post">
			<div><p>Nome</p> <input type="text" name="nome" class="input-txt" required="required"/><br/><br/></div>
			<div><p>Telefone</p> <input type="text" name="telefone" class="input-txt"/><br/><br/></div>
			<input type="hidden" name="logica" value="CadastraAmigo">
			<input type="submit" value="Cadastrar" class="botao"/>
		</form>
	</section>
	
	<c:import url="rodape.jsp"/>
</body>
</html>