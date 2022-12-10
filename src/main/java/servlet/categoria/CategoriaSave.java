package servlet.categoria;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CategoriaDAO;
import VO.Categoria;;

/**
 * Servlet implementation class CategoriaSave
 */
public class CategoriaSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriaSave() {
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
		Categoria c = new Categoria();
		CategoriaDAO cdao = new CategoriaDAO();
		c.setCodigo(0);
		c.setNome("notebook");
		c.setDescricao("notebook");
		
		
		cdao.createCategoria(c);
		
		PrintWriter out = response.getWriter(); 
		 out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Categoria cadastrado</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<h1>Categoria cadastrada Com Sucesso</h1><br/>");
	        out.println("<a href='CategoriaList'>Voltar</a>");  
	        out.println("</body>"); 
	        out.println("</html>");
	}

}
