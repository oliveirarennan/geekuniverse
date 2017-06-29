package controle;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import modelo.Produto;
import servico.CategoriaServico;
import servico.FabricanteServico;
import servico.ProdutoServico;
import util.Util;

/**
 * Servlet implementation class ServletEditarProduto
 */
@WebServlet("/ServletEditarProduto")
@MultipartConfig
public class ServletEditarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEditarProduto() {
        super();
        // TODO Auto-generated constructor stub
    }
	private String pastaImagens = null;
    public void init() throws ServletException{
		super.init();
		
		pastaImagens = getServletContext().getInitParameter("pastaImagens");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("produto");
		
		int id = Integer.parseInt(request.getParameter("id"));
		Produto produto = ProdutoServico.buscarPorId(id);
		
		request.getSession(true).setAttribute("produto", produto);
		
		response.sendRedirect("admin/editar-produto.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Produto produto = ((Produto) request.getSession().getAttribute("produto"));
		
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		Double valor = Util.getDoubleFromRealString(request.getParameter("valor"));
		int estoque = Integer.parseInt(request.getParameter("estoque"));
		int categoria = Integer.parseInt(request.getParameter("categoria"));
		int fabricante = Integer.parseInt(request.getParameter("fabricante"));
		Part arquivo = request.getPart("arquivo");
		if(!arquivo.getSubmittedFileName().equals("")){
			//Pega o caminho da Pasta do projeto
			String  pastaProjeto = getServletContext().getRealPath("");
			
			//Configura o caminho da pasta onde ficar�o as imagens dos produtos
			String pastaDestino = pastaProjeto + File.separator + pastaImagens;
			System.out.println("Imagem salva em " + pastaDestino);
			
			//Se a pasta n�o existir a cria
			File pasta = new File(pastaDestino);
			if(!pasta.exists()){
				pasta.mkdir();
			}
			
			//Pega o arquivo do form
			
			String nomeArquivo = arquivo.getSubmittedFileName();
			
			//grava o arquivo na pasta
			arquivo.write(pastaDestino + File.separator + nomeArquivo);
			produto.setImagem(nomeArquivo);
			
		}
		
		//Prepara o objeto Produto
		
		produto.setNome(nome);
		produto.setDescricao(descricao);
		produto.setValor(valor);
		produto.setEstoque(estoque);
		produto.setCategoria(CategoriaServico.buscarPorId(categoria));
		produto.setFabricante(FabricanteServico.buscarPorId(fabricante));
		
		
		
		if(ProdutoServico.atualizar(produto)){
			response.sendRedirect("admin/editar-produto.jsp?produto=sucesso");
		}else{
			response.sendRedirect("admin/editar-produto.jsp?produto=erro");
		}
	}

}
