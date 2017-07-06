package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servico.UsuarioServico;

/**
 * Servlet implementation class ServletRemoverUsuario
 */
@WebServlet("/ServletRemoverUsuario")
public class ServletRemoverUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRemoverUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		if(UsuarioServico.remover(id)){
			request.getSession().removeAttribute("msgStatus");
			request.getSession().setAttribute("msgStatus", "Usuário removido com sucesso!");
			response.sendRedirect("admin/gerenciar-usuarios.jsp?usuario=sucesso");
		}else{
			request.getSession().removeAttribute("msgStatus");
			request.getSession().setAttribute("msgStatus", "Não foi possivel remover o usuário!");
			response.sendRedirect("admin/gerenciar-usuarios.jsp?usuario=erro");

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
