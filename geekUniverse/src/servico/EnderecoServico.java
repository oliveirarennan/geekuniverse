package servico;

import dao.EnderecoDao;
import modelo.Endereco;

public class EnderecoServico {
	
	public static Endereco cadastrar(Endereco endereco){
		EnderecoDao ed = new EnderecoDao();
		
		return ed.cadastrar(endereco);
	}
	
	public static Endereco bucarPorID(int id){
		EnderecoDao ed = new EnderecoDao();
		
		return ed.buscarId(id);
	}

}
