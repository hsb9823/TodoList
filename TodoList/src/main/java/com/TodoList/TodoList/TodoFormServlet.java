package com.TodoList.TodoList;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TodoList.TodoList.dao.TodoDao;
import com.TodoList.TodoList.dto.Todo;

/**
 * Servlet implementation class TodoFormServlet
 */
@WebServlet("/todoformservlet")
public class TodoFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
 
//        TodoDao dao = new TodoDao();
//        ArrayList<Todo> todoList = dao.getTodos();
//        
//        for(int i = 0; i < todoList.size(); i++) {
//           
//            Todo todo = (Todo)todoList.get(i);
//            String id = todo.getId();
//            String name = todo.getName();
//            String regdate = todo.getRegdate();
//            String sequence = todo.getSepuence();
//            String title = todo.getTitle();
//            String type = todo.getType();
//            // 한 행씩 출력
//            
//        request.setAttribute("id", id);sasad
//        request.setAttribute("name", name);
//        request.setAttribute("regdate", regdate);
//        request.setAttribute("sequence", sequence);
//        request.setAttribute("title", title);
//        request.setAttribute("type", type);

        
        response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("todoForm.jsp");
		dispatcher.forward(request, response);
		return;
        }
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method 
		doGet(request, response);
	}

}
