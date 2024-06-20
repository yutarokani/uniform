package servlet;

import java.io.IOException;
import java.util.ArrayList;

import bean.Goods;
import bean.OrderInfo;
import dao.GoodsDAO;
import dao.OrderInfoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/insertIntoCart")
public class InsertIntoCartServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//エラー変数
		String error = null;
		String cmd = null;
		try {
			// 商品名,購入個数を画面から受け取る
			String uniname = request.getParameter("uniname");
			int buyQuantity = Integer.parseInt(request.getParameter("buyQuantity"));
			
			//uninameの情報を受け取る
			Goods good = new Goods();
			GoodsDAO goodDao = new GoodsDAO();
			good = goodDao.selectByuniname(uniname);
			//uniIdを受け取る
			String uniId=good.getUniId();
			
			//登録する情報を格納
			OrderInfo order = new OrderInfo();
			//set
			order.setUniId(uniId);
			order.setBuyQuantity(buyQuantity);
			//insertメソッドでDB登録
			OrderInfoDAO OrderInfoDAO = new OrderInfoDAO();
			OrderInfoDAO.insert(order);
			
			//arrayリストにすべてのカート情報を格納
			ArrayList<OrderInfo> order_list = new ArrayList<OrderInfo>();
			order_list=OrderInfoDAO.selectAll();
			//リクエストスコープに追加
			request.setAttribute("order_list",order_list);
			
			
			//商品の価格
			int price = good.getPrice();
			//購入金額を計算
			price = price * buyQuantity;
			//リクエストスコープに追加
			request.setAttribute("price",price);
			//遷移
			request.getRequestDispatcher("/view/showCart.jsp").forward(request, response);
			
			//DBエラー
		} catch (IllegalStateException e) {
			error = ("DB接続エラーの為、一覧表示は行えませんでした。");
			cmd = ("logout");

			request.setAttribute("bookMsg", error);
			request.setAttribute("bookCmd", cmd);

			//errorページに遷移
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);

		}
	}
}
