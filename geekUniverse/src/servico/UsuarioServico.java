package servico;

import dao.EnderecoDao;
import dao.UsuarioDao;
import modelo.Usuario;

public class UsuarioServico {
	
	public boolean cadastrarUsuario(Usuario usuario){
		EnderecoDao enderecoDao = new EnderecoDao();
		UsuarioDao usuarioDao = new UsuarioDao();
		
		int retorno = 0;
		
		if(enderecoDao.cadastrar(usuario.getEndereco()) > 0){
			usuario.getEndereco().setId(enderecoDao.buscarId(usuario.getEndereco().getRua()));
			retorno = usuarioDao.cadastrar(usuario);
		}
		if(retorno > 0){
			return true;
		}else{
			return false;
		}
	}
}