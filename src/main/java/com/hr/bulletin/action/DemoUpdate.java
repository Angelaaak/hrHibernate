package com.hr.bulletin.action;

import java.io.IOException;

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

@WebServlet("/DemoUpdate.do")
public class DemoUpdate extends HttpServlet {
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

			response.setContentType("text/html;charset=UTF-8");
			// 取得資料庫物件與建連線
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.getCurrentSession();

			// 利用service找DAO做事
			BulletinBeanService bulletinService = new BulletinBeanService(session);

			//修改
			int postno = Integer.parseInt(request.getParameter("postno"));
			String type = request.getParameter("posttype");
			String title = request.getParameter("title");
			String explanation = request.getParameter("explanation");
			String exp = request.getParameter("exp");
			System.out.println("==="+exp);
			Bulletin resultBeanUpd = bulletinService.update(postno, type, title, explanation, exp);
			boolean bresult =false;
			if(resultBeanUpd!=null)
				bresult = true;
			System.out.println("====="+exp);
			request.setAttribute("bresult", bresult);
			try {
				request.getRequestDispatcher("/bulletin/Updsuc.jsp").forward(request, response);
			
			}catch (IOException e) {
				e.printStackTrace();
			}
			catch (ServletException e) {
				e.printStackTrace();
			}
	}

}
