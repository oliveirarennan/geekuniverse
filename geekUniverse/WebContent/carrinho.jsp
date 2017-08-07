<%@include file="top.jsp" %>
		
		<section class="container-fluid" id="visao">
			<div class="row">
			<c:if test="${ItensCarrinho.size() == null }">
				<div class="col-md-8 col-md-offset-2" style="background-color:rgba(42, 42, 42, 0.9); margin-top: 5%; margin-bottom: 5%; padding: 3% 3% 3% 3%; color:#fff;">
					<div class="col-md-8 col-md-offset-2 ">
						<h3>Carrinho Vazio ... </h3>
					
						<h4>Procure no GeekUniverse e adicione alguns produtos para comprar! XD</h4>
					</div>
				</div>
			</c:if>
			<c:if test="${ItensCarrinho.size() > 0 }">
				<div class="col-md-8 col-md-offset-2" style="background-color:rgba(42, 42, 42, 0.9); margin-top: 5%; margin-bottom: 5%; padding: 3% 3% 3% 3%;">
				<h1 class="fonte"><center>Carrinho de Compras</center></h1>
				<hr>
				<div class="alert alert-warning" role="alert">
					
					<div class="row" >
					<c:forEach var="item" items="${ItensCarrinho}">
						<div class="col-md-8 col-md-offset-2 ">
							<table class="table">
								 <td class="col-md-4">Nome: ${item.produto.nome }
								 	<td>
								 		<a href="ServletDetalharProduto?id=${item.produto.id }"><span class="glyphicon glyphicon-search"></span></a>
								 	</td>
								 	<td >Quantidade: ${item.quantidade}</td>
								 	<td>
								 		<c:if test="${item.produto.estoque > 0 }" >
								  			<a href="ServletAdicionarAoCarrinho?id=${item.produto.id}"><span class="glyphicon glyphicon-plus"></span></a> 
								  		</c:if>
								  		<a href="ServletRemoverDoCarrinho?id=${item.produto.id}&rl=0"><span class="glyphicon glyphicon-minus"></span></a>
								  	</td>  
								  	<td>Preço Unitario: <fmt:formatNumber value="${item.produto.valor}" type="currency"/></td>
								  	<td>
										<a href="ServletRemoverDoCarrinho?id=${item.produto.id }&rl=1">
											<span class="glyphicon glyphicon-remove"></span>
										</a>
									</td>
								</td>
							</table>
						</div>
					</c:forEach>
					
					<br />
					<br />
										<div class="col-md-8 col-md-offset-2 ">
							<div class="pull-right">
							<a class="btn btn-danger"
							href="ServletRemoverDoCarrinho?id=removeAll">Limpar
							Carrinho</a>
						</div>
					</div>
					
					</div>
					</div>		
					<div class="row">
							
								 <h1 class="fonte"><center>Frete e Fechamento de Pedido</center></h1>
								 <hr>
								 
								 <div class="row">
					<div class="col-md-4">
						<form name="calculaFrete" action="ServletCalcularFrete"
							method="POST">
							<div class="col-md-10" style="margin-left:450px;">
								<label for="cep" class="control-label fonte">Verifique o valor do frete</label>
								<input type="text" name="cep" id="cep" class="form-control" required placeholder="Digite seu Cep"/>
								<input type="submit" class="btn btn-primary enviar" data-toggle="tooltip" data-placement="right" title="Clique para calcular o frete" />
								<jsp:useBean id="sf" class="modelo.Frete" />
								<c:set var="valorFrete" value="${Frete}" />
								<c:if test="${Frete != null }">
									<br />
									<br />
									<c:if test="${Frete.valor != null }">
										<h5 class="fonte">O valor  do frete para o cep informado  é  de: <fmt:formatNumber value="${Frete.valor}" type="currency"/></h5>
									</c:if>
									<br />
									<h5 class="fonte">O Prazo estimado de entrega é de: ${Frete.prazo }
										dia(s)</h5>
								</c:if>
							</div>
						</form>
						</div>
					<div class="col-md-12">
					<hr>
						<form name="fecharCompra" action="ServletFecharCompra" method="POST">
							<div class="form-group">
								<jsp:useBean id="sp" class="modelo.Pedido" />
								<c:set var="valorPedido" value="${ValorCarrinho }" />
								<fmt:setLocale value="pt_br"/>
								<label for="valorCompra" class="control-label fonte">Valor da Compra</label>
								<c:if test="${Frete.valor != null }">
									R$<input type="text" name="valorPedido" class="form-control" readonly value="<fmt:formatNumber value="${valorPedido.valor + valorFrete.valor}" type="currency"/>" required/>
								</c:if>
								<c:if test="${Frete.valor == null }">
									<input type="text" name="valorPedido" class="form-control" readonly value="<fmt:formatNumber value="${valorPedido.valor }" type="currency"/>" />
								</c:if>
							</div>
							<c:choose>
								<c:when test="${usuarioLogado ne null }">
									<c:choose>
										<c:when test="${Frete.valor != null }">
											<div class="form-group">
												<input type="submit" class="btn btn-success"
													value="Fechar Compra" />
											</div>
										</c:when>	
										<c:when test="${Frete.valor == null }">
											<div class="form-group">
												<input type="submit" class="btn btn-success"
													value="Fechar Compra" disabled />
													<h3 class="fonte">Para continuar, informe seu cep XD </h3>
											</div>
										</c:when>	
									</c:choose>
								</c:when>
								<c:when test="${usuarioLogado == null }">
									<div >
										<h4 class="fonte">Para finalizar seu pedido, faça login XD</h4>
										<a href="#" class="btn btn-warning" data-toggle="modal" data-target="#loginModal">Login</a>
									</div>
								</c:when>	
							</c:choose>
								
						</form>
						</div>

				</div>
								 
							
					</div>
					
					
				</div>
				</c:if>
					
			</div>
		</section>
		<script type="text/javascript">
		$(document).ready(function() { 
			window.location.href='#visao';
			});
		</script>
<%@include file="footer.jsp" %>		








