package DAO;

import java.util.ArrayList;
import java.util.List;
import VO.Entrega;

public class EntregaDAO {
	
	private Entrega vo = new Entrega();
	private List<Entrega> listaEntrega = new ArrayList<>();
	
public List<Entrega> getListaEntrega() {
		return listaEntrega;
	}
	public void setListaEntrega(List<Entrega> listaEntrega) {
		this.listaEntrega = listaEntrega;
	}

	
	public Entrega getVo() {
		return vo;
	}

	public void setVo(Entrega voEntrega) {
		this.vo = voEntrega;
	}

	public void createEntrega(Entrega e) {
		this.vo.setId(0);
		this.vo.setVenda(e.getVenda());	
		this.vo.setData(e.getData());	
	}
	
	public List<Entrega> getEntregas(){
		
		List<Entrega> lst = new ArrayList<Entrega>();
		
		Entrega entre = new Entrega();
		entre.setId(12);
		entre.setVenda("Notebook");
		entre.setData("11/12/2022");
		
		Entrega entre2 = new Entrega();
		entre2.setId(10);
		entre2.setVenda("Notebook");
		entre2.setData("12/12/2022");
		lst.add(entre);
		lst.add(entre2);
		
		return lst;
	}
	public void deleteEntrega() {
			
	}

}