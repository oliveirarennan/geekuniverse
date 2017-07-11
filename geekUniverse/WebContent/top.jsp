<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="PT-BR">
	<head>
	<meta charset="utf-8"/>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		
		<noscript>Seu navegador não suporta javascript</noscript>
		
		<!--<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />-->
  		<link rel="stylesheet" type="text/css" href="css/estilo.css"/>
	  	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	  	<script type="text/javascript" src="js/rolagem.js"></script>
	  	<script type="text/javascript" src="js/botao.js"></script>

   		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="resources/css/bootstrap.min.css">

		<!-- Optional theme -->
		<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">

		<!-- Latest compiled and minified JavaScript -->
		<script src="resources/js/bootstrap.min.js"></script>

		<!-- Awesome Font bootstrap-->
		 <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous"/> 

 	<style type="text/css">
  		.carousel-inner > .item > 
    		.carousel-inner > .item > a > {
    		}	
  	</style>
		<title>GEEK UNIVERSE</title>
		<link rel="shortcut icon" type="image/x-png" href="img/icone.png">
	</head>
	<body background="img/body.jpg">
		<section>
			<div class="container1" id="inicio">
				<br>
		  		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			    	<!-- Indicators -->
			    	<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					    <li data-target="#myCarousel" data-slide-to="1"></li>
					    <li data-target="#myCarousel" data-slide-to="2"></li>
			    	</ol>
			    	<!-- Wrapper for slides -->
			    	<div class="carousel-inner conf" role="listbox">
			      		<div class="item active">
			        		<img  class="img-responsive" src="img/game.png" alt="Chania">
			      		</div>
			      		<div class="item">
			        		<img class="img-responsive" src="img/Gamesporate.png" alt="Chania">
			      		</div>
			      		<div class="item">
			        		<img class="img-responsive" src="img/prevenda.png" alt="Flower">
			      		</div>
			    	</div>
			    	<!-- Left and right controls -->
			    	<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
			      		<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			      		<span class="sr-only">Previous</span>
			    	</a>
			    	<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
			      		<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			      		<span class="sr-only">Next</span>
			    	</a>
		  		</div>
			</div>
	    	<div>
	      		<img class="img-responsive fundo" src="img/fundo.png" >
	      		<img class="img-responsive logo" src="img/logo.png">
	    	</div>
		</section>
		<header class="menu">
	  		<nav class="navbar navbar-inverse menu">
	  			<div class="container-fluid">
	    			<div class="navbar-header">
	      				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					        <span class="sr-only"></span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
	      				</button>
	    			</div>
	    			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	    				<ul class="nav navbar-nav navbar-left">
	    					<li><a href="index.jsp" ><span class="glyphicon glyphicon-home"></span></a></li>
	    				</ul>
	    				<form class="navbar-form navbar-left" action="ServletBuscaProduto">
	      					<div class="form-group">
	      					
	        					<input class="form-control" type="text" placeholder="Buscar" id="busca" name="busca">
	        					<input type="text" style="display: none;" name="modo" value="1"/>
	        				</div>	
	        				<button class="btn btn-outline-success" type="submit" id="button">Buscar</button>
	        				
	      				</form>
	      				
				      	<ul class="nav navbar-nav" id="nav">
				      	
				        	<li class="dropdown">
	           				<a class="dropdown-toggle" data-toggle="dropdown" href="#" id="drop">Categorias<span class="caret"></span></a>
	           				<jsp:useBean id="ca" class="servico.CategoriaServico"></jsp:useBean>
	           				
	              				<ul class="dropdown-menu" id="atrib">
	              					<c:forEach var="categoria" items="${ca.listarAtivas() }">
							        	<li><a href="ServletBuscaProduto?modo=0&fabricante=0&categoria=${categoria.id}">${categoria.nome}</a></li>
							           
						            </c:forEach>
	              				</ul>
	            			</li>
				        	
				        	<li class="dropdown">
	              			<a class="dropdown-toggle" data-toggle="dropdown" href="#" id="drop">Fabricantes<span class="caret"></span></a>
	              			<jsp:useBean id="fa" class="servico.FabricanteServico"></jsp:useBean>
				            <ul class="dropdown-menu" id="atrib">
				            	<c:forEach var="fabricante" items="${fa.listarAtivado() }">
				            		<li><a href="ServletBuscaProduto?modo=0&categoria=0&fabricante=${fabricante.id}">${fabricante.nome}</a></li>
				            	</c:forEach>	
				                
				              </ul>
				            </li>
				            
				            
	      				</ul>
	      				<div> 
	      					<ul class="nav navbar-nav navbar-right">
	      					<c:choose >
	      						<c:when test="${usuarioLogado == null }">
			      						<li class="dropdown">
					              			<a class="dropdown-toggle" data-toggle="dropdown" href="#" id="drop"><span class="glyphicon glyphicon-user"></span> Login<span class="caret"></span></a>
								            <ul class="dropdown-menu" id="atrib">
								            	<li><a href="#" data-toggle="modal" data-target="#loginModal">Entrar</a></li>
								                <li><a href="cadastrar-usuario.jsp"><strong>Não tem conta? Cadastre-se !</strong></a></li>
						             		 </ul>
						            	</li>
				            	</c:when>
				            	<c:when test="${usuarioLogado ne null }">
				            		<li class="dropdown">
					              			<a class="dropdown-toggle" data-toggle="dropdown" href="#" id="drop"><span class="glyphicon glyphicon-user"></span>Olá,  ${usuarioLogado.nome}<span class="caret"></span></a>
								            <ul class="dropdown-menu" id="atrib">
								            	<li><a href="painel-usuario.jsp" >Meus Dados</a></li>
								            	<li><a href="ServletPedidosUsuario" >Meus Pedidos</a></li>
								            	<c:if test="${usuarioLogado.tipoUsuario ne 'cliente' }">
								                	<li><a href="admin/index.jsp" >Painel de Administração</a></li>
								                </c:if>
								                <li><a href="ServletLogout?logout=true"><strong>Sair</strong></a></li>
						             		 </ul>
						            	</li>
				            	
				            	</c:when>
				            </c:choose>
	      						<c:set var="qtdItens" value="{$ItensCarrinho.item.value}"/>
	      						 <li><a href="carrinho.jsp"><span class="glyphicon glyphicon-shopping-cart"><span class="badge">${ItensCarrinho.size()}</span></span></a></li> 
	    					</ul>
	    				</div><!-- /.navbar-collapse -->
	  				</div><!-- /.container-fluid -->
	  			</div>
			</nav>
		</header>