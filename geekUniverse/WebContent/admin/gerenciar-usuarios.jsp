 <%@ include file="top.jsp" %>
 <title>Gerencia de Usuários</title>
		<div class="fundo col-md-6 col-md-offset-3">
			<br />
			<div class="container-fluid">
				<div class="row">
					<div class=" col-md-12  col-sm-12  col-xs-12  col-lg-12 ">
					
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
							<center>Gerenciar Usuários</center>
						</legend>
						<a href="cadastrar-usuario.jsp" class="btn btn-warning btn-xs">Adicionar
							Usuário</a><a href="index.jsp" class="btn btn-default btn-xs">Voltar</a>
						<br /> <br />

						<table class="table">
							<thead>

								<tr>
									<td><strong>nome</strong></td>
									<td><strong>cidade</strong></td>
									<td><strong>estado</strong></td>
									<td><strong>tipo</strong></td>
									<td><strong>status</strong></td>
									<td><strong>ações</strong></td>

								</tr>

							</thead>
							<tbody>
								<jsp:useBean id="us" class="servico.UsuarioServico"></jsp:useBean>
								<jsp:useBean id="converter" class="util.Util"></jsp:useBean>
								<c:forEach var="usuario" items="${us.listar() }">
									<tr>
										<td>${usuario.nome }</td>
										<td>${usuario.endereco.cidade}</td>
										<td>${usuario.endereco.estado.descricao}</td>
										<td>${usuario.tipoUsuario}</td>
										<td>${converter.converteStatus(usuario.status)}</td>
										<td><a href="../ServletEditarUsuario?id=${usuario.id }"
											class="btn btn-primary btn-xs">Editar</a> <a
											href="../ServletRemoverUsuario?id=${usuario.id }"
											class="btn btn-danger btn-xs">remover</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>


					</div>
				</div>
			</div>
		</div>
	</section>
  <script src="resources/js/jquery-3.2.1.min.js"></script>
 <%@ include file="footer.jsp" %>
