package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servico.ProdutoServico;

/**
 * Servlet implementation class ServletRemoverProduto
 */
@WebServlet("/ServletRemoverProduto")
public class ServletRemoverProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRemoverProduto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		if(ProdutoServico.excluir(id)){
			request.getSession().removeAttribute("msgStatus");
			request.getSession().setAttribute("msgStatus", "Dados atualizados com sucesso!");
				response.sendRedirect("admin/gerenciar-produtos.jsp?produto=sucesso");
			}else{
				request.getSession().removeAttribute("msgStatus");
				request.getSession().setAttribute("msgStatus", "Falha ao remover o produto!");
				response.sendRedirect("admin/gerenciar-produtos.jsp?produto=erro");
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
