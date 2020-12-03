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

import com.oreilly.servlet.MultipartRequest;

import model.dao.RoomDAO;
import model.vo.RoomVO;

/**
 * Servlet implementation class RoomModifyServlet
 */
@WebServlet("/roommodify")
public class RoomModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int r_idx = Integer.parseInt(request.getParameter("r_idx"));
		RoomDAO dao = RoomDAO.getInstance();
		RoomVO vo = new RoomVO();
		vo = dao.RoomView(r_idx);
		
		request.setAttribute("vo", vo);
		RequestDispatcher rd = request.getRequestDispatcher("Room/roomModify.jsp");
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
				new MultipartRequest(request, path, sizeLimit, encType);
		vo.setR_idx(Integer.parseInt(multi.getParameter("r_idx")));
		vo.setR_id(multi.getParameter("r_id"));
		vo.setR_subject(multi.getParameter("r_subject"));
		vo.setR_contents(multi.getParameter("r_contents"));
		vo.setR_filename(multi.getFilesystemName("r_filename"));
		
		boolean dbpass = dao.RoomPasscheck(vo.getR_idx(), vo.getR_id());
		//★☆★☆여기서 중요☆★☆★
		String oldfile = multi.getParameter("oldfile");
		String newfile = multi.getFilesystemName("r_filename");
		if(newfile == null || !dbpass) {
			File file = new File(path+"/"+newfile);
			if(file.exists()) {
				file.delete();
			}
			vo.setR_filename(oldfile);
		}else {
			vo.setR_filename(newfile);
			File file = new File(path+"/"+oldfile);
			if(file.exists()) {
				file.delete();
			}
		}
		
		int row = dao.RoomModify(vo);
		
		request.setAttribute("row", row);
		RequestDispatcher rd = request.getRequestDispatcher("Room/roomModifyPro.jsp");
		rd.forward(request, response);
	}

}
