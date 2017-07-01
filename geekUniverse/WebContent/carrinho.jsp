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
								 <strong>Nome: </strong>${item.produto.nome } <a href="ServletDetalharProduto?id=${item.produto.id }"><span class="glyphicon glyphicon-search"></span></a> | <strong>Quantidade: </strong>${item.quantidade} | <c:if test="${item.produto.estoque > 0 }" > <a
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
								 valores
							
						</div>
					</div>
					
					
				</div>
				</c:if>
					
			</div>
		</section>
<%@include file="footer.jsp" %>		








