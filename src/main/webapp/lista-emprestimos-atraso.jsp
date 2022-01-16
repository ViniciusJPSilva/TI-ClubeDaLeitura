<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="autenticacao.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clube da Leitura - Empréstimos em Atraso</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<section class="titulo-pag">Empréstimos em Atraso</section><br>
	
	<jsp:useBean id="dao" class="vjps.clubedaleitura.dao.EmprestimoDAO"/>
	<table class="tabela">
		<thead>
			<tr bgcolor="#ffdc8f">
				<th>ID</th>
				<th>Amigo</th>
				<th>Revista</th>
				<th>Data do Empréstimo</th>
				<th>Data da Devolução</th>
			</tr>
		</thead>
		<c:forEach var="emprestimo" items="${emprestimosAtraso}" varStatus="id">
			<tr bgcolor="#${(id.count % 2 == 0) ? 'ffdc8f' : 'ffffff'}">
				<td>${emprestimo.id}</td>
				<td>${emprestimo.amigo.nome}</td>
				<td>${emprestimo.revista.colecao} - N° ${emprestimo.revista.numeroEdicao}</td>
				<td><fmt:formatDate value="${emprestimo.dataEmprestimo.time}" pattern="dd/MM/yyyy"/></td>
				<td><fmt:formatDate value="${emprestimo.dataDevolucao.time}" pattern="dd/MM/yyyy"/></td>
			</tr>
		</c:forEach>
	</table>
	
	<c:import url="rodape.jsp"/>
</body>
</html>