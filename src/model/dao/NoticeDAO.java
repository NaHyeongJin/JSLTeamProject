package model.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


import model.vo.*;
import util.DBUtil;


public class NoticeDAO {//여기서 DB 작업 하겠습니다
	PreparedStatement pstmt =null;
	Connection conn = null;
	ResultSet rs =null;
	Logger log = Logger.getGlobal();//메소드 오류 호출용
	private NoticeDAO() {}
	private static NoticeDAO instance = new NoticeDAO();
	public static NoticeDAO getInstance () {//싱글톤
		return instance;
	}

	//공지사항 10개 뽑 목록리스트
	public List<NoticeVO> NoticeList(int startpage,int endpage){
		NoticeVO nvo = null;
		List<NoticeVO> Nlist = new ArrayList<NoticeVO>();
		String query="select X.* from (select rownum as rnum, A.* from (select * from notice order by n_idx desc) A where rownum <= ?) X where X.rnum >= ?";
		try {
			conn=DBUtil.getConnection();
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				nvo= new NoticeVO();
				nvo.setGrade(rs.getString("n_grade"));
				nvo.setId(rs.getString("n_id"));
				nvo.setIdx(rs.getInt("n_idx"));
				nvo.setN_cnt(rs.getInt("n_cnt"));
				nvo.setN_contents(rs.getString("n_contents"));
				nvo.setN_subject(rs.getString("n_subject"));
				nvo.setN_regdate(rs.getString("n_regdate"));
				
				Nlist.add(nvo);
			}
		}catch (Exception e) {
		
			log.info("리스트10개오류");
			
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Nlist;
	}
	//서치검색으로 검색한 목록 리스트
		public List<NoticeVO> PdsPageList(int startpage,int endpage,String squery){
			NoticeVO nvo = null;
			List<NoticeVO> nlist = new ArrayList<NoticeVO>();
	 		String query="select X.* from (select rownum as rnum, A.* from ("
	 				+ "select * from notice order by n_idx desc) A where "+squery+" and rownum <= ?) X where "
	 				+squery+" and X.rnum >= ?";
			try {
				conn=DBUtil.getConnection();
				pstmt=conn.prepareStatement(query);
				pstmt.setInt(1, endpage);
				pstmt.setInt(2, startpage);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					nvo= new NoticeVO();
					nvo.setGrade(rs.getString("n_grade"));
					nvo.setId(rs.getString("n_id"));
					nvo.setIdx(rs.getInt("n_idx"));
					nvo.setN_cnt(rs.getInt("n_cnt"));
					nvo.setN_contents(rs.getString("n_contents"));
					nvo.setN_subject(rs.getString("n_subject"));
					nvo.setN_regdate(rs.getString("n_regdate"));
					
					nlist.add(nvo);
				}
			}catch (Exception e) {
				e.printStackTrace();
				log.info("서치검색리스트오류");
			}finally {
				try {
					conn.close();
					pstmt.close();
					rs.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			return nlist;
		}
	//공지사항 조회수
	public int Noticereadcnt(String id) {
			String query = "update notice set n_cnt=n_cnt + 1 where n_id=?";
			int row=0;
			try {
				conn=DBUtil.getConnection();
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1, id);
				 row= pstmt.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
				log.info("조회수오류");
			}finally {
				try {
					conn.close();
					pstmt.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
		}
			return row;
		}
	
	//공지사항 글쓰기
	public boolean NoticeWrite(NoticeVO nvo){
		int row = 0;
		boolean b= false;
		String query="insert into notice(n_id,n_grade,n_subject,"
				+ "n_contents,n_idx) values(?,?,?,?,tbl_notice_seq_nidx.nextval)";
		try {
			conn=DBUtil.getConnection();
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, nvo.getId());
			pstmt.setString(2, nvo.getGrade());
			pstmt.setString(3, nvo.getN_subject());
			pstmt.setString(4, nvo.getN_contents());
			row = pstmt.executeUpdate();
			if(row==1) {
				b=true;
			}
		}catch (Exception e) {
			log.info("노티스 글등록 오류");
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return b;
	}
	//공지사항 검색서치시 글 수 
	public int NoticeSearchCnt(String squery) {
		String query="select count(*) as cnt from notice where "+squery;
		int cnt =0;
		try {
			conn=DBUtil.getConnection();
			pstmt=conn.prepareStatement(query);
			rs=pstmt.executeQuery();
			rs.next();
			cnt= rs.getInt("cnt");
	
		}catch (Exception e) {
			e.printStackTrace();
			log.info("검색글카운터오류");
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
	//공지사항 전체 글수
	public int NoticeCnt() {
		String query="select count(*) as cnt from notice";
		int cnt =0;
		try {
			conn=DBUtil.getConnection();
			pstmt=conn.prepareStatement(query);
			rs=pstmt.executeQuery();
			rs.next();
			cnt= rs.getInt("cnt");
	
		}catch (Exception e) {
			e.printStackTrace();
			log.info("공지사항 전체글 카운터 오류");
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
	// 뷰 
	public NoticeVO NoticeVOview(String id) {
		NoticeVO nvo = null;
		String query = "select * from notice where n_id=?";
		try {
			conn=DBUtil.getConnection();
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
			nvo = new NoticeVO();
			nvo.setGrade(rs.getString("n_grade"));
			nvo.setId(rs.getString("n_id"));
			nvo.setIdx(rs.getInt("n_idx"));
			nvo.setN_cnt(rs.getInt("n_cnt"));
			nvo.setN_contents(rs.getString("n_contents"));
			nvo.setN_subject(rs.getString("n_subject"));
			nvo.setN_regdate(rs.getString("n_regdate"));
			
			}
		}catch (Exception e) {
			e.printStackTrace();
			log.info("뷰오류");
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		
	}
		return nvo;
	}
	//수정(modify)
		public boolean Noticemodify(NoticeVO nvo) {
			boolean b=false;
			String query = "update notice set n_subject=?,n_contents=? where n_idx=?";
			try {
				conn=DBUtil.getConnection();
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1, nvo.getN_subject());
				pstmt.setString(2, nvo.getN_contents());
				pstmt.setInt(3, nvo.getIdx());
				
				int row =pstmt.executeUpdate();
				if(row==1) {
					b=true;
				}
			}catch (Exception e) {
				e.printStackTrace();
				log.info("수정오류");
			}finally {
				try {
					conn.close();
					pstmt.close();
					rs.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			
		}
			return b;
		}
		//삭제(delete)
		public boolean Noticedelete(int idx) {
			int row =0;
			boolean b= false;
			String query = "delete from notice where n_idx=?";
			log.info("id=" + idx);
			try {
				conn=DBUtil.getConnection();
				pstmt=conn.prepareStatement(query);
				pstmt.setInt(1, idx);
				
				
				row= pstmt.executeUpdate();
				if(row==1) {
					b=true;
				}
			}catch (Exception e) {
				e.printStackTrace();
				log.info("삭제오류");
			}finally {
				try {
					conn.close();
					pstmt.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
		}
			return b;
		}
	
}
