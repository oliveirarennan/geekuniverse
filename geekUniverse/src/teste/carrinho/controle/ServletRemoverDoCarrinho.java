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
		String actionId = request.getParameter("id");
		
		if(actionId == "removeAll"){
			itensSessao.removeAll(itensSessao);
			
		}else{
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
