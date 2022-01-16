<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="autenticacao.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clube da Leitura - Cadastrar Revista</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<section class="titulo-pag">Cadastrar Revista</section>
	
	<section class="formulario formulario-revista">
		<form action="controle" method="post">
			<div><p>Coleção</p> <input type="text" name="colecao" class="input-txt" required="required"/><br/><br/></div>
			<div><p>Edição</p> <input type="number" name="edicao" class="input-txt" required="required" min="0"/><br/><br/></div>
			
			<jsp:useBean id="dataAtual" class="java.util.Date"/>
			<fmt:formatDate var="anoAtual" value="${dataAtual}" pattern="yyyy"/>
			<div><p>Ano</p> <input type="number" name="ano" class="input-txt" min="1663" max="${anoAtual}" required="required"/><br/><br/></div>
			
			<div>
				<p>Caixa</p> <select name="caixa" required="required" class="input-txt">
					<jsp:useBean id="caixaDao" class="vjps.clubedaleitura.dao.CaixaDAO" />
					<c:forEach var="caixa" items="${caixaDao.listaCaixas}">
						<option value="${caixa.id}">${caixa.cor}</option>
					</c:forEach>
				</select><br/><br/>
			</div>
			<input type="hidden" name="logica" value="CadastraRevista">
			<input type="submit" value="Cadastrar" class="botao"/>
		</form>
	</section>
	<c:import url="rodape.jsp"/>
</body>
</html>