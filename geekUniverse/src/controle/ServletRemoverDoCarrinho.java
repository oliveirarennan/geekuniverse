package controle;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Item;
import modelo.Pedido;
import servico.ProdutoServico;

/**
 * Servlet implementation class ServletRemoverDoCarrinho
 */
@WebServlet("/ServletRemoverDoCarrinho")
public class ServletRemoverDoCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRemoverDoCarrinho() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Item> itensSessao = ((ArrayList<Item>) request.getSession().getAttribute("ItensCarrinho"));
		Pedido pedido = (Pedido) request.getSession().getAttribute("ValorCarrinho");

		HttpSession session = request.getSession();
		
	
		String	actionId = request.getParameter("id");
		
		String	removeLinha = request.getParameter("rl");
		
		
		//Remove todos os intens do carrinho
		if(actionId.equals("removeAll")){
			try{
				for (Item item : itensSessao) {
					ProdutoServico.adicionarAoEstoque(item.getProduto(), item.getQuantidade());
				}
				itensSessao.removeAll(itensSessao);
				itensSessao = null;
				pedido.setValor(0.);
				pedido = null;
			}catch (Exception e) {
				// TODO: handle exception
				itensSessao = null;
				pedido = null;
			}
		
		}else if((Integer.parseInt(actionId) > 0) && (Integer.parseInt(removeLinha) == 0)){
			//remove 1 quantidade de produto, caso a quantidade seja menor que 1 remove o produto do carrinho
			for (Item i : itensSessao) {
				if(i.getProduto().getId() == Integer.parseInt(actionId)){
					if(i.getQuantidade() > 1){
						i.setQuantidade(i.getQuantidade() - 1);
						//i.getProduto().setEstoque(i.getProduto().getEstoque() + 1);
						ProdutoServico.adicionarAoEstoque(i.getProduto(), 1);
						i.calcularPreco();
						
						pedido.setValor(pedido.getValor() - i.getProduto().getValor());
						break;
					}else{
						i.setQuantidade(i.getQuantidade() - 1);
						ProdutoServico.adicionarAoEstoque(i.getProduto(), 1);
						itensSessao.remove(i);
						break;
					}
					
				}
			}
			if(itensSessao.size() < 1){
				itensSessao = null;
				pedido = null;
			}
		}else if((Integer.parseInt(actionId) > 0) && (Integer.parseInt(removeLinha) == 1)){
		//remove o produto selecionado independente da quantidade no carrinho
		if(removeLinha != null){
			for (Item i : itensSessao) {
				if(i.getProduto().getId() == Integer.parseInt(actionId)){
						pedido.setValor(pedido.getValor() - i.getPreco());
						ProdutoServico.adicionarAoEstoque(i.getProduto(), i.getQuantidade());
						itensSessao.remove(i);
						break;
					}
			}
			if(itensSessao.size() < 1){
				itensSessao = null;
				pedido = null;
				}
			}
		}
		session.setAttribute("ItensCarrinho", itensSessao);
		session.setAttribute("ValorCarrinho", pedido);
		response.sendRedirect("carrinho.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
