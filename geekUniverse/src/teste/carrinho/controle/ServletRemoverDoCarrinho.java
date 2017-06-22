package teste.carrinho.controle;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import teste.carrinho.modelo.Item;

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
		HttpSession session = request.getSession();
		
		String actionId = null;
		try{
			actionId = request.getParameter("id");
		}catch (Exception e) {
			// TODO: handle exception
			actionId = "0";
		}
		
		
		String removeLinha = null;
		try{
			removeLinha = request.getParameter("rl");
		}catch (Exception e) {
			// TODO: handle exception
			removeLinha = "0";
		}
		
		
		//Remove todos os intens do carrinho
		if(actionId.equals("removeAll")){
			try{
				itensSessao.removeAll(itensSessao);
				itensSessao = null;
			}catch (Exception e) {
				// TODO: handle exception
				itensSessao = null;
			}
		
		}else{
			//remove 1 quantidade de produto, caso a quantidade seja menor que 1 remove o produto do carrinho
			for (Item i : itensSessao) {
				if(i.getProduto().getId() == Integer.parseInt(actionId)){
					if(i.getQuantidade() > 1){
						i.setQuantidade(i.getQuantidade() - 1);
						i.setPreco();
						break;
					}else{
						itensSessao.remove(i);
						break;
					}
					
				}
			}
			if(itensSessao.size() < 1){
				itensSessao = null;
			}
		}
		//remove o produto selecionado independente da quantidade no carrinho
		if(removeLinha != null){
			for (Item i : itensSessao) {
				if(i.getProduto().getId() == Integer.parseInt(removeLinha)){
						itensSessao.remove(i);
						break;
					}
			}
			if(itensSessao.size() < 1){
				itensSessao = null;
			}
		}
		session.setAttribute("ItensCarrinho", itensSessao);
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
