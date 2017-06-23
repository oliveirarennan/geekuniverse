package modelo;

import java.util.Date;

public class Pedido {
	private int id;
	private int numeroPedido;
	private FormaPagamento formaPagamento;
	private String statusPedido;
	private Usuario cliente;
	private Date dataPedido;
	private Frete frete;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public String getStatusPedido() {
		return statusPedido;
	}
	public void setStatusPedido(String statusPedido) {
		this.statusPedido = statusPedido;
	}
	public Usuario getCliente() {
		return cliente;
	}
	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	public Frete getFrete() {
		return frete;
	}
	public void setFrete(Frete frete) {
		this.frete = frete;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + numeroPedido;
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
		Pedido other = (Pedido) obj;
		if (id != other.id)
			return false;
		if (numeroPedido != other.numeroPedido)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", numeroPedido=" + numeroPedido + ", formaPagamento=" + formaPagamento
				+ ", statusPedido=" + statusPedido + ", cliente=" + cliente + ", dataPedido=" + dataPedido + ", frete="
				+ frete + "]";
	}
	

}
