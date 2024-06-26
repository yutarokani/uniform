package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

	public void update(String uniname,int stock) {

		Connection con = null;
		Statement smt = null;

		try {

			String sql = "UPDATE uniforminfo SET stock = '" + stock + 
					"' WHERE uniname = '" + uniname + "'";
			con = GoodsDAO.getConnection();
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

	public void insert(Goods goods) {

		Connection con = null;
		Statement smt = null;

		try {

			String sql = "INSERT INTO uniforminfo VALUES('" + goods.getUniId() + "','" + goods.getUniName() + "','"
					+ goods.getStock() + "','" + goods.getPrice() + "'" + ")";
			con = GoodsDAO.getConnection();
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

	public void delete(String uniId) {

		Connection con = null;
		Statement smt = null;

		try {
			String sql = "UPDATE uniforminfo SET uniname = '' WHERE uniforminfo.uniid = '" + uniId + "'";

			con = GoodsDAO.getConnection();
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

	public ArrayList<Goods> selectAll() {
		Connection con = null;
		Statement smt = null;
		ArrayList<Goods> goodsList = new ArrayList<Goods>();

		try {
			con = getConnection();
			smt = con.createStatement();

			String sql = "SELECT * FROM uniforminfo ORDER BY uniId";
			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				Goods goods = new Goods();
				goods.setUniId(rs.getString("uniId"));
				goods.setUniName(rs.getString("uniName"));
				goods.setStock(rs.getInt("stock"));
				goods.setPrice(rs.getInt("price"));
				goodsList.add(goods);
			}

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
		return goodsList;
	}

	public Goods selectByuniId(String uniId) {

		Connection con = null;
		Statement smt = null;

		Goods goods = new Goods();

		try {
			String sql = "SELECT uniId,uniName,stock,price FROM uniforminfo WHERE uniId = '" + uniId + "'";
			con = GoodsDAO.getConnection();
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				goods.setUniId(rs.getString("uniId"));
				goods.setUniName(rs.getString("uniName"));
				goods.setStock(rs.getInt("stock"));
				goods.setPrice(rs.getInt("price"));
			}
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
		return goods;
	}

	//名前検索
	public Goods selectByuniname(String uniname) {

		Connection con = null;
		Statement smt = null;

		Goods goods = new Goods();

		try {
			String sql = "SELECT uniName,uniId,stock,price FROM uniforminfo WHERE uniName = '" + uniname + "'";
			con = GoodsDAO.getConnection();
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				goods.setUniId(rs.getString("uniId"));
				goods.setUniName(rs.getString("uniName"));
				goods.setStock(rs.getInt("stock"));
				goods.setPrice(rs.getInt("price"));
			}
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
		return goods;
	}
}