package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Fabricante;
import modelo.Item;
import servico.PedidoServico;
import servico.ProdutoServico;
import util.DBUtil;

public class ItemDao {
	
	public int cadastrar(Item item){
		Connection conexao = null;
		int retorno = 0;
		String sql = "INSERT INTO item(produto_id, pedido_id, quantidade, preco) values(?, ?,?,?) ";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, item.getProduto().getId());
			ps.setInt(2, item.getPedido().getId());
			ps.setInt(3, item.getQuantidade());
			ps.setDouble(4, item.getPreco());
			
			retorno = ps.executeUpdate();
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.fechar(conexao);
		}
		return retorno;
	}
	
	public List<Item> listar(){
		Connection conexao = null;
		
		List<Item> listaDeItem = new ArrayList<Item>();
		Item item = null;
		
		String sql = "SELECT * FROM item";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
						
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				item = new Item();
				item.setId(rs.getInt("id"));
				item.setPedido(PedidoServico.buscarPorId(rs.getInt("pedido_id")));
				item.setProduto(ProdutoServico.buscarPorId(rs.getInt("produto_id")));
				item.setQuantidade(rs.getInt("quantidade"));
				item.setPreco(rs.getDouble("preco"));
				
				listaDeItem.add(item);
			}			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.fechar(conexao);
		}
		return listaDeItem;
	}		
	
	
	public boolean excluir(int registro){
		Connection conexao = null;
		
		String sql = "DELETE FROM item WHERE id = ?";
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
	
	public boolean atualizar(Item item) {
		
		Connection conexao = null;
	        try {
	        	conexao = ConexaoFabrica.getConnection();
	        	
	            String query = "UPDATE item SET pedido_id = ?, produto_id = ? quantidade = ?, preco = ? WHERE id = ?";

				PreparedStatement pstm = conexao.prepareStatement(query);
				
				pstm.setInt( 1, item.getPedido().getId());
				pstm.setInt( 2, item.getProduto().getId());
				pstm.setInt( 3, item.getQuantidade());
	            pstm.setDouble( 4, item.getPreco());
	            pstm.setInt( 5, item.getId());
	         
	            pstm.executeUpdate();
	            pstm.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return true;
	    }
	
	public  Item buscarPorId(int id){
		Connection conexao = null;
		
		Item item = null;
		
		String sql = "SELECT * FROM item where id = ?";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
				item = new Item();
				item.setId(rs.getInt("id"));
				item.setPedido(PedidoServico.buscarPorId(rs.getInt("pedido_id")));
				item.setProduto(ProdutoServico.buscarPorId(rs.getInt("produto_id")));
				item.setQuantidade(rs.getInt("quantidade"));
				item.setPreco(rs.getDouble("preco"));
							
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.fechar(conexao);
		}
		return item;
	}
}