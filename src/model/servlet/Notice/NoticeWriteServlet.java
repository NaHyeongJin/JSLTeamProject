package model.servlet.Notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.NoticeDAO;
import model.vo.LoginVO;
import model.vo.NoticeVO;

/**
 * Servlet implementation class NoticeWriteServlet
 */
@WebServlet("/NoticeWrite.do")
public class NoticeWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession(true);
		String grade="";
		String loginid= "";
		if(session.isNew()) {
			loginid="biclient";
			grade = "c";
		}else {
			loginid = (String)session.getAttribute("loginid");
			grade=(String)session.getAttribute("grade");
		}
		
		
		request.setAttribute("n_id",loginid);
		RequestDispatcher rd = request.getRequestDispatcher("Notice/Notice_write.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		NoticeDAO ndao = NoticeDAO.getInstance();
		NoticeVO nvo = new NoticeVO();
		
		String grade = "a";
		nvo.setId(request.getParameter("n_id"));
		nvo.setGrade(grade.toUpperCase());
		nvo.setN_subject(request.getParameter("n_subject"));
		nvo.setN_contents(request.getParameter("n_contents"));
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		boolean b =ndao.NoticeWrite(nvo);
		if(b) {
			
			out.println("<script>");
			out.println("alert(글 등록 성공)");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert(글 등록 실패)");
			out.println("</script>");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/Notice.do");
		rd.forward(request, response);
	}

}
