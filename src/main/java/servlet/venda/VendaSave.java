package servlet.venda;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.VendaDAO;
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
		VendaDAO dao = new VendaDAO();
		v.setCodigo(0);
		v.setCliente(request.getParameter("cliente"));
		v.setData(request.getParameter("data"));
		v.setProduto(request.getParameter("produto"));
		v.setDesconto(10);
		v.setQuantidade(0);
		v.setValorTotal(15);
		System.out.println(v);
		dao.createVenda(v);
		
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
