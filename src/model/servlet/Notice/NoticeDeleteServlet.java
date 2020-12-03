package model.servlet.Notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NoticeDAO;
import model.vo.NoticeVO;

/**
 * Servlet implementation class NoticeDeleteServlet
 */
@WebServlet("/NoticeDelete.do")
public class NoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDeleteServlet() {
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
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		NoticeDAO ndao = NoticeDAO.getInstance();
		NoticeVO nvo = new NoticeVO();
		
		boolean b =ndao.Noticedelete(idx);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(b) {
			out.println("<script>");
			out.println("alert('글 삭제 성공');");
			out.println( "location.href='/Notice.do';");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('글 삭제 실패');");
			out.println( "location.href='/Notice.do';");
			out.println("</script>");
			
		}
		
	}

}
