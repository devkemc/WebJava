package DAO;

import java.util.ArrayList;
import java.util.List;

import VO.Categoria;

public class CategoriaDAO {
	
	private Categoria vo = new Categoria();
	private List<Categoria> listaCategoria = new ArrayList<>();
	
public List<Categoria> getListaCategoria() {
		return listaCategoria;
	}
	public void setListaCategoria(List<Categoria> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}
public CategoriaDAO() {
		
	}
	public CategoriaDAO(Categoria vo) {
		this.vo=vo;
	}
	
	public Categoria getVo() {
		return vo;
	}

	public void setVo(Categoria voCategoria) {
		this.vo = voCategoria;
	}

	public void createCategoria(Categoria c) {
		this.vo.setCodigo(0);
		this.vo.setNome(c.getNome());	
		this.vo.setDescricao(c.getDescricao());	
	}
	
	public List<Categoria> getCategorias(){
		
		List<Categoria> lst = new ArrayList<Categoria>();
		
		Categoria cli = new Categoria();
		cli.setCodigo(12);
		cli.setNome("Notebook");
		cli.setDescricao("categoria de varios notebook");
		
		Categoria cli2 = new Categoria();
		cli2.setCodigo(13);
		cli2.setNome("Celular");
		cli2.setDescricao("categoria de varios celulares");
		
		lst.add(cli);
		
		return lst;
	}
	public void deleteCategoria() {
			
	}

}