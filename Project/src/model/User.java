package model;

import java.io.Serializable;

public class User implements Serializable {

	//フィールド
	private String loginId;
	private String pass;

	//コンストラクタ
	public User() {};

	public User(String loginId, String pass) {
		this.loginId = loginId;
		this.pass = pass;
	}

	//getter setter
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
