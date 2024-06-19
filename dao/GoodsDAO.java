package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import bean.Goods;

public class GoodsDAO {

	private static final String RDB_DRIVE = "org.mariadb.jdbc.Driver";

	private static final String URL = "jdbc:mariadb://localhost/uniformdb";

	private static final String USER = "root";

	private static final String PASSWD = "root123";

	private static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(RDB_DRIVE);
			con = DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public void insert(Goods goods) {

		Connection con = null;
		Statement smt = null;

		try {

			String sql = "INSERT INTO uniforminfo VALUES('" + goods.getUniId() + "','" + goods.getUniName() + "',"
					+ goods.getStock() + "','" + goods.getPrice() + "')";
			
			con = getConnection();
			smt = con.createStatement();
			
			smt.executeUpdate(sql);

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}

		}
	}
}