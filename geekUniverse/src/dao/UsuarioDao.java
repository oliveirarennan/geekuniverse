package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Usuario;
import util.DBUtil;

public class UsuarioDao {
	
	public int cadastrar(Usuario usuario){
		Connection conexao = null;
		int retorno = 0;
		String sql = "INSERT INTO usuario(nome, sobrenome, dataNascimento, sexo, celular, telefoneFixo"
				+ " cpf, rg, email, senha, tipoUsuario, status) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getSobrenome());
			ps.setString(3, usuario.getDataNascimento());
			ps.setString(4, usuario.getSexo());
			ps.setString(5, usuario.getCelular());
			ps.setString(6, usuario.getTelefoneFixo());
			ps.setString(7, usuario.getCpf());
			ps.setString(8, usuario.getRg());
			ps.setString(9, usuario.getEmail());
			ps.setString(10, usuario.getSenha());
			ps.setString(11, usuario.getTipoUsuario());
			ps.setInt(12, usuario.getStatus());
			
			retorno = ps.executeUpdate();
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.fechar(conexao);
		}
		return retorno;
	}
	
	public List<Usuario> listar(){
		Connection conexao = null;
		
		List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
		Usuario usuario = null;
		
		String sql = "SELECT * FROM usuario";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
						
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSobrenome(rs.getString("sobrenome"));
				usuario.setDataNascimento(rs.getString("dataNascimento"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setCelular(rs.getString("celular"));
				usuario.setTelefoneFixo(rs.getString("telefoneFixo"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setRg(rs.getString("rg"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setTipoUsuario(rs.getString("tipoUsuario"));
				usuario.setStatus(rs.getInt("status"));
				
				listaDeUsuarios.add(usuario);
			}			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.fechar(conexao);
		}
		return listaDeUsuarios;
	}		
	
	
	public boolean excluir(int registro){
		Connection conexao = null;
		
		String sql = "DELETE FROM pessoa WHERE id = ?";
		boolean retorno = false;
		
		try{
			int r = 0;
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, registro);
			r = ps.executeUpdate();
			
			if(r > 0)
				retorno = true;
									
		} catch (SQLException e){
			e.printStackTrace();
		}
		return retorno;
	}
	
	public boolean atualizar(Usuario usuario) {
		
		Connection conexao = null;
	        try {
	        	conexao = ConexaoFabrica.getConnection();
	        	
	            String query = "UPDATE usuario SET nome = ?, sobrenome = ?, dataNascimento = ?, sexo = ?"
	            		+ "celular = ?,telefoneFixo = ?, cpf = ?, rg = ?"
	            		+ "email = ?, senha = ?, tipoUsuario = ?, status = ? WHERE id = ?";

				PreparedStatement pstm = conexao.prepareStatement(query);

	            pstm.setString( 1, usuario.getNome());
	            pstm.setString( 2, usuario.getSobrenome());
	            pstm.setString( 3, usuario.getDataNascimento());
	            pstm.setString( 4, usuario.getSexo());
	            pstm.setString( 5, usuario.getCelular());
	            pstm.setString( 6, usuario.getTelefoneFixo());
	            pstm.setString( 7, usuario.getCpf());
	            pstm.setString( 8, usuario.getRg());
	            pstm.setString( 9, usuario.getEmail());
	            pstm.setString( 10, usuario.getSenha());
	            pstm.setString( 11, usuario.getTipoUsuario());
	            pstm.setInt(12, usuario.getStatus());
	            pstm.setInt( 13, usuario.getId());
	         
	            pstm.executeUpdate();
	            pstm.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return true;
	    }
}