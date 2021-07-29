package com.hr.login.model;

import org.hibernate.Session;

public class LoginDao implements ILoginDao {

	private Session session;

	public LoginDao(Session session) {
		this.session = session;
	}

	@Override
	public boolean checkLogin(String empid, String emppwd) {
		if (empid != null && emppwd != null) {
			LoginBean lbID = session.get(LoginBean.class, empid);
			if (lbID != null) {
				String lbPWD = lbID.getEmppwd();
				lbPWD.equalsIgnoreCase(emppwd);
				return lbPWD.equalsIgnoreCase(emppwd);
			} 
		}
		return false;
	}
}
