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
		<!--<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />-->
  		<link rel="stylesheet" type="text/css" href="css/estilo.css"/>
	  	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	  	<script type="text/javascript" src="js/rolagem.js"></script>
	  	<script type="text/javascript" src="js/botao.js"></script>

   		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity=sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

		<!-- Awesome Font bootstrap-->
		<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

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
			        		<img  class="img-responsive" src="img/pesquisa.jpg" alt="Chania">
			      		</div>
			      		<div class="item">
			        		<img class="img-responsive" src="http://via.placeholder.com/2048x500" alt="Chania">
			      		</div>
			      		<div class="item">
			        		<img class="img-responsive" src="http://via.placeholder.com/2048x500" alt="Flower">
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
	    				<form class="navbar-form navbar-left">
	      					<div class="form-group">
	      					
	        					<input class="form-control" type="text" placeholder="Search" id="input">
	        				</div>	
	        				<button class="btn btn-outline-success" type="submit" id="button">Search</button>
	        				
	      				</form>
	      				
				      	<ul class="nav navbar-nav" id="nav">
				      	
				        	<li class="dropdown">
	           				<a class="dropdown-toggle" data-toggle="dropdown" href="#" id="drop">Categorias<span class="caret"></span></a>
	           				<jsp:useBean id="ca" class="servico.CategoriaServico"></jsp:useBean>
	           				
	              				<ul class="dropdown-menu" id="atrib">
	              					<c:forEach var="categoria" items="${ca.listarAtivas() }">
							        	<li><a href="ServletProdutosCategoria?id=${categoria.id}">${categoria.nome}</a></li>
							           
						            </c:forEach>
	              				</ul>
	            			</li>
				        	
				        	<li class="dropdown">
	              			<a class="dropdown-toggle" data-toggle="dropdown" href="#" id="drop">Fabricantes<span class="caret"></span></a>
	              			<jsp:useBean id="fa" class="servico.FabricanteServico"></jsp:useBean>
				            <ul class="dropdown-menu" id="atrib">
				            	<c:forEach var="fabricante" items="${fa.listarAtivado() }">
				            		<li><a href="ServletProdutosFabricante?id=${fabricante.id}">${fabricante.nome}</a></li>
				            	</c:forEach>	
				                
				              </ul>
				            </li>
				            
				            <li class="dropdown">
	              			<a class="dropdown-toggle" data-toggle="dropdown" href="#" id="drop">DROP1<span class="caret"></span></a>
				            <ul class="dropdown-menu" id="atrib">
				            	<li><a href="#">atributo1</a></li>
				                <li><a href="#">atributo2</a></li>
				                <li><a href="#">atributo3</a></li>
				                <li><a href="#">atributo4</a></li>
				                <li><a href="#">atributo5</a></li>
				              </ul>
				            </li>
	      				</ul>
	      				<div> 
	      					<ul class="nav navbar-nav navbar-right">
	      						<li><a href="#"><span class="glyphicon glyphicon-user"  id="drop"></span> Minha Conta</a></li>
	      						<c:set var="qtdItens" value="{$ItensCarrinho.item.value}"/>
	      						 <li><a href="carrinho.jsp"><span class="glyphicon glyphicon-shopping-cart"><span class="badge">${ItensCarrinho.size()}</span></span></a></li> 
	    					</ul>
	    				</div><!-- /.navbar-collapse -->
	  				</div><!-- /.container-fluid -->
	  			</div>
			</nav>
		</header>