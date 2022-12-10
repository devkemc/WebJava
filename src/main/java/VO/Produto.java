package VO;

import anotations.*;

@Entity
@Table(name = "produto")
public class Produto {
	@Id
	private int codigo;
	@Column
	@NotNull
	private String nome;
	@Column
	@NotNull
	private String descricao;
	@Column
	@NotNull
	private double preco;
	@Column
	@NotNull
	private String categoria;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getCategoria() {
		return this.categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
