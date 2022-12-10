<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"  %>
<%@ taglib uri="http://java.sun.com/jstl/core"  prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >
    <title>Venda</title>
</head>
<body>
    <h1>Listagem de Vendas</h1>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">

      <div class="collapse navbar-collapse" id="conteudoNavbarSuportado">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <a class="nav-link" href="Index">Voltar</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="VendaNew">Nova venda</a>
          </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
          <input class="form-control mr-sm-2" type="search" placeholder="Pesquisar" aria-label="Pesquisar">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Pesquisar</button>
        </form>
      </div>
    </nav>
    <table class="table table-striped table-dark">
        <thead>
          <tr>
            <th scope="col">id</th>
            <th scope="col">Data</th>
            <th scope="col">Cliente</th>
            <th scope="col">Produto</th>
            <th scope="col">Quantidade</th>
            <th scope="col">Desconto</th>
            <th scope="col">Valor Total</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="item" items="${lista}" >
            <tr>
              <th scope="row"><c:out value="${item.codigo}" /></th>
              <td><c:out value="${item.data}"/></td>
              <td><c:out value="${item.cliente}"/></td>
              <td><c:out value="${item.produto}"/></td>
              <td><c:out value="${item.quantidade}"/></td>
              <td><c:out value="${item.desconto}"/></td>
              <td><c:out value="${item.valorTotal}"/></td>
              <td><a href="VendaDelete?id=<c:out value="${item.codigo}" />">Deletar</a></td>
              <td><a href="VendaEdit?id=<c:out value="${item.codigo}" />">Editar</a></td>
            </tr>
        </c:forEach>
        </tbody>
      </table>
    
</body>
</html>