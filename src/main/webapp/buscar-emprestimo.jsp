<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="autenticacao.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Clube da Leitura - Buscar Empréstimo</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<section class="titulo-pag">Buscar Empréstimo</section>
	
	<section class="formulario formulario-emprestimo formulario-pequeno">
		<form action="controle" method="post">
			<jsp:useBean id="emprestimoDao" class="vjps.clubedaleitura.dao.EmprestimoDAO"/>
			
			<div>
				<select name="id" required="required" class="input-txt revista-nome">
					<c:forEach var="emprestimo" items="${emprestimoDao.listaEmprestimos}">
						<option value="${emprestimo.id}">${emprestimo.informacoes}</option>
					</c:forEach>
				</select>
			</div>
			
			<input type="hidden" name="logica" value="BuscaEmprestimo">
			<input type="hidden" name="redireciona" value="${param.acao}-emprestimo.jsp">
			<input type="submit" value="Buscar" class="botao"/>
		</form>
	</section>
	
	<c:import url="rodape.jsp"/>
</body>
</html>