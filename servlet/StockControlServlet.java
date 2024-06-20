package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/stockControl")
public class StockControlServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int stock = (Integer.parseInt(request.getParameter("stock")));
		String error = "";
		String cmd = "";
		GoodsDAO goodsDao = new GoodsDAO();
		Goods goods = new Goods();
		
		try {
		
			int newStock = stock-(Integer.parseInt(request.getParameter("buyQuantity")));
			goods.setStock(newStock);
			goodsDao.stockControl(goods);
			
		}catch (IllegalStateException e) {
			error = "DB接続エラーの為、書籍登録処理は行えませんでした";
			cmd = "menu";
		}finally {
			if(error.equals("")) {
				request.setAttribute("goods", goods);
				request.getRequestDispatcher("/list").forward(request, response);
			}else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
		
	}	
}