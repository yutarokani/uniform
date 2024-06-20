package servlet;

import java.io.IOException;

import bean.OrderDetail;
import dao.OrderDetailDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = null;//エラーメッセージ用の変数error
		String cmd = null;//遷移先判定用の変数cmd

		try {

			//OrderDetailDAOクラスのオブジェクトを生成
			OrderDetailDAO orderDetailDao = new OrderDetailDAO();

			//画面から送信されるISBNとcmd情報を受け取るためのエンコードを設定
			request.setCharacterEncoding("UTF-8");

			//画面から送信されるorderNumberとcmd情報を受け取る
			String orderNumber = request.getParameter("orderNumber");
			cmd = request.getParameter("cmd");

			//OrderDetailDAOクラスに定義したselectByOrderDetail（）メソッドを利用して詳細情報を取得
			OrderDetail orderDetail = orderDetailDao.selectByOrderNumber(orderNumber);

			//エラーチェック
			if (orderDetail.getOrderNumber() == 0 && !cmd.equals("update")) {//戻り値のオブジェクトにデータが存在しない場合
				error = "表示対象の受注が存在しない為、詳細情報は表示できませんでした。";
				cmd = "list";
				return;
			}

			if (orderDetail.getOrderNumber() == 0 && cmd.equals("update")) {//戻り値のオブジェクトにデータが存在しない場合
				error = "更新対象の受注が存在しない為、変更画面は表示できませんでした。";
				cmd = "list";
				return;
			}

			//取得した書籍情報を「orderDetail」という名前でリクエストスコープに登録
			request.setAttribute("orderDetail", orderDetail);

		} catch (IllegalStateException e) {

			if (cmd.equals("detail")) {
				error = "DB接続エラーの為、受注詳細情報は表示できませんでした。";
			} else if (cmd.equals("update")) {
				error = "DB接続エラーの為、変更画面は表示できませんでした。";
			}
			cmd = "logout";

		} finally {

			if (error != null) {//エラーがあればerror.jspにフォワード
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);

			} else {
				request.getRequestDispatcher("/view/detail.jsp").forward(request, response);
			}
		}

	}

}