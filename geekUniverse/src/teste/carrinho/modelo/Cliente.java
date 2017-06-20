package teste.carrinho.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class Cliente {
	private int id;
	private String nome;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static List<Cliente> retornaUsuarios(){
		List<Cliente> clientes = new ArrayList<Cliente>();
		Cliente c1 = new Cliente();
		c1.setId(1);
		c1.setNome("Cliente 1");
		clientes.add(c1);
		
		
		Cliente c2 = new Cliente();
		c2.setId(2);
		c2.setNome("Cliente 2");
		clientes.add(c2);
		
		Cliente c3 = new Cliente();
		c3.setId(3);
		c3.setNome("Cliente 3");
		clientes.add(c3);
		
		return clientes;
		
	}
	
	public static Cliente retornaUsuarioLogado(){
		Cliente cliente = new Cliente();
		cliente.setId(100);
		cliente.setNome("Rennan Neves");
		
		
		return cliente;
	}
	
	

}
