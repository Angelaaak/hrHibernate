package com.hr.bulletin.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class BulletinBeanDao {
	
	private Session session;
//	建構子
	public BulletinBeanDao(Session session) {
		this.session = session;
	}
	
//	執行新增(不需判斷資料是否重複)
	public Bulletin insert(Bulletin bBean) {
		session.save(bBean);
		return bBean;
	}
//	執行查詢單筆
	public Bulletin selectById(int postno) {
		return session.get(Bulletin.class, postno);
	}
//	執行查詢多筆
	public List<Bulletin> selectAll() {
		Query<Bulletin> query = session.createQuery("from Bulletin order by postno", Bulletin.class);
		return query.list();
	}
//	執行修改
	public Bulletin update(int postno, String type, String title, String explanation, String exp) {
		Bulletin resultBean = session.get(Bulletin.class, postno);
		if(resultBean!=null) {
			resultBean.setType(type);
			resultBean.setTitle(title);
			resultBean.setExplanation(explanation);
			resultBean.setExp(exp);
		}
		return resultBean;
	}
//	執行刪除
	public boolean delete(int postno) {
		Bulletin resultBean = session.get(Bulletin.class, postno);
		
		if(resultBean!=null) {
			session.delete(resultBean);
			return true;
		}
		
		return false;
	}
}
