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
    <title>Editar de Produtos</title>

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
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-user" id="drop"></span> Minha Conta</a></li> 
          </ul>
		</div>
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
            <div class=" col-md-6 col-md-offset-3 col-sm-6 col-offset-3 col-xs-6 col-xs-offset-3 col-lg-6 col-lg-offset-3">
              <legend><center>Editar Produto</center></legend>
              
              <form name="frmCadastrarProduto" id="frmCadastrarProduto" action="../ServletEditarProduto" method="POST" enctype="multipart/form-data">
                <div class="form-group">
                  <label class="control-label" for="nome">Nome</label>
                  <div class="validateError">
                    <input type="text" name="nome" id="nome" class="form-control" value="${produto.nome }"/>
                  </div>  
                </div>   
                <div class="form-group">
                  <label class="control-label" for="descricao">Descrição</label>
                  <div class="validateError">
                    <input type="text" name="descricao" id="descricao" class="form-control" value="${produto.descricao }"/>
                  </div>  
                </div>
                <div class="form-group">
                  <label class="control-label" for="valor">Valor</label>
                  <div class="validateError">
                    <input type="text" name="valor" id="valor" class="form-control" value="${produto.valor }"/>
                  </div>  
                </div>
                 <div class="form-group">
                  <label class="control-label" for="estoque">Estoque</label>
                  <div class="validateError">
                    <input type="text" name="estoque" id="estoque" class="form-control" value="${produto.estoque }"/>
                  </div>  
                </div>
                <div class="form-group">
                  <label class="control-label" for="categoria">Categoria</label>
                  <div class="validateError">
                  <select class="form-control" name="categoria" id="categoria">
                  <jsp:useBean id="ca" class="servico.CategoriaServico"></jsp:useBean>
                  
                      <optgroup>
                   		<c:forEach var="categoria" items="${ca.listarAtivada() }">
                   			<option value="${categoria.id }" <c:if test="${categoria.id == produto.categoria.id }"><c:out value="selected"/></c:if>>${categoria.nome}</option>
                      </c:forEach>
                      </optgroup>
                    </select>
                  </div>  
                </div>
                
                <div class="form-group">
                  <label class="control-label" for="fabricante">Fabricante</label>
                  <div class="validateError">
                  <select class="form-control" name="fabricante" id="fabricante">
                  <jsp:useBean id="fa" class="servico.FabricanteServico"></jsp:useBean>
                  
                      <optgroup>
                   		<c:forEach var="fabricante" items="${fa.listarAtivado() }">
                   			<option value="${fabricante.id }" <c:if test="${fabricante.id == produto.fabricante.id }"><c:out value="selected"/></c:if>>${fabricante.nome}</option>
                      </c:forEach>
                      </optgroup>
                    </select>
                  </div>  
                </div>
                
                <div class="input-group">
	                <label class="input-group-btn">
	                    <span class="btn btn-warning">
	                        Escolher Imagem <input type="file" accept="image/jpeg; image/png" style="display: none;" name="arquivo" id="arquivo" >
	                    </span>
	                </label>
	                <div class="validateError">
	                	<input type="text" class="form-control" readonly name="imagem" id="imagem">
	                </div>	
            </div>
                <br/>
                <div class="form-group">
		              <input type="submit" name="btnCadastrar" value="Cadastrar" class="btn btn-warning">
		              <input type="reset" name="btnLimpar" value="Limpar" class="btn btn-default"/>
                </div>
              </form> 
                   <a href="gerenciar-produtos.jsp" class="btn btn-default">Voltar</a>    
            </div>   
          </div>
      </div>   
  </div>
</section>

      
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="resources/js/jquery-3.2.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="resources/js/bootstrap.min.js"></script>
   <!--  <script src="resources/js/jquery.maskMoney.min.js"></script> -->
    <script src="resources/js/jquery.validate.min.js"></script>
    <script src="resources/js/additional-methods.min.js"></script>
  <!--   <script src="resources/js/ConfiguracaoMaskMoney.js"></script> -->
    <script src="resources/js/validate-editar-produtos.js"></script>
    <script src="resources/js/jquery.maskedinput.min.js"></script>
    <script src="resources/js/ConfiguracaoMaskInput.js"></script>
    <script src="resources/js/scripts.js"></script>
    
    <script type="text/javascript">
    $(function() {

    	  // We can attach the `fileselect` event to all file inputs on the page
    	  $(document).on('change', ':file', function() {
    	    var input = $(this),
    	        numFiles = input.get(0).files ? input.get(0).files.length : 1,
    	        label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
    	    input.trigger('fileselect', [numFiles, label]);
    	  });

    	  // We can watch for our custom `fileselect` event like this
    	  $(document).ready( function() {
    	      $(':file').on('fileselect', function(event, numFiles, label) {

    	          var input = $(this).parents('.input-group').find(':text'),
    	              log = numFiles > 1 ? numFiles + ' files selected' : label;

    	          if( input.length ) {
    	              input.val(log);
    	          } else {
    	              if( log ) alert(log);
    	          }

    	      });
    	  });
    	  
    	});
    </script>
    
  </body>
</html> 