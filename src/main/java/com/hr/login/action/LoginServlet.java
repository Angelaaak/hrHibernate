package com.hr.login.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hr.login.model.ILoginService;
import com.hr.login.model.LoginService;
import com.hr.util.HibernateUtil;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/login/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		processAction(request, response);		
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charst=UTF-8");	
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
//		session.beginTransaction();		
		
		String rEmpid=request.getParameter("account");
		String rEmppwd=request.getParameter("pwd");			
		
		ILoginService loginDo=new LoginService(session);		
		boolean result=loginDo.checkLogin(rEmpid, rEmppwd);
		try {
			if(loginDo.checkLogin(rEmpid, rEmppwd)) {
				request.setAttribute("empid", rEmpid);
				request.getRequestDispatcher("/DemoQuery.do").forward(request, response);
				System.out.println(result);
			}else {
				request.getRequestDispatcher("/login/loginerror.jsp").forward(request, response);
				System.out.println(result);
			}
		}catch(Exception e){		
			e.printStackTrace();
		}
	}

}
