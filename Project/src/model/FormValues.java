package model;

import java.io.Serializable;

public class FormValues implements Serializable {

	//フィールド
	private String loginId;
	private String name;
	private String birthDate;
	private String pass;

	//コンストラクタ
	public FormValues() {};

	public FormValues(String loginId) {

		this.loginId = loginId;
	}

	public FormValues(String loginId, String name, String birthDate) {

		this.loginId = loginId;
		this.name = name;
		this.birthDate = birthDate;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
