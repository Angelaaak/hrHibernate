package com.hr.login.model;

import org.hibernate.Session;


public class LoginService implements ILoginService {
	
	private ILoginDao lDao;
	
	public LoginService(Session session) {
		lDao=new LoginDao(session);
	}

	@Override
	public boolean checkLogin(String epmid, String emppwd) {
		return lDao.checkLogin(epmid, emppwd);
	}

}
