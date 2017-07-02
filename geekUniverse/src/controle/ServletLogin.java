package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Usuario;
import servico.UsuarioServico;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
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
		

		HttpSession sessao = request.getSession(true);
		
		String login = request.getParameter("email");
		String senha = request.getParameter("senha");
		Usuario usuario = UsuarioServico.Login(login, senha); 
		
		if(usuario != null){
			
			usuario.setSenha("Não é da sua conta!");
			sessao.setAttribute("usuarioLogado", usuario);
			
			if(usuario.getTipoUsuario().equals("cliente")){
				response.sendRedirect("carrinho.jsp");
			}else if(usuario.getTipoUsuario().equals("administrador")){
				
				response.sendRedirect("admin/index.jsp");
			}
			
		}else{
			sessao.invalidate();
			response.sendRedirect("erro-login.jsp");
		}
		
	}

}
