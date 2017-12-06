package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.User;

public class UserDAO {

	public User findById(String targetId, String targetPass) {

		Connection conn = null;

		try {
			//データベースへの接続
			conn = DBManager.getConnection();

			//SELECT文を準備
			String sql = "SELECT login_id, name, password FROM user";

			//SELECT文を実行し、結果表を取得
			Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);

			//結果表に格納されたレコードの内容を取り出し、Userインスタンスに追加
			while(rs.next()) {
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				String pass = rs.getString("password");

				if(targetId.equals(loginId) && targetPass.equals(pass)) {
					User user = new User(loginId, name, pass);
					return user;
				}
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
