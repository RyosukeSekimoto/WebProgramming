package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;
import model.UtilLogic;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//セッションスコープからログインユーザを取得
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");

		if(loginUser == null) {//ユーザーがログインしていなかったら

			//ログイン画面にリダイレクト
			response.sendRedirect("/UserManagement/Login");

		} else {

			//リクエストパラメータを取得
			request.setCharacterEncoding("UTF-8");
			String loginId = request.getParameter("loginId");

			//該当のユーザを獲得
			UserDAO userDao = new UserDAO();
			User updateUser = userDao.findById(loginId);

			//リクエストスコープにユーザーを保存
			request.setAttribute("updateUser", updateUser);

			//詳細画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String loginId = request.getParameter("loginId");
		String pass = request.getParameter("pass");
		String checkingPass = request.getParameter("checkingPass");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");
		Timestamp updateDate = new Timestamp(Long.parseLong(request.getParameter("updateDate")));

		UserDAO userDao = new UserDAO();

		if(name.length() != 0 && birthDate.length() != 0 && pass.equals(checkingPass)) {//情報入力に間違いがないか

			if(pass.isEmpty()) {//どちらも空白だった場合

				//既存のパスワードを準備
				User updateUser = userDao.findById(loginId);
				pass = updateUser.getPass();

			} else {
				//パスワードが入力されていればそれを暗号化
				pass = UtilLogic.encryption(pass);
			}

			//生年月日をDate型に変換
			Date convertBirthDate = Date.valueOf(birthDate);

			//ユーザー情報をアップデート
			userDao.updateById(loginId, name, convertBirthDate, pass, updateDate);

			//ユーザ一覧へリダイレクト
			response.sendRedirect("/UserManagement/UserList");

		} else {

			//リクエストスコープにエラーメッセージを保存
			String errorMessage = "入力された内容は正しくありません。";
			request.setAttribute("errorMessage", errorMessage);

			//リクエストスコープにupdateを保存
			User updateUser = userDao.findById(loginId);
			request.setAttribute("updateUser", updateUser);

			//ユーザ更新画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
			dispatcher.forward(request, response);
		}
	}
}
