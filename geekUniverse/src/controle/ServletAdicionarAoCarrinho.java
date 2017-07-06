package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import modelo.Item;
import modelo.Pedido;
import modelo.Produto;
import servico.ProdutoServico;

/**
 * Servlet implementation class ServletAdicionarAoCarrinho
 */
@WebServlet("/ServletAdicionarAoCarrinho")
public class ServletAdicionarAoCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdicionarAoCarrinho() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Item> itensSessao = ((ArrayList<Item>) request.getSession().getAttribute("ItensCarrinho"));
		Pedido pedido = (Pedido) request.getSession().getAttribute("ValorCarrinho");
		//Caso não funcione testar se itenSessao.size() > 0 e senao for atribuir null
		
		int idproduto = Integer.parseInt(request.getParameter("id"));
		Produto produtoSelecionado = ProdutoServico.buscarPorId(idproduto);
		HttpSession session = null;
		Item item = new Item();
		
		
		
		
		if(produtoSelecionado.getEstoque() > 0){
		item.setProduto(produtoSelecionado);
		item.setQuantidade(1);
		ProdutoServico.removerDoEstoque(item.getProduto(), 1);
		
		
		item.calcularPreco();
		
		Boolean novoItem = false;
		
		if(itensSessao == null ){
			session = request.getSession(true);
			itensSessao = new ArrayList<Item>();
			itensSessao.add(item);
			pedido = new Pedido();
			pedido.setValor(item.getProduto().getValor());
			session.setAttribute("ItensCarrinho", itensSessao);
			session.setAttribute("ValorCarrinho", pedido);
			
		}else{
			session = request.getSession();
				for (Item i : itensSessao) {
					if(i.getProduto().getId() == item.getProduto().getId()){
						i.setQuantidade(i.getQuantidade() + 1);
						i.getProduto().setEstoque(i.getProduto().getEstoque() -1);
						i.calcularPreco();
						pedido.setValor(pedido.getValor() + i.getProduto().getValor());
						novoItem = false;
						session.setAttribute("ItensCarrinho", itensSessao);
						session.setAttribute("ValorCarrinho", pedido);
						break;
					}else{
						novoItem = true;
					}
			}
				if(novoItem){
					itensSessao.add(item);
					pedido.setValor(pedido.getValor() + item.getProduto().getValor());
					session.setAttribute("ItensCarrinho", itensSessao);
					session.setAttribute("ValorCarrinho", pedido);
				}
			
		}
		
		
		
		response.sendRedirect("carrinho.jsp");
		}else{
			response.sendRedirect("carrinho.jsp?estoque=erro");
			request.getSession().removeAttribute("msgStatus");
			request.getSession().setAttribute("msgStatus", "Não foi possivel realizar a operação");
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
