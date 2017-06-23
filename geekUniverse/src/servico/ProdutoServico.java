package servico;

import java.util.List;

import dao.ProdutoDao;
import modelo.Produto;

public class ProdutoServico {
	
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
}