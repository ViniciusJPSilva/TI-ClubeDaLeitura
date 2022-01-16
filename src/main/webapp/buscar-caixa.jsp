<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="autenticacao.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Clube da Leitura - Buscar Caixa</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<section class="titulo-pag">Buscar Caixa</section>
	
	<section class="formulario formulario-revista formulario-pequeno">
		<form action="controle" method="post">
			<jsp:useBean id="caixaDao" class="vjps.clubedaleitura.dao.CaixaDAO"/>
			
			<div>
				<p>Cor</p><select name="id" required="required" class="input-txt">
					<c:forEach var="caixa" items="${caixaDao.listaCaixas}">
						<option value="${caixa.id}">${caixa.cor}</option>
					</c:forEach>
				</select>
			</div>
			
			<input type="hidden" name="logica" value="BuscaCaixa">
			<input type="hidden" name="redireciona" value="${param.acao}-caixa.jsp">
			<input type="submit" value="Buscar" class="botao"/>
		</form>
	</section>
	
	<c:import url="rodape.jsp"/>
</body>
</html>