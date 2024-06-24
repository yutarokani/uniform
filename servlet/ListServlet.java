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
		String cmd = "";

		try {
			
			if(request.getParameter("cmd") != null){
				cmd = request.getParameter("cmd");
			}
			
			// 書籍情報を格納するAllayListオブジェクトを生成、OrderedItemDAOクラスに定義した、selectAll()メソッドを利用して書籍情報を取得
			ArrayList<OrderInfo> orderList = objDao.selectAll();

			// 取得した書籍情報を「order_list」という名前でリクエストスコープに登録
			request.setAttribute("order_list", orderList);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、受注一覧は表示できませんでした。";

		} finally {
			if (error.equals("") && !cmd.equals("update")) {
				request.setAttribute("orderedItem", order);
				// list.jspにフォワード
				request.getRequestDispatcher("/view/list.jsp").forward(request, response);
			}else if (error.equals("") && cmd.equals("update")) {
				request.setAttribute("orderedItem", order);
				// update.jspにフォワード
				request.getRequestDispatcher("/view/update.jsp").forward(request, response);
			} else {
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}

}