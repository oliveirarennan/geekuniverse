package controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import modelo.FormaPagamento;
import modelo.Frete;
import modelo.Item;
import modelo.Pedido;
import servico.FormaPagamentoServico;
import servico.FreteServico;
import servico.ItemServico;
import servico.PedidoServico;

/**
 * Servlet implementation class ServletFinalizarPedido
 */
@WebServlet("/ServletFinalizarPedido")
public class ServletFinalizarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFinalizarPedido() {
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
		List<Item> itens = (List<Item>) request.getSession().getAttribute("ItensCarrinho");
		Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
		Frete frete = (Frete) request.getSession().getAttribute("Frete");
		
		
		
		FormaPagamento formaPagamento = new FormaPagamento();
		formaPagamento.setParcelas(1);
		formaPagamento.setTipoPagamento(request.getParameter("formaPagamento"));
		formaPagamento.setValor(pedido.getValor());
		
		pedido.setFrete(FreteServico.gravar(frete));
		pedido.setFormaPagamento(FormaPagamentoServico.gravar(formaPagamento));
		pedido.setId(PedidoServico.gravar(pedido).getId());
		pedido.setNumeroPedido(pedido.getId() + 1000);
		PedidoServico.atualizar(pedido);
		
		
		for  (Item item : itens) {
			item.setPedido(pedido);
			ItemServico.gravar(item);
		}
		
		//Gerar Boleto
		
		//
		
		request.getSession().removeAttribute("ItensCarrinho");
		request.getSession().removeAttribute("pedido");
		response.sendRedirect("pedido-finalizado.jsp");

		
	}

}
