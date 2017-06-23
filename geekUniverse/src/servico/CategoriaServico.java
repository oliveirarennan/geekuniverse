package servico;

import java.util.List;

import dao.CategoriaDao;
import modelo.Categoria;

public class CategoriaServico {
	
	public boolean excluir(int registro){
		CategoriaDao categoriaDao = new CategoriaDao();
		
		return categoriaDao.excluir(registro);
	}
	
	public List<Categoria> listar(){
		CategoriaDao categoriaDao = new CategoriaDao();
		
		return categoriaDao.listar();
	}

	public boolean atualizar(Categoria categoria) {
		CategoriaDao categoriaDao = new CategoriaDao();
		
		return categoriaDao.atualizar(categoria);
	}
}