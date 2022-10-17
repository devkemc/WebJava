package DAO;

import java.util.ArrayList;
import java.util.List;

import VO.Cliente;

public class ClienteDAO {
	
	private Cliente vo = new Cliente();
	private List<Cliente> listaCliente = new ArrayList<>();
	
public List<Cliente> getListaCliente() {
		return listaCliente;
	}
	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
public ClienteDAO() {
		
	}
	public ClienteDAO(Cliente vo) {
		this.vo=vo;
	}
	
	public Cliente getVo() {
		return vo;
	}

	public void setVo(Cliente voCliente) {
		this.vo = voCliente;
	}

	public void createCliente(Cliente c) {
		this.vo.setNome(c.getNome());	
		this.vo.setEmail(c.getEmail());
		this.vo.setEndereco(c.getEndereco());
		this.vo.setTelefone(c.getTelefone());	
	}
	
	public List<Cliente> getClientes(){
		
		List<Cliente> lst = new ArrayList<Cliente>();
		
		Cliente cli = new Cliente();
		cli.setCodigo(12);
		cli.setEmail("gustavo@gmail.com");
		cli.setEndereco("rua Elias Fernandes");
		cli.setNome("Gustavo");
		cli.setTelefone("(11)951698212");
		
		Cliente cli2 = new Cliente();
		cli2.setCodigo(13);
		cli2.setEmail("joaquim@gmail.com");
		cli2.setEndereco("rua Elias Fernandes");
		cli2.setNome("Joaquim Kennedy");
		cli2.setTelefone("(11)951698212");
		
		lst.add(cli);
		
		return lst;
	}
	public void deleteCliente() {
			
	}

}
