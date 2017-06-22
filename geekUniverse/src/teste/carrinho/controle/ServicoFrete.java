package teste.carrinho.controle;

import br.com.techzee.correios.ws.ConsultaCorreios;
import br.com.techzee.correios.ws.dto.CorreiosPrecoPrazo;
import teste.carrinho.modelo.Frete;

public class ServicoFrete {
	
	public static Frete CalcularFrete(String cepOrigem, String cepDestino ){
		Frete frete = new Frete();
		try {
			CorreiosPrecoPrazo result = new ConsultaCorreios().calcularPrecoPrazo(cepOrigem, cepDestino)[0];
			frete.setPrazo(result.getPrazoEntrega().toString());
			frete.setValor(result.getPrecoFrete());
			System.out.println(String.format("Valor do Frete: %f - Prazo de Entrega: %d dias", result.getPrecoFrete(), result.getPrazoEntrega()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			frete.setValor(null);
			frete.setPrazo(e.getMessage());
			
			e.printStackTrace();
			
		}
		return frete;
	}

}
