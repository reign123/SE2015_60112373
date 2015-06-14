package kr.ac.mju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private String editURL = "jdbc:mysql://localhost:3306/sogongdb";
	private final static String ID = "root";
	private final static String PASSWORD = "sltodrkr92";

	public ArrayList<RegistForCourse> gradeview() throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from sogongdb.rfc";
		ArrayList<RegistForCourse> rfc = new ArrayList<RegistForCourse>();
		try {
			con = DriverManager.getConnection(editURL, ID, PASSWORD);
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				RegistForCourse proData = new RegistForCourse();
				proData.setStudentname(rs.getString("stuname"));
				proData.setNo(rs.getString("no"));
				proData.setProname(rs.getString("proname"));
				proData.setClassname(rs.getString("name"));
				proData.setYear(rs.getString("year"));
				proData.setGrade(rs.getString("grade"));
				proData.setMax(rs.getString("max"));
				proData.setCredit(rs.getString("credit"));
				proData.setClassGrade(rs.getString("classgrade"));
				rfc.add(proData);
			}
			rs.close();
			
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		} finally {
			closeStream(con, stmt);
		}
		return rfc;
	}
	
	public void delclass(String num) throws SQLException{
		Connection con = null;
		PreparedStatement stmt = null;
		String use = "set SQL_SAFE_UPDATES=0";
		String sql = "delete from sogongdb.rfc where no = ?";
		try {

			con = DriverManager.getConnection(editURL, ID, PASSWORD);
			stmt = con.prepareStatement(use);
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, num);
			
			stmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		} finally {
			closeStream(con, stmt);
		}
	}

	public ArrayList<Pro> rfcview() throws SQLException {
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

	public void rfc(RegistForCourse rfc) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = null;
		String non = "unwritten";
		try {
			con = DriverManager.getConnection(editURL, ID, PASSWORD);

			sql = "INSERT INTO RFC"
					+ "(STUNAME, NO, PRONAME, NAME, YEAR, GRADE, MAX, CREDIT, CLASSGRADE ) VALUES"
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = con.prepareStatement(sql);

			stmt.setString(1, rfc.getStudentname());
			stmt.setString(2, rfc.getNo());
			stmt.setString(3, rfc.getProname());
			stmt.setString(4, rfc.getClassname());
			stmt.setString(5, rfc.getYear());
			stmt.setString(6, rfc.getGrade());
			stmt.setString(7, rfc.getMax());
			stmt.setString(8, rfc.getCredit());
			stmt.setString(9, non);

			stmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		} finally {
			closeStream(con, stmt);
		}
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
