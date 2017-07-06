package servico;

import java.util.List;

import dao.ItemDao;
import modelo.Item;

public class ItemServico {
	
	public static int gravar(Item item){
		ItemDao dao = new ItemDao();
		return dao.cadastrar(item);
	}
	
	public static List<Item> listar(){
		ItemDao dao = new ItemDao();
		return dao.listar();
	}
	
	public static boolean atualizar(Item item){
		ItemDao dao = new ItemDao();
		return dao.atualizar(item);
	}
	
	public static boolean exckuir(int id){
		ItemDao dao = new ItemDao();
		return dao.excluir(id);
	}
	
	public static Item gravar(int id){
		ItemDao dao = new ItemDao();
		return dao.buscarPorId(id);
	}
	public static List<Item> listarPorPedido(int id){
		ItemDao dao = new ItemDao();
		return dao.listarPorPedido(id);
	}
	
	public static Item buscarPorId(int id){
		ItemDao dao = new ItemDao();
		return dao.buscarPorId(id);
	}
	
	public static Item buscarPorPedidoId(int id){
		ItemDao dao = new ItemDao();
		return dao.buscarPorPedidoId(id);
	}
}
