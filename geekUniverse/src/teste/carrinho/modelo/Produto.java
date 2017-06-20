package teste.carrinho.modelo;

import java.util.ArrayList;
import java.util.List;

public class Produto {
	
	private int id;
	private String nome;
	private Double valor;
	private int estoque;
	
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
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
	public static List<Produto> retornaProdutos(){
		List<Produto> produtos = new ArrayList<Produto>();
		
		Produto p1 = new Produto();
		p1.setId(1);
		p1.setNome("Produto1");
		p1.setValor(1.);
		p1.setEstoque(5);
		produtos.add(p1);
		
		Produto p2 = new Produto();
		p2.setId(2);
		p2.setNome("Produto2");
		p2.setValor(2.);
		p2.setEstoque(2);
		produtos.add(p2);
		
		Produto p3 = new Produto();
		p3.setId(3);
		p3.setNome("Produto3");
		p3.setValor(3.);
		p3.setEstoque(1);
		produtos.add(p3);
	
		return produtos;
	}
	
}
