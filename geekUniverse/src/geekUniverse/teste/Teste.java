package geekUniverse.teste;

import java.util.List;

import teste.carrinho.modelo.Produto;

public class Teste {

	public static void main(String[] args) {
		
		List<Produto> produtos = Produto.retornaProdutos();
		
		System.out.println(produtos.get(1).getId());

	}

}
