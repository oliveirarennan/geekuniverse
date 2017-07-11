package servico;

import java.util.List;

import dao.CategoriaDao;
import dao.FormaPagamentoDao;
import dao.ProdutoDao;
import modelo.Categoria;
import modelo.Fabricante;
import modelo.FormaPagamento;
import modelo.Produto;

public class ProdutoServico {
	
	public int cadastrar(Produto produto){
		ProdutoDao produtoDao = new ProdutoDao();
		
		return produtoDao.cadastrar(produto);
	}
	
	public static boolean excluir(int registro){
		ProdutoDao produtoDao = new ProdutoDao();
		
		return produtoDao.excluir(registro);
	}
	
	public List<Produto> listar(){
		ProdutoDao produtoDao = new ProdutoDao();
		
		return produtoDao.listar();
	}
	public static List<Produto> listarUltimosCadastrados(){
		ProdutoDao produtoDao = new ProdutoDao();
		
		return produtoDao.listarUltimosCadastrados();
	}
	public static List<Produto> listarPorCategoria(Categoria categoria, int quantidade){
		ProdutoDao produtoDao = new ProdutoDao();
		
		return produtoDao.listarPorCategoria(categoria, quantidade);
	}
	
	public static List<Produto> listarPorFabricante(Fabricante fabricante, int quantidade){
		ProdutoDao produtoDao = new ProdutoDao();
		
		return produtoDao.listarPorFabricante(fabricante, quantidade);
	}
	
	public List<Produto> listarNoEstoque(){
		ProdutoDao produtoDao = new ProdutoDao();
		
		return produtoDao.listarNoEstoque();
	}

	public static boolean atualizar(Produto produto) {
		ProdutoDao produtoDao = new ProdutoDao();
		
		return produtoDao.atualizar(produto);
	}
	
	public static Produto buscarPorId(int id){
		return ProdutoDao.buscarPorId(id);
	}
	
	public static void  adicionarAoEstoque(Produto produto, int quantidade){
		ProdutoDao produtoDao = new ProdutoDao();
		
		produtoDao.adicionarNoEstoque(produto, quantidade);
	}
	
	public static void  removerDoEstoque(Produto produto, int quantidade){
		ProdutoDao produtoDao = new ProdutoDao();
		
		produtoDao.removerDoEstoque(produto, quantidade);
	}
	
	public static List<Produto> buscarPorNome(String nome){
		ProdutoDao produtoDao = new ProdutoDao();
		
		return produtoDao.buscarPorNome(nome);
	}
	
	public static List<Produto> listarQuadrinhos(){
		ProdutoDao produtoDao = new ProdutoDao();
		return produtoDao.listarQuadrinhos();
	}
	
	public static List<Produto> listarLivros(){
		ProdutoDao produtoDao = new ProdutoDao();
		return produtoDao.listarLivros();
	}
	
	public static List<Produto> listarActionFigures(){
		ProdutoDao produtoDao = new ProdutoDao();
		return produtoDao.listarActionFigures();
	}
}