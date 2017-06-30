 <%@ include file="top.jsp" %>
 <title>Edição de Produto</title>
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

    
    
<script src="resources/js/jquery-3.2.1.min.js" charset="UTF-8"></script> 
 <script src="resources/js/validate-editar-produto.js" charset="UTF-8"></script>
 <%@ include file="footer.jsp" %>
