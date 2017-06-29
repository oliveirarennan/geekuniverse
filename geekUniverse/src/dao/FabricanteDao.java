package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Fabricante;
import util.DBUtil;

public class FabricanteDao {
	
	public int cadastrar(Fabricante fabricante){
		Connection conexao = null;
		int retorno = 0;
		String sql = "INSERT INTO fabricante(nome, cnpj, status) values(?, ?, ?) ";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, fabricante.getNome());
			ps.setString(2, fabricante.getCnpj());
			ps.setInt(3, fabricante.getStatus());
			
			retorno = ps.executeUpdate();
			
		} catch (SQLException e){
			e.printStackTrace();
			return retorno;
		} finally{
			DBUtil.fechar(conexao);
			
		}
		return retorno;
	}
	
	public List<Fabricante> listar(){
		Connection conexao = null;
		
		List<Fabricante> listaDeFabricantes = new ArrayList<Fabricante>();
		Fabricante fabricante = null;
		
		String sql = "SELECT * FROM fabricante";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
						
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				fabricante = new Fabricante();
				fabricante.setId(rs.getInt("id"));
				fabricante.setNome(rs.getString("nome"));
				fabricante.setCnpj(rs.getString("cnpj"));
				fabricante.setStatus(rs.getInt("status"));
				
				listaDeFabricantes.add(fabricante);
			}			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.fechar(conexao);
		}
		return listaDeFabricantes;
	}
	
	public List<Fabricante> listarAtivado(){
		Connection conexao = null;
		
		List<Fabricante> listaDeFabricantes = new ArrayList<Fabricante>();
		Fabricante fabricante = null;
		
		String sql = "SELECT * FROM fabricante where status = 1";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
						
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				fabricante = new Fabricante();
				fabricante.setId(rs.getInt("id"));
				fabricante.setNome(rs.getString("nome"));
				fabricante.setCnpj(rs.getString("cnpj"));
				fabricante.setStatus(rs.getInt("status"));
				
				listaDeFabricantes.add(fabricante);
			}			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.fechar(conexao);
		}
		return listaDeFabricantes;
	}	
	
	
	public  boolean excluir(int registro){
		Connection conexao = null;
		
		String sql = "DELETE FROM fabricante WHERE id = ?";
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
	
	public boolean atualizar(Fabricante fabricante) {
		
		Connection conexao = null;
	        try {
	        	conexao = ConexaoFabrica.getConnection();
	        	
	            String query = "UPDATE fabricante SET nome = ?, cnpj = ?, status = ? WHERE id = ?";

				PreparedStatement pstm = conexao.prepareStatement(query);

	            pstm.setString( 1, fabricante.getNome());
	            pstm.setString(2, fabricante.getCnpj());
	            pstm.setInt(3, fabricante.getStatus());
	            pstm.setInt(4, fabricante.getId());
	         
	            pstm.executeUpdate();
	            pstm.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return true;
	    }
	
	public static Fabricante buscarPorId(int id){
		Connection conexao = null;
		
		Fabricante fabricante = null;
		
		String sql = "SELECT * FROM fabricante where id = ?";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);
						
			ResultSet rs = ps.executeQuery();
			
			rs.next();
				fabricante = new Fabricante();
				fabricante.setId(rs.getInt("id"));
				fabricante.setNome(rs.getString("nome"));
				fabricante.setCnpj(rs.getString("cnpj"));
				fabricante.setStatus(rs.getInt("status"));
				
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.fechar(conexao);
		}
		return fabricante;
	}	
}