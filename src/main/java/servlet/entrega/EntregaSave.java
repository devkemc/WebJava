package servlet.entrega;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EntregaDAO;
import VO.Entrega;

/**
 * Servlet implementation class EntregaSave
 */
public class EntregaSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntregaSave() {
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
		Entrega e = new Entrega();
		EntregaDAO dao = new EntregaDAO();
		e.setId(0);
		e.setVenda(request.getParameter("venda"));
		e.setData(request.getParameter("data"));
		
		dao.createEntrega(e);
		
		PrintWriter out = response.getWriter(); 
		 out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Entrega cadastrado</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<h1>Entrega incluida Com Sucesso</h1><br/>");
	        out.println("<a href='EntregaList'>Voltar</a>");  
	        out.println("</body>"); 
	        out.println("</html>");
	        
	}

}
