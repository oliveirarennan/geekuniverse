package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Categoria;
import servico.CategoriaServico;
import util.Util;

/**
 * Servlet implementation class ServletEditarCategoria
 */
@WebServlet("/ServletEditarCategoria")
public class ServletEditarCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEditarCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().removeAttribute("categoria");
		int id = Integer.parseInt(request.getParameter("id"));
		Categoria categoria = CategoriaServico.buscarPorId(id);
		HttpSession session = request.getSession(true);
		session.setAttribute("categoria", categoria);
		response.sendRedirect("admin/editar-categoria.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nome");
		int status = Util.statusParseInt(request.getParameter("status"));
		Categoria categoria = ((Categoria) request.getSession().getAttribute("categoria"));
		
		categoria.setNome(nome);
		categoria.setStatus(status);
		
		if(CategoriaServico.atualizar(categoria)){
			request.getSession().removeAttribute("msgStatus");
			request.getSession().setAttribute("msgStatus", "Categoria editada com sucesso!");
			response.sendRedirect("admin/editar-categoria.jsp?categoria=sucesso");
		}else{
			request.getSession().removeAttribute("msgStatus");
			request.getSession().setAttribute("msgStatus", "Não foi possivel editar a categoria!");
			response.sendRedirect("admin/editar-categoria.jsp?categoria=erro");
		}
	}

}
