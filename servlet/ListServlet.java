package servlet;

import java.io.IOException;
import java.util.ArrayList;

import bean.OrderInfo;
import dao.OrderInfoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class ListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// OrderedItemDAOクラスのオブジェクトを生成
		OrderInfoDAO objDao = new OrderInfoDAO();

		OrderInfo order = new OrderInfo();

		String error = "";

		try {

			// 書籍情報を格納するAllayListオブジェクトを生成、OrderedItemDAOクラスに定義した、selectAll()メソッドを利用して書籍情報を取得
			ArrayList<OrderInfo> orderList = objDao.selectAll();

			// 取得した書籍情報を「order_list」という名前でリクエストスコープに登録
			request.setAttribute("order_list", orderList);

			// list.jspにフォワード
			request.getRequestDispatcher("/view/list.jsp").forward(request, response);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、登録できませんでした。";

		} finally {
			if (error.equals("")) {
				request.setAttribute("orderedItem", order);
			} else {
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}

}
