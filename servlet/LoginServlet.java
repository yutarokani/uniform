package servlet;

import java.io.IOException;

import bean.Admin;
import dao.AdminDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userid = request.getParameter("user");
		String password = request.getParameter("password");

		AdminDAO adminDao = new AdminDAO();

		String error = "";
		String cmd = "";
		


		try {
			Admin admin = adminDao.selectByUser(userid);
			
			if (admin.getUserid() != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", userid);

				Cookie useridCookie = new Cookie("user", userid);
				useridCookie.setMaxAge(60 * 60 * 24 * 5);
				response.addCookie(useridCookie);

				Cookie passwordCookie = new Cookie("password", password);
				passwordCookie.setMaxAge(60 * 60 * 24 * 5);
				response.addCookie(passwordCookie);

				request.getRequestDispatcher("/view/menu.jsp").forward(request, response);

			} else {
				request.setAttribute("message", "入力データが間違っています！");
				request.getRequestDispatcher("/view/login.jsp").forward(request, response);
			}

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、書籍登録処理は行えませんでした";
			cmd = "login";
			request.setAttribute("error", error);
			request.setAttribute("cmd", cmd);
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);
		}
	}
}
