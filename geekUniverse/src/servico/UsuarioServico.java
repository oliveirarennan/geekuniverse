package servico;

import java.util.List;

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
	
	public static List<Usuario> listar(){
		UsuarioDao ud = new UsuarioDao();
		return  ud.listar();
	}
	
	public static boolean atualizar(Usuario usuario){
		UsuarioDao ud = new UsuarioDao();
		return ud.atualizar(usuario);
	}
	
	public static boolean remover(int id){
		UsuarioDao ud = new UsuarioDao();
		return ud.excluir(id);
	}
	
	public static Usuario buscarPorId(int id){
		UsuarioDao ud = new UsuarioDao();
		return ud.buscarPorId(id);
	}

	public static Usuario Login(String login, String senha) {
		UsuarioDao usuarioDao = new UsuarioDao();
		return usuarioDao.Login(login, senha);
	}
}