package model.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Login/login.jsp");		
		rd.forward(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 request.setCharacterEncoding("utf-8");
		 
	        String id = request.getParameter("id");
	        String pw = request.getParameter("pw");
        
	        ProjectDAO manager = ProjectDAO.getInstance();
	        LoginVO lvo = new LoginVO();
	        lvo = manager.login(id, pw);
	        
	        
	        
	        response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			Boolean success = (lvo.getRow() == 1) ? true : false;
	        if(success) {
	        	HttpSession session = request.getSession(true);
	        	session.setAttribute("loginid", lvo.getId());
	        	session.setAttribute("grade", lvo.getGrade());
	        	session.setMaxInactiveInterval(3600);
	        	out.println("<script>");
				out.println("alert('회원님 환영합니다');");
				out.println("location.href='/index';");
				out.println("</script>");
				
	        }else if(lvo.getRow()==-1) {
	        	out.println("<script>");
				out.println("alert('ID를 확인해주세요');");
				out.println("location.href='/login.do';");
				out.println("</script>");
	        }else {
	        	out.println("<script>");
				out.println("alert('비밀번호를 확인해주세요');");
				out.println("location.href='/login.do';");
				out.println("</script>");
	        }

	   
		}
}