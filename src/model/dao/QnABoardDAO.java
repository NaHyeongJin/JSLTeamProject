package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import model.vo.QnaVO;
import util.DBUtil;

public class QnABoardDAO {
	PreparedStatement pstmt = null;
	Connection conn = null;
	ResultSet rs = null;
	Logger log = Logger.getGlobal();// 메소드 오류 호출용

	private QnABoardDAO() {
	}

	private static QnABoardDAO instance = new QnABoardDAO();

	public static QnABoardDAO getInstance() {// 싱글톤
		return instance;
	}

	public List<QnaVO> qnaList(int pageIndex) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<QnaVO> qlist = new ArrayList<QnaVO>();

		int first = (pageIndex - 1) * 10 + 1;
		if(isAnswer(first)) {
			first++;
		}
		int end = first + 9;
		if(isAnswer(end + 1)) {
			end++;
		}
		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, A.* FROM (SELECT * FROM QNA ORDER BY Q_IDX desc, Q_REGDATE) A) where rnum >= ? and rnum <= ?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  first);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				QnaVO vo = new QnaVO();
				vo.setA_cnt(rs.getInt("a_cnt"));
				vo.setId(rs.getString("q_id"));
				vo.setGrade(rs.getString("q_grade"));
				vo.setPw(rs.getString("q_pw"));
				vo.setQ_a(rs.getString("q_a"));
				vo.setQ_cnt(rs.getInt("q_cnt"));
				vo.setQ_contents(rs.getString("q_contents"));
				vo.setQ_idx(rs.getInt("q_idx"));
				vo.setQ_regdate(rs.getString("q_regdate"));
				vo.setQ_subject(rs.getString("q_subject"));
				qlist.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
			}
		}

		return qlist;
	}
	
	// option 1 == 제목검색
	// 나머지 작성자검색
	public List<QnaVO> qnaList(int pageIndex, int option, String search) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String temp = (option == 1) ? "q_subject" : "q_id";
		List<QnaVO> qlist = new ArrayList<QnaVO>();

		int first = (pageIndex - 1) * 10 + 1;
		if(isAnswer(first)) {
			first++;
		}
		int end = first + 9;
		if(isAnswer(end + 1)) {
			end++;
		}
		String sql = "SELECT *\r\n" + 
				"FROM (SELECT ROWNUM AS RNUM, A.* FROM (SELECT * FROM QNA ORDER BY Q_IDX desc, Q_REGDATE) A where " + temp + " like '%" + search + "%')\r\n" + 
				"where rnum >= ? and rnum <= ?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  first);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				QnaVO vo = new QnaVO();
				vo.setA_cnt(rs.getInt("a_cnt"));
				vo.setId(rs.getString("q_id"));
				vo.setGrade(rs.getString("q_grade"));
				vo.setPw(rs.getString("q_pw"));
				vo.setQ_a(rs.getString("q_a"));
				vo.setQ_cnt(rs.getInt("q_cnt"));
				vo.setQ_contents(rs.getString("q_contents"));
				vo.setQ_idx(rs.getInt("q_idx"));
				vo.setQ_regdate(rs.getString("q_regdate"));
				vo.setQ_subject(rs.getString("q_subject"));
				qlist.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
			}
		}

		return qlist;
	}
	
	private Boolean isAnswer(int check) {
		Boolean bool = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT q_id FROM (SELECT ROWNUM AS RNUM, A.* FROM (SELECT * FROM QNA ORDER BY Q_IDX DESC, Q_REGDATE) A) where rnum=?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  check);
			rs = pstmt.executeQuery();

			bool = (rs.next()) ? rs.getString("q_id").contains("admin") : false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
			}
		}

		return bool;
	}

	public int totList() {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select count(*) from qna";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			cnt = (rs.next()) ? rs.getInt(1) : cnt;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
			}
		}

		return cnt;
	}

	public Boolean qnaWrite(String id, String pass, String title, String content, String grade) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		Boolean bool = false;

		String sql = "INSERT INTO QNA(Q_PW, Q_ID, Q_SUBJECT, Q_CONTENTS, Q_CNT, Q_IDX, Q_GRADE) VALUES (?, ?, ?, ?, 0, TBL_QNA_SEQ_QIDX.nextval, ?)";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setString(2, id);
			pstmt.setString(3, title);
			pstmt.setString(4, content);
			pstmt.setString(5, grade);

			bool = (pstmt.executeUpdate() == 1) ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
			}
		}

		return bool;
	}

	public void qnaHits(int idx, Boolean isAnswer) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String cnt = (isAnswer) ? "a_cnt" : "q_cnt";
		String sql = "update qna set " + cnt + " = " + cnt + " + 1 where q_idx=?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}
	
	public QnaVO qnaView(int idx, Boolean isAnswer) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		QnaVO vo = new QnaVO();
		String temp = (isAnswer) ? "q_contents" : "q_a";
		String sql = "select * from qna where q_idx=? and " + temp + " is null";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  idx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setA_cnt(rs.getInt("a_cnt"));
				vo.setGrade(rs.getString("q_grade"));
				vo.setId(rs.getString("q_id"));
				vo.setPw(rs.getString("q_pw"));
				vo.setQ_a(rs.getString("q_a"));
				vo.setQ_cnt(rs.getInt("q_cnt"));
				vo.setQ_contents(rs.getString("q_contents"));
				vo.setQ_idx(rs.getInt("q_idx"));
				vo.setQ_regdate(rs.getString("q_regdate"));
				vo.setQ_subject(rs.getString("q_subject"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
			}
		}
		return vo;
	}

	public void editQna(String subject, String content, int idx, Boolean isAnswer) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String temp = (isAnswer) ? "Q_A" : "Q_CONTENTS";
		String sql = "UPDATE QNA SET Q_SUBJECT = ?, " + temp + " = ? where q_idx=?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  subject);
			pstmt.setString(2,  content);
			pstmt.setInt(3, idx);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}
	
	public void deleteQna(int idx, Boolean isAnswer) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String temp = (isAnswer) ? "and Q_CONTENTS is null" : "";
		String sql = "DELETE FROM QNA WHERE q_idx=? " + temp;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}
	
	public String getTitle(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String answer = "";
		String sql = "select q_subject from qna where q_idx=?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			answer = (rs.next()) ? rs.getString("q_subject") : "";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
			}
		}
		return answer;
	}

	public void qnaRewrite(int idx, String subject, String content) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO QNA(Q_ID, Q_SUBJECT, Q_A, A_CNT, Q_IDX, Q_GRADE) VALUES ('admin', ?, ?, 0, ?, 'A')";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setInt(3, idx);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}

	public Boolean passCheck(int idx, String pass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select q_pw from qna where q_idx=? and q_grade='C'";
		Boolean bool = false;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			bool = (rs.next()) ? rs.getString("q_pw").equals(pass) : false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
			}
		}
		return bool;
	}
}
