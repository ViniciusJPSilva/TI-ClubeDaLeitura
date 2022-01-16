<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="autenticacao.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clube da Leitura - Remover Empréstimo</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<section class="titulo-pag">Remover Empréstimo</section>
	
	<section class="formulario formulario-emprestimo">
		<form action="controle" method="post">			
			<div>
				<p>ID</p> <input type="number" name="id" class="input-txt" value="${emprestimo.id}" readonly/><br/><br/>
			</div>
			
			<div>
				<p>Amigo</p> <input type="text" name="amigo"class="input-txt" value="${emprestimo.amigo.nome}" readonly/><br/><br/>
			</div>
			
			<div>
				<p>Revista</p> <input type="text" name="revista" class="input-txt" value="${emprestimo.revista.colecao} - N° ${emprestimo.revista.numeroEdicao}" readonly/><br/><br/>
			</div>
			
			<div>
				<p>Data Empréstimo</p> <input type="text" name="dataEmprestimo" class="input-txt" value="<fmt:formatDate value="${emprestimo.dataEmprestimo.time}" pattern="dd/MM/yyyy"/>" readonly/><br/><br/>
			</div>
			
			<div>
				<p>Data Devolução</p>
				<c:choose>
					<c:when test="${empty emprestimo.dataDevolucao}">
						<input type="text" name="dataDevolucao" class="input-txt" value="Emprestimo pendente" readonly/>
					</c:when>
				    <c:otherwise>
						<input type="text" name="dataDevolucao" class="input-txt" value="<fmt:formatDate value="${emprestimo.dataDevolucao.time}" pattern="dd/MM/yyyy"/>" readonly/>
				    </c:otherwise>
				</c:choose>
				
				<br/><br/>
			</div>
			
			<input type="hidden" name="logica" value="RemoveEmprestimo">
			<input type="submit" value="Remover" class="botao"/>
		</form>
	</section>
	
	<c:import url="rodape.jsp"/>
</body>
</html>