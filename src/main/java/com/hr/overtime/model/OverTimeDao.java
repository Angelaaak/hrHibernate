package com.hr.overtime.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class OverTimeDao {

	private Session session;

	public OverTimeDao(Session session) {
		this.session = session;
	}

	public void save(OverTimePending overTime) {
		session.save(overTime);
	}

	public List<OverTimePending> selectByResult() { // 管理員查詢待審核

		Query<OverTimePending> query = session.createQuery("from OverTimePending where result = 'pending' ",
				OverTimePending.class);

		List<OverTimePending> overTimeList = query.list();

		return overTimeList;
	}

	public OverTimePending selectById(int id) { // 管理員審核 抓到當下那筆

		Query<OverTimePending> query = session.createQuery("FROM OverTimePending where id = :id ",
				OverTimePending.class);

		query.setParameter("id", id);

		OverTimePending overTime = query.uniqueResult();

		return overTime;
	}

	public void deletePendingData(OverTimePending overTimePending) { // 管理員批准刪除

		if (overTimePending != null) {
			session.delete(overTimePending);
		}

	}

	public void inserAuditted(OverTimeAuditted overTimeAuditted) { // 將刪除資料新增進auditted資料表

		if (overTimeAuditted != null) {
			session.save(overTimeAuditted);
		}
	}


	public List<OverTimePending> selectbyEmpnoPending(String empNo) { // 取得某個員工查詢自己

		Query<OverTimePending> query = session.createQuery("from OverTimePending where empNo = :mmm",
				OverTimePending.class);

		query.setParameter("mmm", empNo);

		List<OverTimePending> overTimeList = query.list();

		return overTimeList;
	}

	public List<OverTimeAuditted> selectbyEmpnoAuditted(String empNo) { // 取得某個員工查詢自己

		Query<OverTimeAuditted> query = session.createQuery("from OverTimeAuditted where empNo = :mmm",
				OverTimeAuditted.class);

		query.setParameter("mmm", empNo);

		List<OverTimeAuditted> overTimeList = query.list();

		return overTimeList;
	}

}
