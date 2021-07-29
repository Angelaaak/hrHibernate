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

@WebServlet("/DemoQueryOne.do")
public class DemoQueryOne extends HttpServlet {
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
			
			//查詢單筆
			int postnoQ = Integer.parseInt(request.getParameter("postno"));		
			Bulletin resultBeanQ = bulletinService.selectById(postnoQ);
        		request.setAttribute("resultBeanQ", resultBeanQ);
        	try {
    			request.getRequestDispatcher("/bulletin/UpdatePost.jsp").forward(request, response);
			}catch (IOException e) {
				e.printStackTrace();
			}
			catch (ServletException e) {
				e.printStackTrace();
			}
	}

}
