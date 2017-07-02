<%@include file="top.jsp" %>
		<fmt:setLocale value="pt_br"/>
		<section class="container-fluid">
			<div class="row">
			<c:if test="${ItensCarrinho.size() == null }">
				<div class="col-md-8 col-md-offset-2" style="background-color: rgba(255, 255, 255, 0.8); margin-top: 5%; margin-bottom: 5%; padding: 3% 3% 3% 3%;">
					<div class="col-md-8 col-md-offset-2 ">
						<h3>Erro ... </h3>
					
						<h4>Erro</h4>
					</div>
				</div>
			</c:if>
			<c:if test="${ItensCarrinho.size() > 0 }">
				<div class="col-md-8 col-md-offset-2" style="background-color: rgba(255, 255, 255, 0.8); margin-top: 5%; margin-bottom: 5%; padding: 3% 3% 3% 3%;">
					<div class="row">
					<legend>Resumo do Pedido</legend>
							<br>
					<c:forEach var="item" items="${ItensCarrinho}">
						<div class="col-md-8 col-md-offset-2 ">
							<div class="thumbnail">
							
								 <strong>Nome: </strong>${item.produto.nome }  | <strong>Quantidade: </strong>${item.quantidade} |<strong>Preço Unitario</strong><fmt:formatNumber value="${item.produto.valor}" type="currency"/>|  
									
							</div>
						</div>
					</c:forEach>
					
					<br>
					Valor Frete : <strong><i><fmt:formatNumber value="${pedido.frete.valor}" type="currency"/></i></strong>
					
					<br>
					<strong>Valor Total : <i><fmt:formatNumber value="${pedido.valor}" type="currency"/></i></strong>
					
					<br />
					<br />
					<div >
						Endereço: ${usuarioLogado.endereco.rua}, Número ${usuarioLogado.endereco.numero}, ${usuarioLogado.endereco.bairro}, ${usuarioLogado.endereco.cidade}/${usuarioLogado.endereco.estado.sigla} - ${usuarioLogado.endereco.pais}  
						<br>
						<a href="#" class="btn btn-warning" data-toggle="modal" data-target="#enderecoModal">Alterar Endereço</a>
					</div>
					
						<form name="finalizarPedido" action="ServletFinalizarPedido" method="POST">
							<div class="form-group">
								<select name="formaPagamento" id="formaPagamento" class="form-control">
									<optgroup label="Forma de Pagamento">
										<option value="boleto">Boleto</option>
									</optgroup>
								</select>
								
							</div>
							<c:choose>
								<c:when test="${usuarioLogado ne null }">
									<div class="form-group">
										<input type="submit" class="btn btn-success"
											value="Finalizar Pedido" />
									</div>
								</c:when>
								<c:when test="${usuarioLogado == null }">
									<div >
										<h4>Error</h4>
									</div>
								</c:when>	
							</c:choose>
								
						</form>
						</c:if>
					</div>
					</div>
				</div>				 
						
				
					

		</section>
		
		<!-- Endereco Modal-->
      <!-- Modal -->
        <div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" id="enderecoModal">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Login</h4>
              </div>
              <div class="modal-body">
                 <form action="ServletEditarEndereco" method="POST" >
                      <div class="form-group">
								<label class="control-label" for="pais">Pais</label>
								<div class="validateError">
									<input type="text" name="pais" id="pais" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="estado">Estado</label>
								<div class="validateError">
									<select class="form-control" name="estado" id="estado">
										<jsp:useBean id="cu" class="servico.EstadoServico"></jsp:useBean>
										<optgroup>
											<c:forEach var="estado" items="${cu.listar() }">
												<option value="${estado.id }">${estado.descricao}</option>
											</c:forEach>
										</optgroup>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="cidade">Cidade</label>
								<div class="validateError">
									<input type="text" name="cidade" id="cidade"
										class="form-control" value="${usuarioLogado.endereco.cidade}"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="bairro">Bairro</label>
								<div class="validateError">
									<input type="text" name="bairro" id="bairro"
										class="form-control" value="${usuarioLogado.endereco.bairro}"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="rua">Rua</label>
								<div class="validateError">
									<input type="text" name="rua" id="rua" class="form-control" value="${usuarioLogado.endereco.rua}"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="numero">Numero</label>
								<div class="validateError">
									<input type="text" name="numero" id="numero"
										class="form-control" value="${usuarioLogado.endereco.numero}"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="complemento">Complemento</label>
								<div class="validateError">
									<input type="text" name="complemento" id="complemento"
										class="form-control" value="${usuarioLogado.endereco.complemento}"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="cep">CEP</label>
								<div class="validateError">
									<input type="text" name="cep" id="cep" class="form-control" value="${usuarioLogado.endereco.cep}"/>
								</div>
							</div>
							 <div class="input-group">
                          <button type="submit" class="btn btn-warning">Trocar</button>
                          </div>
                  </form>
              </div>
           </div>
          </div>
        </div>
		
<%@include file="footer.jsp" %>		








