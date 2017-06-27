package servico;

import java.util.List;

import dao.FabricanteDao;
import modelo.Fabricante;

public class FabricanteServico {
	
	public int cadastrar(Fabricante fabricante){
		FabricanteDao fabricanteDao = new FabricanteDao();
		
		return fabricanteDao.cadastrar(fabricante);
	}
	
	public boolean excluir(int registro){
		FabricanteDao fabricanteDao = new FabricanteDao();
		
		return fabricanteDao.excluir(registro);
	}
	
	public List<Fabricante> listar(){
		FabricanteDao fabricanteDao = new FabricanteDao();
		
		return fabricanteDao.listar();
	}

	public boolean atualizar(Fabricante fabricante) {
		FabricanteDao fabricanteDao = new FabricanteDao();
		
		return fabricanteDao.atualizar(fabricante);
	}
	
	public static Fabricante buscarPorId(int id){
		return FabricanteDao.buscarPorId(id);
	}
}