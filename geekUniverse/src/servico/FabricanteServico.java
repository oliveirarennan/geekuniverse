package servico;

import java.util.List;

import dao.FabricanteDao;
import modelo.Fabricante;

public class FabricanteServico {
	
	public int cadastrar(Fabricante fabricante){
		FabricanteDao fabricanteDao = new FabricanteDao();
		
		return fabricanteDao.cadastrar(fabricante);
	}
	
	public static boolean excluir(int registro){
		FabricanteDao fabricanteDao = new FabricanteDao();
		
		return fabricanteDao.excluir(registro);
	}
	
	public List<Fabricante> listar(){
		FabricanteDao fabricanteDao = new FabricanteDao();
		
		return fabricanteDao.listar();
	}
	
	public List<Fabricante> listarAtivado(){
		FabricanteDao fabricanteDao = new FabricanteDao();
		
		return fabricanteDao.listarAtivado();
	}

	public static boolean atualizar(Fabricante fabricante) {
		FabricanteDao fabricanteDao = new FabricanteDao();
		
		return fabricanteDao.atualizar(fabricante);
	}
	
	public static Fabricante buscarPorId(int id){
		return FabricanteDao.buscarPorId(id);
	}
}