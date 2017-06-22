package teste.carrinho.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import teste.carrinho.modelo.Frete;

/**
 * Servlet implementation class ServletCalculaFrete
 */
@WebServlet("/ServletCalcularFrete")
public class ServletCalcularFrete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCalcularFrete() {
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
		// TODO Auto-generated method stub
		
		String cepDestino = request.getParameter("cep");
		Frete frete = ServicoFrete.CalcularFrete("24030085", cepDestino);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("Frete", frete);
		response.sendRedirect("TesteCarrinho/carrinho.jsp");
	}

}
