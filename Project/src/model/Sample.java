package model;

import dao.UserDAO;

public class Sample {
	public static void main(String[] args) {
		UserDAO userDao = new UserDAO();
		User user = userDao.findById("admin", "5F4DCC3B5AA765D61D8327DEB882CF99");

		System.out.println(user.getLoginId());
		System.out.println(user.getPass());
	}
}
