<%@include file="top.jsp" %>
		
		<section class="container-fluid">
			<div class="row">
			<c:if test="${ItensCarrinho.size() == null }">
				<div class="col-md-8 col-md-offset-2" style="background-color: rgba(255, 255, 255, 0.8); margin-top: 5%; margin-bottom: 5%; padding: 3% 3% 3% 3%;">
					<div class="col-md-8 col-md-offset-2 ">
						<h3>Carrinho Vazio ... </h3>
					
						<h4>Procure no GeekUniverse e adicione alguns produtos para comprar! XD</h4>
					</div>
				</div>
			</c:if>
			<c:if test="${ItensCarrinho.size() > 0 }">
				<div class="col-md-8 col-md-offset-2" style="background-color: rgba(255, 255, 255, 0.8); margin-top: 5%; margin-bottom: 5%; padding: 3% 3% 3% 3%;">
					<div class="row">
					<c:forEach var="item" items="${ItensCarrinho}">
						<div class="col-md-8 col-md-offset-2 ">
							<div class="thumbnail">
								 <strong>Nome: </strong>${item.produto.nome } <a href="ServletDetalharProduto?id=${item.produto.id }"><span class="glyphicon glyphicon-search"></span></a> | <strong>Quantidade: </strong>${item.quantidade} |<strong>Preço Unitario</strong><fmt:formatNumber value="${item.produto.valor}" type="currency"/>|  <c:if test="${item.produto.estoque > 0 }" > <a
									href="ServletAdicionarAoCarrinho?id=${item.produto.id}"><span
										class="glyphicon glyphicon-plus"></span></a> </c:if> <a
									href="ServletRemoverDoCarrinho?id=${item.produto.id}&rl=0">
										<span class="glyphicon glyphicon-minus"></span>
								</a> <a
									href="ServletRemoverDoCarrinho?id=${item.produto.id }&rl=1">
										<span class="glyphicon glyphicon-remove"></span>
								</a>
							</div>
						</div>
					</c:forEach>
					
					<br />
					<br />
					
					</div>	
					
					<div class="col-md-8 col-md-offset-2 ">
							<div class="pull-right">
							<a class="btn btn-danger"
							href="ServletRemoverDoCarrinho?id=removeAll">Limpar
							Carrinho</a>
						</div>
					</div>	
					<div class="row">
						<div class="col-md-8 col-md-offset-2 ">
							
								 <legend class="pull-right">Frete e Fechamento de Pedido </legend>
								 
								 <div class="row">
					<div class="col-md-4">
						<form name="calculaFrete" action="ServletCalcularFrete"
							method="POST">
							<div class="form-group">
								<label for="cep" class="control-label">CEP</label> <input
									type="text" name="cep" id="cep" class="form-control" required /><input
									type="submit" class="btn btn-primary pull-right"
									data-toggle="tooltip" data-placement="right"
									title="Clique para calcular o frete" />
								<jsp:useBean id="sf" class="modelo.Frete" />
								<c:set var="valorFrete" value="${Frete}" />
								<c:if test="${Frete != null }">
									<br />
									<br />
									<c:if test="${Frete.valor != null }">
										<h5>O valor do frete é : <fmt:formatNumber value="${Frete.valor}" type="currency"/></h5>
									</c:if>
									<br />
									<h5>O Prazo estimado de entrega é de: ${Frete.prazo }
										dia(s)</h5>
								</c:if>
							</div>
						</form>

						<form name="fecharCompra" action="ServletFecharCompra" method="POST">
							<div class="form-group">
								<jsp:useBean id="sp" class="modelo.Pedido" />
								<c:set var="valorPedido" value="${ValorCarrinho }" />
								<fmt:setLocale value="pt_br"/>
								
								<label for="valorCompra" class="control-label">Valor da
									Compra</label>
								<c:if test="${Frete.valor != null }">
									R$<input type="text" name="valorPedido" class="form-control"
										readonly value="${valorPedido.valor + valorFrete.valor}" required/>
								</c:if>
								<c:if test="${Frete.valor == null }">
									<input type="text" name="valorPedido" class="form-control" readonly value="<fmt:formatNumber value="${valorPedido.valor }" type="currency"/>" />
								</c:if>
							</div>
							<c:choose>
								<c:when test="${usuarioLogado ne null }">
									<div class="form-group">
										<input type="submit" class="btn btn-success"
											value="Fechar Compra" />
									</div>
								</c:when>
								<c:when test="${usuarioLogado == null }">
									<div >
										<h4>Para finalizar seu pedido, faça login XD</h4>
										<a href="#" class="btn btn-warning" data-toggle="modal" data-target="#loginModal">Login</a>
									</div>
								</c:when>	
							</c:choose>
								
						</form>
					</div>
				</div>
								 
							
						</div>
					</div>
					
					
				</div>
				</c:if>
					
			</div>
		</section>
<%@include file="footer.jsp" %>		








