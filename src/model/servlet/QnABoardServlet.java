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
		List<QnaVO> list = new ArrayList<QnaVO>();
		QnaVO vo = new QnaVO();
		vo.setGrade("a");
		vo.setId("na");
		vo.setQ_idx(1);
		vo.setPw("12");
		vo.setQ_subject("질문1");
		vo.setQ_cnt(0);
		list.add(vo);
		vo = new QnaVO();
		vo.setGrade("a");
		vo.setId("admin");
		vo.setQ_idx(1);
		vo.setPw("12");
		vo.setQ_subject("질문1 답변");
		vo.setA_cnt(0);
		list.add(vo);
		request.setAttribute("list", list);
		request.setAttribute("pageIndex", 5);
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
