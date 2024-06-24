package servlet;

import java.io.IOException;
import java.util.ArrayList;

import bean.Goods;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/insertIntoCart")
public class InsertIntoCartServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//エラー変数
		String error = null;
		String cmd = null;
		try {
			//削除対象の配列番号
			String delno = request.getParameter("delno");
			
			//入力情報を受け取るために日本語のエンコード
			response.setContentType("text/html; charset=UTF-8");
			String uniname = request.getParameter("uniname");
			String strbuyQuantity = request.getParameter("buyQuantity");
			//エラー処理
			if(uniname.equals("*")) {
				error=("商品が選択されていませんでした。");
				cmd=("buy");
			}else if(strbuyQuantity.equals("")) {
				error=("商品個数が選択されていません。");
				cmd=("buy");
			}
			if(error==null) {
				//登録する情報を格納
				Goods goods = new Goods();
				int BuyQuantity = Integer.parseInt(strbuyQuantity);
				//set
				goods.setUniName(uniname);
				goods.setBuyQuantity(BuyQuantity);			
				//セッションオブジェクトの生成
				HttpSession session = request.getSession();
				//arrayリストにすべてのカート情報を格納
				ArrayList<Goods> goods_list =(ArrayList<Goods>)session.getAttribute("goods_list");
				//削除
				if (delno!=null) {
					goods_list.remove(Integer.parseInt(delno));
				}
				//一件目
				if(goods_list == null){
					goods_list = new ArrayList<Goods>();
				}
				goods_list.add(goods);	
				//セッションへのデータの登録
				session.setAttribute("goods_list", goods_list);	
			}
			
		}catch(NumberFormatException e){
				//文字が入力された場合のエラー設定
				error = "数字以外が入力されました";
				cmd = ("buy");
		} catch (IllegalStateException e) {
			error = ("DB接続エラーの為、カート追加は行えませんでした。");
			cmd = ("buy");
		}catch (Exception e) {
			error=""+e;
			//エラー
		}finally{
			if(error==null) {
				request.getRequestDispatcher("/view/cart.jsp").forward(request, response);
			}else {
			request.setAttribute("error", error);
			request.setAttribute("cmd", cmd);
			//errorページに遷移
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
