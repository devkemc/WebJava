package VO;

import anotations.*;

@Entity
@Table(name = "entrega")
public class Entrega {
	@Id
	private int id;
	@Column
	@NotNull
	private String venda;
	@Column
	@NotNull
	private String data;
	
	public String getVenda() {
		return venda;
	}
	public void setVenda(String venda) {
		this.venda = venda;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
