package servico;

import dao.UsuarioDao;
import modelo.Usuario;

public class UsuarioServico {
	
	public static boolean cadastrarUsuario(Usuario usuario){
		UsuarioDao ud = new UsuarioDao();
		if(ud.cadastrar(usuario) > 0){
			return true;
		}else{
			return false;
		}
	}
}