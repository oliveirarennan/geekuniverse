import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Endereco;
import modelo.Pessoa;
import servico.PessoaServico;

@WebServlet("/CadastrarUsuarioServlet")
public class CadastrarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CadastrarUsuarioServlet() {
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
		String senha = request.getParameter("senha");
		String tipoUsuario = request.getParameter("tipoUsuario");
		String status = request.getParameter("status");
		String pais = request.getParameter("pais");
		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String rua = request.getParameter("rua");
		String numero = request.getParameter("numero");
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
		usuario.setNome(cpf);
		usuario.setNome(rg);
		usuario.setNome(email);
		usuario.setNome(senha);
		usuario.setNome(tipoUsuario);
		usuario.setNome(status);
		
		Endereco e = new Endereco();
		e.setEstado(pais);
		e.setEstado(estado);
		e.setEstado(cidade);
		e.setBairro(bairro);
		e.setRua(rua);
		e.setEstado(numero);
		e.setComplemento(complemento);
		e.setEstado(cep);
		
		usuario.setEndereco(e);
		
		if(servico.cadastrar(usuario)){
			System.out.println("Usuário incluída");
		} else {
			System.out.println("Inclusão falhou!");
		}	
	}
}