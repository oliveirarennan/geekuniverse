 <%@ include file="top.jsp" %>
 <title>Gerencia de Categorias</title>
		<div class="fundo col-md-6 col-md-offset-3">
			<br />
			<div class="container-fluid">
				<div class="row">
					<div
						class=" col-md-8 col-md-offset-2 col-sm-8 col-offset-2 col-xs-8 col-xs-offset-2 col-lg-8 col-lg-offset-2">
						<legend>
							<center>Gerenciar Categorias</center>
						</legend>
						<a href="cadastrar-categoria.jsp" class="btn btn-warning btn-xs">Adicionar
							Categoria</a><a href="index.jsp" class="btn btn-default btn-xs">Voltar</a>
						<br /> <br />

						<table class="table">
							<thead>

								<tr>
									<td><strong>nome</strong></td>
									<td><strong>status</strong></td>
									<td><strong>a��es</strong></td>

								</tr>

							</thead>
							<tbody>
								<jsp:useBean id="ca" class="servico.CategoriaServico"></jsp:useBean>
								<jsp:useBean id="converter" class="util.Util"></jsp:useBean>
								<c:forEach var="categoria" items="${ca.listar() }">
									<tr>
										<td>${categoria.nome}</td>
										<td>${converter.converteStatus(categoria.status)}</td>
										<td><a
											href="../ServletEditarCategoria?id=${categoria.id }"
											class="btn btn-primary btn-xs">Editar</a> <a
											href="../ServletRemoverCategoria?id=${categoria.id }"
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

 <script src="resources/js/jquery-3.2.1.min.js" charset="UTF-8"></script>
 <%@ include file="footer.jsp" %>