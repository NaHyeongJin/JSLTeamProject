package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.vo.LoginVO;
import util.DBUtil;


public class ProjectDAO {//여기서 DB 작업 하겠습니다
	PreparedStatement pstmt =null;
	Connection conn = null;
	ResultSet rs =null;
	Logger log = Logger.getGlobal();//메소드 오류 호출용
	private ProjectDAO() {}
	private static ProjectDAO instance = new ProjectDAO();
	public static ProjectDAO getInstance () {//싱글톤
		return instance;
	}
	

	//로그인 메소드
	public LoginVO login (String id, String pw) {
		String query = "select id,pw,grade from tbl_client where id=?";
		LoginVO lvo =null;
		/*
		 * log.info("id="+id); log.info("pw="+pw);
		 */
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			boolean b = rs.next();
			if(b) {
				lvo = new LoginVO();
				lvo.setId(rs.getString("id"));
				lvo.setPw( rs.getString("pw"));
				lvo.setGrade( rs.getString("grade"));
				if(lvo.getPw().equals(pw)) {
					lvo.setRow(1);
				}else {
					lvo.setRow(0);
				}
			}else {
				lvo = new LoginVO();
				lvo.setRow(-1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		}try {
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lvo;
		
	}
	
	
}

