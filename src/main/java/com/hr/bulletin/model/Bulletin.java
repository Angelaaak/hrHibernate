package com.hr.bulletin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bulletin")
public class Bulletin {

	@Column(name = "type")
	private String type;

	@Column(name = "title")
	private String title;

	@Column(name = "postdate")
	private String postDate;

	@Column(name = "explanation")
	private String explanation;
	
	@Column(name = "exp")
	private String exp;
	
	@Id @Column(name = "postno")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postno;

	@Column(name = "poststatus")
	private String postStatus;
	


	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public int getPostno() {
		return postno;
	}

	public void setPostno(int postno) {
		this.postno = postno;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getPostStatus() {
		return postStatus;
	}

	public void setPostStatus(String postStatus) {
		this.postStatus = postStatus;
	}

}
