package VO;

import anotations.*;

@Entity
@Table( name = "vendas")
public class Venda {
	@Id
	private int codigo;
	@Column
	@NotNull
	private String data;
	@Column
	@NotNull
	private String cliente;
	@Column
	@NotNull
	private String produto;
	@Column
	@NotNull
	private int quantidade;
	@Column
	@NotNull
	private double desconto;
	@Column
	@NotNull
	private double valorTotal;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}	
	
}
