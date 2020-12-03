package model.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.RoomDAO;

/**
 * Servlet implementation class RoomDeleteServlet
 */
@WebServlet("/roomdelete")
public class RoomDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int r_idx = Integer.parseInt(request.getParameter("r_idx"));
		
		request.setAttribute("r_idx", r_idx);
		RequestDispatcher rd = request.getRequestDispatcher("Room/roomDelete.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int r_idx = Integer.parseInt(request.getParameter("r_idx"));
		String r_pw = request.getParameter("r_pw");
		
		RoomDAO dao = RoomDAO.getInstance();
		String r_filename = dao.SearchFile(r_idx);
		
		int row = dao.RoomDelete(r_idx, r_pw);
		if(row==1) {
			//파일 삭제
			ServletContext context = getServletContext();
			String path = context.getRealPath("Room/upload"); //파일 저장 경로
			File file = new File(path+ "/" +r_filename);
			if(file.exists()) {
				file.delete();
			}
		}
		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("Room/roomDeletePro.jsp");
		rd.forward(request, response);
	}

}
