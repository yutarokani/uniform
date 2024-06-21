package servlet;

import java.io.IOException;

import bean.Goods;
import dao.GoodsDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//エラー処理先を決めるString型のerrorとcmdを宣言し初期化
		String error = "";
		String cmd = "list";
		
		GoodsDAO goodsDao = new GoodsDAO();
		Goods goods = new Goods();
		//コンテンツタイプ
		response.setContentType("text/html;charset=UTF-8");
		
		String uniId = request.getParameter("uniId");

		//各エラー処理
		try {
			Goods goods1 = goodsDao.selectByuniId(uniId);

			if (request.getParameter("uniId").equals("")) {
				error = "uniIdが未入力の為、商品登録処理は行えませんでした。";
			} else if (request.getParameter("uniName").equals("")) {
				error = "uniNameが未入力の為、商品登録処理は行えませんでした。";
			} else if (request.getParameter("stock").equals("")) {
				error = "stockが未入力の為、商品登録処理は行えませんでした。";
			} else if (request.getParameter("price").equals("")) {
				error = "priceが未入力の為、商品登録処理は行えませんでした。";
			} else if (request.getParameter("uniId").equals(goods1.getUniId())){
				error = "入力uniIdは既に登録済みの為、商品登録処理は行えませんでした。";			
			} else {
				//getParameterで取得した情報をbookオブジェクトに格納
				goods.setUniId(request.getParameter("uniId"));
				goods.setUniName(request.getParameter("uniName"));
				goods.setStock(Integer.parseInt(request.getParameter("stock")));
				goods.setPrice(Integer.parseInt(request.getParameter("price")));
				
				goodsDao.insert(goods);
			}
				
		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、商品登録処理は行えませんでした";
			cmd = "menu";
		} catch (NumberFormatException e) {
			error = "数値が不正の為、商品登録処理は行えませんでした。";
			cmd = "menu";

		} finally {
			if(error.equals("")) {
				request.setAttribute("goods", goods);
				request.getRequestDispatcher("/list").forward(request, response);
			}else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
