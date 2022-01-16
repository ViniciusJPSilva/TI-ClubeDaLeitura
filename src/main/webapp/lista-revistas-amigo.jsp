<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="autenticacao.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clube da Leitura - Lista de Revistas Pegas</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<section class="titulo-pag">Revistas pegas pelo amigo ${amigo.nome}</section><br>
	
	<jsp:useBean id="dao" class="vjps.clubedaleitura.dao.EmprestimoDAO"/>
	<table class="tabela">
		<thead>
			<tr>
				<th>ID</th>
				<th>Coleção</th>
				<th>N° Edição</th>
				<th>Ano</th>
				<th>Caixa</th>
			</tr>
		</thead>
		<c:forEach var="emprestimo" items="${dao.listaEmprestimos}" varStatus="id">
			<c:if test="${amigo.id eq emprestimo.amigo.id}">
				<tr bgcolor="#${(id.count % 2 == 0) ? 'ffdc8f' : 'ffffff'}">
					<td>${emprestimo.revista.id}</td>
					<td>${emprestimo.revista.colecao}</td>
					<td>${emprestimo.revista.numeroEdicao}</td>
					<td>${emprestimo.revista.anoRevista}</td>
					<td>${emprestimo.revista.caixa.cor}</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
	<c:import url="rodape.jsp"/>
</body>
</html>