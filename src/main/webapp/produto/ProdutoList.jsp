<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"  %>
<%@ taglib uri="http://java.sun.com/jstl/core"  prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >
    <title>Produtos</title>
</head>
<body>
    <h1>Listagem de Produtos</h1>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">

      <div class="collapse navbar-collapse" id="conteudoNavbarSuportado">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <a class="nav-link" href="Index">Voltar</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ProdutoNew">Novo produto</a>
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
            <th scope="col">#</th>
            <th scope="col">Nome</th>
            <th scope="col">Descrição</th>
            <th scope="col">Preço</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="item" items="${lista}" >
            <tr>
              <th scope="row"><c:out value="${item.codigo}" /></th>
              <td><c:out value="${item.nome}"/></td>
              <td><c:out value="${item.descricao}"/></td>
              <td><c:out value="${item.preco}"/></td>
              <td><a href="ProdutoDelete?id=<c:out value="${item.codigo}" />">Deletar</a></td>
              <td><a href="ProdutoEdit?id=<c:out value="${item.codigo}" />">Editar</a></td>
            </tr>
        </c:forEach>
        </tbody>
      </table>
    
</body>
</html>