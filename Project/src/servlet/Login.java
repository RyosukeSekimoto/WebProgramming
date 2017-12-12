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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//セッションスコープからログインユーザを取得
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");

		if(loginUser != null) {//ユーザーがログインしていたら

			//ユーザー一覧へリダイレクト
			response.sendRedirect("/UserManagement/UserList");

		} else {//ログインしていなければ

			//ログイン画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String loginId = request.getParameter("loginId");
		String pass = request.getParameter("pass");

		UserDAO userDao = new UserDAO();
		pass = Util.encryption(pass);
		User loginUser = userDao.findById(loginId);

		if(loginUser != null && pass.equals(loginUser.getPass())) {

			//セッションスコープにログインユーザを保存
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);

			//ユーザー一覧にリダイレクト
			response.sendRedirect("/UserManagement/UserList");

		} else { //ログインできなかったら

			//リクエストスコープにエラーメッセージを保存
			String errorMessage = "ログインIDまたはパスワードに誤りがあります。";
			request.setAttribute("errorMessage", errorMessage);

			//ログイン画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);

		}


	}

}
