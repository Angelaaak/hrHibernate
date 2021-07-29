package com.hr.overtime.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hr.overtime.model.OverTimePending;
import com.hr.overtime.model.OverTimeService;
import com.hr.util.HibernateUtil;

@WebServlet("/ManagerUpdateServletAction.do")
public class ManagerUpdateServletAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		HttpSession httpSession = request.getSession(true);
		String empNo = (String)httpSession.getAttribute("empNo");
		empNo = "123";
		String id = request.getParameter("ID");
		String type = request.getParameter("type");
		
		System.out.println("id = " + id);
		
		OverTimeService overTimeService = new OverTimeService(session);
		//管理員審核
		overTimeService.approve(Integer.parseInt(id),type);
		
		
		request.getRequestDispatcher("/ManagerQueryServletAction.do").forward(request, response);
		
		
		
		
		
		

		
	}

}
