package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Item;
import modelo.Pedido;
import modelo.Usuario;
import servico.ItemServico;
import servico.PedidoServico;

/**
 * Servlet implementation class ServletPedidosUsuario
 */
@WebServlet("/ServletPedidosUsuario")
public class ServletPedidosUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPedidosUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Item> itens = new ArrayList<Item>() ;
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		List<Pedido> pedidos = PedidoServico.lsitarPorUsuario(usuario.getId());
		request.getSession().setAttribute("pedidosUsuario", pedidos);
		for (Pedido pedido : pedidos) {
			itens.add(ItemServico.buscarPorPedidoId(pedido.getId()));
		}
		request.getSession().setAttribute("itensPedido", itens);
		response.sendRedirect("pedidos-usuario.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
