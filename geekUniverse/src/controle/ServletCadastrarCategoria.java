package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Categoria;
import servico.CategoriaServico;

/**
 * Servlet implementation class ServletCadastrarCategoria
 */
@WebServlet("/ServletCadastrarCategoria")
public class ServletCadastrarCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCadastrarCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String status = request.getParameter("status");
	
		Categoria categoria = new Categoria();
		categoria.setNome(nome);
		
		if(status.equals("true")){
			categoria.setStatus(1);
		}else{
			categoria.setStatus(0);
		}
		
		CategoriaServico cs = new CategoriaServico();
		
		int rq = cs.cadastrar(categoria);
		
		if(rq > 0){
			request.getSession().removeAttribute("msgStatus");
			request.getSession().setAttribute("msgStatus", "Categoria cadastrada com sucesso!");
			response.sendRedirect("admin/cadastrar-categoria.jsp?categoria=sucesso");
		}else{
			request.getSession().removeAttribute("msgStatus");
			request.getSession().setAttribute("msgStatus", "Não foi possivel cadastrar a categoria");
			response.sendRedirect("admin/cadastrar-categoria.jsp?categoria=erro");
		}
		
	}

}
