package model;

import java.io.Serializable;

public class User implements Serializable {

	//フィールド
	private int id;
	private String loginId;
	private String name;
	private String birthDate;
	private String pass;
	private String createDate;
	private String updateDate;

	//コンストラクタ
	public User() {};


	public User(String loginId, String name, String birthDate, String pass, String createDate, String updateDate) {

		this.loginId = loginId;
		this.name = name;
		this.birthDate = birthDate;
		this.pass = pass;
		this.createDate = createDate;
		this.updateDate = updateDate;

	}

	public User(int id, String loginId, String name, String birthDate, String pass, String createDate, String updateDate) {

		this.id = id;
		this.loginId = loginId;
		this.name = name;
		this.birthDate = birthDate;
		this.pass = pass;
		this.createDate = createDate;
		this.updateDate = updateDate;

	}

	//setter getter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
