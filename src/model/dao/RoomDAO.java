package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.vo.BoardVO;
import model.vo.NoticeVO;
import model.vo.QnaVO;
import model.vo.RoomVO;
import util.DBUtil;

public class RoomDAO {// 여기서 DB 작업 하겠습니다
	PreparedStatement pstmt = null;
	Connection conn = null;
	ResultSet rs = null;
	Logger log = Logger.getGlobal();// 메소드 오류 호출용

	private RoomDAO() {
	}

	private static RoomDAO instance = new RoomDAO();

	public static RoomDAO getInstance() {// 싱글톤
		return instance;
	}

	// 회원회원가입
	public int ClientWrite() {
		int row = 0;
		String query = "";
		return row;
	}

	// 자유게시판 목록리스트
	public List<BoardVO> BoardList() {
		List<BoardVO> Blist = new ArrayList<BoardVO>();
		String query = "";
		return Blist;
	}

	// 공지사항 목록리스트
	public List<NoticeVO> NoticeList() {
		List<NoticeVO> Nlist = new ArrayList<NoticeVO>();
		String query = "";
		return Nlist;
	}

	// 전체 게시물 수 카운트
	public int RoomCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 리턴타입
		int row = 0;
		// 쿼리
		String sql = "select count(*) from room";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}

	// 전체 게시물 수 카운트
	public int RoomCount(String s_query) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 리턴타입
		int row = 0;
		// 쿼리
		String sql = "select count(*) from room where " + s_query;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}

	// 자료실 목록리스트(10개씩) 리턴
	public List<RoomVO> RoomList(int startpage, int endpage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 리턴타입
		List<RoomVO> list = new ArrayList<RoomVO>();
		// 쿼리
		String sql = "select X.* from (select rownum as rnum, A.* from "
				+ "(select * from room order by r_idx desc) A where rownum <= ?) X where X.rnum >= ?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				RoomVO vo = new RoomVO();
				vo.setR_idx(rs.getInt("r_idx"));
				vo.setR_id(rs.getString("r_id"));
				vo.setR_subject(rs.getString("r_subject"));
				vo.setR_cnt(rs.getInt("r_cnt"));
				vo.setR_regdate(rs.getString("r_regdate"));
				vo.setR_filename(rs.getString("r_filename"));

				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// 게시물 리스트(10개씩) 리턴 - 검색조건이 있는 경우
	public List<RoomVO> RoomList(String s_query, int startpage, int endpage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 리턴타입
		List<RoomVO> list = new ArrayList<RoomVO>();
		// 쿼리
		String sql = "select X.* from (select rownum as rnum, A.* from "
				+ "(select * from room order by r_idx desc) A where " + s_query + " and rownum <= ?) X where " + s_query
				+ " and X.rnum >= ?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				RoomVO vo = new RoomVO();
				vo.setR_idx(rs.getInt("r_idx"));
				vo.setR_id(rs.getString("r_id"));
				vo.setR_subject(rs.getString("r_subject"));
				vo.setR_cnt(rs.getInt("r_cnt"));
				vo.setR_regdate(rs.getString("r_regdate"));
				vo.setR_filename(rs.getString("r_filename"));

				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// 등록메소드
	public int RoomWrite(RoomVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 리턴
		int row = 0;
		// 쿼리
		String sql = "insert into room(r_idx,r_subject,r_id,r_filename,r_contents) "
				+ "values(tbl_room_seq_ridx.nextval,?,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getR_subject());
			pstmt.setString(2, vo.getR_id());
			pstmt.setString(3, vo.getR_filename());
			pstmt.setString(4, vo.getR_contents());

			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}

	// 상세보기(roomView)
	public RoomVO RoomView(int r_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 리턴
		RoomVO vo = new RoomVO();
		// 쿼리
		String sql = "select * from room where r_idx=?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r_idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo.setR_idx(rs.getInt("r_idx"));
				vo.setR_id(rs.getString("r_id"));
				vo.setR_subject(rs.getString("r_subject"));
				vo.setR_regdate(rs.getString("r_regdate"));
				vo.setR_cnt(rs.getInt("r_cnt"));
				vo.setR_contents(rs.getString("r_contents"));
				vo.setR_filename(rs.getString("r_filename"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return vo;
	}

	// 조회수(r_regdate)
	public void RoomHits(int r_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 쿼리
		String sql = "update room set r_cnt = r_cnt + 1 where r_idx=?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r_idx);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 수정(modify)
	public int RoomModify(RoomVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 리턴타입
		int row = 0;
		// 쿼리
		String sql = "update room set r_subject=?, r_id=?, r_contents=?, r_filename=? where r_idx=?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getR_subject());
			pstmt.setString(2, vo.getR_id());
			pstmt.setString(3, vo.getR_contents());
			pstmt.setString(4, vo.getR_filename());
			pstmt.setInt(5, vo.getR_idx());

			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}

	// 파일 검색
	public String SearchFile(int r_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 리턴
		String r_filename = null;
		// 쿼리
		String sql = "select r_filename from room where r_idx=?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r_idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				r_filename = rs.getString("r_filename");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return r_filename;
	}

	public boolean RoomPasscheck(int r_idx, String r_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 리턴
		String dbpass = null;
		// 쿼리
		String sql = "select r_id from room where r_idx=?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r_idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dbpass = rs.getString("r_id");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dbpass.equals(r_id);
	}

	// 삭제(delete)
	public int RoomDelete(int idx, String r_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 리턴타입
		int row = 0;
		// 쿼리
		String sql = "delete from room where r_idx=? and r_id=?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setString(2, r_id);

			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}

	// 질문답변 목록리스트
	public List<QnaVO> QnaList() {
		List<QnaVO> Qlist = new ArrayList<QnaVO>();
		String query = "";
		return Qlist;
	}
}
