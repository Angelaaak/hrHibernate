package com.hr.login.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp")
public class LoginBean {
	
	@Id @Column(name = "empno")
	private String empid;
	@Column(name = "password")
	private String emppwd;

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getEmppwd() {
		return emppwd;
	}

	public void setEmppwd(String emppwd) {
		this.emppwd = emppwd;
	}

}
