package com.hr.overtime.model;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

public class OverTimeService {

	private OverTimeDao overTimeDao;

	public OverTimeService(Session session) {
		overTimeDao = new OverTimeDao(session);
	}
//員工功能
	public void saveOverTime(HttpServletRequest request) { //將畫面資料取得存入資料庫

		// logic 邏輯
		// HttpSession parasession = request.getSession(true);
		String Type = "submit";
		String EmpNo = "123";
		// String EmpNo = (String) parasession.getAttribute("empno");
		String DateOfApplication = request.getParameter("Date of Application");
		String EmpName = request.getParameter("EmpName");
		String Department = request.getParameter("department");
		String Position = request.getParameter("position");
		String OvertimeCategory = request.getParameter("Overtime category");
		String OvertimeDate = request.getParameter("OvertimeDate");
		String StartingTime = request.getParameter("Starting time");
		String EndingTime = request.getParameter("Ending time");
		double hours = getOverTimeHours(StartingTime, EndingTime);
		String Reason = request.getParameter("reason");
		String Remarks = request.getParameter("Remarks");

		//convert to bean
		OverTimePending overtime = new OverTimePending();
		overtime.setType(Type);
		overtime.setEmpNo(EmpNo);
		overtime.setDateOfApplication(getDate(DateOfApplication));
		overtime.setEmpName(EmpName);
		overtime.setDepartment(Department);
		overtime.setPosition(Position);
		overtime.setOvertimeCategory(OvertimeCategory);
		overtime.setOverTimeDate(getDate(OvertimeDate));
		overtime.setStartingTime(StartingTime);
		overtime.setEndingTime(EndingTime);
		overtime.setOverTimeHours(Double.toString(hours));
		overtime.setReason(Reason);
		overtime.setRemarks(Remarks);
		overtime.setResult("pending");
		
		// dao save bean
		overTimeDao.save(overtime);

	}

	private double getOverTimeHours(String startTime, String endTime) {

		double diffHours = 0;
		double diffHours1 = 0;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

			Date startDate = sdf.parse(startTime);
			Date endDate = sdf.parse(endTime);

			long diff = endDate.getTime() - startDate.getTime();
			diffHours = diff / (60 * 60.0 * 1000) % 24;
			BigDecimal b = new BigDecimal(diffHours);
			diffHours1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return diffHours1;

	}
	//員工查詢自己
	public  List<OverTimePending> EmpoyeeQueryPending(String empNo) {
		  
		List<OverTimePending> overTimePending = overTimeDao.selectbyEmpnoPending(empNo);
		
		return overTimePending;
	}
	public  List<OverTimeAuditted> EmpoyeeQueryAuditted(String empNo) {
		
		List<OverTimeAuditted> overTimeAuditted = overTimeDao.selectbyEmpnoAuditted(empNo);
		
		return overTimeAuditted;
	}
	
	
	
	
	//-------------------------------------------------------------------------------------------------
	//管理員功能
	//管理員查詢全部資料
	public List<OverTimePending> queryManagerData() { 
		List<OverTimePending> overTimeList = overTimeDao.selectByResult();
		
		return overTimeList;
	}
//管理員批准新增後刪除
	public void approve(int id,String type) {
		
		//1. 查  => dao 呼叫    ===> pending Bean OverTimePending 
		
		OverTimePending overTimePending = overTimeDao.selectById(id);
		
		//2.insert 新增資料到auditing => dao 呼叫
		OverTimeAuditted overTimeAuditted = new OverTimeAuditted();
		overTimeAuditted.setId(overTimePending.getId());
		overTimeAuditted.setType(overTimePending.getType());
		overTimeAuditted.setDateOfApplication(overTimePending.getDateOfApplication());
		overTimeAuditted.setEmpNo(overTimePending.getEmpNo());
		overTimeAuditted.setEmpName(overTimePending.getEmpName());
		overTimeAuditted.setDepartment(overTimePending.getDepartment());
		overTimeAuditted.setPosition(overTimePending.getPosition());
		overTimeAuditted.setOvertimeCategory(overTimePending.getOvertimeCategory());
		overTimeAuditted.setOverTimeDate(overTimePending.getOverTimeDate());
		overTimeAuditted.setStartingTime(overTimePending.getStartingTime());
		overTimeAuditted.setEndingTime(overTimePending.getEndingTime());
		overTimeAuditted.setOverTimeHours(overTimePending.getOverTimeHours());
		overTimeAuditted.setReason(overTimePending.getReason());
		overTimeAuditted.setRemarks(overTimePending.getRemarks());
		overTimeAuditted.setResult(type);
		
		overTimeDao.inserAuditted(overTimeAuditted);
		
		//3.把pending 刪掉  => dao 呼叫
		overTimeDao.deletePendingData(overTimePending);
	}
	
	private Date getDate(String dateString) {

		//yyyy-MM-dd
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
		
	}
	
}
