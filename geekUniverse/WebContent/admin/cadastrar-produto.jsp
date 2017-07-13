 <%@ include file="top.jsp" %>
 <title>Cadastro de Produto</title>
  <div class="container">
    <br/>
     
          <div class="row">
            <div class="jumbotron col-md-6 col-md-offset-3 col-sm-6 col-offset-3 col-xs-6 col-xs-offset-3 col-lg-6 col-lg-offset-3">
            <c:choose>
							<c:when test="${param.produto == 'sucesso' }">
								<div class="alert alert-success alert-dismissible" role="alert">
									  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
									  <strong>Sucesso!</strong> ${msgStatus}
								</div>
							</c:when>
							<c:when test="${param.produto == 'erro' }">
								<div class="alert alert-danger alert-dismissible" role="alert">
									  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
									  <strong>Erro!</strong> ${msgStatus}
								</div>
							</c:when>
						</c:choose>
						
						<legend>
              <legend><center>Cadastrar Produtos</center></legend>
              <form name="frmCadastrarProduto" id="frmCadastrarProduto" action="../ServletCadastrarProduto" method="POST" enctype="multipart/form-data">
                <div class="form-group">
                  <label class="control-label" for="nome">Nome</label>
                  <div class="validateError">
                    <input type="text" name="nome" id="nome" class="form-control"/>
                  </div>  
                </div>   
                <div class="form-group">
                  <label class="control-label" for="descricao">Descrição</label>
                  <div class="validateError">
                    <input type="text" name="descricao" id="descricao" class="form-control"/>
                  </div>  
                </div>
                <div class="form-group">
                  <label class="control-label" for="valor">Valor</label>
                  <div class="validateError">
                    <input type="text" name="valor" id="valor" class="form-control"/>
                  </div>  
                </div>
                 <div class="form-group">
                  <label class="control-label" for="estoque">Estoque</label>
                  <div class="validateError">
                    <input type="text" name="estoque" id="estoque" class="form-control"/>
                  </div>  
                </div>
                <div class="form-group">
                  <label class="control-label" for="categoria">Categoria</label>
                  <div class="validateError">
                  <select class="form-control" name="categoria" id="categoria">
                  <jsp:useBean id="ca" class="servico.CategoriaServico"></jsp:useBean>
                  
                      <optgroup>
                   		<c:forEach var="categoria" items="${ca.listarAtivas() }">
                   			<option value="${categoria.id }">${categoria.nome}</option>
                      </c:forEach>
                      </optgroup>
                    </select>
                  </div>  
                </div>
                
                <div class="form-group">
                  <label class="control-label" for="categoria">Fabricante</label>
                  <div class="validateError">
                  <select class="form-control" name="fabricante" id="fabricante">
                  <jsp:useBean id="fa" class="servico.FabricanteServico"></jsp:useBean>
                  
                      <optgroup>
                   		<c:forEach var="fabricante" items="${fa.listarAtivado() }">
                   			<option value="${fabricante.id }">${fabricante.nome}</option>
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
 
</section>

   
    
      <script src="resources/js/jquery-3.2.1.min.js" charset="UTF-8"></script>
       <script src="resources/js/validate-cadastrar-produtos.js" charset="UTF-8"></script>
  <%@ include file="footer.jsp" %>
