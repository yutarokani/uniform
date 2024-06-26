package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.OrderInfo;

public class OrderDetailDAO {

	//データベース接続情報
	private static String RDB_DRIVE = "org.mariadb.jdbc.Driver";
	private static String URL = "jdbc:mariadb://localhost/uniformdb";
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
	public OrderInfo selectByOrderNumber(String orderNumber) {

		Connection con = null;
		Statement smt = null;

		//検索した受注詳細情報を格納するOrderInfoオブジェクトを生成
		OrderInfo orderinfo = new OrderInfo();

		try {

			//orderinfoの全部のデータとorderdetailのuniidを検索するSQL
			String sql = "SELECT orderinfo.*,uniforminfo.uniname,buyquantity FROM orderdetail "
					+ "JOIN orderinfo ON orderinfo.ordernumber "
					+ "= orderdetail.ordernumber = '" 
					+ orderNumber + "' JOIN uniforminfo ON uniforminfo.uniid = orderdetail.uniid";

			//BookDAOクラスに定義した、getConnection()メソッドを利用してConnectionオブジェクトを生成
			con = getConnection();
			//ConnectionオブジェクトのcreateStatement（）メソッドを利用してStatementオブジェクトを生成
			smt = con.createStatement();

			//Statementオブジェクトの、executeQuery（）メソッドを利用して、SQL文を発行し結果セットを取得
			ResultSet rs = smt.executeQuery(sql);

			//結果セットからデータを取り出し、orderDetailオブジェクトに格納
			if(rs.next()) {
				orderinfo.setOrderNumber(rs.getInt("ordernumber"));
				orderinfo.setName(rs.getString("name"));
				orderinfo.setMail(rs.getString("mail"));
				orderinfo.setAddress(rs.getString("address"));
				orderinfo.setUniId(rs.getString("uniname"));
				orderinfo.setOther(rs.getString("other"));
				orderinfo.setBuyQuantity(rs.getInt("buyquantity"));
				orderinfo.setDay(rs.getString("day"));
				orderinfo.setPayment(rs.getString("payment"));
				orderinfo.setShipping(rs.getString("shipping"));
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
		return orderinfo;
	}

}