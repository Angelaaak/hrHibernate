package com.hr.bulletin.model;

import java.util.List;

public interface IBulletinBeanService {
	
	public Bulletin insert(Bulletin bBean);
	public Bulletin selectById(int postno);
	public List<Bulletin> selectAll();
	public Bulletin update(int postno, String type, String title, String explanation, String exp);
	public boolean delete(int postno);

}
