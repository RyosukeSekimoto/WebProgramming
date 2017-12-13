package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.SearchConditionBeans;
import model.User;

public class UserDAO extends DaoUtil {

	/**
	 * データベースからすべてのユーザ情報を取得して返す
	 * @return	すべてのユーザが格納されたList<User>型インスタンス
	 */
	public List<User> findAll() {

		Connection conn = null;
		List<User> userList = new ArrayList<User>();

		try {

			//データベースへの接続
			conn = DBManager.getConnection();

			//SELECT文を準備
			String sql = "SELECT * FROM user ORDER BY ID DESC";

			//SELECT文を実行し、結果表を取得
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			//結果表に格納されたレコードの内容をuserインスタンスに設定し、ArrayListインスタンスに追加
			while(rs.next()) {

				int id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				String birthDate = rs.getString("birth_date");
				String pass = rs.getString("password");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");

				User user = new User(id, loginId, name, birthDate, pass, createDate, updateDate);
				userList.add(user);
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
		return userList;
	}

	/**
	 * ログインIDをもとに該当ユーザーを検索して返す
	 * @param targetId	探したいユーザーのログインID
	 * @return			該当するユーザーのUser型インスタンス
	 */
	public User findById(String targetId) {

		Connection conn = null;

		try {
			//データベースへの接続
			conn = DBManager.getConnection();

			//SELECT文を準備
			String sql = "SELECT * FROM user WHERE login_id = ?";

			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, targetId);
			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {

			//結果表に格納されたレコードの内容を取り出し、Userインスタンスに追加
				int id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				String birthDate = rs.getString("birth_date");
				String pass = rs.getString("password");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");

				User user = new User(id, loginId, name, birthDate, pass, createDate, updateDate);
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

	/**
	 * データベースに新規ユーザを登録
	 * @param loginId
	 * @param name
	 * @param birthDate
	 * @param password
	 * @param createDate	※登録日時
	 * @param updateDate	※更新日時
	 */
	public void createUser(String loginId, String name, String birthDate, String password, String createDate, String updateDate) {

		Connection conn = null;

		try {
			//データベースへ接続
			conn = DBManager.getConnection();

			//INSERT文を用意
			String sql = "INSERT INTO user(login_id, name, birth_date, password, create_date, update_date) "
						 + "VALUES(?, ?, ?, ?, ?, ?)";

			//INSERTを実行
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, name);
			pStmt.setString(3, birthDate);
			pStmt.setString(4, password);
			pStmt.setString(5, createDate);
			pStmt.setString(6, updateDate);

			int resultNum = pStmt.executeUpdate();

			//追加された行数を出力
			System.out.println(resultNum);

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//データベース切断
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 該当ユーザの情報を更新
	 * @param loginId
	 * @param name
	 * @param birthDate
	 * @param password
	 * @param updateDate
	 */
	public void updateById(String loginId, String name, String birthDate, String password, String updateDate) {

		Connection conn = null;

		try {
			//データベースへ接続
			conn = DBManager.getConnection();

			//UPDATE文を用意
			String sql = "UPDATE user SET name = ?, birth_date = ?, password = ?, update_date = ? WHERE login_id = ?";

			//UPDATEを実行
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);
			pStmt.setString(2, birthDate);
			pStmt.setString(3, password);
			pStmt.setString(4, updateDate);
			pStmt.setString(5, loginId);

			int resultNum = pStmt.executeUpdate();

			//追加された行数を出力
			System.out.println(resultNum);

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//データベース切断
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * ログインIDをもとに該当ユーザをデータベースから削除
	 * @param loginId	削除したいユーザーのログインID
	 */
	public void deleteUser(String loginId) {

		Connection conn = null;

		try {
			//データベースへ接続
			conn = DBManager.getConnection();

			//DELETE文を用意
			String sql = "DELETE FROM user WHERE login_id=?";

			//DELETEを実行
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);

			int resultNum = pStmt.executeUpdate();

			//追加された行数を出力
			System.out.println(resultNum);

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//データベース切断
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * ユーザを検索する(引数に渡された値が空でないもののみ検索する)
	 * @param loginId
	 * @param userName
	 * @param birthdayFrom
	 * @param birthdayTo
	 * @return
	 * @throws SQLException
	 */
	public List<User> searchUser(String loginId, String userName, String birthdayFrom, String birthdayTo) {

		Connection conn = null;
		ArrayList<User> userList = new ArrayList<User>();

		try {

			conn = DBManager.getConnection();

			String sql = "SELECT * FROM user";

			// 各種検索要件を設定してSQLを生成
			List<SearchConditionBeans> conditions = new ArrayList<SearchConditionBeans>();
			conditions.add(new SearchConditionBeans("login_id", loginId, WHERE_TYPE_EQUAL));
			conditions.add(new SearchConditionBeans("name", userName, WHERE_TYPE_LIKE_PARTIAL_MATCH));
			conditions.add(new SearchConditionBeans("birth_date", birthdayFrom, WHERE_TYPE_GENDER_OR_EQUAL));
			conditions.add(new SearchConditionBeans("birth_date", birthdayTo, WHERE_TYPE_LESS_OR_EQUAL));
			sql = addWhereCondition(sql, conditions);

			// IDの降順に表示
			sql += " order by id desc";

			// TODO デバッグ用(納品時に消す)
			System.out.println(sql);

			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();


			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setLoginId(rs.getString("login_id"));
				user.setName(rs.getString("name"));
				user.setBirthDate(rs.getString("birth_date"));
				user.setPass(rs.getString("password"));
				user.setCreateDate(rs.getString("create_date"));
				user.setUpdateDate(rs.getString("update_date"));
				userList.add(user);
			}

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//データベース切断
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return userList;

	}
}
