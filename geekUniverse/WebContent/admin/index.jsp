 <%@ include file="top.jsp" %>
 <title>Pagina de Administração</title>
		<section class="container">
		<div class="jumbotron jumbotron-fluid">
				<div class="row">
					<div
						class=" col-md-4 col-md-offset-4 col-sm-4 col-offset-4 col-xs-4 col-xs-offset-4 col-lg-4 col-lg-offset-4">
						<legend>
							<center>Painel Administrativo</center>
						</legend>
						
						<center>
					<div class="btn-group-vertical">
						<a href="gerenciar-usuarios.jsp">     <button type="button" class="btn btn-warning">Gerenciar Usuários</button></a><br><br>
						<a href="gerenciar-categorias.jsp">   <button type="button" class="btn btn-warning">Gerenciar Categoria</button></a><br><br>
						<a href="gerenciar-fabricantes.jsp">  <button type="button" class="btn btn-warning">Gerenciar Fabricante</button></a><br><br>
						<a href="gerenciar-produtos.jsp">     <button type="button" class="btn btn-warning">Gerenciar Produtos</button></a><br><br>
						<a href="gerenciar-pedidos.jsp">      <button type="button" class="btn btn-warning">Gerenciar Pedidos</button></a> <br><br>
					</div>
						
						</center>
				</div>
			</div>
		</div>
	</section>

  <script src="resources/js/jquery-3.2.1.min.js"></script>
 <%@ include file="footer.jsp" %>
