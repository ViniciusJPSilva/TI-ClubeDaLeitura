<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="autenticacao.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clube da Leitura - Cadastrar Caixa</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<section class="titulo-pag">Cadastrar Caixa</section>
	
	<section class="formulario formulario-login formulario-pequeno">
		<form action="controle" method="post">
			<div><p>Cor</p> <input type="text" name="cor" class="input-txt" required="required"/><br/><br/></div>			
			
			<input type="hidden" name="logica" value="CadastraCaixa">
			<input type="submit" value="Cadastrar" class="botao"/>
		</form>
	</section>
	
	<c:import url="rodape.jsp"/>
</body>
</html>