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
 * Servlet implementation class QnAEditServlet
 */
@WebServlet("/qna_edit")
public class QnAEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnAEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QnABoardDAO manager = QnABoardDAO.getInstance();
		int idx = Integer.parseInt(request.getParameter("idx"));
		Boolean isAnswer = request.getParameter("isAnswer").equals("true") ? true : false;
		
		request.setAttribute("vo", manager.qnaView(idx, isAnswer));
		RequestDispatcher dispatcher = request.getRequestDispatcher("QnABoard/board_edit.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QnABoardDAO manager = QnABoardDAO.getInstance();
		String subject = request.getParameter("qnaTitle");
		String content = request.getParameter("qnaContent");
		Boolean isAnswer = request.getParameter("isAnswer").equals("true") ? true : false;
		int idx = Integer.parseInt(request.getParameter("idx"));
		manager.editQna(subject, content, idx, isAnswer);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("QnABoard/board_list.jsp");
		dispatcher.forward(request, response);
	}

}
