package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.OrderedItem;

public class OrderedItemDAO {

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
	public ArrayList<OrderedItem> selectAll(){
		// 変数宣言
		Connection con = null;
		Statement smt = null;

		// return 用オブジェクトの生成
		ArrayList<OrderedItem> list = new ArrayList<OrderedItem>();

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
				OrderedItem item = new OrderedItem();
				item.setOrdernumber(rs.getInt("orderinfo.ordernumber"));
				item.setName(rs.getString("orderinfo.name"));
				item.setUniname(rs.getString("uniforminfo.uniname"));
				item.setBuyquantity(rs.getInt("orderdetail.buyquantity"));
				item.setSendday(rs.getString("orderinfo.sendday"));
				item.setPayment(rs.getString("orderinfo.payment"));
				item.setShipping(rs.getString("orderinfo.shipping"));

				list.add(item);
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
	public void update(OrderedItem ordereditem){
		// 変数宣言
		Connection con = null;
		Statement smt = null;

		// SQL文
		String sql = "UPDATE orderinfo SET payment='" + ordereditem.getPayment() 
		+ "',shipping=" + ordereditem.getShipping() 
		+ " WHERE ordernumber='" + ordereditem.getOrdernumber() + "'";

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
