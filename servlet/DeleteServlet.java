package servlet;

import java.io.IOException;

import dao.GoodsDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uniId = request.getParameter("uniId");
		GoodsDAO goodsDao = new GoodsDAO();
		String error = "";
		String cmd = "";

		try {

			goodsDao.delete(uniId);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、一覧表示は行えませんでした。";
			cmd = "menu";
		} finally {
			if (error.equals("")) {
				request.getRequestDispatcher("/view/list.jsp").forward(request, response);
			}

		}
	}
}