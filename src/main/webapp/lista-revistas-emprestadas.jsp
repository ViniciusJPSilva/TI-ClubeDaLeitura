<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="autenticacao.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clube da Leitura - Lista de Revistas Pegas</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<section class="titulo-pag">Revistas Emprestadas</section><br>
	
	<jsp:useBean id="dao" class="vjps.clubedaleitura.dao.EmprestimoDAO"/>
	<table class="tabela">
		<thead>
			<tr bgcolor="#ffdc8f">
				<th>ID</th>
				<th>Coleção</th>
				<th>N° Edição</th>
				<th>Ano</th>
				<th>Caixa</th>
				<th>Amigo</th>
				<th>Data Empréstimo</th>
				<th>Devolução</th>
			</tr>
		</thead>
		<c:forEach var="emprestimo" items="${dao.listaEmprestimos}" varStatus="id">
			<c:if test="${empty emprestimo.dataDevolucao}">
				<tr bgcolor="#${(id.count % 2 == 0) ? 'ffdc8f' : 'ffffff'}">
					<td>${emprestimo.revista.id}</td>
					<td>${emprestimo.revista.colecao}</td>
					<td>${emprestimo.revista.numeroEdicao}</td>
					<td>${emprestimo.revista.anoRevista}</td>
					<td>${emprestimo.revista.caixa.cor}</td>
					<td>${emprestimo.amigo.nome}</td>
					<td><fmt:formatDate value="${emprestimo.dataEmprestimo.time}" pattern="dd/MM/yyyy"/></td>
					<td>
						<form action="controle" method="post">
							<input type="hidden" name="idEmprestimo" value="${emprestimo.id}">
							<input type="hidden" name="logica" value="DevolveRevista">
							<input type="submit" value="Devolver">
						</form>
					</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
	<c:import url="rodape.jsp"/>
</body>
</html>