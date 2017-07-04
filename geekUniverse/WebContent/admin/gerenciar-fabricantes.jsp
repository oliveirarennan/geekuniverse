 <%@ include file="top.jsp" %>
 <title>Gerencia de Fabricantes</title>
		<div class="fundo col-md-6 col-md-offset-3">
			<br />
			<div class="container-fluid">
				<div class="row">
					<div
						class=" col-md-8 col-md-offset-2 col-sm-8 col-offset-2 col-xs-8 col-xs-offset-2 col-lg-8 col-lg-offset-2">
						<legend>
							<center>Gerenciar Fabricantes</center>
						</legend>
						<a href="cadastrar-fabricante.jsp" class="btn btn-warning btn-xs">Adicionar
							Fabricante</a><a href="index.jsp" class="btn btn-default btn-xs">Voltar</a>
						<br /> <br />

						<table class="table">
							<thead>

								<tr>
									<td><strong>nome</strong></td>
									<td><strong>cnpj</strong></td>
									<td><strong>status</strong></td>
									<td><strong>ações</strong></td>


								</tr>

							</thead>
							<tbody>
								<jsp:useBean id="fa" class="servico.FabricanteServico"></jsp:useBean>
								<jsp:useBean id="converter" class="util.Util"></jsp:useBean>
								<c:forEach var="fabricante" items="${fa.listar() }">
									<tr>
										<td>${fabricante.nome}</td>
										<td>${fabricante.cnpj }</td>
										<td>${converter.converteStatus(fabricante.status)}</td>
										<td><a
											href="../ServletEditarFabricante?id=${fabricante.id }"
											class="btn btn-primary btn-xs">Editar</a> <a
											href="../ServletRemoverFabricante?id=${fabricante.id }"
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
