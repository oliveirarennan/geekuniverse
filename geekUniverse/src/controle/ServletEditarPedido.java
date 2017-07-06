package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Pedido;
import servico.PedidoServico;

/**
 * Servlet implementation class ServletEditarPedido
 */
@WebServlet("/ServletEditarPedido")
public class ServletEditarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEditarPedido() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		String status = request.getParameter("status");
		
		Pedido pedido = PedidoServico.buscarPorId(id);
		
		pedido.setStatusPedido(status);
		
		if(PedidoServico.atualizar(pedido)){
			request.getSession().removeAttribute("msgStatus");
			request.getSession().setAttribute("msgStatus", "Pedido atualizado com sucesso.");
			response.sendRedirect("admin/gerenciar-pedidos.jsp?pedido=sucesso");
		}else{
			request.getSession().removeAttribute("msgStatus");
			request.getSession().setAttribute("msgStatus", "Não foi possivel atualizar o pedido.");
			response.sendRedirect("admin/gerenciar-pedidos.jsp?pedido=erro");
		}
	}

}
