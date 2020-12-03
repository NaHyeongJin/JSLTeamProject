package model.servlet.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.QnABoardDAO;
import model.vo.QnaVO;

/**
 * Servlet implementation class QnAViewServlet
 */
@WebServlet("/qna_view")
public class QnAViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnAViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean passCheck = (request.getParameter("passCheck").equals("true")) ? true : false;
		Boolean isAnswer = (request.getParameter("isAnswer").equals("true")) ? true : false;
		request.setAttribute("isAnswer", request.getParameter("isAnswer"));
		int idx = Integer.parseInt(request.getParameter("idx"));
		request.setAttribute("idx", idx);
		if(!passCheck) {
			QnABoardDAO manager = QnABoardDAO.getInstance();
			
			manager.qnaHits(idx, isAnswer);
			request.setAttribute("vo", manager.qnaView(idx, isAnswer));
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("QnABoard/board_view.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("QnABoard/board_pass_check.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean bool = false;
		QnABoardDAO manager = QnABoardDAO.getInstance();
		int idx = Integer.parseInt(request.getParameter("idx"));
		String pass = request.getParameter("pass");
		Boolean isAnswer = (request.getParameter("isAnswer").equals("true")) ? true : false;
		
		bool = manager.passCheck(idx, pass);
		request.setAttribute("bool", bool);
		request.setAttribute("idx", idx);
		request.setAttribute("isAnswer", isAnswer);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("QnABoard/board_view_pro.jsp");
		dispatcher.forward(request, response);
	}

}
