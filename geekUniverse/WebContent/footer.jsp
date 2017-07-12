<!-- Login Modal-->
      <!-- Modal -->
        <div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" id="loginModal">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Login</h4>
              </div>
              <div class="modal-body">
                 <form action="ServletLogin" method="POST" >
                      <div class="input-group">
                        <span class="input-group-addon" id="basic-addon1">@</span>
                        <input type="text" class="form-control" placeholder="Email" id="emailid" name="email" aria-describedby="basic-addon1">
                      </div><br >
                      <div class="input-group">
                          <span class="input-group-addon" id="basic-addon1">#</span>
                          <input type="password" class="form-control" placeholder="Senha" id="senhaid" name="senha">
                      </div><br>
                      <div class="input-group">
                          <button type="submit" class="btn btn-warning">Entrar</button>
                          <a href="#"> Esqueci a senha</a>
                      </div>
                  </form>
              </div>
           </div>
          </div>
        </div>  
	<footer class="col-md-12 footer">
			<div class="col-md-5 col-md-offset-5">
				<img src="img/logo2.png" class="img-responsive">
			</div>
			<div>
				<div class="social col-md-4 col-md-offset-2">
				    <h3 class="texto">Redes Sociais</h3>
				    <ul class="social-network social-circle redes">
				      <li><a href="#" class="icoInstagram" title="Instagram"><i class="fa fa-instagram"></i></a></li>
				      <li><a href="#" class="icoFacebook" title="Facebook" data-toggle="modal" data-target="#modal2"><i class="fa fa-facebook"></i></a></li>
				      <li><a href="#" class="icoTwitter" title="Twitter"  data-toggle="modal" data-target="#modal1"><i class="fa fa-twitter"></i></a></li>
				      <li><a href="#" class="icoWhatsapp" title="Whatsapp" data-toggle="modal" data-target="#modalwpp"><i class="fa fa-whatsapp"></i></a></li>
				    </ul>
				</div>
			</div>
			<div class="formas col-md-4">
				<h3 class="">Formas de Pagamento</h3>
					<ul class="social-network social-circle" id="pg">
						<li><a href="#" class="icoBarcode" title="barcode"><i class="fa fa-barcode"></i></a></li>
					</ul>	
			</div>
		</footer>
	</body>
</html>