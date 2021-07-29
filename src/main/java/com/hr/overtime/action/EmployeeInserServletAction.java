package com.hr.overtime.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hr.overtime.model.OverTimeService;
import com.hr.util.HibernateUtil;

@WebServlet("/EmployeeInserServletAction.do")
public class EmployeeInserServletAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		HttpSession httpSession = request.getSession(true);
		String empNo = (String)httpSession.getAttribute("empNo");
		empNo = "123";
		
		OverTimeService overTimeService = new OverTimeService(session);
		
		overTimeService.saveOverTime(request);
		
		
		
		request.getRequestDispatcher("/EmployeeQueryServletAction.do").forward(request, response);
		
//		String Result = request.getParameter("result");
		//從網頁拿到輸入資料

		//將資料存入資料庫

	}

	

}
