package DAO;
import java.util.ArrayList;
import java.util.List;
import VO.Venda;


public class VendaDAO {
	private Venda vo = new Venda();
	private List <Venda> listaVenda = new ArrayList<>();
	
	public List<Venda> getListaVenda() {
		return listaVenda;
	}
	public void setListaVenda(List<Venda> listaVenda) {
		this.listaVenda = listaVenda;
	}
	
	public Venda getVo() {
		return vo;
	}

	public void setVo(Venda vo) {
		this.vo = vo;
	}

	public void createVenda(Venda v) {
		this.vo.setCliente(v.getCliente());
		this.vo.setCodigo(0);
		this.vo.setData(v.getData());
		this.vo.setDesconto(v.getDesconto());
		this.vo.setProduto(v.getProduto());
		this.vo.setQuantidade(v.getQuantidade());
		this.vo.setValorTotal(v.getValorTotal());
		this.listaVenda.add(vo);
		
	}
	
	public List<Venda> getVenda(){
		List<Venda> lst = new ArrayList<Venda>();
		Venda v = new Venda();
		v.setCliente("Carlos");
		v.setCodigo(0);
		v.setData("10/12/2020");
		v.setDesconto(150);
		v.setProduto("notebook i5");
		v.setQuantidade(1);
		v.setValorTotal(7500);
		lst.add(v);
		
		Venda v2 = new Venda();
		vo.setCliente("Eduardo");
		v2.setCodigo(0);
		v2.setData("10/12/2022");
		v2.setDesconto(120);
		v2.setProduto("Iphone 5");
		v2.setQuantidade(2);
		v2.setValorTotal(3000);
		return lst;
	}
	public void deleteVenda() {
			
	}
}
