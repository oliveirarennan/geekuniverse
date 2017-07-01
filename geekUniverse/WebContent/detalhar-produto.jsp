<%@include file="top.jsp" %>
		
		<section class="container-fluid">
			<div class="row">
				<div class="col-md-8 col-md-offset-2" style="background-color: rgba(255, 255, 255, 0.8); margin-top: 5%; margin-bottom: 5%; padding: 3% 3% 3% 3%;">
					
					<strong>${produtoSelecionado.nome}</strong>
					<br>
					<div class="thumbnail">
				    	<img src="imagens-produtos/${produtoSelecionado.imagem}" alt="Imagem de ${produtoSelecionado.nome }" width="300" height="300">
				    </div>
					<p>${produtoSelecionado.descricao}</p>
					<br>
					
					<p>R$ ${produtoSelecionado.valor }</p>
					<br>
					<br>
					<a href="ServletAdicionarAoCarrinho?id=${produtoSelecionado.id }" class="btn btn-default">Adicionar no Carrinho</a>
					
					 
				</div>
					
			</div>
		</section>
<%@include file="footer.jsp" %>		








