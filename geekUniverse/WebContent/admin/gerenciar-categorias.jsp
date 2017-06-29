<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="resources/css/estilo.css"/>
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Gerenciar Categorias</title>

    <!-- Bootstrap -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
 
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via fsile:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
    <body background="img/">
  <section>
  <nav class="navbar navbar-inverse" id="nav">
    <div>
      <img class="img-responsive" src="resources/images/novo2.png" id="logo">
    </div>
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>                        
          </button>
        </div>
      </div>
        <div class="collapse navbar-collapse" id="myNavbar top2">
          <ul class="nav navbar-nav"> 
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
            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="drop">DROP2<span class="caret"></span></a>
              <ul class="dropdown-menu" id="atrib">
                <li><a href="#">atributo1</a></li>
                <li><a href="#">atributo2</a></li>
                <li><a href="#">atributo3</a></li>
                <li><a href="#">atributo4</a></li>
                <li><a href="#">atributo5</a></li>
              </ul>
            </li>
            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="drop">DROP3<span class="caret"></span></a>
              <ul class="dropdown-menu" id="atrib">
                <li><a href="#">atributo1</a></li>
                <li><a href="#">atributo2</a></li>
                <li><a href="#">atributo3</a></li>
                <li><a href="#">atributo4</a></li>
                <li><a href="#">atributo5</a></li>
              </ul>
            </li>
            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="drop">DROP4<span class="caret"></span></a>
                <ul class="dropdown-menu" id="atrib">
                    <li><a href="#">atributo1</a></li>
                    <li><a href="#">atributo2</a></li>
                    <li><a href="#">atributo3</a></li>
                    <li><a href="#">atributo4</a></li>
                    <li><a href="#">atributo5</a></li>
                </ul>
            </li>
            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="drop">DROP5<span class="caret"></span></a>
              <ul class="dropdown-menu" id="atrib">
                <li><a href="#">atributo1</a></li>
                <li><a href="#">atributo2</a></li>
                <li><a href="#">atributo3</a></li>
                <li><a href="#">atributo4</a></li>
                <li><a href="#">atributo5</a></li>
              </ul>
            </li>
          </ul>
          </div>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-user" id="drop"></span> Minha Conta</a></li> 
          </ul>

          <div>
             <form>
                <input class="form-control" type="text" placeholder="Search" id="input">
               <button class="btn btn-outline-success" type="submit" id="button">Search</button>
             </form>
          </div>
  </nav>
  <div class="fundo col-md-6 col-md-offset-3">
    <br/>
      <div class="container-fluid">
          <div class="row">
            <div class=" col-md-8 col-md-offset-2 col-sm-8 col-offset-2 col-xs-8 col-xs-offset-2 col-lg-8 col-lg-offset-2">
              <legend><center>Gerenciar Categorias</center></legend>
              <a href="cadastrar-categoria.jsp" class="btn btn-warning btn-xs">Adicionar Categoria</a><a href="index.jsp" class="btn btn-default btn-xs">Voltar</a>
              <br />
              <br />
              
              <table class="table">
              	<thead>
              	
              		<tr>
              			<td><strong>nome</strong></td>
              			<td><strong>status</strong></td>
              			<td><strong>ações</strong></td>
              			
              		</tr>
              		
              	</thead>
              	<tbody>
              	<jsp:useBean id="ca" class="servico.CategoriaServico"></jsp:useBean>
              	<jsp:useBean id="converter" class="util.Util"></jsp:useBean>
              	<c:forEach var="categoria" items="${ca.listar() }">
              		<tr>
              			<td>${categoria.nome}</td>
              			<td>${converter.converteStatus(categoria.status)}</td>
              			<td><a href="../ServletEditarCategoria?id=${categoria.id }" class="btn btn-primary btn-xs">Editar</a>  <a href="../ServletRemoverCategoria?id=${categoria.id }" class="btn btn-danger btn-xs">remover</a>  </td>
              		</tr>
              		</c:forEach>
              	</tbody>
              </table>
              
                    
            </div>   
          </div>
      </div>   
  </div>
</section>

      
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="resources/js/jquery-3.2.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/jquery.maskMoney.min.js"></script>
    <script src="resources/js/jquery.validate.min.js"></script>
    <script src="resources/js/additional-methods.min.js"></script>
    <script src="resources/js/ConfiguracaoMaskMoney.js"></script>
    <script src="resources/js/validate-cadastrar-categoria.js"></script>
    <script src="resources/js/jquery.maskedinput.min.js"></script>
    <script src="resources/js/ConfiguracaoMaskInput.js"></script>
    <script src="resources/js/scripts.js"></script>
  </body>
</html> 