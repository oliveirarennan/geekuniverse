package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Categoria;
import util.DBUtil;

public class CategoriaDao {
	
	public int cadastrar(Categoria categoria){
		Connection conexao = null;
		int retorno = 0;
		String sql = "INSERT INTO categoria(nome, status) values(?, ?) ";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, categoria.getNome());
			ps.setString(3, categoria.getStatus());
			
			retorno = ps.executeUpdate();
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.fechar(conexao);
		}
		return retorno;
	}
	
	public List<Categoria> listar(){
		Connection conexao = null;
		
		List<Categoria> listaDeCategorias = new ArrayList<Categoria>();
		Categoria categoria = null;
		
		String sql = "SELECT * FROM categoria";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
						
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				categoria = new Categoria();
				categoria.setNome(rs.getString("nome"));
				categoria.setStatus(rs.getString("status"));
				
				listaDeCategorias.add(categoria);
			}			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.fechar(conexao);
		}
		return listaDeCategorias;
	}		
	
	public boolean excluir(int registro){
		Connection conexao = null;
		
		String sql = "DELETE FROM categoria WHERE nome = ?";
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
	
	public boolean atualizar(Categoria categoria) {
		
		Connection conexao = null;
	        try {
	        	conexao = ConexaoFabrica.getConnection();
	        	
	            String query = "UPDATE categoria SET nome = ?, status = ? WHERE id = ?";

				PreparedStatement pstm = conexao.prepareStatement(query);

	            pstm.setString( 1, categoria.getNome());
	            pstm.setString(2, categoria.getStatus());
	            pstm.setInt( 3, categoria.getId());
	         
	            pstm.executeUpdate();
	            pstm.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return true;
	    }
}