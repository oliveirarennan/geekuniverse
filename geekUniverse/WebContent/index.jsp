<%@include file="top.jsp" %>
		<section class="container-fluid">
			<div class="col-md-3 tipo1">
			
				<img src="img/produtos.jpg" class="img-responsive"> 
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
				        <center><button class="btn"><a href="ServletDetalharProduto?id=${produto.id }">Ver Detalhes</a></button></center> 
				    </div>
		      	</div>
		      	</c:forEach>
		      	<!-- 
				<div class="col-md-3">
				    <div class="thumbnail">
				        <img src="http://via.placeholder.com/300x300" alt="New York" width="300" height="300">
				        <center><p><strong>Produto 2</strong></p></center>
				        <center><button class="btn"><a href="index1.html">Ver Detalhes</a></button>
				    </div><
				</div>
			    <div class="col-md-3">
			        <div class="thumbnail">
		          		<img src="http://via.placeholder.com/300x300" alt="San Francisco" width="300" height="300">
		          		<center><p><strong>Produto 3</strong></p></center>
		          		<center><button class="btn"><a href="index1.html">Ver Detalhes</a></button></center>
			        </div>
			    </div>
		      	<div class="col-md-3">
		        	<div class="thumbnail">
	          			<img src="http://via.placeholder.com/300x300" alt="San Francisco" width="300" height="300">
	          			<center><p><strong>Produto 4</strong></p></center>
	          			<center><button class="btn"><a href="index1.html">Ver Detalhes</a></button></center>
		        	</div>
		      	</div>
		      	 -->
			</div>
			<!-- Divs da IMAGEM central e do tipo de venda seguinte -->
			<div class="col-md-10 col-md-offset-2">
		   		<img src="img/voorgamers.jpg" class="img-responsive img">
		  	</div>
	  		<div class="col-md-3 tipo">
				<img src="http://via.placeholder.com/260x50" class="img-responsive"> 
			</div>
			<!-- //Divs da IMAGEM central e do tipo de venda seguinte -->
			<div class="gamb col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xs-8 col-xs-offset-2 col-lg-8 col-lg-offset-2">
				<div class="col-md-3">
		        	<div class="thumbnail">
				    	<img src="img/grand.jpg" alt="Paris" width="300" height="300">
				        <center><p><strong>Produto 1</strong></p></center>
				        <center><button class="btn"><a href="index1.html">Ver Detalhes</a></button></center>
				    </div>
		      	</div>
				<div class="col-md-3">
				    <div class="thumbnail">
				        <img src="img/nba.png" alt="New York" width="300" height="300">
				        <center><p><strong>Produto 2</strong></p></center>
				        <center><button class="btn"><a href="index1.html">Ver Detalhes</a></button></center>
				    </div>
				</div>
			    <div class="col-md-3">
			        <div class="thumbnail">
		          		<img src="img/mortal.jpg" alt="San Francisco" width="300" height="300">
		          		<center><p><strong>Produto 3</strong></p></center>
		          		<center><button class="btn"><a href="index1.html">Ver Detalhes</a></button></center>
			        </div>
			    </div>
		      	<div class="col-md-3">
		        	<div class="thumbnail">
	          			<img src="img/uncharted.jpg" alt="San Francisco" width="300" height="300">
	          			<center><p><strong>Produto 4</strong></p></center>
	          			<center><button class="btn"><a href="index1.html">Ver Detalhes</a></button></center>
		        	</div>
		      	</div>
			</div>
		</section>
<%@include file="footer.jsp" %>		








