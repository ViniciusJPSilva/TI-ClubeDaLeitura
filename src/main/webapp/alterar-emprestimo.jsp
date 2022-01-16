<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="autenticacao.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clube da Leitura - Alterar Empr�stimo</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<section class="titulo-pag">Alterar Empr�stimo</section>
	
	<section class="formulario formulario-emprestimo">
		<form action="controle" method="post">	
			<div>
				<p>ID</p> <input type="number" name="id" class="input-txt" value="${emprestimo.id}" readonly/><br/><br/>
			</div>
				
			<div>
				<p>Amigo</p> <select name="amigo" class="input-txt" required="required">
					<option value="${emprestimo.amigo.id}">${emprestimo.amigo.nome}</option>
				
					<jsp:useBean id="amigoDao" class="vjps.clubedaleitura.dao.AmigoDAO" />
					<c:forEach var="amigo" items="${amigoDao.listaAmigos}" varStatus="id">
						<c:if test="${amigoDao.verificaPendencia(amigo) eq -1}"> <!-- Lista apenas amigos sem pendencias -->
							<option value="${amigo.id}">${amigo.nome}</option>
						</c:if>
					</c:forEach>
				</select><br/><br/>
			</div>
			
			<div>
				<p>Revista</p> <select name="revista" class="input-txt" required="required">
					<option value="${emprestimo.revista.id}">${emprestimo.revista.colecao} - N� ${emprestimo.revista.numeroEdicao}</option>
					
					<jsp:useBean id="revistaDao" class="vjps.clubedaleitura.dao.RevistaDAO" />
					<c:forEach var="revista" items="${revistaDao.listaRevistas}" varStatus="id">
						<c:if test="${revista.disponibilidade}"> <!-- Verifica se a revista est� dispon�vel -->
							<option value="${revista.id}">${revista.colecao} - N� ${revista.numeroEdicao}</option>
						</c:if>
					</c:forEach>
				</select><br/><br/>
			</div>
			
			<div><p>Data Empr�stimo</p> <input type="text" name="dataEmprestimo" class="input-txt" required="required" value="<fmt:formatDate value="${emprestimo.dataEmprestimo.time}" pattern="dd/MM/yyyy"/>"/><br/><br/></div>
			
			<div>
				<p>Data Devolu��o</p>
				
				<c:choose>
					<c:when test="${empty emprestimo.dataDevolucao}">
						 <input type="text" class="input-txt" value="Empr�stimo pendente" readonly/>
					</c:when>
				    <c:otherwise>
				       <input type="text" class="input-txt" value="<fmt:formatDate value="${emprestimo.dataDevolucao.time}" pattern="dd/MM/yyyy"/>"/>
				    </c:otherwise>
				</c:choose>
				
				<br/><br/>
			</div>
			<input type="hidden" name="logica" value="AlteraEmprestimo">
			<input type="submit" value="Alterar" class="botao"/>
		</form>
	</section>
	
	<c:import url="rodape.jsp"/>
</body>
</html>