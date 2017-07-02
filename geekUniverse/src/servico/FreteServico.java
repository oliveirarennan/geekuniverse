package servico;

import java.util.List;

import dao.FreteDao;
import modelo.Frete;

public class FreteServico {
	public static Frete gravar(Frete frete){
		FreteDao fDao= new FreteDao();
		return fDao.cadastrar(frete);
	}
	
public static boolean atualizar(Frete frete){
		FreteDao fDao= new FreteDao();
		return fDao.atualizar(frete);
	}

public static boolean excluir(int id){
	FreteDao fDao= new FreteDao();
	return fDao.excluir(id);
}

public static List<Frete> listar(){
	FreteDao fDao= new FreteDao();
	return fDao.listar();
}

public static Frete buscarPorId(int id){
	FreteDao fDao= new FreteDao();
	return fDao.buscarPorId(id);
}

}
