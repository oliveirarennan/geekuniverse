package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Pedido;
import servico.FormaPagamentoServico;
import servico.FreteServico;
import servico.UsuarioServico;
import util.DBUtil;

public class PedidoDao {
	
	public Pedido cadastrar(Pedido pedido){
		Connection conexao = null;
		String sql = "INSERT INTO pedido(numeroPedido, formaPagamento_id, status, usuario_id, dataPedido, frete_id, valor) values(?, ?, ?, ?, ?, ?, ?) ";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, pedido.getNumeroPedido());
			ps.setInt(2, pedido.getFormaPagamento().getId());
			ps.setString(3, pedido.getStatusPedido());
			ps.setInt(4, pedido.getCliente().getId());
			ps.setString(5, pedido.getDataPedido());
			ps.setInt(6, pedido.getFrete().getId());
			ps.setDouble(7, pedido.getValor());
			
			if(ps.executeUpdate() == 0){
				return null;
			}
			try{
				ResultSet idGerado =  ps.getGeneratedKeys();
				if(idGerado.next()){
					pedido.setId(idGerado.getInt(1));
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
		return pedido;
	}
	
	public List<Pedido> listar(){
		Connection conexao = null;
		
		List<Pedido> listaDePedidos = new ArrayList<Pedido>();
		Pedido pedido = null;
		
		String sql = "SELECT * FROM pedido";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
						
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				pedido = new Pedido();
				pedido.setId(rs.getInt("id"));
				pedido.setNumeroPedido(rs.getInt("numeroPedido"));
				pedido.setFormaPagamento(FormaPagamentoServico.buscarPorId(rs.getInt("formaPagamento_id")));
				pedido.setStatusPedido(rs.getString("status"));
				pedido.setCliente(UsuarioServico.buscarPorId(rs.getInt("usuario_id")));
				pedido.setDataPedido(rs.getString("dataPedido"));
				pedido.setFrete(FreteServico.buscarPorId(rs.getInt("frete_id")));
				pedido.setValor(rs.getDouble("valor"));
				listaDePedidos.add(pedido);
			}			
		} catch (SQLException e){
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.fechar(conexao);
		}
		return listaDePedidos;
	}		
	
	
	public boolean excluir(int registro){
		Connection conexao = null;
		
		String sql = "DELETE FROM pedido WHERE numeroPedido = ?";
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
	
	public boolean atualizar(Pedido pedido) {
		
		Connection conexao = null;
	        try {
	        	conexao = ConexaoFabrica.getConnection();
	        	
	            String query = "UPDATE pedido SET formaPagamento_id = ?, status = ?, usuario_id = ?, dataPedido = ?, frete_id = ?, valor = ?, numeroPedido = ? WHERE id = ?";

				PreparedStatement pstm = conexao.prepareStatement(query);

	            pstm.setInt( 1, pedido.getFormaPagamento().getId());
	            pstm.setString( 2, pedido.getStatusPedido());
	            pstm.setInt( 3, pedido.getCliente().getId());
	            pstm.setString( 4, pedido.getDataPedido());
	            pstm.setInt( 5, pedido.getFrete().getId());
	            pstm.setDouble( 6, pedido.getValor());
	            pstm.setInt( 7, pedido.getNumeroPedido());
	            pstm.setInt(8, pedido.getId());
	            
	            pstm.executeUpdate();
	            pstm.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }catch (Exception e) {
				e.printStackTrace();
			} 
	        return true;
	    }
	
	public Pedido buscarPorId(int id){
		Connection conexao = null;
		
		Pedido pedido = null;
		
		String sql = "SELECT * FROM pedido where id = ?";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);
						
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				pedido = new Pedido();
				pedido.setId(rs.getInt("id"));
				pedido.setNumeroPedido(rs.getInt("numeroPedido"));
				pedido.setFormaPagamento(FormaPagamentoServico.buscarPorId(rs.getInt("formaPagamento_id")));
				pedido.setStatusPedido(rs.getString("status"));
				pedido.setCliente(UsuarioServico.buscarPorId(rs.getInt("usuario_id")));
				pedido.setDataPedido(rs.getString("dataPedido"));
				pedido.setFrete(FreteServico.buscarPorId(rs.getInt("frete_id")));
				pedido.setValor(rs.getDouble("valor"));
				
			}			
		} catch (SQLException e){
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}  finally{
			DBUtil.fechar(conexao);
		}
		return pedido;
	}
	
	public List<Pedido> listarPorUsuario(int id){
		Connection conexao = null;
		
		List<Pedido> listaDePedidos = new ArrayList<Pedido>();
		Pedido pedido = null;
		
		String sql = "SELECT * FROM pedido where usuario_id = ?";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);
						
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				pedido = new Pedido();
				pedido.setId(rs.getInt("id"));
				pedido.setNumeroPedido(rs.getInt("numeroPedido"));
				pedido.setFormaPagamento(FormaPagamentoServico.buscarPorId(rs.getInt("formaPagamento_id")));
				pedido.setStatusPedido(rs.getString("status"));
				pedido.setCliente(UsuarioServico.buscarPorId(rs.getInt("usuario_id")));
				pedido.setDataPedido(rs.getString("dataPedido"));
				pedido.setFrete(FreteServico.buscarPorId(rs.getInt("frete_id")));
				pedido.setValor(rs.getDouble("valor"));
				listaDePedidos.add(pedido);
			}			
		} catch (SQLException e){
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}  finally{
			DBUtil.fechar(conexao);
		}
		return listaDePedidos;
	}	
}