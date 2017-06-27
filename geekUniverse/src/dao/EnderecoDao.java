package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Endereco;
import util.DBUtil;

public class EnderecoDao {
	
	public int cadastrar(Endereco endereco){
		Connection conexao = null;
		int retorno = 0;
		String sql = "INSERT INTO endereco(pais, estado, cidade, bairro, rua, numero, complemento, cep) values(?, ?, ?, ?, ?, ?, ?, ?) ";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, endereco.getPais());
			ps.setString(2, endereco.getEstado());
			ps.setString(3, endereco.getCidade());
			ps.setString(4, endereco.getBairro());
			ps.setString(5, endereco.getRua());
			ps.setInt(6, endereco.getNumero());
			ps.setString(7, endereco.getComplemento());
			ps.setString(8, endereco.getCep());
			
			if(ps.executeUpdate() > 0){
				retorno = ps.getGeneratedKeys().getInt(1);
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.fechar(conexao);
		}
		return retorno;
	}
	
	public Endereco buscarId(int id){
		Connection conexao = null;
		Endereco endereco = null;
		
		String sql = "SELECT id FROM endereco WHERE id = ?";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			PreparedStatement ps;
			ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				endereco = new Endereco();
				endereco.setId(rs.getInt("id"));
				endereco.setRua(rs.getString("rua"));
				endereco.setNumero(Integer.parseInt(rs.getString("numero")));
				endereco.setComplemento(rs.getString("complemento"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setEstado(rs.getString("estado"));
				endereco.setPais(rs.getString("pais"));
				endereco.setCep(rs.getString("cep"));
				
				return endereco;
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return endereco;
	}
	
	public boolean atualizar(Endereco endereco) {
			
			Connection conexao = null;
		        try {
		        	conexao = ConexaoFabrica.getConnection();
		        	
		            String query = "UPDATE endereco SET pais = ?, estado = ?, cidade = ?, bairro = ?, rua = ?, numero = ?, complemento = ?, cep = ? WHERE id = ?";
	
					PreparedStatement pstm = conexao.prepareStatement(query);
	
					pstm.setString( 1, endereco.getPais());
		            pstm.setString( 2, endereco.getEstado());
		            pstm.setString( 3, endereco.getCidade());
		            pstm.setString( 4, endereco.getBairro());
		            pstm.setString( 5, endereco.getRua());
		            pstm.setInt( 6, endereco.getNumero());
		            pstm.setString( 7, endereco.getComplemento());
		            pstm.setString( 8, endereco.getCep());
		            pstm.setInt( 9, endereco.getId());
		         
		            pstm.executeUpdate();
		            pstm.close();
	
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return true;
		    }
	
	
	public List<Endereco> listarEndereco(){
		Connection conexao = null;
		
		List<Endereco> listaDeEnderecos = new ArrayList<Endereco>();
		Endereco endereco = null;
		
		String sql = "SELECT * FROM endereco";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
						
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				endereco = new Endereco();
				endereco.setId(rs.getInt("id"));
				endereco.setPais(rs.getString("pais"));
				endereco.setEstado(rs.getString("estado"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setRua(rs.getString("rua"));
				endereco.setNumero(rs.getInt("numero"));
				endereco.setComplemento(rs.getString("complemento"));
				endereco.setCep(rs.getString("cep"));
				
				listaDeEnderecos.add(endereco);
			}			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.fechar(conexao);
		}
		return listaDeEnderecos;
	}		
	
	public boolean excluir(int registro){
		Connection conexao = null;
		
		String sql = "DELETE FROM endereco WHERE id = ?";
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
}