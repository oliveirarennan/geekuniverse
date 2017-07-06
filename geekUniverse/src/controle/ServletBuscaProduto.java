package controle;

import java.io.IOException;
import java.util.List;
import java.util.ServiceConfigurationError;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Produto;
import servico.CategoriaServico;
import servico.FabricanteServico;
import servico.ProdutoServico;

/**
 * Servlet implementation class ServletBuscaProduto
 */
@WebServlet("/ServletBuscaProduto")
public class ServletBuscaProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBuscaProduto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String modo = request.getParameter("modo");
		String fabricante = request.getParameter("fabricante");
		String categoria = request.getParameter("categoria");
		
		if(modo.equals("1")){
		
			String termoBusca = request.getParameter("busca");
			List<Produto> produtos = ProdutoServico.buscarPorNome(termoBusca);
			
			request.getSession().setAttribute("resultadoBusca", produtos);
			
			response.sendRedirect("busca-produto.jsp");
		}else if(!fabricante.equals("0")){
			List<Produto> produtos = ProdutoServico.listarPorFabricante(FabricanteServico.buscarPorId(Integer.parseInt(fabricante)), 0);
			request.getSession().setAttribute("resultadoBusca", produtos);
			
			response.sendRedirect("busca-produto.jsp");
		}else if(!categoria.equals("0")){
			List<Produto> produtos = ProdutoServico.listarPorCategoria(CategoriaServico.buscarPorId(Integer.parseInt(categoria)), 0);
			request.getSession().setAttribute("resultadoBusca", produtos);
			
			response.sendRedirect("busca-produto.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
