package com.hr.bulletin.model;
import java.util.List;

import org.hibernate.Session;


public class BulletinBeanService implements IBulletinBeanService {

	private BulletinBeanDao bDao;
	
	public BulletinBeanService(Session session) {
		bDao = new BulletinBeanDao(session);
			}

	@Override
	public Bulletin insert(Bulletin bBean) {
				return bDao.insert(bBean);
	}

	@Override
	public Bulletin selectById(int postno) {
				return bDao.selectById(postno);
	}

	@Override
	public List<Bulletin> selectAll() {
				return bDao.selectAll();
	}

	@Override
	public Bulletin update(int postno, String type, String title, String explanation, String exp) {
				return bDao.update(postno, type, title, explanation, exp);
	}

	@Override
	public boolean delete(int postno) {
				return bDao.delete(postno);
	}

}
