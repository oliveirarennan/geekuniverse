package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Estado;
import util.DBUtil;

public class EstadoDao {
	
	public static List<Estado> listar(){
		Connection conexao = null;
		
		List<Estado> listaDeEstados = new ArrayList<Estado>();
		Estado estado = null;
		
		String sql = "SELECT * from estados";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
						
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				estado = new Estado();
				estado.setId(rs.getInt("id"));
				estado.setSigla(rs.getString("sigla"));
				estado.setDescricao(rs.getString("descricao"));
				
				listaDeEstados.add(estado);
			}			
		} catch (SQLException e){
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}  finally{
			DBUtil.fechar(conexao);
		}
		return listaDeEstados;
	}	
	
	public static Estado buscarPorId(int id){
		Connection conexao = null;
		
		Estado estado = null;
		
		String sql = "SELECT * FROM estados where id = ?";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);
						
			ResultSet rs = ps.executeQuery();
			
			rs.next();
				estado = new Estado();
				estado.setId(rs.getInt("id"));
				estado.setSigla(rs.getString("sigla"));
				estado.setDescricao(rs.getString("descricao"));
				
		} catch (SQLException e){
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		} 
		finally{
			DBUtil.fechar(conexao);
		}
		return estado;
	}	

}
