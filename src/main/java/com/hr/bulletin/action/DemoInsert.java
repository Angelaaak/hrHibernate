package com.hr.bulletin.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hr.bulletin.model.Bulletin;
import com.hr.bulletin.model.BulletinBeanService;
import com.hr.util.HibernateUtil;

@WebServlet("/DemoInsert.do")
public class DemoInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("demoins");
			response.setContentType("text/html;charset=UTF-8");
			// 取得資料庫物件與建連線
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.getCurrentSession();
			
			// 利用service找DAO做事
			BulletinBeanService bulletinService = new BulletinBeanService(session);
			
			//新增
			Date time = new Date();
			SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");

			Bulletin resultIns = new Bulletin();
			resultIns.setType(request.getParameter("posttype"));
			resultIns.setTitle(request.getParameter("title"));;
			resultIns.setPostDate(sdfDate.format(time).toString());
			resultIns.setExplanation(request.getParameter("explanation"));
			resultIns.setExp(request.getParameter("exp"));
			resultIns.setPostStatus("onpost");
			bulletinService.insert(resultIns);
			
			boolean bresult =false;
			if(resultIns!=null)
				bresult = true;
			request.setAttribute("bresult", bresult);
			try {
				request.getRequestDispatcher("/bulletin/PostSuc.jsp").forward(request, response);
			
			}catch (IOException e) {
				e.printStackTrace();
			}
			catch (ServletException e) {
				e.printStackTrace();
			}
	
	}

}
