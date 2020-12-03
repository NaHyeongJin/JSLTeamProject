package model.servlet.qna;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.filters.SetCharacterEncodingFilter;

import model.dao.QnABoardDAO;

/**
 * Servlet implementation class QnAWriteServlet
 */
@WebServlet("/qna_write")
public class QnAWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnAWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 된 상태인지 안된 상태인지 판별하는 bool값 만들어서
		request.setAttribute("isLoginned", false); // 넣어주고 이게 false면 비회원 아이디 비번 입력창 만들기
		RequestDispatcher dispatcher = request.getRequestDispatcher("QnABoard/board_write.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 여기서 제목이랑 내용이 넘어오면
		// 로그인 된 토큰 기반으로 저장하거나
		// 비회원이면 아이디 비번 받아서 저장
		// 로그인 된 상태인지 확인하는 bool값 호출하고
		HttpSession session = request.getSession(false);
		request.setCharacterEncoding("UTF-8");
		Boolean isLoginned = (session == null) ? false : true;
		String id = (isLoginned) ? (String) session.getAttribute("loginedMemberId") : (String) request.getParameter("qnaId");
		String pass = (isLoginned) ? "" : (String) request.getParameter("qnaPass");
		String grade = (isLoginned) ? (String) session.getAttribute("Grade") : "C";
		QnABoardDAO manager = QnABoardDAO.getInstance();
		manager.qnaWrite(id, pass, (String) request.getParameter("qnaTitle"), (String) request.getParameter("qnaContent"), grade);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("qna_board?page=1");
		dispatcher.forward(request, response);
	}

}
