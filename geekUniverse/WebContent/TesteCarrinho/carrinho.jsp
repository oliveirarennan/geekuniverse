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
    <title>Carrinho</title>

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
  				<p class="left">Usuario : <strong>${usuarioLogado.nome}</strong> - <a href="listaProduto.jsp">Adicionar mais produtos</a> </p>
  				
  			</nav>
  		</div>
  	</div>
  		<div class="row">
  			<div class="col-md-6 col-offset-3">
  				<table class="table">
  				<thead>
  					<tr>
  						<td><strong>id </strong></td>
  						<td><strong>nome </strong></td>
  						<td><strong>valor </strong></td>
  						<td><strong>quantidade</strong></td>
  						<td><strong>valor total</strong> </td>
  						<td><strong>ações</strong></td>
  						<td> </td>
  						<td> </td>
  						
  					</tr>
  				</thead>
  				<tbody>
  				<jsp:useBean id="sc" class="teste.carrinho.modelo.Item"/>
  				
  				<c:forEach var="item" items="${ItensCarrinho}">
  					<tr>
  						<td>${item.id}</td>
  						<td>${item.produto.nome}</td>
  						<td>${item.produto.valor}</td>
  						<td>${item.quantidade}</td>
  						<td>${item.preco}</td>
  						<td><a href="../ServletAdicionarAoCarrinho?id=${item.produto.id}"><span class="glyphicon glyphicon-plus" ></span></a>  </a> <a href="../ServletRemoverDoCarrinho?id=${item.produto.id}&rl=0"> <span class="glyphicon glyphicon-minus" ></span> </a> <a href="../ServletRemoverDoCarrinho?id=${item.produto.id }&rl=1"> <span class="glyphicon glyphicon-remove" ></span> </a></td>
  						<td> </td>
  						<td> </td>
  					</tr>
  				</c:forEach>	
  				</tbody>
  					
  				</table>
  				<div class="pull-right">
  					<a  class="btn btn-danger"href="../ServletRemoverDoCarrinho?id=removeAll">Limpar Carrinho</a>
  				</div>
  				<br />
  				<div class="row">
  					<div class="col-md-4">
  							<form name="calculaFrete" action="../ServletCalcularFrete" method="POST">
  								<div class="form-group">
					  						<label for="cep" class="control-label">CEP</label>
					  						<input type="text" name="cep" id="cep"  class="form-control" required/><input type="submit" class="btn btn-primary pull-right" data-toggle="tooltip" data-placement="right" title="Clique para calcular o frete"/>
				  						<jsp:useBean id="sf" class="teste.carrinho.modelo.Frete"/>
				  						<c:set var="valorFrete" value="${Frete}"/>
				  						<c:if test = "${Frete != null }">
				  							<br />
				  							<br />
				  							<c:if test = "${Frete.valor != null }">
				  								<h5>O valor do frete é : R$ ${Frete.valor }</h5>
				  							</c:if>
				  							<br />
				  							<h5>O Prazo estimado de entrega é de:  ${Frete.prazo } dia(s) </h5>
				  						</c:if>
				  					</div>
  							</form>
  							
		  					<form name="fecharCompra" action="" method="POST">
				  					<div class="form-group">
				  						<jsp:useBean id="sp" class="teste.carrinho.modelo.Pedido"/>
				  						<c:set var="valorPedido" value="${ValorCarrinho }"/>
					  						<label for="valorCompra" class="control-label">Valor da Compra</label>
					  						<c:if test = "${Frete.valor != null }">
					  							<input type="text" name="valorPedido"  class="form-control" readonly value="R$ ${valorPedido.valor + valorFrete.valor}"/>
					  						</c:if>	
					  						<c:if test = "${Frete.valor == null }">
					  							<input type="text" name="valorPedido"  class="form-control" readonly value="R$ ${valorPedido.valor}"/>
					  						</c:if>
				  					</div>	
				  					<div class="form-group">
		  								<input type="submit"  class="btn btn-success" value="Fechar Compra" />
		  							</div>	
		  					</form>
		  			</div>		
  				</div>
  				
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
    <script src="resources/js/jquery.maskedinput.min.js"></script>
    <script src="resources/js/ConfiguracaoMaskInput.js"></script>
    <script src="resources/js/scripts.js"></script>
  </body>
</html>