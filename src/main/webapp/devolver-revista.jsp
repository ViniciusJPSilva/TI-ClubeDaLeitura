<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="autenticacao.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Clube da Leitura - Devolução de Revista</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<section class="titulo-pag"> Devolução de Revista</section>
	
	<section class="formulario formulario-emprestimo">
		<form action="controle" method="post">			
			<div><p>Revista</p> <input type="text" name="revista" class="input-txt"  value="${revista.colecao} - N° ${revista.numeroEdicao}" readonly/><br/><br/></div>
			<div><p>Amigo</p> <input type="text" name="amigo" class="input-txt"  value="${amigo.nome}" readonly/><br/><br/></div>
			<div><p>Data Empréstimo</p> <input type="text" name="dataEmprestimo" class="input-txt"  value="<fmt:formatDate value="${emprestimo.dataEmprestimo.time}" pattern="dd/MM/yyyy"/>" readonly/><br/><br/></div>
			<div><p>Data Devolução</p> <input type="text" name="novaDataDevolucao" class="input-txt"  value="<fmt:formatDate value="${emprestimo.dataDevolucao.time}" pattern="dd/MM/yyyy"/>"/><br/><br/></div>
			
			<input type="hidden" name="logica" value="DevolveRevista">
			<input type="hidden" name="idRevista" value="${revista.id}">
			<input type="hidden" name="idEmprestimo" value="${emprestimo.id}">
			<input type="submit" value="Devolver" class="botao"/>
		</form>
	</section>
	
	<c:import url="rodape.jsp"/>
</body>
</html>