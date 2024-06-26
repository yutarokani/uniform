
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
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	// データベースから全ての注文情報の検索を行うメソッド
	public ArrayList<OrderInfo> selectAll() {
		// 変数宣言
		Connection con = null;
		Statement smt = null;

		// return 用オブジェクトの生成
		ArrayList<OrderInfo> list = new ArrayList<OrderInfo>();

		// SQL文
		String sql = "SELECT orderinfo.* ,orderdetail.buyquantity,"
				+ "SUM(uniforminfo.price * orderdetail.buyquantity ) "
				+ "as 合計金額 FROM orderdetail JOIN orderinfo "
				+ "ON orderdetail.ordernumber=orderinfo.ordernumber "
				+ "JOIN uniforminfo ON orderdetail.uniid=uniforminfo.uniid "
				+ "GROUP BY orderinfo.ordernumber ORDER BY ordernumber DESC;";
		try {
			con = getConnection();
			smt = con.createStatement();

			// SQL を DB へ発行
			ResultSet rs = smt.executeQuery(sql);

			// 検索結果を配列に格納
			while (rs.next()) {
				OrderInfo info = new OrderInfo();
				info.setOrderNumber(rs.getInt("orderNumber"));
				info.setBuyQuantity(rs.getInt("buyquantity"));
				info.setName(rs.getString("name"));
				info.setMail(rs.getString("mail"));
				info.setAddress(rs.getString("address"));
				info.setDay(rs.getString("day"));
				info.setPayment(rs.getString("payment"));
				info.setShipping(rs.getString("shipping"));
				info.setUniId(rs.getString("合計金額"));
				list.add(info);
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// リソースの開放
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
		return list;
	}

	public void update(OrderInfo orderedinfo) {
		// 変数宣言
		Connection con = null;
		Statement smt = null;
		// SQL文
		String sql = "UPDATE orderinfo SET payment='" + orderedinfo.getPayment() + "',"
				+ "shipping='" + orderedinfo.getShipping() + "'" + " WHERE orderinfo.ordernumber='"
				+ orderedinfo.getOrderNumber() + "'";

		try {
			con = getConnection();
			smt = con.createStatement();

			// SQL を DB へ発行
			smt.executeUpdate(sql);

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// リソースの開放
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

	//注文番号で検索し、出てきた受注詳細情報の格納されたオブジェクトをを呼び出し元に返却
	public OrderInfo selectByOrderNumber(int orderNumber) {

		Connection con = null;
		Statement smt = null;

		//検索した受注詳細情報を格納するOrderInfoオブジェクトを生成
		OrderInfo orderInfo = new OrderInfo();

		try {

			//orderinfoのordernumberを検索するSQL
			String sql = "SELECT * FROM orderinfo WHERE ordernumber = " + orderNumber + ";";

			//BookDAOクラスに定義した、getConnection()メソッドを利用してConnectionオブジェクトを生成
			con = getConnection();
			//ConnectionオブジェクトのcreateStatement（）メソッドを利用してStatementオブジェクトを生成
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			//結果セットからデータを取り出し、orderDetailオブジェクトに格納
			while (rs.next()) {
				orderInfo.setOrderNumber(rs.getInt("orderNumber"));
				orderInfo.setName(rs.getString("name"));
				orderInfo.setMail(rs.getString("mail"));
				orderInfo.setAddress(rs.getString("address"));
				orderInfo.setOther(rs.getString("other"));
				orderInfo.setDay(rs.getString("day"));
				orderInfo.setPayment(rs.getString("payment"));
				orderInfo.setShipping(rs.getString("shipping"));
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
		return orderInfo;
	}

	public ArrayList<OrderInfo> order(int orderNumber) {
		Connection con = null;
		Statement smt = null;
		ArrayList<OrderInfo> order_list = new ArrayList<OrderInfo>();

		//検索した受注詳細情報を格納するOrderInfoオブジェクトを生成
		OrderInfo orderInfo = new OrderInfo();
		try {

			//uniforminfoからuninameとorderdetailからbuyquantityを検索するSQL
			String sql = "SELECT uniforminfo.uniId,orderdetail.buyquantity FROM orderdetail "
					+ "INNER JOIN uniforminfo ON "
					+ "orderdetail.uniid = uniforminfo.uniid "
					+ "WHERE orderdetail.ordernumber = " + orderNumber + ";";

			//BookDAOクラスに定義した、getConnection()メソッドを利用してConnectionオブジェクトを生成
			con = getConnection();
			//ConnectionオブジェクトのcreateStatement（）メソッドを利用してStatementオブジェクトを生成
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			//結果セットからデータを取り出し、orderDetailオブジェクトに格納
			while (rs.next()) {
				orderInfo.setUniId(rs.getString("uniId"));
				orderInfo.setBuyQuantity(rs.getInt("buyQuantity"));
				order_list.add(orderInfo);

			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
		return order_list;
	}

	public void insert(OrderInfo order) {

		Connection con = null;
		Statement smt = null;

		try {
			//登録用のsql文を発行
			String sql = "INSERT INTO orderdetail(uniid,buyquantity) VALUES('" + order.getUniId() + "','"
					+ order.getBuyQuantity() + "')";
			//オブジェクト生成
			con = getConnection();
			smt = con.createStatement();
			//データベースに登録
			smt.executeUpdate(sql);

			//クローズ
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

	public void profileInsert(OrderInfo orderinfo) {

		Connection con = null;
		Statement smt = null;

		try {

			String sql = "INSERT INTO orderinfo(name,mail,address,other,day,payment,shipping) VALUES('"
					+ orderinfo.getName() + "','" + orderinfo.getMail() + "','"
					+ orderinfo.getAddress() + "','" + orderinfo.getOther() + "','"
					+ orderinfo.getDay() + "','" + orderinfo.getPayment() + "','"
					+ orderinfo.getShipping() + "')";

			con = OrderInfoDAO.getConnection();
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