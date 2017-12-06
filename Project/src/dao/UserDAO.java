package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDAO {

	public User findById(String targetId, String targetPass) {

		Connection conn = null;

		try {
			//データベースへの接続
			conn = DBManager.getConnection();

			//SELECT文を準備
			String sql = "SELECT login_id, name, password FROM user WHERE login_id = ? AND password = ?";

			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, targetId);
			pStmt.setString(2, targetPass);
			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {

			//結果表に格納されたレコードの内容を取り出し、Userインスタンスに追加
			String loginId = rs.getString("login_id");
			String name = rs.getString("name");
			String pass = rs.getString("password");

			User user = new User(loginId, name, pass);
			return user;
			}

		} catch(SQLException e) {

			e.printStackTrace();

		} finally {
			// データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
		}
		return null;
	}
}
