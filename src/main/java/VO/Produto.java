package VO;

public class Produto {
	
	private int codigo;
	private String nome;
	private String descricao;
	private float preco;
	private Categoria categoria;
	
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
	
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = new Categoria();
		this.categoria.setNome(categoria.getNome());
		this.categoria.setDescricao(categoria.getDescricao());
		this.categoria.setCodigo(categoria.getCodigo());
	}
	
}
