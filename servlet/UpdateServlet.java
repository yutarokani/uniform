package servlet;

import java.io.IOException;

import bean.OrderInfo;
import dao.OrderInfoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = "";
		String cmd = "list";

		try {

			//ordernumber、name、mail、addres、uniname、other、day、sendday、payment、shipping
			//入力パラメータを取得
			String ordernumber = request.getParameter("ordernumber"); //注文番号
			String name = request.getParameter("name"); //氏名
			String mail = request.getParameter("mail"); //メール
			String addres = request.getParameter("addres"); //住所
			String uniid = request.getParameter("uniid"); //商品ID
			String other = request.getParameter("other"); //備考欄
			String day = request.getParameter("day"); //注文日
			String sendday = request.getParameter("sendday"); //発送日
			String payment = request.getParameter("payment"); //入金状況
			String shipping = request.getParameter("shipping"); //発送状況

			//オブジェクト生成
			OrderInfoDAO objOrderedItemDAO = new OrderInfoDAO();

			//それぞれが未入力の時のエラー表示
			if (ordernumber.equals("")) {
				error = "注文番号が未入力の為、書籍登録処理は行えませんでした。";

			} else if (name.equals("")) {
				error = "氏名が未入力の為、書籍登録処理は行えませんでした。";

			} else if (mail.equals("")) {
				error = "メールアドレスが未入力の為、書籍登録処理は行えませんでした。";

			} else if (addres.equals("")) {
				error = "住所が未入力の為、書籍登録処理は行えませんでした。";

			} else if (uniid.equals("")) {
				error = "商品名が未入力の為、書籍登録処理は行えませんでした。";

			} else if (other.equals("")) {
				error = "備考欄が未入力の為、書籍登録処理は行えませんでした。";

			} else if (day.equals("")) {
				error = "注文日が未入力の為、書籍登録処理は行えませんでした。";

			} else if (sendday.equals("")) {
				error = "発送日が未入力の為、書籍登録処理は行えませんでした。";

			} else if (payment.equals("")) {
				error = "入金状況が未入力の為、書籍登録処理は行えませんでした。";

			} else if (shipping.equals("")) {
				error = "発送状況が未入力の為、書籍登録処理は行えませんでした。";

			} else if (request.getParameter("price").equals("")) {
				error = "Priceが未入力の為、書籍登録処理は行えませんでした。";

			} else {

				//Bookのオブジェクトを生成し、各setterメソッドを利用し、②で取得したやつを設定
				OrderInfo orderinfo = new OrderInfo();
				orderinfo.setOrderNumber(Integer.parseInt(ordernumber));
				orderinfo.setName(name);
				orderinfo.setUniId(uniid);
				orderinfo.setSendDay(sendday);
				orderinfo.setPayment(payment);
				orderinfo.setShipping(shipping);

				//③で設定したOrderedItemのオブジェクトを引数として、OrderedItemDAOをインスタンス化し、関連メソッドを呼び出す
				objOrderedItemDAO.update(orderinfo);

			}
		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、登録できませんでした。";
			cmd = "menu";

		} catch (NumberFormatException e) {
			error = "価格の値が不正の為、書籍登録処理は行えませんでした。";
			cmd = "menu";

		} finally {
			if (error.equals("")) {
				request.setAttribute("cmd", cmd);
				//「ListServlet」へフォワード
				request.getRequestDispatcher("/list").forward(request, response);

			} else {
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}

		}
	}
}
