package com.danyllopenna.dominio;



public class Produto {
	private long idproduto;
	private String tipo,vendedor,lote;
	private Double valor, quantidade;
	private String dataCompra;
	
	public Produto(long idproduto, String tipo, String vendedor, String lote, Double valor, Double quantidade,
			String dataCompra) {
		super();
		this.idproduto = idproduto;
		this.tipo = tipo;
		this.vendedor = vendedor;
		this.lote = lote;
		this.valor = valor;
		this.quantidade = quantidade;
		this.dataCompra = dataCompra;
	}

	public Produto() {
		super();
	}

	public long getIdproduto() {
		return idproduto;
	}

	public void setIdproduto(long idproduto) {
		this.idproduto = idproduto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public String getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(String dataCompra) {
		this.dataCompra = dataCompra;
	}
	
	@Override
	public String toString() {
		return "Produto [idproduto=" + idproduto + ",lote="+ lote +", tipo=" + tipo + ", vendedor=" + vendedor + ", valor=" + valor
				+ ", quantidade=" + quantidade + ", datacompra=" + dataCompra + "]";
	}
}
