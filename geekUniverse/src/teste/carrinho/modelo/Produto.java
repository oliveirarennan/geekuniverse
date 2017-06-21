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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + estoque;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (estoque != other.estoque)
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
	
	
	
}
