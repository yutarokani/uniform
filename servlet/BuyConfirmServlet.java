package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import bean.Goods;
import bean.OrderInfo;
import dao.GoodsDAO;
import dao.OrderInfoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.SendMail;

@WebServlet("/buyConfirm")
public class BuyConfirmServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		
		// エラー文を格納する変数を宣言
		String error = null;
		
		// エラー判別用の変数を宣言
		String cmd = null;
		
		// 日付取得用変数
		Calendar calendar = Calendar.getInstance();

		
		try {
			// 日付の取得
			int year = calendar.get(Calendar.YEAR);
		    int month = calendar.get(Calendar.MONTH);
		    int day = calendar.get(Calendar.DATE);
		    
		    String today = year + "-" + (month + 1) + "-" + day;
			
			//セッションオブジェクトの生成
			HttpSession session = request.getSession();
			
			//セッションからのデータの取得
			ArrayList<Goods> goods_list = (ArrayList<Goods>)session.getAttribute("goods_list");
			
			// カートの中身がない場合エラー処理を行う
			if(goods_list.size() == 0) {
				error = "カートの中に何もなかったので購入は出来ません。";
				cmd = "buy";
				return;
			}
			
			// 注文情報用のArrayListを作成
			ArrayList<OrderInfo> order_list = new ArrayList<OrderInfo>();
			
			// 注文した商品名のArrayListを作成
			ArrayList<String> uniname_list = new ArrayList<String>();
			
			//入力情報を受け取るために日本語のエンコード
			response.setContentType("text/html; charset=UTF-8");
			
			// パラメータから情報を受け取る
			String name = request.getParameter("name");
			String mail = request.getParameter("email");
			String address = request.getParameter("address");
			String other = request.getParameter("comment");
			
			// エラー処理
			if(name.isEmpty()) {
				error = "氏名欄が入力されていないので、購入できませんでした。";
				cmd = "confirm";
				return;
			}else if(mail.isEmpty()) {
				error = "メール欄が入力されていないので、購入できませんでした。";
				cmd = "confirm";
				return;
			}else if(!mail.contains("@")){// メール欄に「@」が含まれているかチェック
				error = "メールアドレスに「@」が含まれていませんでした。";
				cmd = "confirm";
				return;
			}else if(address.isEmpty()) {
				error = "住所欄が入力されていないので、購入できませんでした。";
				cmd = "confirm";
				return;
			}
			
			// orderinfoDao インスタンス化
			OrderInfoDAO orderinfoDao = new OrderInfoDAO();
			
			// goods オブジェクトをインスタンス化
			Goods goods = new Goods();
			
			// goodsDao インスタンス化
			GoodsDAO goodsDao = new GoodsDAO();
			
			for(int i = 0; i < goods_list.size(); i++) {
				
				// 商品IDを受け取る
				goods = goodsDao.selectByuniname(goods_list.get(i).getUniName());
				String uniid = goods.getUniId();
				
				// orderinfoオブジェクトを作成し、各情報を格納
				OrderInfo orderinfo = new OrderInfo();
				orderinfo.setUniId(uniid);
				orderinfo.setBuyQuantity(goods_list.get(i).getBuyQuantity());
				
				orderinfo.setName(name);
				orderinfo.setMail(mail);
				orderinfo.setAddress(address);
				orderinfo.setOther(other);
				orderinfo.setDay(today);
				orderinfo.setPayment("入金待ち");
				orderinfo.setShipping("未発送");
				
				// 注文情報用の配列に格納
				order_list.add(orderinfo);
				
				// 商品名のArrayListに格納
				uniname_list.add(goods_list.get(i).getUniName());
				
				// データベースに注文した商品の情報を登録
				orderinfoDao.insert(orderinfo);
				
				// データベースに注文した顧客情報を登録
				orderinfoDao.profileInsert(orderinfo);
			}
			
			// セッションに登録
			session.setAttribute("order_list",order_list);
			session.setAttribute("uniname_list",uniname_list);
			
			// "order_list"の注文情報内容をメール送信する。
			SendMail sendmail = new SendMail();
			
			// メール文格納用の変数を作成
			String ordermail = "";
			
			// 各小計を受け取る
			int mail_price = 0;
			
			// メールに表示する合計金額用の変数を宣言
			int total = 0;
			
			ordermail += name + "様\n\n";
            ordermail += "ユニフォームのご購入ありがとうざいます。\n";
            ordermail += "以下の内容でご注文を受け付けましたので、ご連絡致します。\n\n";
            
            for(int i = 0; i < goods_list.size(); i++) {
            	
            	// メールに表示する小計
            	mail_price = 5000 * (goods_list.get(i).getBuyQuantity());
            	
            	// 合計金額の計算
            	total += mail_price;
            	
            	ordermail += "商品名：" + goods_list.get(i).getUniName() + "   " + 
            				"購入個数：" + goods_list.get(i).getBuyQuantity() + "   " + 
            				"小計：" + mail_price + "円\n\n";
            	
            }
            
            ordermail += "\n合計：" + total + "円\n\n\n";
            
            
            ordermail +=  "またのご利用をお待ちしております。";
			
            sendmail.sendMail(ordermail,  "ご購入ありがとうございます【神田】", mail);
            
            // 在庫数を購入数分減らす
            for(int i = 0; i < goods_list.size(); i++) {
            	goods = goodsDao.selectByuniname(goods_list.get(i).getUniName());
            	int stock = goods.getStock(); 
            	stock -= goods_list.get(i).getBuyQuantity();
            	goodsDao.update(goods_list.get(i).getUniName(),stock);	
            }
			
			// セッションの"goods_list"情報(カートの中身)をクリアする。
			session.setAttribute("goods_list",null);
			
		}catch(IllegalStateException e) {
			// DB接続エラー用の文を格納
			error = "DB接続エラーの為、購入はできません。";
			cmd = "buy";
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
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
			
		}
		
	}
	
}