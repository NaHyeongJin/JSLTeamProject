package model.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.RoomDAO;
import model.vo.RoomVO;
import util.PageIndex;

/**
 * Servlet implementation class RoomServlet
 */
@WebServlet("/room")
public class RoomListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		RoomDAO dao = RoomDAO.getInstance();
		//List<RoomVO> list = dao.RoomList();
		String url = "room";
		String query = "", key = "", s_query = "";
		int totcount = 0;//검색조건이 들어왔을때
		if(request.getParameter("key") != null && !request.getParameter("key").equals("")) {
			query = request.getParameter("search");
			key = request.getParameter("key");
			s_query = query + " like '%" + key + "%'";
			totcount = dao.RoomCount(s_query);
		}else{
			//검색 없을시 총 갯수
			totcount = dao.RoomCount();
		}
		
		int nowpage = 1; //편재 페이지 초기화
		int maxlist = 10; //페이지당 게시글 수 초기화
		int totpage = 1; //전체 페이지 초기화
		
		//총페이지 수 계산
		if(totcount % maxlist == 0) {
			totpage = totcount / maxlist;
		}else {
			totpage = totcount / maxlist +1;
		}
		
		if(totpage == 0) {
			totpage = 1;
		}
		if(request.getParameter("page") != null) {
	         nowpage = Integer.parseInt(request.getParameter("page"));
	    }
		if(nowpage>totpage) {
			nowpage=totpage;
		}
		int startpage = (nowpage-1)*maxlist+1;
	    int endpage = nowpage*maxlist;
	    int listcount = totcount-((nowpage-1)*maxlist);
	    
	    List<RoomVO> list = null;
	    if(key.equals("")) {
	    	list = dao.RoomList(startpage, endpage);	    	
	    }else {
	    	list = dao.RoomList(s_query, startpage, endpage);
	    }

		
		//페이지 처리
		String pageSkip = "";
		if(key.equals("")) {
			pageSkip = PageIndex.pageList(nowpage, totpage, url, "");
		}else {
			pageSkip = PageIndex.pageListHan(nowpage, totpage, url, query, key);
		}
		request.setAttribute("totcount", totcount);
		request.setAttribute("page", nowpage);
		request.setAttribute("totpage", totpage);
		request.setAttribute("listcount", listcount);
		request.setAttribute("list", list);
		request.setAttribute("pageSkip", pageSkip);
		request.setAttribute("query", query);
		request.setAttribute("key", key);
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("Room/roomList.jsp");
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
