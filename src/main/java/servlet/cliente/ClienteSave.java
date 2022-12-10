package servlet.cliente;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClienteDAO;
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
		Cliente c = new Cliente();
		ClienteDAO cdao = new ClienteDAO();
		c.setCodigo(0);
		c.setNome(request.getParameter("nome"));
		c.setEmail(request.getParameter("email"));
		c.setTelefone(request.getParameter("telefone"));
		c.setEndereco(request.getParameter("endereco"));
		
		cdao.createCliente(c);
		
		PrintWriter out = response.getWriter(); 
		 out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Cliente cadastrado</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<h1>Cliente cadastrado Com Sucesso</h1><br/>");
	        out.println("<a href='ClienteList'>Voltar</a>");  
	        out.println("</body>"); 
	        out.println("</html>");
	        
	}

}
