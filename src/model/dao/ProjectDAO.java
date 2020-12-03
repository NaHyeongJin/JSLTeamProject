
package model.dao;

import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.vo.*;
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
	
	//회원가입
	
	public int ClientWrite(ClientVO client) {
		
		int row = 0;
		String query="INSERT INTO TBL_CLIENT(id,pw,name,email,email2,tel1,tel2,tel3) " + 
				" VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, client.getId());
			pstmt.setString(2, client.getPw());
			pstmt.setString(3, client.getName());
			pstmt.setString(4, client.getEmail());
			pstmt.setString(5, client.getEmail2());
			pstmt.setInt(6, client.getTel1());
			pstmt.setInt(7, client.getTel2());
			pstmt.setInt(8, client.getTel3());
			
			row = pstmt.executeUpdate();
			
		}catch(Exception e) {
			log.info("ClientWrite() 에러 발생 ");
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(Exception e) {}
		}
		return row;
	}
	
	//자유게시판 목록리스트
	public List<BoardVO> BoardList(){
		List<BoardVO> Blist = new ArrayList<BoardVO>();
		String query="";
		return Blist;
	}
	//공지사항 목록리스트
	public List<NoticeVO> NoticeList(){
		List<NoticeVO> Nlist = new ArrayList<NoticeVO>();
		String query="";
		return Nlist;
	}
	//자료실 목록리스트
	public List<RoomVO> RoomList(){
		List<RoomVO> Rlist = new ArrayList<RoomVO>();
		String query="";
		return Rlist;
	}
	//질문답변 목록리스트
	public List<QnaVO> QnaList(){
		List<QnaVO> Qlist = new ArrayList<QnaVO>();
		String query="";
		return Qlist;
	}
}


