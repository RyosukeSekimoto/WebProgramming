package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//セッションスコープからログインユーザーを取得
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");

		if(loginUser == null) {//ユーザーがログインしていなかったら

			//ログイン画面にリダイレクト
			response.sendRedirect("/UserManagement/Login");

		} else {

			//リクエストパラメータを取得
			request.setCharacterEncoding("UTF-8");
			String loginId = request.getParameter("loginId");

			//該当のユーザーを獲得
			UserDAO userDao = new UserDAO();
			User deleteUser = userDao.findById(loginId);

			//リクエストスコープにユーザーを保存
			request.setAttribute("deleteUser", deleteUser);

			//ユーザ削除画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/delete.jsp");
			dispatcher.forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String loginId = request.getParameter("loginId");

		//データベースから該当ユーザを削除
		UserDAO userDao = new UserDAO();
		userDao.deleteUser(loginId);

		////ユーザ一覧画面へリダイレクト
		response.sendRedirect("/UserManagement/UserList");
	}

}
