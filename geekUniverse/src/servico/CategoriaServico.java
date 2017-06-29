package servico;

import java.util.List;

import dao.CategoriaDao;
import modelo.Categoria;

public class CategoriaServico {
	
	public int cadastrar(Categoria categoria){
		CategoriaDao categoriaDao = new CategoriaDao();
		
		return categoriaDao.cadastrar(categoria);
	}
	
	public static boolean excluir(int registro){
		CategoriaDao categoriaDao = new CategoriaDao();
		
		return categoriaDao.excluir(registro);
	}
	
	public static List<Categoria> listar(){
		CategoriaDao categoriaDao = new CategoriaDao();
		
		return categoriaDao.listar();
	}
	
	public static List<Categoria> listarAtivada(){
		CategoriaDao categoriaDao = new CategoriaDao();
		
		return categoriaDao.listarAtivada();
	}

	public static boolean atualizar(Categoria categoria) {
		CategoriaDao categoriaDao = new CategoriaDao();
		
		return categoriaDao.atualizar(categoria);
	}
	
	public static Categoria buscarPorId(int id){
		return CategoriaDao.buscarPorId(id);
	}
}