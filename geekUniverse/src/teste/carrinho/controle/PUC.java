package teste.carrinho.controle;

import br.com.techzee.correios.ws.ConsultaCorreios;
import br.com.techzee.correios.ws.dto.CorreiosPrecoPrazo;

public class PUC {
	public static void main(String [] args){
		try {
			CorreiosPrecoPrazo result = new ConsultaCorreios().calcularPrecoPrazo("24020000", "0")[0];
			System.out.println(String.format("Valor do Frete: %f - Prazo de Entrega: %d dias", result.getPrecoFrete(), result.getPrazoEntrega()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
}
