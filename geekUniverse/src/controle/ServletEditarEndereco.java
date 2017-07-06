package controle;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Endereco;
import modelo.Usuario;
import servico.EnderecoServico;
import servico.EstadoServico;
import servico.UsuarioServico;
import util.Util;

/**
 * Servlet implementation class ServletEditarUsuario
 */
@WebServlet("/ServletEditarEndereco")
public class ServletEditarEndereco extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEditarEndereco() {
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
		String compra = request.getParameter("compra");
		
		Endereco endereco = EnderecoServico.bucarPorID(id);
		
		if(compra.equals("1")){
		
			String pais = request.getParameter("pais");
			int estado = Integer.parseInt(request.getParameter("estado"));
			String cidade = request.getParameter("cidade");
			String bairro = request.getParameter("bairro");
			String rua = request.getParameter("rua");
			int numero = Integer.parseInt(request.getParameter("numero"));
			String complemento = request.getParameter("complemento");
			String cep = request.getParameter("cep");
			
			
			
			
			
			endereco.setPais(pais);
			endereco.setEstado(EstadoServico.buscarPorId(estado));
			endereco.setCidade(cidade);
			endereco.setBairro(bairro);
			endereco.setRua(rua);
			endereco.setNumero(numero);
			endereco.setComplemento(complemento);
			endereco.setCep(cep);
	
			if(EnderecoServico.atualizar(endereco)){
				Usuario  usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado"); 
				usuarioLogado.setEndereco(endereco);
				
				request.getSession().setAttribute("usuarioLogado", usuarioLogado);
				response.sendRedirect("escolher-pagamento.jsp");
				
			}else{
				response.sendRedirect("escolher-pagamento.jsp?endereco=erro");
			}
		}else if(compra.equals("2") ){
			
			String pais = request.getParameter("pais");
			int estado = Integer.parseInt(request.getParameter("estado"));
			String cidade = request.getParameter("cidade");
			String bairro = request.getParameter("bairro");
			String rua = request.getParameter("rua");
			int numero = Integer.parseInt(request.getParameter("numero"));
			String complemento = request.getParameter("complemento");
			String cep = request.getParameter("cep");
			
			
			
			
			
			endereco.setPais(pais);
			endereco.setEstado(EstadoServico.buscarPorId(estado));
			endereco.setCidade(cidade);
			endereco.setBairro(bairro);
			endereco.setRua(rua);
			endereco.setNumero(numero);
			endereco.setComplemento(complemento);
			endereco.setCep(cep);
			
			
	
			if(EnderecoServico.atualizar(endereco)){
				Usuario ul = (Usuario) request.getSession().getAttribute("usuarioLogado");
				ul.setEndereco(endereco);
				request.getSession().setAttribute("usuarioLogado", ul);
				response.sendRedirect("painel-usuario.jsp?endereco=sucesso");
			}else{
				response.sendRedirect("painel-usuario.jsp?endereco=erro");
			}
			
		}else{
		
			String pais = request.getParameter("pais");
			int estado = Integer.parseInt(request.getParameter("estado"));
			String cidade = request.getParameter("cidade");
			String bairro = request.getParameter("bairro");
			String rua = request.getParameter("rua");
			int numero = Integer.parseInt(request.getParameter("numero"));
			String complemento = request.getParameter("complemento");
			String cep = request.getParameter("cep");
			
			
			
			
			
			endereco.setPais(pais);
			endereco.setEstado(EstadoServico.buscarPorId(estado));
			endereco.setCidade(cidade);
			endereco.setBairro(bairro);
			endereco.setRua(rua);
			endereco.setNumero(numero);
			endereco.setComplemento(complemento);
			endereco.setCep(cep);
	
			if(EnderecoServico.atualizar(endereco)){
				response.sendRedirect("admin/editar-endereco.jsp?endereco=sucesso");
			}else{
				response.sendRedirect("admin/editar-endereco.jsp?endereco=erro");
			}
		}
	}
}
