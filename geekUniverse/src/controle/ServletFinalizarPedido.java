package controle;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import modelo.FormaPagamento;
import modelo.Frete;
import modelo.Item;
import modelo.Pedido;
import servico.FormaPagamentoServico;
import servico.FreteServico;
import servico.ItemServico;
import servico.PedidoServico;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Endereco;
import br.com.caelum.stella.boleto.Pagador;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;

/**
 * Servlet implementation class ServletFinalizarPedido
 */
@WebServlet("/ServletFinalizarPedido")
@MultipartConfig
public class ServletFinalizarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
private String pastaBoletos = null;
	
	public void init() throws ServletException{
		super.init();
		
		pastaBoletos = getServletContext().getInitParameter("pastaBoletos");
	}
	
    public ServletFinalizarPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Item> itens = (List<Item>) request.getSession().getAttribute("ItensCarrinho");
		Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
		Frete frete = (Frete) request.getSession().getAttribute("Frete");
		
		
		
		FormaPagamento formaPagamento = new FormaPagamento();
		formaPagamento.setParcelas(1);
		formaPagamento.setTipoPagamento(request.getParameter("formaPagamento"));
		formaPagamento.setValor(pedido.getValor());
		
		
		
		pedido.setFrete(FreteServico.gravar(frete));
		pedido.setFormaPagamento(FormaPagamentoServico.gravar(formaPagamento));
		pedido.setId(PedidoServico.gravar(pedido).getId());
		pedido.setNumeroPedido(pedido.getId() + 1000);
		formaPagamento.setInfo("boleto_pedido_"+pedido.getNumeroPedido()+".pdf");
		FormaPagamentoServico.atualizar(formaPagamento);
		pedido.setFormaPagamento(formaPagamento);
		PedidoServico.atualizar(pedido);
		
		
		
		
		
		for  (Item item : itens) {
			item.setPedido(pedido);
			ItemServico.gravar(item);
		}
		
		//Gerar Boleto
		Calendar c = Calendar.getInstance();
		
		Datas datas = Datas.novasDatas()
                .comDocumento(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH), c.get(Calendar.YEAR))
                .comProcessamento(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH), c.get(Calendar.YEAR))
                .comVencimento(c.get(Calendar.DAY_OF_MONTH + 3), c.get(Calendar.MONTH), c.get(Calendar.YEAR));  

        Endereco enderecoBeneficiario = Endereco.novoEndereco()
        		.comLogradouro("Rua Almirante Teffé, 680")  
        		.comBairro("Centro")  
        		.comCep("24030-085")  
        		.comCidade("Niterói")  
        		.comUf("RJ");  

        //Quem emite o boleto
        Beneficiario beneficiario = Beneficiario.novoBeneficiario()  
                .comNomeBeneficiario("GeekUniver Lojas de Tranqueiras")  
                .comAgencia("4242").comDigitoAgencia("4")  
                .comCodigoBeneficiario("76000")  
                .comDigitoCodigoBeneficiario("5")  
                .comNumeroConvenio("1207113")  
                .comCarteira("18")  
                .comEndereco(enderecoBeneficiario)
                .comNossoNumero("9000206");  

        Endereco enderecoPagador = Endereco.novoEndereco()
        		.comLogradouro(pedido.getCliente().getEndereco().getRua())  
        		.comBairro(pedido.getCliente().getEndereco().getBairro())  
        		.comCep(pedido.getCliente().getEndereco().getCep())  
        		.comCidade(pedido.getCliente().getEndereco().getCidade())  
        		.comUf(pedido.getCliente().getEndereco().getEstado().getSigla());  
        
        //Quem paga o boleto
        Pagador pagador = Pagador.novoPagador()  
                .comNome(pedido.getCliente().getNome() + " "+ pedido.getCliente().getSobrenome() )  
                .comDocumento(pedido.getCliente().getCpf())
                .comEndereco(enderecoPagador);

        Banco banco = new BancoDoBrasil();  

        Boleto boleto = Boleto.novoBoleto()  
                .comBanco(banco)  
                .comDatas(datas)  
                .comBeneficiario(beneficiario)  
                .comPagador(pagador)  
                .comValorBoleto(pedido.getValor())  
                .comNumeroDoDocumento("1234")  
                .comInstrucoes("SR CAIXA NÃO ACEITAR PAGAMENTO EM CHEQUE")  
                .comLocaisDePagamento("PAGAVEL EM QUALQUER BANCO ATÉ O VENCIMENTO");  

        GeradorDeBoleto gerador = new GeradorDeBoleto(boleto);  

        // Para gerar um boleto em PDF  
        
      //Pega o caminho da Pasta do projeto
      		String  pastaProjeto = getServletContext().getRealPath("");
      		
      		//Configura o caminho da pasta onde ficarï¿½o as imagens dos produtos
      		String pastaDestino = pastaProjeto + File.separator + pastaBoletos;
      		System.out.println("Boleto salvo em " + pastaDestino);
      		
      		//Se a pasta nï¿½o existir a cria
      		File pasta = new File(pastaDestino);
      		if(!pasta.exists()){
      			pasta.mkdir();
      		}
        
        gerador.geraPDF(pastaDestino + File.separator +pedido.getFormaPagamento().getInfo());  



        
        System.out.println("rodei");
		
		//
		
		request.getSession().removeAttribute("ItensCarrinho");
		request.getSession().removeAttribute("pedido");
		request.getSession().setAttribute("boleto", formaPagamento.getInfo());
		response.sendRedirect("pedido-finalizado.jsp");

		
	}

}
