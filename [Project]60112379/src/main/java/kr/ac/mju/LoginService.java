package kr.ac.mju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	private String URL = "jdbc:mysql://localhost:3306/";
	private String editURL = "jdbc:mysql://localhost:3306/sogongdb";
	private final static String ID = "root";
	private final static String PASSWORD = "sltodrkr92";
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, ID, PASSWORD);
	}
	
	public int login(User user){
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from sogongdb.user where id =? and password =?";
		int flag = 0;
		try {
			con = DriverManager.getConnection(editURL, ID, PASSWORD);
			stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getID());
			stmt.setString(2, user.getPassword());
			rs = stmt.executeQuery();
			
			if(rs.next()){
				user.setName(rs.getString("name"));
				user.setPos(rs.getString("position"));
				if(user.getPos().equals("stu")) flag = 1;
				else if(user.getPos().equals("pro")) flag = 2;
				else flag = 3;
			}else{
				flag = 4;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			closeStream(con, stmt);
			return flag;
		}
	}
	
	public void closeStream(Connection con, PreparedStatement stmt){
		try{
			con.close();
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
