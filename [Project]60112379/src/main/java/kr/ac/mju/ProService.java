package kr.ac.mju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class ProService {
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

	public void openclass(Pro pro) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = null;
		try {
			con = DriverManager.getConnection(editURL, ID, PASSWORD);

			sql = "INSERT INTO class"
					+ "(NO, PRONAME, NAME, YEAR, GRADE, MAX, CREDIT) VALUES"
					+ "(?, ?, ?, ?, ?, ?, ?)";
			stmt = con.prepareStatement(sql);

			stmt.setString(1, pro.getNo());
			stmt.setString(2, pro.getProname());
			stmt.setString(3, pro.getName());
			stmt.setString(4, pro.getYear());
			stmt.setString(5, pro.getGrade());
			stmt.setString(6, pro.getMax());
			stmt.setString(7, pro.getCredit());

			stmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		} finally {
			closeStream(con, stmt);
		}
	}

	public ArrayList<Pro> List() throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from sogongdb.class";
		ArrayList<Pro> post = new ArrayList<Pro>();
		try {

			con = DriverManager.getConnection(editURL, ID, PASSWORD);
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Pro proData = new Pro();
				proData.setNo(rs.getString("no"));
				proData.setProname(rs.getString("proname"));
				proData.setName(rs.getString("name"));
				proData.setYear(rs.getString("year"));
				proData.setGrade(rs.getString("grade"));
				proData.setMax(rs.getString("max"));
				proData.setCredit(rs.getString("credit"));
				post.add(proData);
			}
			rs.close();
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		} finally {
			closeStream(con, stmt);
		}
		return post;
	}
	
	public void Grade(RegistForCourse rfc) throws SQLException{
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "update sogongdb.rfc set classgrade = ? where stuname =? and name = ?";
		try {
			con = DriverManager.getConnection(editURL, ID, PASSWORD);
			stmt = con.prepareStatement(sql);
			stmt.setString(1, rfc.getClassGrade());
			stmt.setString(2, rfc.getStudentname());
			stmt.setString(3, rfc.getClassname());
			
			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			closeStream(con, stmt);
		}
	}

	public ArrayList<RegistForCourse> grantGrade(String no) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String number = null;
		String sql = "select * from sogongdb.rfc";
		ArrayList<RegistForCourse> List = new ArrayList<RegistForCourse>();
		try {
			con = DriverManager.getConnection(editURL, ID, PASSWORD);
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				RegistForCourse proData = new RegistForCourse();
				number = rs.getString("no");
				if (no.equals(number)) {
					proData.setStudentname(rs.getString("stuname"));
					proData.setNo(rs.getString("no"));
					proData.setProname(rs.getString("proname"));
					proData.setClassname(rs.getString("name"));
					proData.setYear(rs.getString("year"));
					proData.setGrade(rs.getString("grade"));
					proData.setMax(rs.getString("max"));
					proData.setCredit(rs.getString("credit"));
					proData.setClassGrade(rs.getString("classgrade"));
					List.add(proData);
				}
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStream(con, stmt);
		}
		return List;
	}

	public void closeStream(Connection con, PreparedStatement stmt) {
		try {
			con.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
