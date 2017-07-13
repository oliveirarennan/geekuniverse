 <%@ include file="top.jsp" %>
 <title>Edição de Categoria</title>
		<div class="container">
			<br />
			
				<div class="row">
					<div
						class="jumbotron col-md-6 col-md-offset-3 col-sm-6 col-offset-3 col-xs-6 col-xs-offset-3 col-lg-6 col-lg-offset-3">
						<c:choose>
							<c:when test="${param.categoria == 'sucesso' }">
								<div class="alert alert-success alert-dismissible" role="alert">
									  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
									  <strong>Sucesso!</strong> ${msgStatus}
								</div>
							</c:when>
							<c:when test="${param.categoria == 'erro' }">
								<div class="alert alert-danger alert-dismissible" role="alert">
									  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
									  <strong>Erro!</strong> ${msgStatus}
								</div>
							</c:when>
						</c:choose>
						
						<legend>
						<legend>
							<center>Editar Categoria</center>
						</legend>
						<form name="frmCadastrarCategoria" id="frmCadastrarCategoria"
							action="../ServletEditarCategoria" method="POST">
							<div class="form-group">
								<label class="control-label" for="nome">Nome</label>
								<div class="validateError">
									<input type="text" name="nome" id="nome" class="form-control"
										value="${categoria.nome }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="status">Status</label>
								<div class="validateError">
									<select class="form-control" name="status" id="status">
										<optgroup>
											<c:if test="${categoria.status == 1}">
												<option value="true" selected>Ativado</option>
												<option value="false">Desativado</option>
											</c:if>
											<c:if test="${categoria.status == 0}">
												<option value="true">Ativado</option>
												<option value="false" selected>Desativado</option>
											</c:if>

										</optgroup>
									</select>
								</div>
							</div>
							<div class="form-group">
								<input type="submit" name="btnCadastrar" value="Cadastrar"
									class="btn btn-warning"> <input type="reset"
									name="btnLimpar" value="Limpar" class="btn btn-default" />
							</div>
						</form>
						<a href="gerenciar-categorias.jsp" class="btn btn-default">Voltar</a>
					</div>

				</div>
			</div>
		
	</section>
  <script src="resources/js/jquery-3.2.1.min.js" charset="UTF-8"></script>
   <script src="resources/js/validate-cadastrar-categoria.js" charset="UTF-8"></script>
 <%@ include file="footer.jsp" %>
