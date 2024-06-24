package servlet;

import java.io.IOException;
import java.util.ArrayList;

import bean.Goods;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
			
			//登録する情報を格納
			Goods goods = new Goods();
			//set
			goods.setUniName(uniname);
			goods.setBuyQuantity(buyQuantity);
			
			//セッションオブジェクトの生成
			HttpSession session = request.getSession();
			//arrayリストにすべてのカート情報を格納
			ArrayList<Goods> goods_list =(ArrayList<Goods>)session.getAttribute("goods_list");
			if(goods_list == null){
				goods_list = new ArrayList<Goods>();
			}
			goods_list.add(goods);	
			//セッションへのデータの登録
			session.setAttribute("goods_list", goods_list);	
			//遷移
			request.getRequestDispatcher("/view/cart.jsp").forward(request, response);
			
			//DBエラー
		} catch (IllegalStateException e) {
			error = ("DB接続エラーの為、カート追加は行えませんでした。");
			cmd = ("logout");

			request.setAttribute("bookMsg", error);
			request.setAttribute("bookCmd", cmd);

			//errorページに遷移
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);

		}
	}
}
