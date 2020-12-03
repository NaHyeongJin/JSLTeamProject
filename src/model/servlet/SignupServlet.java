
package model.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.dao.ProjectDAO;
import model.vo.ClientVO;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/sign_up")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			request.setCharacterEncoding("utf-8");
			
			ClientVO client = new ClientVO();
			ProjectDAO dao = ProjectDAO.getInstance();
			client.setId(request.getParameter("id"));
			client.setPw(request.getParameter("pw"));
			client.setName(request.getParameter("name"));
			client.setEmail(request.getParameter("email"));
			client.setEmail2(request.getParameter("email2"));
			int tel1 = Integer.parseInt(request.getParameter("tel1"));
			client.setTel1(tel1);
			int tel2 = Integer.parseInt(request.getParameter("tel2"));
			client.setTel2(tel2);
			int tel3 = Integer.parseInt(request.getParameter("tel3"));
			client.setTel3(tel3);
			
			int row = dao.ClientWrite(client);
			
			request.setAttribute("row", row);
			RequestDispatcher rd = request.getRequestDispatcher("/SignUp/sign_up_pro.jsp");
			rd.forward(request, response);
			
			
	}

}