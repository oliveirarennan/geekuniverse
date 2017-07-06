package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Fabricante;
import modelo.Frete;
import util.DBUtil;

public class FreteDao {
	
	public Frete cadastrar(Frete frete){
		Connection conexao = null;
		
		String sql = "INSERT INTO frete(prazo, valor) values(?, ?) ";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, frete.getPrazo());
			ps.setDouble(2, frete.getValor());
			
			if(ps.executeUpdate() == 0){
				return null;
			}
			try{
				ResultSet idGerado =  ps.getGeneratedKeys();
				if(idGerado.next()){
					frete.setId(idGerado.getInt(1));
				}
			}catch (Exception e) {
				e.getStackTrace();
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}  finally{
			DBUtil.fechar(conexao);
		}
		return frete;
	}
	
	public List<Frete> listar(){
		Connection conexao = null;
		
		List<Frete> listaDeFrete = new ArrayList<Frete>();
		Frete frete = null;
		
		String sql = "SELECT * FROM frete";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
						
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				frete = new Frete();
				frete.setId(rs.getInt("id"));
				frete.setPrazo(rs.getString("prazo"));
				frete.setValor(rs.getDouble("valor"));
				
				listaDeFrete.add(frete);
			}			
		} catch (SQLException e){
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}  finally{
			DBUtil.fechar(conexao);
		}
		return listaDeFrete;
	}		
	
	
	public boolean excluir(int registro){
		Connection conexao = null;
		
		String sql = "DELETE FROM frete WHERE id = ?";
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
		}catch (Exception e) {
			e.printStackTrace();
		} 
		return retorno;
	}
	
	public boolean atualizar(Frete frete) {
		
		Connection conexao = null;
	        try {
	        	conexao = ConexaoFabrica.getConnection();
	        	
	            String query = "UPDATE prazo = ?, valor = ? WHERE id = ?";

				PreparedStatement pstm = conexao.prepareStatement(query);

	            pstm.setString( 1, frete.getPrazo());
	            pstm.setDouble( 2, frete.getValor());
	         
	            pstm.executeUpdate();
	            pstm.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }catch (Exception e) {
				e.printStackTrace();
			} 
	        return true;
	    }
	
	public  Frete buscarPorId(int id){
		Connection conexao = null;
		
		Frete frete = null;
		
		String sql = "SELECT * FROM frete where id = ?";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
				frete = new Frete();
				frete.setId(rs.getInt("id"));
				frete.setPrazo(rs.getString("prazo"));
				frete.setValor(rs.getDouble("valor"));
							
		} catch (SQLException e){
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}  finally{
			DBUtil.fechar(conexao);
		}
		return frete;
	}
}