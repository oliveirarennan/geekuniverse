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
@WebServlet("/ServletEditarUsuario")
public class ServletEditarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEditarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("usuario");
		
		int id =  Integer.parseInt(request.getParameter("id"));
		Usuario usuario = UsuarioServico.buscarPorId(id);
		request.getSession(true).setAttribute("usuario", usuario);
		
		response.sendRedirect("admin/editar-usuario.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Usuario usuario = ((Usuario)request.getSession().getAttribute("usuario"));
		
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String sexo = request.getParameter("sexo");
		String celular = request.getParameter("celular");
		String telefoneFixo = request.getParameter("telefoneFixo");
		String cpf = request.getParameter("cpf");
		String rg = request.getParameter("rg");
		String email = request.getParameter("email");
		String senha = null;
		try {
			if(request.getParameter("senha") != null){
			senha = Util.getMd5(request.getParameter("senha"));
			}
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		
		String tipoUsuario = request.getParameter("tipoUsuario");
		String status = request.getParameter("status");
		String pais = request.getParameter("pais");
		int estado = Integer.parseInt(request.getParameter("estado"));
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String rua = request.getParameter("rua");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String complemento = request.getParameter("complemento");
		String cep = request.getParameter("cep");
		String dataNascimento = request.getParameter("dataNascimento");
		dataNascimento = dataNascimento.replaceAll("-", "/");
		
		usuario.setNome(nome);
		usuario.setSobrenome(sobrenome);
		usuario.setDataNascimento(dataNascimento);
		usuario.setSexo(sexo);
		usuario.setCelular(celular);
		usuario.setTelefoneFixo(telefoneFixo);
		usuario.setCpf(cpf);
		usuario.setRg(rg);
		usuario.setEmail(email);
		if(senha != null){
			usuario.setSenha(senha);
		}
		if(tipoUsuario != null){
			usuario.setTipoUsuario(tipoUsuario);
		}else{
			usuario.setTipoUsuario("cliente");
		}
		usuario.setSexo(sexo);
		if(status != null){
			if(status.equals("true")){
				usuario.setStatus(1);
			}else{
				usuario.setStatus(0);
			}
		}else{
			usuario.setStatus(1);
		}
		
		
		usuario.getEndereco().setPais(pais);
		usuario.getEndereco().setEstado(EstadoServico.buscarPorId(estado));
		usuario.getEndereco().setCidade(cidade);
		usuario.getEndereco().setBairro(bairro);
		usuario.getEndereco().setRua(rua);
		usuario.getEndereco().setNumero(numero);
		usuario.getEndereco().setComplemento(complemento);
		usuario.getEndereco().setCep(cep);

		if(EnderecoServico.atualizar(usuario.getEndereco())){
		
			if(UsuarioServico.atualizar(usuario)){
				if((tipoUsuario == null) && (status == null)){
					response.sendRedirect("editar-usuario.jsp?usuario=sucesso");
				}else{
					response.sendRedirect("admin/editar-usuario.jsp?usuario=sucesso");
				}
			}else{
				if((tipoUsuario == null) && (status == null)){
					response.sendRedirect("editar-usuario.jsp?usuario=erro");
				}else{
					response.sendRedirect("admin/editar-usuario.jsp?usuario=erro");
				}
			}	
		}else{
			if((tipoUsuario == null) && (status == null)){
				response.sendRedirect("editar-usuario.jsp?usuario=erro");
			}else{
				response.sendRedirect("admin/editar-usuario.jsp?usuario=erro");
			}
		}
		
	}

}
