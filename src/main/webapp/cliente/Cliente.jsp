<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core"  prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <title>Cadastro Cliente</title>
</head>
<body>
    <h1>Cadastro de Cliente</h1>
    <form id="formulario01" action="ClienteSave" method="post">
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="inputNome">Nome</label>
            <input type="text" class="form-control" id="inputNome" placeholder="Nome" value="<c:out value="${cliente.nome}"/>">
          </div>
          <div class="form-group col-md-6">
            <label for="inputEmail">Email</label>
            <input type="email" class="form-control" id="inputEmail" placeholder="Email" value="<c:out value="${cliente.email}"/>">
          </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputTelefone">Telefone</label>
                <input type="text" class="form-control" id="inputTelefone" placeholder="(11) 91111-1111" value="<c:out value="${cliente.telefone}"/>">
            </div>
            <div class="form-group col-md-6">
                <label for="inputAddress">Endereço</label>
                <input type="text" class="form-control" id="inputAddress" placeholder="Rua dos Bobos, nº 0" value="<c:out value="${cliente.endereco}"/>">
            </div>
        </div>
        <button type="submit" class="btn btn-success">Gravar</button>
        <button type="reset" class="btn btn-primary">Limpar</button>
        <a class="btn btn-danger" href="ClienteList">Voltar</a>
      </form>
    
    </body>
</html>