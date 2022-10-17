package DAO;
import java.util.ArrayList;
import java.util.List;

import VO.Produto;

public class ProdutoDAO {
	private Produto vo = new Produto();
	private List <Produto> listaProduto = new ArrayList<>();
	public ProdutoDAO() {
		
	}
	public List<Produto> getListaProduto() {
		return listaProduto;
	}
	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}
	
	public ProdutoDAO(Produto vo) {
		this.vo=vo;
	}
	
	
	public Produto getVo() {
		return vo;
	}

	public void setVo(Produto vo) {
		this.vo = vo;
	}

	public void createProduct(Produto p) {
		this.vo.setDescricao(p.getDescricao());
		this.vo.setNome(p.getNome());	
		this.vo.setPreco(p.getPreco());
		this.vo.setCodigo(0);
		this.listaProduto.add(vo);
		
	}
	
	public List<Produto> getProducts(){
		List<Produto> lst = new ArrayList<Produto>();
		Produto p = new Produto();
		p.setCodigo(12);
		p.setNome("Computador");
		p.setDescricao("Produto teste 01234");
		lst.add(p);
		
		Produto p2 = new Produto();
		p2.setCodigo(13);
		p2.setNome("Notebook");
		p2.setDescricao("Notebook barato");
		lst.add(p2);
		return lst;
	}
	public void deleteProduto() {
			
	}
}
