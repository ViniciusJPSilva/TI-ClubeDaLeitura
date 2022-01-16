<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="autenticacao.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Clube da Leitura - Buscar Revista</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<section class="titulo-pag">Buscar Revista</section>
	
	<section class="formulario formulario-revista formulario-pequeno">
		<form action="controle" method="post">
			<jsp:useBean id="revistaDao" class="vjps.clubedaleitura.dao.RevistaDAO"/>
			
			<div>
				<select name="id" required="required" class="input-txt revista-nome">
					<c:forEach var="revista" items="${revistaDao.listaRevistas}">
						<option value="${revista.id}">${revista.colecao} - N° ${revista.numeroEdicao}</option>
					</c:forEach>
				</select>
			</div>
			
			<input type="hidden" name="logica" value="BuscaRevista">
			<input type="hidden" name="redireciona" value="${param.acao}-revista.jsp">
			<input type="submit" value="Buscar" class="botao"/>
		</form>
	</section>
	
	<c:import url="rodape.jsp"/>
</body>
</html>