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
		String error = "";
		String cmd = "";

		try {
			if(request.getParameter("cmd") != null) {
				//リクエストスコープからcmdを格納
				cmd = request.getParameter("cmd");
			}

			// 書籍情報を格納するAllayListオブジェクトを生成、BookDAOクラスに定義した、selectAll()メソッドを利用して書籍情報を取得
			ArrayList<Goods> goodsList = objDao.selectAll();
			
			

			// 取得した書籍情報を「goods_list」という名前でリクエストスコープに登録
			request.setAttribute("goods_list", goodsList);


		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、商品一覧は表示できませんでした。";
			if(cmd.equals("buy")) {
				cmd = "error";
			}else {
				cmd = "logout";
			}

		} finally {
			
			if(cmd.equals("buy")) {
				request.getRequestDispatcher("/view/buy.jsp").forward(request, response);
			}
			if (error.equals("")) {
				// list.jspにフォワード
				request.getRequestDispatcher("/view/uniformList.jsp").forward(request, response);
			} else {
				if(cmd.equals("error")) {
					cmd = "buy";
				}
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}

}