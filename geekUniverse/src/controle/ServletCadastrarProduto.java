package controle;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ServiceConfigurationError;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.omg.PortableInterceptor.ServerRequestInterceptorOperations;

import modelo.Produto;
import servico.CategoriaServico;
import servico.FabricanteServico;
import servico.ProdutoServico;
import util.Util;

/**
 * Servlet implementation class ServletCadastrarProduto
 */
@WebServlet("/ServletCadastrarProduto")
@MultipartConfig
public class ServletCadastrarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private String pastaImagens = null;
	
	public void init() throws ServletException{
		super.init();
		
		pastaImagens = getServletContext().getInitParameter("pastaImagens");
	}
	
    public ServletCadastrarProduto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		Double valor = Util.getDoubleFromRealString(request.getParameter("valor"));
		int estoque = Integer.parseInt(request.getParameter("estoque"));
		int categoria = Integer.parseInt(request.getParameter("categoria"));
		int fabricante = Integer.parseInt(request.getParameter("fabricante"));
		
		//Pega o caminho da Pasta do projeto
		String  pastaProjeto = getServletContext().getRealPath("");
		
		//Configura o caminho da pasta onde ficar�o as imagens dos produtos
		String pastaDestino = pastaProjeto + File.separator + pastaImagens;
		
		//Se a pasta n�o existir a cria
		File pasta = new File(pastaDestino);
		if(!pasta.exists()){
			pasta.mkdir();
		}
		
		//Pega o arquivo do form
		Part arquivo = request.getPart("arquivo");
		String nomeArquivo = arquivo.getSubmittedFileName();
		
		//grava o arquivo na pasta
		arquivo.write(pastaDestino + File.separator + nomeArquivo);
		
		//Prepara o objeto Produto
		Produto produto = new Produto();
		
		produto.setNome(nome);
		produto.setDescricao(descricao);
		produto.setValor(valor);
		produto.setEstoque(estoque);
		produto.setCategoria(CategoriaServico.buscarPorId(categoria));
		produto.setFabricante(FabricanteServico.buscarPorId(fabricante));
		produto.setImagem(nomeArquivo);
		
		ProdutoServico ps = new ProdutoServico();
		int rq = ps.cadastrar(produto);
		if(rq > 0){
			request.getSession().removeAttribute("msgStatus");
			request.getSession().setAttribute("msgStatus", "Produto cadastrado com sucesso!");
			response.sendRedirect("admin/cadastrar-produto.jsp?produto=sucesso");
		}else{
			request.getSession().removeAttribute("msgStatus");
			request.getSession().setAttribute("msgStatus", "N�o foi possivel cadastrar o produto.");
			response.sendRedirect("admin/cadastrar-produto.jsp?produto=erro");
		}
		
		
	
	}

}
