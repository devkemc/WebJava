package VO;

import anotations.*;

@Entity
@Table(name = "categoria")
public class Categoria {
	@Id
	private int codigo;
	@Column
	@NotNull
	private String nome;
	@Column
	@NotNull
	private String descricao;
	
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
}
