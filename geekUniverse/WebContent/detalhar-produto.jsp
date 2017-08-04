<%@include file="top.jsp" %>
		
		<section class="container-fluid">
			<div class="row">
				<div class="col-md-8 col-md-offset-2" style="background-color: rgba(42, 42, 42, 0.9); margin-top: 5%; margin-bottom: 5%; padding: 3% 3% 3% 3%; color:#fff;">
					
					<h1><center>${produtoSelecionado.nome}</center></h1>
					<hr>
					<br>
					<div class="col-md-4">
				    	<img src="imagens-produtos/${produtoSelecionado.imagem}" class="img-responsive" alt="Imagem de ${produtoSelecionado.nome }" width="300" height="300" margin-left="-5%">
				    </div>
					<h4>Descrição : ${produtoSelecionado.descricao}</h4>
					<hr>
					<br>
					<h4>Categoria : ${produtoSelecionado.categoria.nome}</h4>
					<br>
					<h4>Fabricante : ${produtoSelecionado.fabricante.nome}</h4>
					<fmt:setLocale value="pt_br"/>
					<br>
					<h4><fmt:formatNumber value="${produtoSelecionado.valor}" type="currency"/></h4>
					<br>
					<br>
					<a href="ServletAdicionarAoCarrinho?id=${produtoSelecionado.id }" class="botao">Adicionar no Carrinho</a>
				</div>
					
			</div>
		</section>
<%@include file="footer.jsp" %>		

