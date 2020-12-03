package model.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.RoomDAO;
import model.vo.RoomVO;

/**
 * Servlet implementation class RoomViewServlet
 */
@WebServlet("/roomview")
public class RoomViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int r_idx = Integer.parseInt(request.getParameter("r_idx"));
		
		RoomDAO dao = RoomDAO.getInstance();
		//조회수 증가
		dao.RoomHits(r_idx);
		
		RoomVO vo = dao.RoomView(r_idx);
		//엔터를 <br>태그로 바꿔줌
		vo.setR_contents(vo.getR_contents().replace("\n", "<br>"));
		request.setAttribute("vo", vo);
		
		RequestDispatcher rd = request.getRequestDispatcher("Room/roomView.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
