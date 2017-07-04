package servico;

import java.util.List;

import dao.FormaPagamentoDao;
import modelo.FormaPagamento;

public class FormaPagamentoServico {
	
	public static FormaPagamento gravar(FormaPagamento formaDePagamento){
		FormaPagamentoDao fpDao = new FormaPagamentoDao();
		return fpDao.cadastrar(formaDePagamento);
		
	}
	
	public static boolean atualizar(FormaPagamento formaDePagamento){
		FormaPagamentoDao fpDao = new FormaPagamentoDao();
		return fpDao.atualizar(formaDePagamento);
		
	}
	
	public static boolean excluir(int id){
		FormaPagamentoDao fpDao = new FormaPagamentoDao();
		return fpDao.excluir(id);
		
	}
	
	public static List<FormaPagamento> listar(){
		FormaPagamentoDao fpDao = new FormaPagamentoDao();
		return fpDao.listar();
		
	}
	
	public static FormaPagamento buscarPorId(int id){
		FormaPagamentoDao fpDao = new FormaPagamentoDao();
		return fpDao.buscarPorId(id);
		
	}

}
