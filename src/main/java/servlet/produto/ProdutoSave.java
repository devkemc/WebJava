package servlet.produto;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.GenericDAO;
import DAO.ProdutoDAO;
import VO.Produto;

/**
 * Servlet implementation class ProdutoSave
 */
public class ProdutoSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdutoSave() {
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
		Produto p = new Produto();
		p.setNome(request.getParameter("nome"));
		p.setDescricao(request.getParameter("descricao"));
		p.setPreco(Float.parseFloat(request.getParameter("preco")));
		p.setCategoria(request.getParameter("categoria"));


		try {
			GenericDAO<Produto> produtoDao = new GenericDAO<>();
			produtoDao.create(p);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}


		PrintWriter out = response.getWriter(); 
		 out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Produto cadastrado</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<h1>Produto Incluido Com Sucesso</h1><br/>");
	        out.println("<a href='ProdutoList'>Voltar</a>");  
	        out.println("</body>"); 
	        out.println("</html>");
	        
		
	}

}
