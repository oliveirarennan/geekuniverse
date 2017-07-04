package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.FormaPagamento;
import modelo.Produto;
import util.DBUtil;

public class FormaPagamentoDao {
	
	public FormaPagamento cadastrar(FormaPagamento pagamento){
		Connection conexao = null;
		
		String sql = "INSERT INTO formaPagamento(tipoPagamento, parcelas, valor, info) values(?, ?, ?, ?) ";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, pagamento.getTipoPagamento());
			ps.setInt(2, pagamento.getParcelas());
			ps.setDouble(3, pagamento.getValor());
			ps.setString(4, pagamento.getInfo());
			
			if(ps.executeUpdate() == 0){
				return null;
			}
			try{
				ResultSet idGerado =  ps.getGeneratedKeys();
				if(idGerado.next()){
					pagamento.setId(idGerado.getInt(1));
				}
			}catch (Exception e) {
				e.getStackTrace();
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.fechar(conexao);
		}
		return pagamento;
	}
	
	public List<FormaPagamento> listar(){
		Connection conexao = null;
		
		List<FormaPagamento> listaDeFormaPagamento = new ArrayList<FormaPagamento>();
		FormaPagamento pagamento = null;
		
		String sql = "SELECT * FROM formaPagamento";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
						
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				pagamento = new FormaPagamento();
				pagamento.setId(rs.getInt("id"));
				pagamento.setTipoPagamento(rs.getString("tipoPagamento"));
				pagamento.setParcelas(rs.getInt("parcelas"));
				pagamento.setValor(rs.getDouble("valor"));
				pagamento.setInfo(rs.getString("info"));
				
				listaDeFormaPagamento.add(pagamento);
			}			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.fechar(conexao);
		}
		return listaDeFormaPagamento;
	}
	
	
	
	
	public boolean excluir(int registro){
		Connection conexao = null;
		
		String sql = "DELETE FROM formaPagamento WHERE id = ?";
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
	
	public boolean atualizar(FormaPagamento pagamento) {
		
		Connection conexao = null;
	        try {
	        	conexao = ConexaoFabrica.getConnection();
	        	
	            String query = "UPDATE formaPagamento SET tipoPagamento = ?, parcelas = ?, valor = ?, info = ? WHERE id = ?";

				PreparedStatement pstm = conexao.prepareStatement(query);

	            pstm.setString( 1, pagamento.getTipoPagamento());
	            pstm.setInt( 2, pagamento.getParcelas());
	            pstm.setDouble( 3, pagamento.getValor());
	            pstm.setString( 4, pagamento.getInfo());
	            pstm.setInt( 5, pagamento.getId());

	            pstm.executeUpdate();
	            pstm.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return true;
	    }
	
	public  FormaPagamento buscarPorId(int id){
		Connection conexao = null;
		
		FormaPagamento formaPagamento = null;
		
		String sql = "SELECT * FROM formaPagamento where id = ?";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
				formaPagamento = new FormaPagamento();
				formaPagamento.setTipoPagamento(rs.getString("tipoPagamento"));
				formaPagamento.setParcelas(rs.getInt("parcelas"));
				formaPagamento.setValor(rs.getDouble("valor"));
				formaPagamento.setInfo(rs.getString("info"));
				
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.fechar(conexao);
		}
		return formaPagamento;
	}
}