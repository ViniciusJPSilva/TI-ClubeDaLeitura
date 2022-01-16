<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Clube da Leitura - Login</title>
	<link rel="stylesheet" type="text/css" href="./style/style.css"/>
</head>
<body>
	<c:import url="cabecalho.jsp"/><br/><br><hr/>
	<section class="titulo-pag">Efetue Login</section>
	
	<section class="formulario">
		<form action="controle" method="post">
			<div><p>Login</p> <input type="text" name="login" class="input-txt" required="required"/><br/><br/></div>
			<div><p>Senha</p> <input type="password" name="senha"class="input-txt" required="required"/><br/><br/></div>
			<input type="hidden" name="logica" value="EfetuaLogin">
			<input type="submit" value="Entrar" class="botao"/>
		</form>
	</section>
	<c:import url="rodape.jsp" />
</body>
</html>