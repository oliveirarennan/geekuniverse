<%@ include file="verificar-login.jsp" %> 
<%@include file="top.jsp" %>
		
		<section class="container-fluid">
			<div class="row">
				<div class="col-md-8 col-md-offset-2" style="background-color: rgba(0, 0, 0, 0.7); margin-top: 5%; margin-bottom: 5%; padding: 3% 3% 3% 3%;">
					
					<div class="alert alert-success alert-dismissible" role="alert">
					  	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<strong>Sucesso!</strong>Seu pedido foi registrado em nosso sistema.
					</div>
					<a href="boletos/${boleto}" target="_blank" class="btn btn-success" >Visualizar Boleto</a> 
				</div>
					
			</div>
		</section>
<%@include file="footer.jsp" %>		








