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
 * Servlet implementation class NoticeModifyServlet
 */
@WebServlet("/NoticeModify.do")
public class NoticeModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		int idx = Integer.parseInt(request.getParameter("idx"));
		NoticeDAO ndao = NoticeDAO.getInstance();
		NoticeVO nvo = new NoticeVO();
		nvo = ndao.NoticeVOview(id);
		
		request.setAttribute("idx", idx);
		request.setAttribute("nvo", nvo);
		
		RequestDispatcher rd = request.getRequestDispatcher("Notice/Notice_modify.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		NoticeDAO ndao = NoticeDAO.getInstance();
		NoticeVO nvo = new NoticeVO();
		
		nvo.setId(request.getParameter("n_id"));
		nvo.setIdx(Integer.parseInt(request.getParameter("idx")));
		nvo.setN_subject(request.getParameter("n_subject"));
		nvo.setN_contents(request.getParameter("n_contents"));
		
		boolean b =ndao.Noticemodify(nvo);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(b) {
			out.println("<script>");
			out.println("alert('글 수정 성공');");
			out.println( "location.href='/Notice.do';");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('글 수정 실패');");
			out.println( "location.href='/Notice.do';");
			out.println("</script>");
			
		}
	}

}
