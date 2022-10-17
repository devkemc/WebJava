<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core"  prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Produto</title>
<style type="text/css"> @import url("./css/texto.css"); </style>
</head>
<body>
	<h1>Cadastro de Produto</h1>
	<form id="formulario01" action="ProdutoSave" method="post">
	<table>
	<tr>
	<td>Nome</td><td>
	<input type="text" id="nome" name="nome" 
			value="<c:out value="${produto.nome}"/>" /> 
	</td>
	</tr>
	<tr>
	<td>Descrição</td><td><input type="text" id="descricao" name="descricao" value="<c:out value="${produto.descricao}"/>" /> </td>
	</tr>
	<tr>
	<td>Preço</td><td>
	<input type="text" id="preco" name="preco"
	value="<c:out value="${produto.preco}"/>" /> 
	
	</td>
	</tr>
	<tr>
		<td><button type="submit" value="Gravar">Gravar</button>
			<button type="submit" value="limpar">Limpar</button>
			<a href="ProdutoList">Voltar</a>
		</td>
	</tr>
	</table>
	</form>
</body>
</html>