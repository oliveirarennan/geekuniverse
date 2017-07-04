 <%@ include file="top.jsp" %>
 <title>Edição de Usuário</title>
		<div class="fundo col-md-6 col-md-offset-3">
			<br />
			<div class="container-fluid">
				<div class="row">
					<div
						class=" col-md-6 col-md-offset-3 col-sm-6 col-offset-3 col-xs-6 col-xs-offset-3 col-lg-6 col-lg-offset-3">
						<legend>
							<center>Editar Usuário</center>
						</legend>
						<form name="frmCadastrarUsuario" id="frmCadastrarUsuario"
							action="../ServletEditarUsuario" method="POST">
							<div class="form-group">
								<label class="control-label" for="nome">Nome</label>
								<div class="validateError">
									<input type="text" name="nome" id="nome" class="form-control"
										value="${usuario.nome }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="sobrenome">Sobrenome</label>
								<div class="validateError">
									<input type="text" name="sobrenome" id="sobrenome"
										class="form-control" value="${usuario.sobrenome }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="sexo">Sexo</label>
								<div class="validateError">
									<select name="sexo" id="sexo" class="form-control">
										<optgroup>
											<c:if test="${usuario.sexo == 'Masculino'}">
												<option value="Masculino" selected>Masculino</option>
												<option value="Feminino">Feminino</option>
											</c:if>
											<c:if test="${usuario.sexo == 'Feminino'}">
												<option value="Masculino" selected>Masculino</option>
												<option value="Feminino" selected>Feminino</option>
											</c:if>
										</optgroup>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="pais">Pais</label>
								<div class="validateError">
									<input type="text" name="pais" id="pais" class="form-control"
										value="${usuario.endereco.pais }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="estado">Estado</label>
								<div class="validateError">
									<select class="form-control" name="estado" id="estado">
										<jsp:useBean id="cu" class="servico.EstadoServico"></jsp:useBean>
										<optgroup>
											<c:forEach var="estado" items="${cu.listar() }">
												<c:if
													test="${usuario.endereco.estado.descricao == estado.descricao}">
													<option value="${estado.id }" selected>${estado.descricao}</option>
												</c:if>
												<c:if
													test="${usuario.endereco.estado.descricao != estado.descricao}">
													<option value="${estado.id }">${estado.descricao}</option>
												</c:if>
											</c:forEach>
										</optgroup>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="cidade">Cidade</label>
								<div class="validateError">
									<input type="text" name="cidade" id="cidade"
										class="form-control" value="${usuario.endereco.cidade }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="bairro">Bairro</label>
								<div class="validateError">
									<input type="text" name="bairro" id="bairro"
										class="form-control" value="${usuario.endereco.bairro }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="rua">Rua</label>
								<div class="validateError">
									<input type="text" name="rua" id="rua" class="form-control"
										value="${usuario.endereco.rua }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="numero">Numero</label>
								<div class="validateError">
									<input type="text" name="numero" id="numero"
										class="form-control" value="${usuario.endereco.numero }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="complemento">Complemento</label>
								<div class="validateError">
									<input type="text" name="complemento" id="complemento"
										class="form-control" value="${usuario.endereco.complemento }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="cep">CEP</label>
								<div class="validateError">
									<input type="text" name="cep" id="cep" class="form-control"
										value="${usuario.endereco.cep }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="dataNascimento">Data
									de Nascimento</label>
								<div class="validateError">
									<input type="date" name="dataNascimento" id="dataNascimento"
										class="form-control" value="${usuario.dataNascimento }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="celular">Celular</label>
								<div class="validateError">
									<input type="text" name="celular" id="celular"
										class="form-control" value="${usuario.celular }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="telFixo">Telefone Fixo</label>
								<div class="validateError">
									<input type="text" name="telefoneFixo" id="telefoneFixo"
										class="form-control" value="${usuario.telefoneFixo }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="cpf">CPF</label>
								<div class="validateError">
									<input type="text" name="cpf" id="cpf" class="form-control"
										value="${usuario.cpf }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="rg">RG</label>
								<div class="validateError">
									<input type="text" name="rg" id="rg" class="form-control"
										value="${usuario.rg }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="email">Email</label>
								<div class="validateError">
									<input type="text" name="email" id="email" class="form-control"
										value="${usuario.email }" />
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
										<c:if test="${usuario.tipoUsuario ne 'cliente' }">
											<option value="administrador" selected>Administrador</option>
											<option value="cliente">Usuario Comum</option>
										</c:if>
										<c:out value="${usuario.tipoUsuario }" />
										<c:if test="${usuario.tipoUsuario ne 'administrador'}">
											<option value="administrador">Administrador</option>
											<option value="cliente" selected>Usuario Comum</option>
										</c:if>
									</optgroup>
								</select>
							</div>
							<div class="form-group">
								<label class="control-label" for="status">Status</label> <select
									class="form-control" name="status" id="status">
									<optgroup>
										<c:if test="${usuario.status == 1}">
											<option value="true" selected>Ativado</option>
											<option value="false">Desativado</option>
										</c:if>
										<c:if test="${usuario.status == 0}">
											<option value="true">Ativado</option>
											<option value="false" selected>Desativado</option>
										</c:if>
									</optgroup>
								</select>
							</div>
							<div class="form-group">
								<input type="submit" name="btnCadastrar" value="Cadastrar"
									class="btn btn-warning"> <input type="reset"
									name="btnLimpar" value="Limpar" class="btn btn-default" />
							</div>

						</form>
						<a href="gerenciar-usuarios.jsp" class="btn btn-default">Voltar</a>
					</div>
				</div>
			</div>
		</div>
  <script src="resources/js/jquery-3.2.1.min.js" charset="UTF-8"></script>
   <script src="resources/js/validate-editar-usuario.js" charset="UTF-8"></script>
<%@ include file="footer.jsp" %>
