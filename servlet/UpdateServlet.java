package servlet;

import java.io.IOException;

import bean.OrderInfo;
import dao.OrderInfoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.SendMail;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = "";
		String cmd = "list";
		String title = "";//メールのタイトル用変数
		String message = ""; // メール本文用変数

		try {
			
			/* update.jspから選択された変数を受け取る */
			String price = request.getParameter("updatePrice"); // 入金状況
			String updateTr = request.getParameter("updateTr"); // 発送状況

			//ordernumber、name、mail、addres、uniname、other、day、sendday、payment、shipping
			//入力パラメータを取得
			String ordernumber = "1";//request.getParameter("ordernumber"); //注文番号
			String name = "test";//request.getParameter("name"); //氏名
			String mail = "test";//request.getParameter("mail"); //メール
			String addres = "test";//request.getParameter("addres"); //住所
			String uniname = "test";//request.getParameter("uniname"); //商品名
			String other = "test";//request.getParameter("other"); //備考欄
			String day = "2024/06/19";//request.getParameter("day"); //注文日
			String sendday = "2024/06/19";//request.getParameter("sendday"); //発送日
			String payment = "1";//request.getParameter("payment"); //入金状況
			String shipping = "1";//request.getParameter("shipping"); //発送状況

			//オブジェクト生成
			OrderInfoDAO objOrderedItemDAO = new OrderInfoDAO();
			OrderInfo orderInfo = new OrderInfo();

			//それぞれが未入力の時のエラー表示
			if (ordernumber.equals("")) {
				error = "注文番号が未入力の為、書籍登録処理は行えませんでした。";

			} else if (name.equals("")) {
				error = "氏名が未入力の為、書籍登録処理は行えませんでした。";

			} else if (mail.equals("")) {
				error = "メールアドレスが未入力の為、書籍登録処理は行えませんでした。";

			} else if (addres.equals("")) {
				error = "住所が未入力の為、書籍登録処理は行えませんでした。";

			} else if (uniname.equals("")) {
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

			} else if (price.equals("")){//request.getParameter("price").equals("")) {
				error = "Priceが未入力の為、書籍登録処理は行えませんでした。";

			} else {
				
				/* update.jspで変更が行われた際処理 */
				if (price != null || updateTr != null) {
					
					if(price.equals("notPay")) {
						
						price = "入金待ち";
						orderInfo.setPayment(price);
						
					} else if (price.equals("pay")) {
						
						price = "入金済み";
						orderInfo.setPayment(price);
						
						title = "入金確認のご連絡";
						message = name + "様\n\n入金を確認いたしました。\n順次発送準備をさせていただきます。\nしばらくお待ちください。\n\nこの度はご利用いただきありがとうございました。";
						/* メール送信処理 */
						SendMail.Email(message, mail, title);
					}
					
					if (updateTr.equals("non")) {
						
						updateTr = "未発送";
						orderInfo.setShipping(updateTr);
						
					} else if (updateTr.equals("notTr")) {
						
						updateTr = "発送準備中";
						orderInfo.setShipping(updateTr);
						
					} else if (updateTr.equals("trance")) {
						
						updateTr = "発送済み";
						orderInfo.setShipping(updateTr);
						
						title = "商品発送のご連絡";
						message = name + "様\n\nご注文頂きました商品を発送いたしました。\nまたのご利用をお待ちしております。";
						/* メール送信処理 */
						SendMail.Email(message, mail, title);
					}

					/* データベースを更新 */
					objOrderedItemDAO.update(orderInfo);
				}

				//Bookのオブジェクトを生成し、各setterメソッドを利用し、②で取得したやつを設定
				orderInfo.setOrderNumber(Integer.parseInt(ordernumber));

				//③で設定したOrderedItemのオブジェクトを引数として、OrderedItemDAOをインスタンス化し、関連メソッドを呼び出す
				objOrderedItemDAO.update(orderInfo);

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