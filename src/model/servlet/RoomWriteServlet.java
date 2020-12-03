package model.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.RoomDAO;
import model.vo.RoomVO;

/**
 * Servlet implementation class RoomWriteServlet
 */
@WebServlet("/roomwrite")
public class RoomWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Room/roomWrite.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		RoomDAO dao = RoomDAO.getInstance();
		RoomVO vo = new RoomVO();
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("Room/upload"); //파일 저장 경로
		String encType = "UTF-8";
		int sizeLimit = 2*1024*1024;// 파일크기 설정(2MB)
		
		MultipartRequest multi = 
				new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		vo.setR_id(multi.getParameter("r_id"));
		vo.setR_pass(multi.getParameter("r_pass"));
		vo.setR_subject(multi.getParameter("r_subject"));
		vo.setR_contents(multi.getParameter("r_contents"));
		vo.setR_filename(multi.getFilesystemName("r_filename")); //<<<★☆★☆이샛기 중요☆★☆★
		
		int row = dao.RoomWrite(vo);
		
		request.setAttribute("row", row);
		RequestDispatcher rd = request.getRequestDispatcher("Room/roomWritePro.jsp");
		rd.forward(request, response);
	}

}
