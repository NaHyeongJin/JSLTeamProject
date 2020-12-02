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

	public List<QnaVO> qnaList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<QnaVO> qlist = new ArrayList<QnaVO>();

		String sql = "select * from qna order by q_idx desc, q_regdate";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
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
}
