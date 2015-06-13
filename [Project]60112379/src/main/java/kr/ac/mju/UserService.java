package kr.ac.mju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import org.junit.runner.Request;
import org.springframework.stereotype.Service;

@Service
public class UserService {
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

	/*
	 * private void closeConnection(Connection connection, Statement statement,
	 * ResultSet resultSet) throws SQLException { if (connection == null) {
	 * return; } connection.close(); statement.close(); resultSet.close(); }
	 */

	public void createAccount() throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		con = DriverManager.getConnection(URL, ID, PASSWORD);
		String accountSQL = "GRANT ALL PRIVILEGES ON *.* to sogong2015@localhost IDENTIFIED BY 'mju12345' WITH GRANT OPTION;";
		try {
			stmt = con.prepareStatement(accountSQL);
			stmt.executeUpdate();
			System.out.println("Account Create");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStream(con, stmt);
		}
	}

	public void createDB() throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "create Database sogongdb";
		try {
			con = getConnection();
			stmt = con.prepareStatement(sql);
			stmt.executeUpdate();

			System.out.println("CreateDB");
			editURL = URL + "sogongdb/";
		} catch (Exception e) {
			System.out.println("Now Created DB");
			e.printStackTrace();
		} finally {
			closeStream(con, stmt);
		}
	}

	public void createTable() throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = null;
		try {
			System.out.println(editURL);
			con = DriverManager.getConnection(editURL, ID, PASSWORD);
			sql = "use sogongdb;";
			stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
			System.out.println("Use Database");

			sql = "CREATE TABLE sogongdb.USER" + "(ID VARCHAR(10) NOT NULL,"
					+ "PASSWORD VARCHAR(10) NOT NULL,"
					+ "NAME VARCHAR(10) NOT NULL,"
					+ "POSITION VARCHAR(10) NOT NULL);";
			stmt = con.prepareStatement(sql);
			System.out.println("CreateTable");
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Now Created Table");
			e.printStackTrace();
		} finally {
			closeStream(con, stmt);
		}
	}

	public void createTable2() throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = null;
		try {
			System.out.println(editURL);
			con = DriverManager.getConnection(editURL, ID, PASSWORD);
			sql = "use sogongdb;";
			stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
			System.out.println("Use Database");

			sql = "CREATE TABLE sogongdb.CLASS" + "(NO VARCHAR(10) NOT NULL,"
					+ "PRONAME VARCHAR(10) NOT NULL,"
					+ "NAME VARCHAR(10) NOT NULL,"
					+ "YEAR VARCHAR(10) NOT NULL,"
					+ "GRADE VARCHAR(10) NOT NULL,"
					+ "MAX VARCHAR(10) NOT NULL,"
					+ "CREDIT VARCHAR(10) NOT NULL);";
			stmt = con.prepareStatement(sql);
			System.out.println("CreateTable");
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Now Created Table");
			e.printStackTrace();
		} finally {
			closeStream(con, stmt);
		}
	}

	public void createTable3() throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = null;
		try {
			System.out.println(editURL);
			con = DriverManager.getConnection(editURL, ID, PASSWORD);
			sql = "use sogongdb;";
			stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
			System.out.println("Use Database");

			sql = "CREATE TABLE sogongdb.RFC"
					+ "(STUNAME VARCHAR(10) NOT NULL,"
					+ "NO VARCHAR(10) NOT NULL,"
					+ "PRONAME VARCHAR(10) NOT NULL,"
					+ "NAME VARCHAR(10) NOT NULL,"
					+ "YEAR VARCHAR(10) NOT NULL,"
					+ "GRADE VARCHAR(10) NOT NULL,"
					+ "MAX VARCHAR(10) NOT NULL,"
					+ "CREDIT VARCHAR(10) NOT NULL,"
					+ "CLASSGRADE VARCHAR(10) NOT NULL);";
			stmt = con.prepareStatement(sql);
			System.out.println("CreateTable");
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Now Created Table");
			e.printStackTrace();
		} finally {
			closeStream(con, stmt);
		}
	}

	public void insertData(User user) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = null;
		try {
			con = DriverManager.getConnection(editURL, ID, PASSWORD);

			sql = "INSERT INTO USER" + "(ID, PASSWORD, NAME, POSITION) VALUES"
					+ "(?, ?, ?, ?)";
			stmt = con.prepareStatement(sql);

			stmt.setString(1, user.getID());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getName());
			stmt.setString(4, user.getPos());

			stmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		} finally {
			closeStream(con, stmt);
		}
	}

	public void dropTable() throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = null;
		try {
			sql = "Drop Table sogongdb.user";
			System.out.println("DropTable");
			con = getConnection();
			stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStream(con, stmt);
		}
	}

	public void dropTable2() throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = null;
		try {
			sql = "Drop Table sogongdb.rfc";
			System.out.println("DropTable");
			con = getConnection();
			stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStream(con, stmt);
		}
	}

	public void dropDB() throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = null;

		sql = "Drop Database sogongDB";
		System.out.println("DropDB");
		try {
			con = getConnection();
			stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dropAccount() throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = null;

		sql = "drop User sogong2015@localhost;";
		System.out.println("DropAccount");
		try {
			con = getConnection();
			stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
		} catch (Exception e) {
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
