package servico;

import java.util.List;

import dao.CategoriaDao;
import dao.FormaPagamentoDao;
import dao.ProdutoDao;
import modelo.FormaPagamento;
import modelo.Produto;

public class ProdutoServico {
	
	public int cadastrar(Produto produto){
		ProdutoDao produtoDao = new ProdutoDao();
		
		return produtoDao.cadastrar(produto);
	}
	
	public boolean excluir(int registro){
		ProdutoDao produtoDao = new ProdutoDao();
		
		return produtoDao.excluir(registro);
	}
	
	public List<Produto> listar(){
		ProdutoDao produtoDao = new ProdutoDao();
		
		return produtoDao.listar();
	}

	public boolean atualizar(Produto produto) {
		ProdutoDao produtoDao = new ProdutoDao();
		
		return produtoDao.atualizar(produto);
	}
	
	public static FormaPagamento buscarPorId(int id){
		return FormaPagamentoDao.buscarPorId(id);
	}
}