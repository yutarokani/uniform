package servlet;

import java.io.IOException;

import bean.OrderInfo;
import dao.OrderInfoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/custmer")
public class CustomerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = ""; //氏名
		String mail = ""; //メール
		String address = ""; //住所

		String error = "";

		// GoodsDAOクラスのオブジェクトを生成
		OrderInfoDAO orderedInfoDao = new OrderInfoDAO();

		OrderInfo orderedInfo = new OrderInfo();

		try {

			if (name.equals("")) {
				error = "氏名が未入力の為、書籍登録処理は行えませんでした。";

			} else if (mail.equals("")) {
				error = "メールアドレスが未入力の為、書籍登録処理は行えませんでした。";

			} else if (address.equals("")) {
				error = "住所が未入力の為、書籍登録処理は行えませんでした。";

			} else {

				orderedInfo.setName(request.getParameter("name"));
				orderedInfo.setMail(request.getParameter("mail"));
				orderedInfo.setAddress(request.getParameter("address"));
				orderedInfo.setOther(request.getParameter("other"));

				orderedInfoDao.profileInsert(orderedInfo);

			}

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、登録できませんでした。";

		} finally {
			if (error.equals("")) {
				request.setAttribute("orderedInfo", orderedInfo);
			} else {
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}

	}

}