package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Fabricante;
import servico.FabricanteServico;
import util.Util;

/**
 * Servlet implementation class ServletEditarFabricante
 */
@WebServlet("/ServletEditarFabricante")
public class ServletEditarFabricante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEditarFabricante() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("fabricante");
		int id = Integer.parseInt(request.getParameter("id"));
		Fabricante fabricante = FabricanteServico.buscarPorId(id);
		request.getSession(true).setAttribute("fabricante", fabricante);
		
		response.sendRedirect("admin/editar-fabricante.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cnpj = request.getParameter("cnpj");
		int status = Util.statusParseInt(request.getParameter("status"));
		Fabricante fabricante = ((Fabricante) request.getSession().getAttribute("fabricante"));
		
		fabricante.setNome(nome);
		fabricante.setCnpj(cnpj);
		fabricante.setStatus(status);
		
		if(FabricanteServico.atualizar(fabricante)){
			request.getSession().removeAttribute("msgStatus");
			request.getSession().setAttribute("msgStatus", "Fabricante atualizado com sucesso!");
			response.sendRedirect("admin/editar-fabricante.jsp?fabricante=sucesso");
		}else{
			request.getSession().removeAttribute("msgStatus");
			request.getSession().setAttribute("msgStatus", "Não foi possivel atualizar o fabricante");
			response.sendRedirect("admin/editar-fabricante.jsp?fabricante=falha");

		}
		
		
		
	}

}
