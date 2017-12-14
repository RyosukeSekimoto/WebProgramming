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
 * Servlet implementation class Detail
 */
@WebServlet("/Detail")
public class Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//セッションスコープからログインユーザを取得
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");

		if(loginUser == null) {//ユーザがログインしていなかったら

			//ログイン画面にリダイレクト
			response.sendRedirect("/UserManagement/Login");

		} else {

			//リクエストパラメータを取得
			request.setCharacterEncoding("UTF-8");
			String login_Id = request.getParameter("loginId");

			//該当のユーザーを獲得
			UserDAO userDao = new UserDAO();
			User detailUser = userDao.findById(login_Id);

			//リクエストスコープにユーザーを保存
			request.setAttribute("detailUser", detailUser);

			//詳細画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/detail.jsp");
			dispatcher.forward(request, response);
		}
	}

}
