<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="autenticacao.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clube da Leitura - Alterar Revista</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<section class="titulo-pag">Alterar Revista</section>
	
	<section class="formulario formulario-revista">
		<form action="controle" method="post">			
			<div><p>ID</p> <input type="number" name="id" class="input-txt"  value="${revista.id}" readonly/><br/><br/></div>
			<div><p>Coleção</p> <input type="text" name="colecao" class="input-txt"  value="${revista.colecao}"/><br/><br/></div>
			<div><p>Edição</p> <input type="text" name="edicao" class="input-txt" value="${revista.numeroEdicao }"/><br/><br/></div>
			<div><p>Ano</p> <input type="text" name="ano" class="input-txt" value="${revista.anoRevista}"/><br/><br/></div>
			<div>
				<p>Caixa</p> <select name="caixa" required="required" class="input-txt">
					<option value="${revista.caixa.id}" selected="selected">${revista.caixa.cor}</option> <!-- Valor default -->
					<jsp:useBean id="caixaDao" class="vjps.clubedaleitura.dao.CaixaDAO"/>
						<c:forEach var="caixa" items="${caixaDao.listaCaixas}">
							<c:if test="${caixa.id ne revista.caixa.id}">
								<option value="${caixa.id}">${caixa.cor}</option>
							</c:if>
						</c:forEach>
				</select><br/><br/>
			</div>
			
			<input type="hidden" name="logica" value="AlteraRevista">
			<input type="submit" value="Confirmar" class="botao"/>
		</form>
	</section>
	
	<c:import url="rodape.jsp"/>
</body>
</html>