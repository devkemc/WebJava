package servlet.venda;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.GenericDAO;
import VO.Venda;

/**
 * Servlet implementation class VendaSave
 */
public class VendaSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendaSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Venda v = new Venda();
		v.setCodigo(0);
		v.setCliente(request.getParameter("cliente"));
		v.setData(request.getParameter("data"));
		v.setProduto(request.getParameter("produto"));
		v.setDesconto(Integer.parseInt(request.getParameter("desconto")));
		v.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
		v.setValorTotal(Integer.parseInt(request.getParameter("valorTotal")));
		try {
			GenericDAO<Venda> dao = new GenericDAO<>();
			dao.create(v);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}


		PrintWriter out = response.getWriter(); 
		 out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Venda cadastrada</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<h1>Venda Incluida Com Sucesso</h1><br/>");
	        out.println("<a href='VendaList'>Voltar</a>");  
	        out.println("</body>"); 
	        out.println("</html>");
	        
		
	}

}
