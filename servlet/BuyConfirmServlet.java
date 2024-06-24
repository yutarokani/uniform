package servlet;

import java.io.IOException;

import bean.Goods;
import bean.OrderInfo;
import dao.GoodsDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
			
			String name = request.getParameter("name");
			String mail = request.getParameter("email");
			String address = request.getParameter("address");
			String other = request.getParameter("comment");
			int buyquantity = 2;
			String uniid = "1";
			
			OrderInfo orderinfo = new OrderInfo();
			
			orderinfo.setName(name);
			orderinfo.setMail(mail);
			orderinfo.setAddress(address);
			orderinfo.setOther(other);
			orderinfo.setBuyQuantity(buyquantity);
			orderinfo.setUniId(uniid);
			
			// goods オブジェクトをインスタンス化
			Goods goods = new Goods();
			GoodsDAO goodsDao = new GoodsDAO();
			// 商品名を受け取る
			goods = goodsDao.selectByuniId(orderinfo.getUniId());
			String uniname = goods.getUniName();
			
			// 商品価格を受け取る
			int price = goods.getPrice();
			
			// 合計金額を計算する
			int total = price * buyquantity;
			
			request.setAttribute("orderinfo",orderinfo);
			request.setAttribute("uniname", uniname);

			/*// セッションから"admin"を取得する。(セッション切れの場合はerror.jspに遷移する)
			HttpSession session = request.getSession();
			Admin admin = (Admin)session.getAttribute("admin");
			
			if(admin == null) {
				error = "セッション切れの為、購入は出来ません。";
				ercmd = "logout";
				return;
			}*/
			
			/*
			 * セッションから、カートの中身を表す"order_list"を取得する。
			 * (カートの中身がない場合はerror.jspに遷移する)
			 */
			/*ArrayList<OrderInfo> order_list = (ArrayList<OrderInfo>)session.getAttribute("order_list");
			
			
			
			/*if(order_list.size() == 0) {
				error = "カートの中に何もなかったので購入は出来ません。";
				ercmd = "menu";
				return;
			}*/
			
			
			// "order_list"の注文情報内容をメール送信する。
			SendMail sendmail = new SendMail();
			
			// メール文格納用の変数を作成
			String ordermail = "";
			
			ordermail += orderinfo.getName() + "様\n\n";
            ordermail += "ユニフォームのご購入ありがとうざいます。\n";
            ordermail += "以下内容でご注文を受け付けましたので、ご連絡致します。\n\n";
            
            ordermail += "商品名：" + uniname + " " + "購入個数：" + buyquantity + " " + "商品価格：" + price + "\n";
            
            ordermail += "合計　" + total + "円\n\n";
            
            ordermail +=  "またのご利用をお待ちしております。";
			
            sendmail.sendMail(ordermail, orderinfo.getMail(), "ご購入ありがとうございます【神田】");
			
			// セッションの"order_list"情報をクリアする。
			/*session.setAttribute("order_list",null);*/
			
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