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
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//セッションスコープからログインユーザ情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");

		if(loginUser == null) {//ユーザがログインしていなかったら

			//ログイン画面にリダイレクト
			response.sendRedirect("/UserManagement/Login");

		} else {

			//ユーザ登録画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
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
		String createDate = request.getParameter("createDate");
		String updateDate = request.getParameter("updateDate");

		//登録されたログインIDでユーザを検索
		UserDAO userDao = new UserDAO();
		User existUser = userDao.findById(loginId);

		if	((loginId.length() != 0 && pass.length() != 0 && checkingPass.length() != 0 && name.length() != 0 && birthDate.length() != 0)//記入漏れがなし
			&& (pass.equals(checkingPass)) //パスワードに不備なし
			&& (existUser == null)) {// 同じログインIDのユーザーがなし

			//パスワードを暗号化
			String encryptedPass = Util.encryption(pass);

			//データベースに新しいユーザー情報を登録
			userDao.createUser(loginId, name, birthDate, encryptedPass, createDate, updateDate);

			//ユーザ一覧画面へリダイレクト
			response.sendRedirect("/UserManagement/UserList");

		} else {

			//リクエストスコープに記入されたログインID、名前、生年月日を保存
			request.setAttribute("loginId", loginId);
			request.setAttribute("name", name);
			request.setAttribute("birthDate", birthDate);

			//リクエストスコープにエラーメッセージを保存
			String errorMessage = "入力された内容は正しくありません。";
			request.setAttribute("errorMessage", errorMessage);

			//ユーザ一覧画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
			dispatcher.forward(request, response);

		}
	}

}
