<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Ajax Demo</title>

<!-- Bootstrap -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
<link href="resources/css/cssValidador.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<form name="frmAjaxDemo" id="frmAjaxDemo" action="#" method="POST">
					<div class="form-group">
						<label for="email" class="control-label">E-mail</label>
						<div class="validateError">
							<input type="text" class="form-control" name="email" id="email" />
						</div>
						<strong class="has-error" id="srvResposta"></strong>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-warning" value="Cadastrar"
							id="btnCadastrar" />
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
	<script src="resources/js/AjaxDemoFormValidation.js"></script>
	<script src="resources/js/jquery.maskedinput.min.js"></script>
	<script src="resources/js/ConfiguracaoMaskInput.js"></script>
	<script src="resources/js/scripts.js"></script>

	<script type="text/javascript">
    	$(document).ready(function() {
    		$('#email').keyup(function() {
    			var email = $('#email').val();
				$.ajax({
					type:'POST',
					data: {email: email},
					url: '../ServletAjaxDemo',
					success: function(result) {
						var status = result;
						if (status == "true"){
							$('#email').val("");
							$('#srvResposta').html("Email já cadastrado!");
						}else{
							$('#srvResposta').html("Email Disponivel !");
						}
					}
				});
			});
		});
    </script>
</body>
</html>