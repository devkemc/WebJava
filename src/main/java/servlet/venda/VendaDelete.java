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
 * Servlet implementation class VendaDelete
 */
public class VendaDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendaDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("id"));
		Venda v = new Venda();
		v.setCodigo(codigo);
		try {
			GenericDAO<Venda> dao = new GenericDAO<>();
			dao.delete(v);
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
	        out.println("<title>Venda excluida</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<h1>Venda Excluida Com Sucesso</h1><br/>");
	        out.println("<a href='VendaList'>Voltar</a>");  
	        out.println("</body>"); 
	        out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
