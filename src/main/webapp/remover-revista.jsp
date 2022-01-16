<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="autenticacao.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clube da Leitura - Remover Revista</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<section class="titulo-pag">Remover Revista</section>
	
	<section class="formulario formulario-revista">
		<form action="controle" method="post">			
			<div><p>ID</p> <input type="number" name="id" class="input-txt"  value="${revista.id}" readonly/><br/><br/></div>
			<div><p>Coleção</p> <input type="text" name="colecao" class="input-txt"  value="${revista.colecao}" readonly/><br/><br/></div>
			<div><p>Edição</p> <input type="text" name="edicao" class="input-txt" value="${revista.numeroEdicao }" readonly/><br/><br/></div>
			<div><p>Ano</p> <input type="text" name="ano" class="input-txt" value="${revista.anoRevista}" readonly/><br/><br/></div>
			<div><p>Caixa</p> <input type="text" name="caixa" class="input-txt" value="${revista.caixa.cor}" readonly/><br/><br/></div>
			
			<input type="hidden" name="logica" value="RemoveRevista">
			<input type="submit" value="Confirmar" class="botao"/>
		</form><br/><br/>
		<h6>OBS: Todos os empréstimos também serão removidos.</h6>
	</section>
	
	<c:import url="rodape.jsp"/>
</body>
</html>