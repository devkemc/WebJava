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
 * Servlet implementation class ClienteSave
 */
public class ClienteSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteSave() {
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
		String ret;
		Cliente c = new Cliente();
		String codigo = request.getParameter("codigo");
		c.setNome(request.getParameter("nome"));
		c.setEmail(request.getParameter("email"));
		c.setTelefone(request.getParameter("telefone"));
		c.setEndereco(request.getParameter("endereco"));
		System.out.println(codigo);
		try {
			GenericDAO<Cliente> dao = new GenericDAO<>();
			if (codigo == "" || codigo == null) {
				ret = "Cliente Incluído com Sucesso";
				dao.create(c);
			} else {
				ret = "Cliente Alterado com Sucesso";
				c.setCodigo(Integer.parseInt(codigo));
				dao.update(c);
			}

		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException(ex);
		} catch (IllegalAccessException ex) {
			throw new RuntimeException(ex);
		}

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Cliente cadastrado</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>" + ret + "</h1><br/>");
		out.println("<a href='ClienteList'>Voltar</a>");
		out.println("</body>");
		out.println("</html>");
	}

}
