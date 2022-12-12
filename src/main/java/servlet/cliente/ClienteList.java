package servlet.cliente;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.GenericDAO;
import VO.Cliente;

/**
 * Servlet implementation class ClienteList
 */
public class ClienteList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente c = new Cliente();
		try {
			GenericDAO<Cliente> dao = new GenericDAO<>();
			request.setAttribute("lista", dao.getAll(c));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException |
				 NoSuchMethodException e) {
			throw new RuntimeException(e);
		}

		request.getRequestDispatcher("/cliente/ClienteList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
