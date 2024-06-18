package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.Admin;

public class AdminDAO {

	//データベース接続情報
	private static String RDB_DRIVE = "org.mariadb.jdbc.Driver";
	private static String URL = "jdbc:mariadb://localhost/mybookdb";
	private static String USER = "root";
	private static String PASS = "root123";

	//データベース接続
	private static Connection getConnection() {
		try {

			//Class.forNameメソッドを利用してJDBCドライバーをロード
			Class.forName(RDB_DRIVE);

			//DriverManager.getConnectionメソッドを利用してConnectionオブジェクトを生成
			Connection con = DriverManager.getConnection(URL, USER, PASS);

			//生成されたConnectionオブジェクトをリターン
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public static void main(String[] args) throws Exception {
		Connection con = getConnection();
		System.out.println("con=" + con);
		con.close();
	}
	
	public Admin selectByUser(String userid, String password) {

		Connection con = null;
		Statement smt = null;

		//管理者のログイン情報を格納するAdminオブジェクトを生成
		Admin admin = new Admin();

		try {

			//引数の情報を利用し、検索用のSQL文を文字列として定義
			String sql = "SELECT * FROM userinfo WHERE user ='"+userid+"' "
					+ "AND password='"+password+"'";

			//BookDAOクラスに定義した、getConnection()メソッドを利用してConnectionオブジェクトを生成
			con = getConnection();
			//ConnectionオブジェクトのcreateStatement（）メソッドを利用してStatementオブジェクトを生成
			smt = con.createStatement();

			//Statementオブジェクトの、executeQuery（）メソッドを利用して、SQL文を発行し結果セットを取得
			ResultSet rs = smt.executeQuery(sql);

			//結果セットからデータを取り出し、Adminオブジェクトに格納
			while (rs.next()) {
				admin.setUserid(rs.getString("userid"));
				admin.setPassword(rs.getString("password"));
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close(); //Statementオブジェクトをクローズ
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close(); //Connectionオブジェクトをクローズ
				} catch (SQLException ignore) {
				}
			}
		}
		return admin;
	}

}
