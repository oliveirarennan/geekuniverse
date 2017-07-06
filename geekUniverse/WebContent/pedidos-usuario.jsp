<%@ include file="verificar-login.jsp" %> 
<%@include file="top.jsp" %>
		<title>Painel do Usuário</title>
		<section class="container-fluid">
			<div class="row">
				<div class="col-md-6 col-md-offset-3" style="background-color: rgba(255, 255, 255, 0.8); margin-top: 5%; margin-bottom: 5%; padding: 3% 3% 3% 3%;">
					<legend>Pedidos</legend>
					<br />
					<h2>Oi, ${usuarioLogado.nome }!</h2>
					<h3>Clique em um dos seus pedidos para obeter mais informações! XD</h3>
					<br />
			<c:forEach var="pedido" items="${pedidosUsuario }">	
				<div class="col-md-9 col-md-offset-3 " style="color: rgba(192, 77, 22, 1);">
					<button class="btn btn-warning btn-lg" type="button"
						data-toggle="collapse" data-target="#collapse${pedido.id }"
						aria-expanded="false" aria-controls="collapse">${pedido.numeroPedido}</button>
						<div class="collapse" id="collapse${pedido.id }">
							<div class="well">
								Data: ${pedido.dataPedido} <br /> <fmt:formatNumber value="${pedido.valor}" type="currency" /> <br />
								Forma de Pagamento: ${pedido.formaPagamento.tipoPagamento }<br />
								Status: ${pedido.statusPedido} 
								
							</div>
							<legend>Produtos</legend>
									<div class="thumbnail">
										<c:forEach var="item" items="${itensPedido }">
											<c:if test="${pedido.id == item.pedido.id }">
												<div name="itens">
													<strong>Nome: </strong>${item.produto.nome } <a
														href="ServletDetalharProduto?id=${item.produto.id }"><span
														class="glyphicon glyphicon-search"></span></a> <strong>Quantidade:
													</strong>${item.quantidade} <strong>Preço Unitario :</strong>
													<fmt:formatNumber value="${item.produto.valor}" type="currency" /><br>
													<a href="boletos/${pedido.formaPagamento.info }" class="btn btn-success">Visualizar Boleto</a>
													
												</div>
											</c:if>	
										
										</c:forEach>
										
									</div>
						</div>
				</div>
		</c:forEach>	




		</div>
				</div>
							
		</section>
		
		
<%@include file="footer.jsp" %>		








