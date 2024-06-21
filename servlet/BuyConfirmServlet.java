package servlet;

import java.io.IOException;
import java.util.ArrayList;

import bean.Admin;
import bean.Goods;
import bean.OrderInfo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.SendMail;

@WebServlet("/buyConfirm")
public class BuyConfirmServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		
		// エラー文を格納する変数を宣言
		String error = null;
		
		// エラー判別用の変数を宣言
		String ercmd = null;
		
		try {
			
			OrderInfo orderedinfo = new OrderInfo();
			
			// 送信メールで表示する購入商品を格納するリスト
			ArrayList<Goods> mail_list = new ArrayList<Goods>();

			// セッションから"admin"を取得する。(セッション切れの場合はerror.jspに遷移する)
			HttpSession session = request.getSession();
			Admin admin = (Admin)session.getAttribute("admin");
			
			if(admin == null) {
				error = "セッション切れの為、購入は出来ません。";
				ercmd = "logout";
				return;
			}
			
			/*
			 * セッションから、カートの中身を表す"order_list"を取得する。
			 * (カートの中身がない場合はerror.jspに遷移する)
			 */
			ArrayList<Goods> order_list = (ArrayList<Goods>)session.getAttribute("order_list");
			
			if(order_list.size() == 0) {
				error = "カートの中に何もなかったので購入は出来ません。";
				ercmd = "menu";
				return;
			}
			
			// Goodsオブジェクトを格納する配列を作成
			ArrayList<Goods> goods_list = new ArrayList<Goods>();
			
			// 関連メソッドをorder_listの(カート追加データ分）だけ呼び出す。
			for(int i = 0;i < order_list.size();i++) {
				Goods add_goods = order_list.get(i);
				
				// 取得した各OrderをListに追加
				goods_list.add(add_goods);
			}
			
			// リクエストスコープに"book_list"という名前で格納
			request.setAttribute("goods_list",goods_list);
			
			// "order_list"の注文情報内容をメール送信する。
			SendMail sendmail = new SendMail();
			/* 購入文章の記載、兼データの格納 */
            String message1 = orderedinfo.getName() + "様\n\nユニフォームのご購入ありがとうございます。\n以下の内容でご注文を受け付けましたので、ご連絡致します。\n\n";
            /* DAOメソッドの呼び出し、メソッドを利用して配列の値を格納 */
            Goods sendGoods;
            String message2 = ""; // null が入ってしまうため、空文字の挿入
            for(int i = 0; i < order_list.size(); i++) {
            	sendGoods = order_list.get(i);
            	mail_list.add(sendGoods);
            	
            	/* 繰り返しから購入された書籍分のメッセージ準備 */
				message2 += mail_list.get(i).getUniName() + "\t" + mail_list.get(i).getBuyQuantity() + "\n";
            }

            String message3 = "\n\nまたのご利用よろしくお願いします。";

            /* 受け渡しデータの準備 */
            String address = (String) orderedinfo.getMail(); // セッションからユーザーのEmail情報を取得
            String mailMessage = message1 + message2 + message3; // メッセージの統合
            
            sendmail.Email(mailMessage, address, "ご購入ありがとうございます【神田】");
			
			// セッションの"order_list"情報をクリアする。
			session.setAttribute("order_list",null);
			
		}catch(IllegalStateException e) {
			// DB接続エラー用の文を格納
			error = "DB接続エラーの為、購入はできません。";
			ercmd = "logout";
			return;
			
		}catch(Exception e) {
			// その他のエラー用の文を格納
			error = "予期せぬエラーが発生しました。<br>" + e;
			
		}finally {
			if(error == null) {
				// 正常な処理の場合、 buyConrirm.jsp にフォワード
				request.getRequestDispatcher("/view/buyConfirm.jsp").forward(request, response);
			}else {
				// エラー文をリクエストスコープに登録し、 error.jsp にフォワード
				request.setAttribute("error", error);
				request.setAttribute("cmd", ercmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
			
		}
		
	}
	
}