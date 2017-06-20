<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Lista Produto</title>

    <!-- Bootstrap -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/style.css" rel="stylesheet">
    <link href="resources/css/cssValidador.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  	<div class="container-fluid">
  	<div class="row">
  		<div class="col-md-12">
  			<nav class="nav navbar">
  				<jsp:useBean id="su" class="teste.carrinho.modelo.Cliente"/>
  				<c:set var="usuarioLogado" value="${su.retornaUsuarioLogado()}" />
  				<p class="left">Usuario : <strong>${usuarioLogado.nome}</strong> - <a href="carrinho.jsp">Visualizar Carrinho</a> </p>
  				
  			</nav>
  		</div>
  	</div>
  		<div class="row">
  			<div class="col-md-8 col-offset-2">
  				<table class="table">
  				<thead>
  					<tr>
  						<td><strong>id </strong></td>
  						<td><strong>nome </strong></td>
  						<td><strong>valor </strong></td>
  						<td><strong>estoque </strong></td>
  						<td><strong>acões </strong></td>
  					</tr>
  				</thead>
  				<tbody>
  				<jsp:useBean id="sc" class="teste.carrinho.modelo.Produto"/>
  				
  				<c:forEach var="produto" items="${sc.retornaProdutos()}">
  					<tr>
  						<td>${produto.id}</td>
  						<td>${produto.nome}</td>
  						<td>${produto.valor}</td>
  						<td>${produto.estoque}</td>
  						<td><a href="../ServletAdicionarAoCarrinho?id=${produto.id}">Adicionar ao Carrinho</a></td>
  					</tr>
  				</c:forEach>	
  				</tbody>
  					
  				</table>
  			</div>
  		</div>
  	</div>
  
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="resources/js/jquery-3.2.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/jquery.maskMoney.min.js"></script>
    <script src="resources/js/jquery.validate.min.js"></script>
    <script src="resources/js/additional-methods.min.js"></script>
    <script src="resources/js/ConfiguracaoMaskMoney.js"></script>
    <script src="resources/js/ConfiguracaoFormValidation.js"></script>
  </body>
</html>