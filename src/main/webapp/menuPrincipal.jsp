<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="autenticacao.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clube da Leitura - Menu Principal</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<section class="links-menu links-revista"><br/>
		<a href="cadastrar-revista.jsp">Cadastrar Revista</a><br/>
		<a href="buscar-revista.jsp?acao=remover">Remover Revista</a><br/>
		<a href="buscar-revista.jsp?acao=alterar">Alterar Revista</a><br/>
	</section>
	
	<section class="links-menu links-caixa"><br/>
		<a href="cadastrar-caixa.jsp">Cadastrar Caixa</a><br/>
		<a href="buscar-caixa.jsp?acao=remover">Remover Caixa</a><br/>
		<a href="buscar-caixa.jsp?acao=alterar">Alterar Caixa</a><br/>
	</section>
	
	<section class="links-menu links-amigo"><br/>
		<a href="cadastrar-amigo.jsp">Cadastrar Amigo</a><br/>
		<a href="buscar-amigo.jsp?acao=remover">Remover Amigo</a><br/>
		<a href="buscar-amigo.jsp?acao=alterar">Alterar Amigo</a><br/>
	</section>
	
	<section class="links-menu links-emprestimo"><br/>
		<a href="efetuar-emprestimo.jsp">Efetuar Empréstimo</a><br/>
		<a href="buscar-emprestimo.jsp?acao=remover">Remover Emprestimo</a><br/>
		<a href="buscar-emprestimo.jsp?acao=alterar">Alterar Empréstimo</a><br/>
	</section>
	
	<section class="links-menu links-listagem"><br/>
		<a href="lista-revistas-emprestadas.jsp">Revistas Emprestadas</a><br/>
		<a href="controle?logica=AtrasosEmprestimo">Emprestimos em Atraso</a><br/>
		<a href="buscar-amigo.jsp?acao=lista-revistas">Revistas pegas por um amigo</a><br/>
	</section>
	
	<c:import url="rodape.jsp"/>
</body>
</html>