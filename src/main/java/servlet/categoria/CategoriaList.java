package servlet.categoria;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.GenericDAO;
import VO.Categoria;

/**
 * Servlet implementation class CategoriaList
 */
public class CategoriaList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriaList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Categoria c = new Categoria();

		try {
			GenericDAO<Categoria>  dao = new GenericDAO<>();
			request.setAttribute("lista", dao.getAll(c));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException |
				 NoSuchMethodException e) {
			throw new RuntimeException(e);
		}

	 request.getRequestDispatcher("/categoria/CategoriaList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
