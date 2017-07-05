 <%@ include file="top.jsp" %>
 <title>Edi��o de Fabricante</title>
		<div class="fundo col-md-6 col-md-offset-3">
			<br />
			<div class="container-fluid">
				<div class="row">
					<div
						class=" col-md-6 col-md-offset-3 col-sm-6 col-offset-3 col-xs-6 col-xs-offset-3 col-lg-6 col-lg-offset-3">
						<legend>
							<center>Editar Fabricante</center>
						</legend>
						<form name="frmCadastrarFabricante" id="frmCadastrarFabricante"
							action="../ServletEditarFabricante" method="POST">
							<div class="form-group">
								<label class="control-label" for="nome">Nome</label>
								<div class="validateError">
									<input type="text" name="nome" id="nome" class="form-control"
										value="${fabricante.nome }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="cnpj">CNPJ</label>
								<div class="validateError">
									<input type="text" name="cnpj" id="cnpj" class="form-control"
										value="${fabricante.cnpj }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="status">Status</label>
								<div class="validateError">
									<select class="form-control" name="status" id="status">
										<optgroup>
											<c:if test="${fabricante.status == 1}">
												<option value="true" selected>Ativado</option>
												<option value="false">Desativado</option>
											</c:if>
											<c:if test="${fabricante.status == 0}">
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
						<a href="gerenciar-fabricantes.jsp" class="btn btn-default">Voltar</a>
					</div>
				</div>
			</div>
		</div>
	</section>

  <script src="resources/js/jquery-3.2.1.min.js" charset="UTF-8"></script>
   <script src="resources/js/validate-cadastrar-fabricante.js" charset="UTF-8"></script>
 <%@ include file="footer.jsp" %>