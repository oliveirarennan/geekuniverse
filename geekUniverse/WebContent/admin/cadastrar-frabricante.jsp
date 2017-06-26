<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Cadastro de Fabricante</title>

    <!-- Bootstrap -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/style.css" rel="stylesheet">
 
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via fsile:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
      <br />
      <div class="container-fluid">
        
          <div class="row">
              <div class="col-xs-12 col-sm-6 col-md-3 col-lg-3">
                  <legend>Cadastrar Fabricante</legend>
                  <form name="frmCadastrarFabricante" id="frmCadastrarFabricante" action="" method="POST">
                    <div class="form-group">
                        <label class="control-label" for="nome">Nome</label>
                        <div class="validateError">
                        	<input type="text" name="nome" id="nome" class="form-control"/>
                        </div>	
                    </div>   
                  
                    <div class="form-group">
                        <label class="control-label" for="cnpj">Cnpj</label>
                        <div class="validateError">
                        	<input type="text" name="cnpj" id="cnpj" class="form-control"/>
                        </div>	
                    </div>

                    <div class="form-group">
                        <label class="control-label" for="status">Status</label>
                        <div class="validateError">
	                        <select class="form-control" name="status" id="status">
	                            <optgroup>
	                                <option value="true" selected>Ativado</option>
	                                <option value="false">Desativado </option> 
	                            </optgroup>
	                        </select>
	                      </div> 
                    </div>
                    <div class="form-group">
                        <input type="submit" name="btnCadastrar" value="Cadastrar" class="btn btn-warning">
                        <input type="reset" name="btnLimpar" value="Limpar" class="btn btn-default"/>
                    </div>    
               </form>     
                    </div>

                  
                  
              </div>
        
      </div>   
  
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="resources/js/jquery-3.2.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/jquery.maskMoney.min.js"></script>
    <script src="resources/js/jquery.validate.min.js"></script>
    <script src="resources/js/additional-methods.min.js"></script>
    <script src="resources/js/ConfiguracaoMaskMoney.js"></script>
    <script src="resources/js/validate-cadastrar-fabricante.js"></script>
    <script src="resources/js/jquery.maskedinput.min.js"></script>
    <script src="resources/js/ConfiguracaoMaskInput.js"></script>
    <script src="resources/js/scripts.js"></script>
  </body>
</html>