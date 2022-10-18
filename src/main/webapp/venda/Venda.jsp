<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core"  prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <title>Venda</title>
</head>
<body>
    <h1>Venda</h1>
    <form id="formulario01" action="VendaSave" method="post">
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="inputData">Data</label>
            <input type="date" class="form-control" id="inputData" value="<c:out value="${venda.data}"/>">
          </div>
          <div class="form-group col-md-6">
            <label for="inputCliente">Cliente</label>
            <input type="text" class="form-control" id="inputCliente" placeholder="Cliente" value="<c:out value="${venda.cliente}"/>">
          </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputProduto">Produto</label>
                <input type="text" class="form-control" id="inputProduto" placeholder="notebook" value="<c:out value="${venda.produto}"/>">
            </div>
            <div class="form-group col-md-6">
                <label for="inputQuantidade">Quantidade</label>
                <input type="text" class="form-control" id="inputQuantidade" placeholder="Quantidade" value="<c:out value="${venda.quantidade}"/>">
            </div>
        </div>
         <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputDesconto">Desconto</label>
                <input type="text" class="form-control" id="inputDesconto" value="<c:out value="${venda.desconto}"/>">
            </div>
            <div class="form-group col-md-6">
                <label for="inputValorTotal">Valor Total</label>
                <input type="text" class="form-control" id="inputValorTotal" placeholder="Quantidade" value="<c:out value="${venda.valorTotal}"/>">
            </div>
        </div>
        <button type="submit" class="btn btn-success">Efetuar Venda</button>
        <button type="reset" class="btn btn-primary">Limpar</button>
        <a class="btn btn-danger" href="VendaList">Voltar</a>
      </form>
    
    </body>
</html>