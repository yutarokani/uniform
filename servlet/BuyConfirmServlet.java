import java.io.IOException;
import java.util.ArrayList;

import bean.Admin;
import bean.Order;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.sendMail;

@WebServlet("/buyConfirm")
public class BuyConfirmServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		
		// エラー文を格納する変数を宣言
		String error = null;
		
		// エラー判別用の変数を宣言
		String ercmd = null;
		
		try {
						
			// セッションから"admin"を取得する。(セッション切れの場合はerror.jspに遷移する)
			HttpSession session = request.getSession();
			Admin admin = (Admin)session.getAttribute("admin");
			
			if(admin == null) {
				error = "セッション切れの為、購入は出来ません。";
				ercmd = "logout";
				return;
			}
			
			// セッションから"order_list"を取得する。(カートの中身がない場合はerror.jspに遷移する)
			ArrayList<Order> order_list = (ArrayList<Order>)session.getAttribute("order_list");
			
			if(order_list.size() == 0) {
				error = "カートの中に何もなかったので購入は出来ません。";
				ercmd = "menu";
				return;
			}
			
			// Orderオブジェクトを格納する配列を作成
			ArrayList<Order> order = new ArrayList<Order>();
			
			// 関連メソッドをorder_listの(カート追加データ分）だけ呼び出す。
			for(int i = 0;i < order_list.size();i++) {
				Order addorder = order_list.get(i);
				
				// 取得した各OrderをListに追加
				order.add(addorder);
			}
			
			// リクエストスコープに"book_list"という名前で格納
			request.setAttribute("deforder",order);
			
			sendMail.main(null);
			
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