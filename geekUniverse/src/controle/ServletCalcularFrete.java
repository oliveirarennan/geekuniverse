package controle;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Frete;
import modelo.Pedido;

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
	//Codigo abaixo usa a classe que consome o webservice dos correios para o calculo do frete
	//bloqueado pelo proxy do senac	
		/*
		String cepDestino = request.getParameter("cep");
		Frete frete = ServicoFrete.CalcularFrete("24030085", cepDestino);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("Frete", frete);
		response.sendRedirect("carrinho.jsp");
	}
	*/
		//Simulação de Caluculo do Frete
		//Cobra de 10% do pedido em valor de frete
		//Gera um prazo de entre  5  a 20 dias para entrega
		String cepDestino = request.getParameter("cep");
		Pedido pedido = (Pedido) request.getSession().getAttribute("ValorCarrinho");
		
		
		Frete frete = new Frete();
		frete.setValor(pedido.getValor()* 0.03);
		Random prazo = new Random();
		
		frete.setPrazo((prazo.nextInt(5)+16) + " ");
		
		request.getSession().setAttribute("Frete", frete);
		response.sendRedirect("carrinho.jsp");
	}
}
