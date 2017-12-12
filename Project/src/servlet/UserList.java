package servlet;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class UserList
 */
@WebServlet("/UserList")
public class UserList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//セッションスコープからログインユーザを取得
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");

		if(loginUser == null) {//ユーザーがログインしていなかったら

			//ログイン画面にリダイレクト
			response.sendRedirect("/UserManagement/Login");

		} else {

			//ユーザ一覧をリクエストスコープに保存
			UserDAO userDao = new UserDAO();
			List<User> userList = userDao.findAll();
			request.setAttribute("userList", userList);

			//ユーザ一覧画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
