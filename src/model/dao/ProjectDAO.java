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

import model.vo.ClientVO;
import model.vo.LoginVO;


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
	//커넥션 풀 설정
	public static Connection getConnection() throws Exception {
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection();
		//etc.
		return conn;
	
	}

	//로그인 메소드
	public LoginVO login (String id, String pw) {
		String query = "select pw,grade from tbl_client where id=? ";
		LoginVO lvo =null;
		log.info("id="+id);
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				lvo = new LoginVO();
				lvo.setPw( rs.getString("pw"));
				lvo.setGrade( rs.getString("grade"));
				if(lvo.getPw().equals(pw)) {
					lvo.setRow(1);
				}else {
					lvo.setRow(0);
				}
			}else {
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
	// 등급 반환 메소드
	
	// 등급 반환 메소드
	public String grade (String id) {
		String query = "select grade from tbl_client where id=? ";
		String grade = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
			grade = rs.getString("grade");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
		}try {

			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return grade;
		
	
	}
	
	
}

