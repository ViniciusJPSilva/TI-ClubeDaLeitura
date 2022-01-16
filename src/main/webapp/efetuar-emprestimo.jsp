<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="autenticacao.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clube da Leitura - Efetuar Empréstimo</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<section class="titulo-pag">Efetuar Empréstimo</section>
	
	<section class="formulario formulario-emprestimo">
		<form action="controle" method="post">			
			<div>
				<p>Amigo</p> <select name="amigo" required="required" class="input-txt">
					<jsp:useBean id="amigoDao" class="vjps.clubedaleitura.dao.AmigoDAO" />
					<c:forEach var="amigo" items="${amigoDao.listaAmigos}" varStatus="id">
						<c:if test="${amigoDao.verificaPendencia(amigo) eq -1}"> <!-- Listando apenas amigos sem pendencias -->
							<option value="${amigo.id}">${amigo.nome}</option>
						</c:if>
					</c:forEach>
				</select><br/><br/>
			</div>
			
			<div>
				<p>Revista</p> <select name="revista" class="input-txt" required="required">
					<jsp:useBean id="revistaDao" class="vjps.clubedaleitura.dao.RevistaDAO" />
					<c:forEach var="revista" items="${revistaDao.listaRevistas}" varStatus="id">
						<c:if test="${revista.disponibilidade}"> <!-- Verifica se a revista está disponível -->
							<option value="${revista.id}">${revista.colecao} - N° ${revista.numeroEdicao}</option>
						</c:if>
					</c:forEach>
				</select><br/><br/>
			</div>
			<jsp:useBean id="dataAtual" class="java.util.Date" />
			<div><p>Data Empréstimo</p> <input type="text" name="dataEmprestimo" class="input-txt" required="required" value="<fmt:formatDate value="${dataAtual}" pattern="dd/MM/yyyy"/>"/><br/><br/></div>
			<div><p>Data Devolução</p> <input type="text" class="input-txt" value="10 dias após a data de empréstimo" readonly/><br/><br/></div>
			<input type="hidden" name="logica" value="EfetuaEmprestimo">
			<input type="submit" value="Emprestar" class="botao"/>
		</form>
	</section>
	
	<c:import url="rodape.jsp"/>
</body>
</html>