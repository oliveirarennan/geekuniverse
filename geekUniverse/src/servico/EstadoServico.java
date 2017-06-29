package servico;

import java.util.List;

import dao.EstadoDao;
import modelo.Estado;

public class EstadoServico {
	
	public static List<Estado> listar(){
		return EstadoDao.listar();
	}
	
	public static Estado buscarPorId(int id){
		return EstadoDao.buscarPorId(id);
	}

}
