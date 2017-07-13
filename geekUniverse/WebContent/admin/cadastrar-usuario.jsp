 <%@ include file="top.jsp" %>
 <title>Cadastro de Usuários</title>
		<div class="container">
			<br />
			
				<div class="row">
					<div
						class=" jumbotron col-md-10 col-md-offset-1 col-sm-10 col-offset-1 col-xs-10 col-xs-offset-1 col-lg-10 col-lg-offset-1">
						
						
						
						<c:choose>
							<c:when test="${param.usuario == 'sucesso' }">
								<div class="alert alert-success alert-dismissible" role="alert">
									  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
									  <strong>Sucesso!</strong> ${msgStatus}
								</div>
							</c:when>
							<c:when test="${param.usuario == 'erro' }">
								<div class="alert alert-danger alert-dismissible" role="alert">
									  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
									  <strong>Erro!</strong> ${msgStatus}
								</div>
							</c:when>
						</c:choose>
						
						<legend>
							<center>Cadastrar Usuario</center>
						</legend>
						
						<form name="frmCadastrarUsuario" id="frmCadastrarUsuario"
							action="../ServletCadastrarUsuario" method="POST">
							<div class="form-group">
								<label class="control-label" for="nome">Nome</label>
								<div class="validateError">
									<input type="text" name="nome" id="nome" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="sobrenome">Sobrenome</label>
								<div class="validateError">
									<input type="text" name="sobrenome" id="sobrenome"
										class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="sexo">Sexo</label>
								<div class="validateError">
									<select name="sexo" id="sexo" class="form-control">
										<optgroup>
											<option value="Masculino">Masculino</option>
											<option value="Feminino">Feminino</option>
										</optgroup>
									</select>
								</div>
							</div>
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
										class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="bairro">Bairro</label>
								<div class="validateError">
									<input type="text" name="bairro" id="bairro"
										class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="rua">Rua</label>
								<div class="validateError">
									<input type="text" name="rua" id="rua" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="numero">Numero</label>
								<div class="validateError">
									<input type="text" name="numero" id="numero"
										class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="complemento">Complemento</label>
								<div class="validateError">
									<input type="text" name="complemento" id="complemento"
										class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="cep">CEP</label>
								<div class="validateError">
									<input type="text" name="cep" id="cep" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="dataNascimento">Data
									de Nascimento</label>
								<div class="validateError">
									<input type="date" name="dataNascimento" id="dataNascimento"
										class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="celular">Celular</label>
								<div class="validateError">
									<input type="text" name="celular" id="celular"
										class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="telFixo">Telefone Fixo</label>
								<div class="validateError">
									<input type="text" name="telefoneFixo" id="telefoneFixo"
										class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="cpf">CPF</label>
								<div class="validateError">
									<input type="text" name="cpf" id="cpf" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="rg">RG</label>
								<div class="validateError">
									<input type="text" name="rg" id="rg" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="email">Email</label>
								<div class="validateError">
									<input type="text" name="email" id="email" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="senha">Senha</label>
								<div class="validateError">
									<input type="password" name="senha" id="senha"
										class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="tipoUsuario">Contas</label> <select
									class="form-control" name="tipoUsuario" id="tipoUsuario">
									<optgroup>
										<option value="administrador" selected>Administrador</option>
										<option value="cliente">Usuario Comum</option>
									</optgroup>
								</select>
							</div>
							<div class="form-group">
								<label class="control-label" for="status">Status</label> <select
									class="form-control" name="status" id="status">
									<optgroup>
										<option value="true">Ativado</option>
										<option value="false">Desativado</option>
									</optgroup>
								</select>
							</div>
							<div class="form-group">
								<input type="submit" name="btnCadastrar" value="Cadastrar"
									class="btn btn-warning"> <input type="reset"
									name="btnLimpar" value="Limpar" class="btn btn-default" />
							</div>
							
							 <div class="form-group">
						   		<a href="gerenciar-usuarios.jsp" class="btn btn-default">Voltar</a>
						   </div>
						</form>
					</div>
				</div>
			</div>
		
	
  <script src="resources/js/jquery-3.2.1.min.js" charset="UTF-8"></script>
   <script src="resources/js/validate-cadastrar-usuario.js" charset="UTF-8"></script>
 <%@ include file="footer.jsp" %>
