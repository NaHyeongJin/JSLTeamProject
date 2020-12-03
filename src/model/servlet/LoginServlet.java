package model.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.ProjectDAO;
import model.vo.LoginVO;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/LoginOut/login.jsp");		
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 request.setCharacterEncoding("utf-8");
		 
	        String id = request.getParameter("id");
	        String pw = request.getParameter("pw");
        
	        ProjectDAO manager = ProjectDAO.getInstance();
	        LoginVO lvo = manager.login(id, pw);
	        
	        Boolean success = (lvo.getRow() == 1) ? true : false;
	        
	        if(success) {
	        	HttpSession session = request.getSession();
	        	session.setAttribute("loginedMemberId", id);
	        	session.setAttribute("Grade", lvo.getGrade());
	        	session.setMaxInactiveInterval(3600);
	        }
	        request.setAttribute("lvo", lvo);
	        RequestDispatcher rd = request.getRequestDispatcher("/index_pro.jsp");
	        rd.forward(request, response);
	   
		}
}