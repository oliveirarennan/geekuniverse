package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// import modelo.Frete;
// import modelo.Usuario
// import modelo.FormaPagamento;
import modelo.Pedido;
import servico.CategoriaServico;
import util.DBUtil;

public class PedidoDao {
	
	public int cadastrar(Pedido pedido){
		Connection conexao = null;
		int retorno = 0;
		String sql = "INSERT INTO pedido(numeroPedido, formaPagamento, statusPedido, cliente, dataPedido, frete) values(?, ?, ?, ?, ?, ?) ";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, pedido.getNumeroPedido());
			ps.setInt(2, pedido.getFormaPagamento().getId());
			ps.setString(3, pedido.getStatusPedido());
			ps.setString(4, pedido.getStatusPedido());
			ps.setInt(5, pedido.getCliente().getId());
		//	ps.set(6, pedido.getDataPedido());
			ps.setInt(6, pedido.getFrete().getId());
			
			retorno = ps.executeUpdate();
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.fechar(conexao);
		}
		return retorno;
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
				pedido.setNumeroPedido(rs.getInt("numeroPedido"));
			//	pedido.setFormaPagamento(FormaPagamentoServico.buscarPorId(rs.getInt("formaPagamento")));
				pedido.setStatusPedido(rs.getString("statusPedido"));
			//	pedido.setCliente(rs.getUsuario().getId());
			//	pedido.setDataPedido(rs.getCalendar("dataPedido"));
			//	pedido.setFrete(rs.getFrete().getId());
				
				listaDePedidos.add(pedido);
			}			
		} catch (SQLException e){
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
		}
		return retorno;
	}
	
	public boolean atualizar(Pedido pedido) {
		
		Connection conexao = null;
	        try {
	        	conexao = ConexaoFabrica.getConnection();
	        	
	            String query = "UPDATE pedido SET formaPagamento = ?, statusPedido = ?, cliente = ?, dataPedido = ?, frete = ? WHERE numeroPedido = ?";

				PreparedStatement pstm = conexao.prepareStatement(query);

	            pstm.setInt( 1, pedido.getFormaPagamento().getId());
	            pstm.setString( 2, pedido.getStatusPedido());
	            pstm.setInt( 3, pedido.getCliente().getId());
	        //  pstm.set...( 4, pedido.getDataPedido());
	            pstm.setInt( 5, pedido.getFrete().getId());
	            pstm.setInt( 6, pedido.getNumeroPedido());
	         
	            pstm.executeUpdate();
	            pstm.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return true;
	    }
}