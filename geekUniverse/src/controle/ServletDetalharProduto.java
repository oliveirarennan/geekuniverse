package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Produto;
import servico.ProdutoServico;

/**
 * Servlet implementation class ServletDetalharProduto
 */
@WebServlet("/ServletDetalharProduto")
public class ServletDetalharProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetalharProduto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("produtoSelecionado");
		int id = 0;
		try{
			 id = Integer.parseInt(request.getParameter("id"));
			 Produto produto  = ProdutoServico.buscarPorId(id);
			 
			 request.getSession(true).setAttribute("produtoSelecionado", produto);
			 response.sendRedirect("detalhar-produto.jsp");
		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("operacao-invalida.jsp");
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
