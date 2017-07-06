package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Categoria;
import modelo.Fabricante;
import modelo.Produto;
import servico.CategoriaServico;
import servico.FabricanteServico;
import util.DBUtil;

public class ProdutoDao {

	public int cadastrar(Produto produto){
		Connection conexao = null;
		int retorno = 0;
		String sql = "INSERT INTO produto(nome, descricao, valor, estoque, imagem, fabricante_id, categoria_id) values(?, ?, ?, ?, ?, ?, ?) ";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getDescricao());
			ps.setDouble(3, produto.getValor());
			ps.setInt(4, produto.getEstoque());
			ps.setString(5, produto.getImagem());
			ps.setInt(6, produto.getFabricante().getId());
			ps.setInt(7, produto.getCategoria().getId());
			
			retorno = ps.executeUpdate();
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.fechar(conexao);
		}
		return retorno;
	}
	
	public List<Produto> listar(){
		Connection conexao = null;
		
		List<Produto> listaDeProdutos = new ArrayList<Produto>();
		Produto produto = null;
		
		String sql = "SELECT * FROM produto";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
						
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setValor(rs.getDouble("valor"));
				produto.setEstoque(rs.getInt("estoque"));
				produto.setImagem(rs.getString("imagem"));
				produto.setCategoria(CategoriaServico.buscarPorId(rs.getInt("categoria_id")));
				produto.setFabricante(FabricanteServico.buscarPorId(rs.getInt("fabricante_id")));
				
				listaDeProdutos.add(produto);
			}			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.fechar(conexao);
		}
		return listaDeProdutos;
	}
	
	public List<Produto> listarUltimosCadastrados(){
		Connection conexao = null;
		
		List<Produto> listaDeProdutos = new ArrayList<Produto>();
		Produto produto = null;
		
		String sql = "SELECT * FROM produto where estoque > 0 ORDER BY id desc limit 4";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
						
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setValor(rs.getDouble("valor"));
				produto.setEstoque(rs.getInt("estoque"));
				produto.setImagem(rs.getString("imagem"));
				produto.setCategoria(CategoriaServico.buscarPorId(rs.getInt("categoria_id")));
				produto.setFabricante(FabricanteServico.buscarPorId(rs.getInt("fabricante_id")));
				
				listaDeProdutos.add(produto);
			}			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.fechar(conexao);
		}
		return listaDeProdutos;
	}
	
	public List<Produto> listarPorCategoria(Categoria categoria, int quantidade){
		Connection conexao = null;
		
		List<Produto> listaDeProdutos = new ArrayList<Produto>();
		Produto produto = null;
		String sql = null;
		if(quantidade > 0){
			sql = "SELECT * FROM produto where categoria_id = ? and estoque > 0 ORDER BY id desc limit ?";
		}else{
			sql = "SELECT * FROM produto where categoria_id = ? order by id desc";
		}
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			if(quantidade > 0){
				ps.setInt(1, categoria.getId());
				ps.setInt(2, quantidade);
			}else{
				ps.setInt(1, categoria.getId());
			}
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setValor(rs.getDouble("valor"));
				produto.setEstoque(rs.getInt("estoque"));
				produto.setImagem(rs.getString("imagem"));
				produto.setCategoria(CategoriaServico.buscarPorId(rs.getInt("categoria_id")));
				produto.setFabricante(FabricanteServico.buscarPorId(rs.getInt("fabricante_id")));
				
				listaDeProdutos.add(produto);
			}			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.fechar(conexao);
		}
		return listaDeProdutos;
	}
	
	public List<Produto> listarPorFabricante(Fabricante fabricante, int quantidade){
		Connection conexao = null;
		
		List<Produto> listaDeProdutos = new ArrayList<Produto>();
		Produto produto = null;
		String sql = null;
		if(quantidade > 0){
			sql = "SELECT * FROM produto where fabricante_id = ? and estoque > 0 ORDER BY id desc limit ?";
		}else{
			sql = "SELECT * FROM produto where fabricante_id = ? order by id desc";
		}
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			if(quantidade > 0){
				ps.setInt(1, fabricante.getId());
				ps.setInt(2, quantidade);
			}else{
				ps.setInt(1, fabricante.getId());
			}
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setValor(rs.getDouble("valor"));
				produto.setEstoque(rs.getInt("estoque"));
				produto.setImagem(rs.getString("imagem"));
				produto.setCategoria(CategoriaServico.buscarPorId(rs.getInt("categoria_id")));
				produto.setFabricante(FabricanteServico.buscarPorId(rs.getInt("fabricante_id")));
				
				listaDeProdutos.add(produto);
			}			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.fechar(conexao);
		}
		return listaDeProdutos;
	}
	
	public List<Produto> listarNoEstoque(){
		Connection conexao = null;
		
		List<Produto> listaDeProdutos = new ArrayList<Produto>();
		Produto produto = null;
		
		String sql = "SELECT * FROM produto where estoque > 0";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
						
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setValor(rs.getDouble("valor"));
				produto.setEstoque(rs.getInt("estoque"));
				produto.setImagem(rs.getString("imagem"));
				produto.setCategoria(CategoriaServico.buscarPorId(rs.getInt("categoria")));
				produto.setFabricante(FabricanteServico.buscarPorId(rs.getInt("fabricante")));
				
				listaDeProdutos.add(produto);
			}			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.fechar(conexao);
		}
		return listaDeProdutos;
	}
	
	
	public boolean excluir(int registro){
		Connection conexao = null;
		
		String sql = "DELETE FROM produto WHERE id = ?";
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
	
	public boolean atualizar(Produto produto) {
		
		Connection conexao = null;
	        try {
	        	conexao = ConexaoFabrica.getConnection();
	        	
	            String query = "UPDATE produto SET fabricante_id = ?, categoria_id = ?, nome = ?, descricao = ?, valor = ?, estoque = ?, imagem = ? WHERE id = ?";

				PreparedStatement pstm = conexao.prepareStatement(query);
				pstm.setInt(1, produto.getFabricante().getId());
				pstm.setInt(2, produto.getCategoria().getId());
	            pstm.setString(3, produto.getNome());
	            pstm.setString(4, produto.getDescricao());
	            pstm.setDouble(5, produto.getValor());
	            pstm.setInt(6, produto.getEstoque());
	            pstm.setString(7, produto.getImagem());
	            pstm.setInt(8, produto.getId());
	         
	            pstm.executeUpdate();
	            pstm.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return true;
	    }
	
	public static Produto buscarPorId(int id){
		Connection conexao = null;
		
		Produto produto = null;
		
		String sql = "SELECT * FROM produto where id = ?";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
				produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setValor(rs.getDouble("valor"));
				produto.setEstoque(rs.getInt("estoque"));
				produto.setImagem(rs.getString("imagem"));
				produto.setCategoria(CategoriaServico.buscarPorId(rs.getInt("categoria_id")));
				produto.setFabricante(FabricanteServico.buscarPorId(rs.getInt("fabricante_id")));
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.fechar(conexao);
		}
		return produto;
	}
	public  void adicionarNoEstoque(Produto produto, int quantidade){
		
			produto.setEstoque(produto.getEstoque() + quantidade);
		
		this.atualizar(produto);
	}
	
	public  void removerDoEstoque(Produto produto, int quantidade){
		if(produto.getEstoque() > quantidade){
			produto.setEstoque(produto.getEstoque() - quantidade);
		}else{
			produto.setEstoque(0);
		}
		this.atualizar(produto);
	}
	
	public List<Produto> buscarPorNome(String nome){
		Connection conexao = null;
		
		List<Produto> listaDeProdutos = new ArrayList<Produto>();
		Produto produto = null;
		
		String sql = "SELECT * FROM produto where nome like ?";
		
		try{
			conexao = ConexaoFabrica.getConnection();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, "%"+nome+"%");
						
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setValor(rs.getDouble("valor"));
				produto.setEstoque(rs.getInt("estoque"));
				produto.setImagem(rs.getString("imagem"));
				produto.setCategoria(CategoriaServico.buscarPorId(rs.getInt("categoria_id")));
				produto.setFabricante(FabricanteServico.buscarPorId(rs.getInt("fabricante_id")));
				
				listaDeProdutos.add(produto);
			}			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.fechar(conexao);
		}
		return listaDeProdutos;
	}

	
}