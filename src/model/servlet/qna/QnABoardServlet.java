package model.servlet.qna;

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
		request.setCharacterEncoding("UTF-8");
		QnABoardDAO manager = QnABoardDAO.getInstance();
		int pageIndex = Integer.parseInt(request.getParameter("page"));
		if(pageIndex == 0) pageIndex++;
		List<QnaVO> list = manager.qnaList(pageIndex);
		if (list.isEmpty()) {
			pageIndex--;
			list = manager.qnaList(pageIndex);
		}
		int cnt = manager.totList() - 1;
		
		if(list.size() > 10)
			cnt = (list.get(10).getId().contains("admin")) ? cnt - 1 : cnt;
		cnt = (int) (cnt / 10) + 1;
		
		request.setAttribute("page", pageIndex);
		request.setAttribute("list", list);
		request.setAttribute("pageIndex", cnt);
		request.setAttribute("newIdx", 0);
		request.setAttribute("id", "");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("QnABoard/board_list.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		QnABoardDAO manager = QnABoardDAO.getInstance();
		int pageIndex = Integer.parseInt(request.getParameter("page"));
		int option = 1;
		if (request.getParameter("inputSearch") == null) {
			doGet(request, response);
			return;
		} else {
			option = request.getParameter("inputSearch").equals("제목") ? 1 : 2;
		}
		String search = request.getParameter("search");
		List<QnaVO> list = manager.qnaList(pageIndex, option, search);
		int cnt = manager.totList() - 1;
		
		if(list.size() > 10)
			cnt = (list.get(10).getId().contains("admin")) ? cnt - 1 : cnt;
		cnt = (int) (cnt / 10) + 1;
		
		request.setAttribute("list", list);
		request.setAttribute("pageIndex", cnt);
		request.setAttribute("newIdx", 0);
		request.setAttribute("id", "");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("QnABoard/board_list.jsp");
		dispatcher.forward(request, response);
	}

}
