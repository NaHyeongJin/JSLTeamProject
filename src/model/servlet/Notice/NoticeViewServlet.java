package model.servlet.Notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.NoticeDAO;
import model.vo.LoginVO;
import model.vo.NoticeVO;

/**
 * Servlet implementation class NoticeViewServlet
 */
@WebServlet("/NoticeView.do")
public class NoticeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		
		
		HttpSession session = request.getSession(true);
		String grade="";
		String loginid= "";
		if(session.isNew()) {
			loginid="biclient";
			grade = "c";
		}else {
			loginid = (String)session.getAttribute("loginid");
			grade=(String)session.getAttribute("grade");
		}
		
		
		NoticeDAO ndao = NoticeDAO.getInstance();
		NoticeVO nvo = new NoticeVO();
		nvo = ndao.NoticeVOview(id);
		nvo.setN_contents(nvo.getN_contents().replace("\n","<br>"));
		boolean bool = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		for(int x=0; x<cookies.length;x++){
			info=cookies[x];
			if(info.getName().equals("NoticeCookie")){//grade로 거름
				bool=true;
				break;
			}
		}
		String newValue = ""+System.currentTimeMillis();//몇시몇분몇초를 초로 바꾸는메소드 현재시간을 값으로 줌
		if(!bool){
			info = new Cookie("NoticeCookie"+loginid,newValue);// 첫번쨰 인자에는 쿠키의 이름 두번째는 쿠키의 값(여러개잇을수도잇읍)
			info.setMaxAge(600);
			response.addCookie(info);//클라이언트일정 폴더에 저장을해줘야함
			//조회수 증가 쿼리
			ndao.Noticereadcnt(id);
			}
		
		
		request.setAttribute("grade", grade);
		request.setAttribute("nvo", nvo);
		
		RequestDispatcher rd = request.getRequestDispatcher("Notice/Notice_view.jsp");
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
