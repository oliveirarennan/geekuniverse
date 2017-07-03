package controle;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Frete;
import modelo.Pedido;
import modelo.Usuario;
import util.Util;

/**
 * Servlet implementation class ServletFecharCompra
 */
@WebServlet("/ServletFecharCompra")
public class ServletFecharCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFecharCompra() {
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
		String valorTotal = request.getParameter("valorPedido");
				
		Frete frete = (Frete) request.getSession().getAttribute("Frete");
		Pedido pedido = new Pedido();
		
		pedido.setValor(Util.getDoubleFromRealString(valorTotal));
		pedido.setFrete(frete);
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		pedido.setStatusPedido("Aguardando pagamento");
		pedido.setCliente(usuario);
		Date d = new Date();
		
		SimpleDateFormat std = new SimpleDateFormat("yyyy-MM-dd");
		pedido.setDataPedido(std.format(d.getTime()));
		
		
		request.getSession(true).setAttribute("pedido", pedido);
		
		response.sendRedirect("escolher-pagamento.jsp");
		
		
	}

}
