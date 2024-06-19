package servlet;

import java.io.IOException;
import java.util.ArrayList;

import bean.Goods;
import dao.GoodsDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/uniformlist")
public class UniformListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// GoodsDAOクラスのオブジェクトを生成
		GoodsDAO objDao = new GoodsDAO();

		Goods goods = new Goods();

		String error = "";

		try {

			// 書籍情報を格納するAllayListオブジェクトを生成、BookDAOクラスに定義した、selectAll()メソッドを利用して書籍情報を取得
			ArrayList<Goods> goodsList = objDao.selectAll();

			// 取得した書籍情報を「book_list」という名前でリクエストスコープに登録
			request.setAttribute("goods_list", goodsList);

			// list.jspにフォワード
			request.getRequestDispatcher("/view/uniformlist.jsp").forward(request, response);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、登録できませんでした。";

		} finally {
			if (error.equals("")) {
				request.setAttribute("book", goods);
			} else {
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}

}
