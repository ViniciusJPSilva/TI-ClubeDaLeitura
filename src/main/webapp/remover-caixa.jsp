<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="autenticacao.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clube da Leitura - Remover Caixa</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<section class="titulo-pag">Remover Caixa</section>
	
	<section class="formulario formulario-revista">
		<form action="controle" method="post">			
			<div><p>ID</p> <input type="number" name="id" class="input-txt"  value="${caixa.id}" readonly/><br/><br/></div>
			<div><p>Cor</p> <input type="text" name="cor" class="input-txt"  value="${caixa.cor}" readonly/><br/><br/></div>
			
			<input type="hidden" name="logica" value="RemoveCaixa">
			<input type="submit" value="Confirmar" class="botao"/>
		</form><br><br>
		<h6>OBS: Todas as revistas que estão na caixa também serão removidas.</h6>
	</section>
	
	<c:import url="rodape.jsp"/>
</body>
</html>