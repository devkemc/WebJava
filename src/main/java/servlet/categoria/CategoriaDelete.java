package servlet.categoria;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.GenericDAO;
import VO.Categoria;

/**
 * Servlet implementation class CategoriaDelete
 */
public class CategoriaDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriaDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("id"));
		Categoria c = new Categoria();
		c.setCodigo(codigo);
		try {
			GenericDAO<Categoria> dao = new GenericDAO<>();
			dao.delete(c);
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
	        out.println("<title>Categoria excluida</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<h1>Categoria excluida Com Sucesso</h1><br/>");
	        out.println("<a href='CategoriaList'>Voltar</a>");  
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
