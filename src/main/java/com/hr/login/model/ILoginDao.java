package com.hr.login.model;

public interface ILoginDao {
	public boolean checkLogin(String empid, String emppwd);
}
