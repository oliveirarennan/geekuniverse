<%@include file="top.jsp" %>
		<section class="container-fluid">
			<div class="col-md-3 tipo1">
			
				<img src="img/novidades.jpg" class="img-responsive"> 
			<jsp:useBean id="pr" class="servico.ProdutoServico"></jsp:useBean>
			<jsp:useBean id="converter" class="util.Util"></jsp:useBean>
			 	
			</div>
			<div class="gamb col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xs-8 col-xs-offset-2 col-lg-8 col-lg-offset-2">
				<c:forEach var="produto" items="${pr.listarUltimosCadastrados() }">
				<div class="col-md-3">
		        	<div class="thumbnail">
		        	<fmt:setLocale value="pt_br"/>
				    	<img src="imagens-produtos/${produto.imagem}" alt="Paris" width="300" height="300">
				        <center><p><strong>${produto.nome} </strong></p></center>
				        <center><p><i><fmt:formatNumber value="${produto.valor}" type="currency"/></i></p></center>
				        <center><a href="ServletDetalharProduto?id=${produto.id }" class="btn">Ver Detalhes</a></center> 
				    </div>
		      	</div>
		      	</c:forEach>
		      	
			</div>
			<!-- Divs da IMAGEM central e do tipo de venda seguinte -->
			<div class="col-md-10 col-md-offset-2">
		   		<img src="img/voorgamers.jpg" class="img-responsive img">
		  	</div>
	  		<div class="col-md-3 tipo">
				<img src="img/teste.jpg" class="img-responsive"> 
			</div>
			<!-- //Divs da IMAGEM central e do tipo de venda seguinte -->
			<div class="gamb col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xs-8 col-xs-offset-2 col-lg-8 col-lg-offset-2">
				<c:forEach var="produto" items="${pr.listarQuadrinhos() }">
				<div class="col-md-3">
		        	<div class="thumbnail">
		        	<fmt:setLocale value="pt_br"/>
				    	<img src="imagens-produtos/${produto.imagem}" alt="Paris" width="300" height="300">
				        <center><p><strong>${produto.nome} </strong></p></center>
				        <center><p><i><fmt:formatNumber value="${produto.valor}" type="currency"/></i></p></center>
				        <center><a href="ServletDetalharProduto?id=${produto.id }" class="btn">Ver Detalhes</a></center> 
				    </div>
		      	</div>
		      	</c:forEach>
		      	
			</div>
				<div class="col-md-3 tipo">
				<img src="img/teste2.jpg" class="img-responsive"> 
			</div>
			<!-- //Divs da IMAGEM central e do tipo de venda seguinte -->
			<div class="gamb col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xs-8 col-xs-offset-2 col-lg-8 col-lg-offset-2">
				<c:forEach var="produto" items="${pr.listarLivros() }">
				<div class="col-md-3">
		        	<div class="thumbnail">
		        	<fmt:setLocale value="pt_br"/>
				    	<img src="imagens-produtos/${produto.imagem}" alt="Paris" width="300" height="300">
				        <center><p><strong>${produto.nome} </strong></p></center>
				        <center><p><i><fmt:formatNumber value="${produto.valor}" type="currency"/></i></p></center>
				        <center><a href="ServletDetalharProduto?id=${produto.id }" class="btn">Ver Detalhes</a></center> 
				    </div>
		      	</div>
		      	</c:forEach>
		      		
			
		      	
			</div>
				
		</section>
<%@include file="footer.jsp" %>		








