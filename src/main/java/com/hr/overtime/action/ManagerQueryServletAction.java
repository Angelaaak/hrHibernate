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

@WebServlet("/ManagerQueryServletAction.do")
public class ManagerQueryServletAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		HttpSession httpSession = request.getSession(true);
		String empNo = (String)httpSession.getAttribute("empNo");
		empNo = "123";
		
		OverTimeService overTimeService = new OverTimeService(session);
		

		List<OverTimePending> overTimeList = overTimeService.queryManagerData();
		
		
		request.setAttribute("overTimeList", overTimeList);
		
		//轉導jsp
		request.getRequestDispatcher("OverTime/ManagerInterface.jsp").forward(request, response);
		
//		OverTime dBean = session.get(OverTime.class, 20);
//		
//		if(dBean!=null) {
//			out.write(dBean.getEmpNo() + ":" + dBean.getEmpName() + "<br/>");
//		}else {
//			out.write("no result");
//		}
		
		out.close();
	}

}
