package servlet.cliente;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.GenericDAO;
import VO.Cliente;

/**
 * Servlet implementation class ClienteDelete
 */
public class ClienteDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("id"));
		Cliente c = new Cliente();
		c.setCodigo(codigo);
		GenericDAO<Cliente> dao = null;
		try {
			dao = new GenericDAO<>();
			dao.delete(c);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		PrintWriter out = response.getWriter(); 
		 out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Cliente excluido</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<h1>Cliente excluido Com Sucesso</h1><br/>");
	        out.println("<a href='ClienteList'>Voltar</a>");  
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
