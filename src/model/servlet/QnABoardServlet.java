package model.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.QnABoardDAO;
import model.vo.QnaVO;

/**
 * Servlet implementation class QnABoardServlet
 */
@WebServlet("/qna_board")
public class QnABoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnABoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QnABoardDAO manager = QnABoardDAO.getInstance();
		List<QnaVO> list = manager.qnaList();
		int cnt = manager.totList() - 1;
		
		if(list.size() > 10)
			cnt = (list.get(10).getId().contains("admin")) ? cnt - 1 : cnt;
		cnt = (int) (cnt / 10) + 1;
		
		request.setAttribute("list", list);
		request.setAttribute("pageIndex", cnt);
		request.setAttribute("newIdx", 0);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("QnABoard/board_list.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
