package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Usuario;
import servico.EnderecoServico;
import util.DBUtil;

public class UsuarioDao {
	
	public int cadastrar(Usuario usuario){
		Connection conexao = null;
		int retorno = 0;
		String sql = "INSERT INTO usuario(endereco_id, nome, sobrenome, dataNascimento, sexo, celular, telefoneFixo , cpf, rg, email, senha, tipoUsuario, status) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, usuario.getEndereco().getId());
			ps.setString(2, usuario.getNome());
			ps.setString(3, usuario.getSobrenome());
			ps.setString(4, usuario.getDataNascimento());
			ps.setString(5, usuario.getSexo());
			ps.setString(6, usuario.getCelular());
			ps.setString(7, usuario.getTelefoneFixo());
			ps.setString(8, usuario.getCpf());
			ps.setString(9, usuario.getRg());
			ps.setString(10, usuario.getEmail());
			ps.setString(11, usuario.getSenha());
			ps.setString(12, usuario.getTipoUsuario());
			ps.setInt(13, usuario.getStatus());
			
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
				usuario.setEndereco(EnderecoServico.bucarPorID(rs.getInt("endereco_id")));
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
		
		String sql = "DELETE FROM usuario WHERE id = ?";
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
	        	
	            String query = "UPDATE usuario SET endereco_id, nome = ?, sobrenome = ?, dataNascimento = ?, sexo = ?, celular = ?,telefoneFixo = ?, cpf = ?, rg = ?,email = ?, senha = ?, tipoUsuario = ?, status = ? WHERE id = ?";

				PreparedStatement pstm = conexao.prepareStatement(query);
				
				pstm.setInt(1, usuario.getEndereco().getId());
	            pstm.setString( 2, usuario.getNome());
	            pstm.setString( 3, usuario.getSobrenome());
	            pstm.setString( 4, usuario.getDataNascimento());
	            pstm.setString( 5, usuario.getSexo());
	            pstm.setString( 6, usuario.getCelular());
	            pstm.setString( 7, usuario.getTelefoneFixo());
	            pstm.setString( 8, usuario.getCpf());
	            pstm.setString( 9, usuario.getRg());
	            pstm.setString( 10, usuario.getEmail());
	            pstm.setString( 11, usuario.getSenha());
	            pstm.setString( 12, usuario.getTipoUsuario());
	            pstm.setInt(13, usuario.getStatus());
	            pstm.setInt( 14, usuario.getId());
	         
	            pstm.executeUpdate();
	            pstm.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return true;
	    }
	
	public Usuario buscarPorId(int id){
		Connection conexao = null;
		
		Usuario usuario = null;
		
		String sql = "SELECT * FROM usuario where id = ?";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				usuario = new Usuario();
				usuario.setEndereco(EnderecoServico.bucarPorID(rs.getInt("endereco_id")));
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
				
			}			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.fechar(conexao);
		}
		return usuario;
	}	
}