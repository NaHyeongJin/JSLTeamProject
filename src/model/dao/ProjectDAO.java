package model.dao;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

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
	
	
}
