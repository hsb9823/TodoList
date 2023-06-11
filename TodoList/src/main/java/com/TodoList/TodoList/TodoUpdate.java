package com.TodoList.TodoList;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TodoList.TodoList.dao.TodoDao;

/**
 * Servlet implementation class TodoUpdate
 */
@WebServlet("/todoupdate")
public class TodoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		
		TodoDao dao = TodoDao.getInstance();
		System.out.println(id);
		dao.updateTodo(Integer.parseInt(id));
		response.getWriter().write(id);
		response.sendRedirect("http://localhost:8080/Todo/main");
	}

}
