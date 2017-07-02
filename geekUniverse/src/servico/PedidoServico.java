package servico;

import java.util.List;

import dao.PedidoDao;
import modelo.Pedido;

public class PedidoServico {
	public static Pedido gravar(Pedido pedido){
		PedidoDao dao = new PedidoDao();
		return dao.cadastrar(pedido);
	}
	
	public static boolean atualizar(Pedido pedido){
		PedidoDao dao = new PedidoDao();
		return dao.atualizar(pedido);
	}
	
	public static List<Pedido> listar(){
		PedidoDao dao = new PedidoDao();
		return dao.listar();
	}
	
	public static boolean apagar(int id){
		PedidoDao dao = new PedidoDao();
		return dao.excluir(id);
	}
	
	public static Pedido buscarPorId(int id){
		PedidoDao dao = new PedidoDao();
		return dao.buscarPorId(id);
	}
}
