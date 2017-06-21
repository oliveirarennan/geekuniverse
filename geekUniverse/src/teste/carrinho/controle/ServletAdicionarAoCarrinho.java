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
		ArrayList<Produto> produtosSessao = (ArrayList<Produto>) request.getSession().getAttribute("produtosCarrinho");
		
		List<Produto> produtos = Produto.retornaProdutos();
		Produto produtoSelecionado = null;
		HttpSession session = null;
		
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
		
		if(produtosSessao == null){
			session = request.getSession(true);
			produtosSessao = new ArrayList<Produto>();
			produtosSessao.add(produtoSelecionado);
			session.setAttribute("produtosCarrinho", produtosSessao);
		}else{
			session = request.getSession();
			produtosSessao.add(produtoSelecionado);
			session.setAttribute("produtosCarrinho", produtosSessao);
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
