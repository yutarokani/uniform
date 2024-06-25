package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import bean.OrderInfo;
import dao.OrderInfoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class ListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// OrderedItemDAOクラスのオブジェクトを生成
		OrderInfoDAO objDao = new OrderInfoDAO();
		OrderInfo order = new OrderInfo();

		String error = "";
		String cmd = "";
		
		var date = new Date();

		try {
			
			if(request.getParameter("cmd") != null){
				cmd = request.getParameter("cmd");
			}
			
			// 書籍情報を格納するAllayListオブジェクトを生成、OrderedItemDAOクラスに定義した、selectAll()メソッドを利用して書籍情報を取得
			ArrayList<OrderInfo> orderList = objDao.selectAll();

			// 取得した書籍情報を「order_list」という名前でリクエストスコープに登録
			request.setAttribute("order_list", orderList);
			
			int thisMonth = (int)date.getMonth() + 1; // 今月
			int lastMonth = thisMonth - 1; // 先月
			
			/* 12月の場合の処理 */
			if (lastMonth == 0) {
				lastMonth = 12;
			}
			int thisSum = 0; // 合計金額を受け取る
			int lastSum = 0;
			
			for (int i = 0; i < orderList.size(); i++) {
				
				OrderInfo orderInfo = (OrderInfo)orderList.get(i);
				
				/* 注文日の取得、加工 */
				String orderMonth = orderInfo.getDay();
				String[] nums = orderMonth.split("-"); // 分割して取得
				int monthNum = Integer.parseInt(nums[1]); // int 型に変換
				
				/* 注文日と参照日を比較 */
				if(monthNum == thisMonth) {
					
					thisSum += Integer.parseInt(orderInfo.getUniId()); // 合計金額
					
				} else if(monthNum == lastMonth) {
					
					lastSum += Integer.parseInt(orderInfo.getUniId()); // 合計金額
					
				}
			}
			
			/* それぞれをリクエストスコープへ登録 */
			request.setAttribute("thisMonth", thisMonth);
			request.setAttribute("lastMonth", lastMonth);
			request.setAttribute("thisSum", thisSum);
			request.setAttribute("lastSum", lastSum);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、受注一覧は表示できませんでした。";

		}catch(Exception e) {
			error = ""+ e;
		} finally {
			if (error.equals("") && !cmd.equals("update")) {
				request.setAttribute("orderedItem", order);
				// list.jspにフォワード
				request.getRequestDispatcher("/view/list.jsp").forward(request, response);
			}else if (error.equals("") && cmd.equals("update")) {
				request.setAttribute("orderedItem", order);
				// update.jspにフォワード
				request.getRequestDispatcher("/view/update.jsp").forward(request, response);
			} else {
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}

}