package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.OrderDetail;

public class OrderDetailDAO {

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

	//注文番号で検索し、出てきた受注詳細情報の格納されたArrayListを呼び出し元に返却
	public OrderDetail selectByOrderNumber(String orderNumber) {

		Connection con = null;
		Statement smt = null;

		//検索した受注詳細情報を格納するOrderDetailオブジェクトを生成
		OrderDetail orderDetail = new OrderDetail();

		try {

			//orderinfoの全部のデータとorderdetailのuniidを検索するSQL
			String sql = "SELECT orderinfo.*,orderdetail.uniid FROM orderinfo "
					+ "LEFT OUTER JOIN orderdetail ON orderinfo.ordernumber "
					+ "= orderdetail.ordernumber = '" 
					+ orderNumber + "'";

			//BookDAOクラスに定義した、getConnection()メソッドを利用してConnectionオブジェクトを生成
			con = getConnection();
			//ConnectionオブジェクトのcreateStatement（）メソッドを利用してStatementオブジェクトを生成
			smt = con.createStatement();

			//Statementオブジェクトの、executeQuery（）メソッドを利用して、SQL文を発行し結果セットを取得
			ResultSet rs = smt.executeQuery(sql);

			//結果セットからデータを取り出し、orderDetailオブジェクトに格納
			while (rs.next()) {
				orderDetail.setOrderNumber(rs.getInt("orderNumber"));
				orderDetail.setName(rs.getString("name"));
				orderDetail.setMail(rs.getString("mail"));
				orderDetail.setUniId(rs.getString("uniId"));
				orderDetail.setBuyQuantity(rs.getInt("buyQuantity"));
				orderDetail.setOther(rs.getString("other"));
				orderDetail.setDay(rs.getString("day"));
				
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
		return orderDetail;
	}

}
