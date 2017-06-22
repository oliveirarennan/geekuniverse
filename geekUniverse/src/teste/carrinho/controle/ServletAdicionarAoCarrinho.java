package teste.carrinho.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.modeler.NotificationInfo;

import teste.carrinho.modelo.Item;
import teste.carrinho.modelo.Produto;

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
		
		//Caso não funcione testar se itenSessao.size() > 0 e senao for atribuir null
		
		List<Produto> produtos = Produto.retornaProdutos();
		Produto produtoSelecionado = null;
		HttpSession session = null;
		Item item = new Item();
		
		int idproduto = Integer.parseInt(request.getParameter("id"));
		
		switch (idproduto) {
		case 1:
			produtoSelecionado = produtos.get(0);
			break;
		case 2:
			produtoSelecionado = produtos.get(1);
			break;
		case 3:
			produtoSelecionado = produtos.get(2);
			break;	
		default:
			break;
		}
		
		item.setProduto(produtoSelecionado);
		item.setQuantidade(1);
		item.setPreco();
		
		Boolean novoItem = false;
		
		if(itensSessao == null ){
			session = request.getSession(true);
			itensSessao = new ArrayList<Item>();
			itensSessao.add(item);
			session.setAttribute("ItensCarrinho", itensSessao);
			
		}else{
			session = request.getSession();
				for (Item i : itensSessao) {
					if(i.getProduto().getId() == item.getProduto().getId()){
						i.setQuantidade(i.getQuantidade() + 1);
						i.setPreco();
						novoItem = false;
						session.setAttribute("ItensCarrinho", itensSessao);
						System.out.println("===> Item já no carrinho, aumentando a quantidade.");
						break;
					}else{
						novoItem = true;
					}
			}
				if(novoItem){
					itensSessao.add(item);
					session.setAttribute("ItensCarrinho", itensSessao);
				}
			
		}
		
		
		
		response.sendRedirect("TesteCarrinho/carrinho.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
