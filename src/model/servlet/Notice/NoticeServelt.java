package model.servlet.Notice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.NoticeDAO;
import model.vo.LoginVO;
import model.vo.NoticeVO;
import util.PageIndex;

/**
 * Servlet implementation class NoticeServelt
 */
@WebServlet("/Notice.do")
public class NoticeServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession(true);
		
		String grade = "";
		if(session.isNew()) {
			grade = "c";
		}else {
			grade = (String)session.getAttribute("grade");
		}
		
		
		NoticeDAO ndao = NoticeDAO.getInstance();
		List<NoticeVO> nlist = new ArrayList<NoticeVO>();
		
		String url = "Notice/Notice_list.jsp";
		int totcnt = 0;
		
		String key = "", query="", squery="";
		if(request.getParameter("key")!=null && !request.getParameter("key").equalsIgnoreCase("")) {
			query=request.getParameter("search");
			key = request.getParameter("key");
			squery=query+" like '%" + key +"%'";
			totcnt = ndao.NoticeSearchCnt(squery); // 검색 쿼리를 이용한 메소드로 구한 개수
		}else {
		totcnt = ndao.NoticeCnt(); // 전체 게시물 수
		}
		int nowpage=1; // 현재 페이지 초기화
		int maxlist=10;// 페이지당 게시글 수 초기화
		int totpage=1;// 전체 페이지 초기화
		//페이지수 계산
		if(totcnt%maxlist ==0) {//10으로 나누었을때(한페이지당 10개니까)떨어지면 그페이지수
			totpage=totcnt/maxlist;
		}else {
			totpage=totcnt/maxlist+1;
		}
		if(totpage==0) {//혹시 계산결과가 0페이지로나오면 1로 다시 수정
			totpage=1;
		}
		if(request.getParameter("page")!=null&&!request.getParameter("page").equalsIgnoreCase("")) {
			//현재 페이지 를 눌러서 불러옴
			nowpage = Integer.parseInt(request.getParameter("page"));
			if(nowpage==0) {
				nowpage++;
			}
		}
		if(nowpage>totpage) {
			nowpage--;
		}
		//시작 , 끝 페이지 계싼
		int startpage=(nowpage-1)*maxlist+1;
		int endpage = nowpage*maxlist;
		int listcnt = totcnt-((nowpage-1)*maxlist);
		
		
		nlist= null;
		if(key.equals("")) {//검색 조건 없을떄
		nlist=ndao.NoticeList(startpage, endpage);//전체 목록 메소드
		}else {
			nlist=ndao.PdsPageList(startpage, endpage, squery);//검색조건쿼리문을 보내서 검색에 맞는 목록 가져오기
		}
		
		//페이지 처리
//		String pageSkip="";
//		if(key.equals("")) {
//		pageSkip = PageIndex.pageList(nowpage, totpage, url, "");
//		}else {
//		pageSkip = PageIndex.pageListHan(nowpage, totpage, url, query,key);
//		}
		
		for(int x=0; x<nlist.size();x++) {
			if(nlist.get(x).getGrade().equalsIgnoreCase("a")) {
				nlist.get(x).setGrade("관리자");
			}
		}
		
		request.setAttribute("grade", grade);
		request.setAttribute("nlist", nlist);
		request.setAttribute("search",query);
		request.setAttribute("key",key);
		request.setAttribute("page", nowpage);
		request.setAttribute("totpage", totpage);
		request.setAttribute("nlistcnt", listcnt);
		//request.setAttribute("pageSkip", pageSkip);
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Notice/Notice_list.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
