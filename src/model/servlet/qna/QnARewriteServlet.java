package model.servlet.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.QnABoardDAO;

/**
 * Servlet implementation class QnARewriteServlet
 */
@WebServlet("/qna_rewrite")
public class QnARewriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnARewriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QnABoardDAO manager = QnABoardDAO.getInstance();
		int idx = Integer.parseInt(request.getParameter("idx"));
		request.setAttribute("title", manager.getTitle(idx));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("QnABoard/board_rewrite.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 필요한거 idx, 제목, 내용
		QnABoardDAO manager = QnABoardDAO.getInstance();
		int idx = Integer.parseInt(request.getParameter("idx"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		manager.qnaRewrite(idx, subject, content);
		RequestDispatcher dispatcher = request.getRequestDispatcher("QnABoard/board_list.jsp");
		dispatcher.forward(request, response);
	}

}
