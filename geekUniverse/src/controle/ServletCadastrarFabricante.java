package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Fabricante;
import servico.FabricanteServico;

/**
 * Servlet implementation class ServletCadastrarFabricante
 */
@WebServlet("/ServletCadastrarFabricante")
public class ServletCadastrarFabricante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCadastrarFabricante() {
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
		String cnpj = request.getParameter("cnpj");
		int status = 0;
		if(request.getParameter("status").equals("true")){
			status = 1;
		}
		
		Fabricante fabricante = new Fabricante();
		
		fabricante.setNome(nome);
		fabricante.setCnpj(cnpj);
		fabricante.setStatus(status);
		
		FabricanteServico fs = new FabricanteServico();
		int rq = fs.cadastrar(fabricante);
		if(rq > 0){
			response.sendRedirect("admin/cadastrar-fabricante.jsp?categoria=sucesso");
		}else{
			response.sendRedirect("admin/cadastrar-fabricante.jsp?categoria=erro");
		}
		
		
		
	}

}
