<%@ include file="verificar-login.jsp" %> 
<%@include file="top.jsp" %>
		<title>Painel do Usuário</title>
		<section class="container-fluid">
			<div class="row">
				<div class="col-md-6 col-md-offset-3" style="background-color: rgba(255, 255, 255, 0.8); margin-top: 5%; margin-bottom: 5%; padding: 3% 3% 3% 3%;">
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
									  <strong>Erro!</strong>${msgStatus}
								</div>
							</c:when>
						</c:choose>
					<legend>Dados Pessoais</legend>
						<div class="col-md-4 col-md-offset-4" style="color: rgba(192, 77, 22, 1);">
							<strong>Nome :</strong> ${usuarioLogado.nome} <br />
							<strong>Sobrenome :</strong> ${usuarioLogado.sobrenome}<br />
							<strong>Sexo :</strong> ${usuarioLogado.sexo}<br />
							<strong>Data de Nascimento :</strong>${usuarioLogado.dataNascimento}<br />
							<strong>Celular :</strong> ${usuarioLogado.celular}<br />
							<strong>Telefone Fixo :</strong> ${usuarioLogado.telefoneFixo}<br />
							<strong>CPF :</strong>${usuarioLogado.cpf}<br />
							<strong>RG :</strong>${usuarioLogado.rg}<br />
							<strong>E-mail :</strong>${usuarioLogado.email}<br />
							<br />
							<a href="#" data-toggle="modal" data-target="#usuarioModal" class="btn btn-warning">Editar</a>
							
						</div>	
						
						
						
					<legend>Endereço</legend>
						<div class="col-md-4 col-md-offset-4" style="color: rgba(192, 77, 22, 1);">
							<strong>País :</strong>${usuarioLogado.endereco.pais}<br />
							<strong>Estado :</strong>${usuarioLogado.endereco.estado.descricao}<br />
							<strong>Rua :</strong>${usuarioLogado.endereco.rua}<br />
							<strong>Número :</strong>${usuarioLogado.endereco.numero}<br />
							<strong>Complemento :</strong>${usuarioLogado.endereco.complemento}<br />
							<strong>Bairro :</strong>${usuarioLogado.endereco.bairro}<br />
							<strong>Cidade :</strong>${usuarioLogado.endereco.cidade}<br />
							<strong>CEP :</strong>${usuarioLogado.endereco.cep}<br />
							<br/>
							<a href="#" data-toggle="modal" data-target="#enderecoModal" class="btn btn-warning">Editar</a>
						</div>	
					
					</div>
				</div>
							
		</section>
		
		<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" id="enderecoModal">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Trocar Endereço</h4>
              </div>
              <div class="modal-body">
                 <form action="ServletEditarEndereco" method="POST" >
                 	<div class="form-group" style="display: none;">
								
									<input type="text" name="id" id="id" class="form-control" value="${usuarioLogado.endereco.id }"/>
									<input type="text" name="compra" id="compra" class="form-control" value="2"/>
								
							</div>
                      <div class="form-group">
								<label class="control-label" for="pais">Pais</label>
								<div class="validateError">
									<input type="text" name="pais" id="pais" class="form-control" value="${usuarioLogado.endereco.pais }"/>
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
        
        
        <!-- Modal  Usuario  -->
        
        <div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" id="usuarioModal">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Alterar Dados Pessoais</h4>
              </div>
              <div class="modal-body">
                 <form action="ServletEditarUsuario" method="POST" >
                 			<div class="form-group" style="display: none;">
									<input type="text" name="id" id="id" class="form-control" value="${usuarioLogado.id }"/>
									<input type="text" name="compra" id="compra" class="form-control" value="2"/>
							</div>
							<div class="form-group">
								<label class="control-label" for="nome">Nome</label>
								<div class="validateError">
									<input type="text" name="nome" id="nome" class="form-control"
										value="${usuarioLogado.nome }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="sobrenome">Sobrenome</label>
								<div class="validateError">
									<input type="text" name="sobrenome" id="sobrenome"
										class="form-control" value="${usuarioLogado.sobrenome }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="sexo">Sexo</label>
								<div class="validateError">
									<select name="sexo" id="sexo" class="form-control">
										<optgroup>
											<c:if test="${usuarioLogado.sexo == 'Masculino'}">
												<option value="Masculino" selected>Masculino</option>
												<option value="Feminino">Feminino</option>
											</c:if>
											<c:if test="${usuarioLogado.sexo == 'Feminino'}">
												<option value="Masculino" selected>Masculino</option>
												<option value="Feminino" selected>Feminino</option>
											</c:if>
										</optgroup>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="dataNascimento">Data
									de Nascimento</label>
								<div class="validateError">
									<input type="date" name="dataNascimento" id="dataNascimento"
										class="form-control" value="${usuarioLogado.dataNascimento }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="celular">Celular</label>
								<div class="validateError">
									<input type="text" name="celular" id="celular"
										class="form-control" value="${usuarioLogado.celular }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="telFixo">Telefone Fixo</label>
								<div class="validateError">
									<input type="text" name="telefoneFixo" id="telefoneFixo"
										class="form-control" value="${usuarioLogado.telefoneFixo }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="cpf">CPF</label>
								<div class="validateError">
									<input type="text" name="cpf" id="cpf" class="form-control"
										value="${usuarioLogado.cpf }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="rg">RG</label>
								<div class="validateError">
									<input type="text" name="rg" id="rg" class="form-control"
										value="${usuarioLogado.rg }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="email">Email</label>
								<div class="validateError">
									<input type="text" name="email" id="email" class="form-control"
										value="${usuarioLogado.email }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="senha">Senha</label>
								<div class="validateError">
									<input type="password" name="senha" id="senha"
										class="form-control" />
								</div>
							</div>
                      
							<div class="input-group">
                         		 <button type="submit" class="btn btn-warning">Alterar</button>
                          </div>
                  </form>
              </div>
           </div>
          </div>
        </div>
		
<%@include file="footer.jsp" %>		








