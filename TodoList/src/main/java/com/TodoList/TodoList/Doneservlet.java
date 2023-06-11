package com.TodoList.TodoList;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TodoList.TodoList.dao.TodoDao;

/**
 * Servlet implementation class Doneservlet
 */
@WebServlet("/doneservlet")
public class Doneservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Doneservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		
		TodoDao dao = TodoDao.getInstance();
		dao.DONE(Integer.parseInt(id));
		System.out.println(id);
	
		response.sendRedirect("http://localhost:8080/Todo/main");
	}

}
