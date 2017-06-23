package modelo;

public class FormaPagamento {
	private int id;
	private String tipoPagamento;
	private int parcelas;
	private Double valor;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	public int getParcelas() {
		return parcelas;
	}
	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		FormaPagamento other = (FormaPagamento) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FormaPagamento [id=" + id + ", tipoPagamento=" + tipoPagamento + ", parcelas=" + parcelas + ", valor="
				+ valor + "]";
	}
	
	
	

}
