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
		String cmd = "";
		String title = "";//メールのタイトル用変数
		String message = ""; // メール本文用変数

		try {

			/* update.jspから選択された変数を受け取る */
			String price = request.getParameter("updatePrice"); // 入金状況
			String updateTr = request.getParameter("updateTr"); // 発送状況

			
			String ordernumber = request.getParameter("ordernumber"); //注文番号
			String name = request.getParameter("name"); //氏名
			String mail = request.getParameter("mail"); //メール

			//オブジェクト生成
			OrderInfo orderInfo = new OrderInfo();
			OrderInfoDAO objOrderInfoDAO = new OrderInfoDAO();
			//各setterメソッドを利用し、②で取得したやつを設定
			int number=Integer.parseInt(ordernumber);
			orderInfo.setOrderNumber(number);

			/* update.jspで変更が行われた際処理 */
			

				if (price.equals("notPay")) {

					price = "入金待ち";
					orderInfo.setPayment(price);

				} else if (price.equals("pay")) {

					price = "入金済み";
					orderInfo.setPayment(price);

					title = "入金確認のご連絡";
					message = name + "様\n\n入金を確認いたしました。\n順次発送準備をさせていただきます。\nしばらくお待ちください。\n\nこの度はご利用いただきありがとうございました。";
					/* メール送信処理 */
					SendMail.sendMail(message, title, mail);
					
				}else if(price==""){
					OrderInfo remainOrderInfo = objOrderInfoDAO.selectByOrderNumber(number);
					String Price=remainOrderInfo.getPayment();
					orderInfo.setPayment(Price);
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
					SendMail.sendMail(message, title, mail);
				}else if(updateTr==""){
					OrderInfo remainOrderInfo = objOrderInfoDAO.selectByOrderNumber(number);
					String Shipping=remainOrderInfo.getShipping();
					orderInfo.setShipping(Shipping);
					
				}

				/* データベースを更新 */
				objOrderInfoDAO.update(orderInfo);
			

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、更新できませんでした。";
			cmd = "logout";

		} finally {
			if (error.equals("")) {
				//「ListServlet」へフォワード
				request.getRequestDispatcher("/list").forward(request, response);

			} else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}

		}
	}
}