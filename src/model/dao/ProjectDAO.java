package model.dao;

import java.sql.*;
<<<<<<< HEAD
=======
import java.util.*;
import java.util.logging.Logger;
>>>>>>> 1c68133d37007489ecb4b37a4de29c6b9fc4f5c0

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

<<<<<<< HEAD
public class ProjectDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private static ProjectDAO instance = new ProjectDAO();
	private ProjectDAO() {}
	public static ProjectDAO getinstance() {
		return instance;
	}
	
	//커넥션 풀 설정
	private static Connection getConnection() throws Exception{
		   Context initContext = new InitialContext();
		   Context envContext  = (Context)initContext.lookup("java:/comp/env");
		   DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		   Connection conn = ds.getConnection();
		   return conn;
	   }
	
	
=======
import model.vo.*;


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
	private static Connection getConnection() throws Exception{
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection();
		return conn;
	}
	//회원회원가입
	public int ClientWrite() {
		int row =0;
		String query="";
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
>>>>>>> 1c68133d37007489ecb4b37a4de29c6b9fc4f5c0
}
