package model;

import dao.UserDAO;
import model.User;

public class Sample {
	public static void main(String[] args) {
		UserDAO userDao = new UserDAO();
		User user = userDao.findById("admin", "password");

		System.out.println(user.getLoginId());
		System.out.println(user.getPass());
	}
}
