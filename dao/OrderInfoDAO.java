package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.OrderInfo;

public class OrderInfoDAO {

	// 接続用の情報をフィールドに定数として定義
	private static String RDB_DRIVE = "org.mariadb.jdbc.Driver";
	private static String URL = "jdbc:mariadb://localhost/uniformdb";
	private static String USER = "root";
	private static String PASS = "root123";

	// データベース接続を行うメソッド
	public static Connection getConnection() {
		try {
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL,USER,PASS);
			return con;
		}catch(Exception e) {
			throw new IllegalStateException(e);
		}
	}

	// データベースから全ての注文情報の検索を行うメソッド
	public ArrayList<OrderInfo> selectAll(){
		// 変数宣言
		Connection con = null;
		Statement smt = null;

		// return 用オブジェクトの生成
		ArrayList<OrderInfo> list = new ArrayList<OrderInfo>();

		// SQL文
		String sql = "SELECT buyquantity,orderinfo.*,uniforminfo.uniname,SUM(uniforminfo.price * orderdetail.number) as 合計金額 "
				+ "FROM orderdetail "
				+ "JOIN orderinfo ON orderdetail.ordernumber=orderinfo.ordernumber "
				+ "JOIN uniforminfo ON orderdetail.uniid=uniforminfo.uniid "
				+ "GROUP BY orderinfo.ordernumber";
		try {
			con = getConnection();
			smt = con.createStatement();

			// SQL を DB へ発行
			ResultSet rs = smt.executeQuery(sql);

			// 検索結果を配列に格納
			while(rs.next()) {
				OrderInfo info = new OrderInfo();
				info.setUniname(rs.getString("uniforminfo.uniName"));
				info.setBuyquantity(rs.getInt("orderdetail.buyQuantity"));
				info.setName(rs.getString("orderinfo.name"));
				info.setMail(rs.getString("orderinfo.mail"));
				info.setAddress(rs.getString("orderinfo.addres"));
				info.setDay(rs.getString("orderinfo.day"));
				info.setSendday(rs.getString("orderinfo.sendDay"));
				info.setPayment(rs.getString("orderinfo.payment"));
				info.setShipping(rs.getString("orderinfo.shipping"));
				list.add(info);
			}

		}catch(Exception e) {
			throw new IllegalStateException(e);
		}finally {
			// リソースの開放
			if(smt != null) {
				try {smt.close();}catch(SQLException ignore) {}
			}
			if(con != null) {
				try {con.close();}catch(SQLException ignore) {}
			}
		}
		return list;
	}

	// 該当注文情報の更新処理を行うメソッド
	public void update(OrderInfo orderedinfo){
		// 変数宣言
		Connection con = null;
		Statement smt = null;

		// SQL文
		String sql = "UPDATE orderinfo SET payment='" + orderedinfo.getPayment() 
		+ "',shipping=" + orderedinfo.getShipping() 
		+ " WHERE ordernumber='" + orderedinfo.getOrdernumber() + "'";

		try {
			con = getConnection();
			smt = con.createStatement();

			// SQL を DB へ発行
			smt.executeUpdate(sql);

		}catch(Exception e) {
			throw new IllegalStateException(e);
		}finally {
			// リソースの開放
			if(smt != null) {
				try {smt.close();}catch(SQLException ignore) {}
			}
			if(con != null) {
				try {con.close();}catch(SQLException ignore) {}
			}
		}
	}

}