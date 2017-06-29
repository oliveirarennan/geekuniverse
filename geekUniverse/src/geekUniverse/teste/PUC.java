package geekUniverse.teste;


import modelo.Endereco;
import modelo.Usuario;
import servico.EnderecoServico;
import servico.EstadoServico;
import servico.UsuarioServico;

public class PUC {

	public static void main(String[] args) {
		
	Usuario u = new Usuario();
	
	u.setCelular("999999");
	u.setCpf("111111111");
	u.setDataNascimento("1990-03-08");
	u.setEmail("rennan@gmail.com");
	u.setNome("Rennan");
	u.setSobrenome("Neves");
	u.setSenha("12345678");
	u.setRg("11111");
	u.setSexo("Masculino");
	u.setStatus(1);
	u.setTipoUsuario("Administrador");
	u.setTelefoneFixo("9999999");
	
	Endereco e = new Endereco();
	e.setBairro("Centro");
	e.setCep("2402000");
	e.setCidade("Niteroi");
	e.setComplemento("Apartamento 702");
	e.setNumero(139);
	e.setPais("Brasil");
	e.setRua("Av visconde do rio branco");
	e.setEstado(EstadoServico.buscarPorId(2));
	
	u.setEndereco(EnderecoServico.cadastrar(e));
	
	if(UsuarioServico.cadastrarUsuario(u)){
		System.out.println("Usuario Cadastrado com sucesso");
	}
			
	
	}

}
