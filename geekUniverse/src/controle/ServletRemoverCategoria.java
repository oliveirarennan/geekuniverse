package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servico.CategoriaServico;

/**
 * Servlet implementation class ServletRemoverCategoria
 */
@WebServlet("/ServletRemoverCategoria")
public class ServletRemoverCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRemoverCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		if(CategoriaServico.excluir(id)){
			request.getSession().removeAttribute("msgStatus");
			request.getSession().setAttribute("msgStatus", "Exclusão realizada com sucesso!");
			response.sendRedirect("admin/gerenciar-categorias.jsp?categoria=sucesso");
		}else{
			request.getSession().removeAttribute("msgStatus");
			request.getSession().setAttribute("msgStatus", "Não foi possivel excluir a categoria!");
			response.sendRedirect("admin/gerenciar-categorias.jsp?categoria=falha");
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
