package model;

import java.io.Serializable;

public class User implements Serializable {

	//フィールド
	private String loginId;
	private String name;
	private String birthDate;
	private String pass;
	private String createDate;
	private String updateDate;

	//コンストラクタ
	public User() {};

	public User(String loginId) {
		this.loginId = loginId;
	}

	public User(String loginId, String name, String pass) {
		this.loginId = loginId;
		this.name = name;
		this.pass = pass;
	}

	public User(String loginId, String name, String birthDate, String pass, String createDate, String updateDate) {

		this.loginId = loginId;
		this.name = name;
		this.birthDate = birthDate;
		this.pass = pass;
		this.createDate = createDate;
		this.updateDate = updateDate;

	}

	//setter getter
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

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}


}
