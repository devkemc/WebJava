<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core"  prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Entrega</title>
<style type="text/css"> @import url("./css/texto.css"); </style>
</head>
<body>
	<h1>Cadastro de Entrega</h1>
	<form id="formulario01" action="EntregaSave" method="post">
	<table>
	<tr>
	<td>Venda</td><td>
	<input type="text" id="venda" name="venda" 
			value="<c:out value="${entrega.venda}"/>" /> 
	</td>
	</tr>
	<tr>
	<td>data</td><td><input type="date" id="data" name="data" value="<c:out value="${entrega.data}"/>" /> </td>
	</tr>
	<tr>
		<td><button type="submit" value="Gravar">Gravar</button>
			<button type="submit" value="limpar">Limpar</button>
			<a href="EntregaList">Voltar</a>
		</td>
	</tr>
	</table>
	</form>
</body>
</html>