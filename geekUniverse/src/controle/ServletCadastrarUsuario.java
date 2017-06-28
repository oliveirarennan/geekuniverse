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
import servico.UsuarioServico;
import util.Util;

@WebServlet("/ServletCadastrarUsuario")
public class ServletCadastrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCadastrarUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String dataNascimento = request.getParameter("dataNacimento");
		String sexo = request.getParameter("sexo");
		String celular = request.getParameter("celular");
		String telefoneFixo = request.getParameter("telefoneFixo");
		String cpf = request.getParameter("cpf");
		String rg = request.getParameter("rg");
		String email = request.getParameter("email");
		String senha = null;
		try {
			senha = Util.getMd5(request.getParameter("senha"));
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String tipoUsuario = request.getParameter("tipoUsuario");
		String status = request.getParameter("status");
		String pais = request.getParameter("pais");
		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String rua = request.getParameter("rua");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String complemento = request.getParameter("complemento");
		String cep = request.getParameter("cep");
		
		UsuarioServico servico = new UsuarioServico();
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setSobrenome(sobrenome);
		usuario.setDataNascimento(dataNascimento);
		usuario.setSexo(sexo);
		usuario.setCelular(celular);
		usuario.setTelefoneFixo(telefoneFixo);
		usuario.setCpf(cpf);
		usuario.setRg(rg);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setTipoUsuario(tipoUsuario);
		if(status == "true"){
			usuario.setStatus(0);
		}else{
			usuario.setStatus(1);
		}
		
		
		
		Endereco e = new Endereco();
		e.setEstado(pais);
		e.setEstado(estado);
		e.setEstado(cidade);
		e.setBairro(bairro);
		e.setRua(rua);
		e.setNumero(numero);
		e.setComplemento(complemento);
		e.setEstado(cep);

		
		int enderecoId = EnderecoServico.cadastrar(e);
		System.out.println("===>"+enderecoId);
		e.setId(enderecoId);
		usuario.setEndereco(e);
		
	
		
		if(servico.cadastrarUsuario(usuario)){
			response.sendRedirect("admin/cadastrar-usuario.jsp?usuario=sucesso");
		}else{
			response.sendRedirect("admin/cadastrar-usuario.jsp?usuario=erro");
		}	
	}
}