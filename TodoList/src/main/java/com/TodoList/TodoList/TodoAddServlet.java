package com.TodoList.TodoList;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Sequence;
import javax.swing.border.TitledBorder;

import com.TodoList.TodoList.dao.TodoDao;
import com.TodoList.TodoList.dto.Todo;
import com.google.protobuf.DescriptorProtos.MethodOptions.IdempotencyLevel;

/**
 * Servlet implementation class TodoAddServlet
 */
@WebServlet("/todoaddservlet")
public class TodoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
//        PrintWriter out = response.getWriter();
        
		
//		addlist = dao.addTodo(todo);
//		String id = request.getParameter("id");
		String name = request.getParameter("name");
//		String regdate = request.getParameter("regdate");
		String sequence = request.getParameter("sequence");
		String title = request.getParameter("title");
//		String type = request.getParameter("type");
		
		TodoDao dao = TodoDao.getInstance();
		dao.insertTodo(title, name, sequence);
		response.sendRedirect("http://localhost:8080/Todo/main");
		
//		request.setAttribute("id", id);
//        todo.setName(name);
//        request.setAttribute("regdate", regdate);
//        todo.setSepuence(sequence);
//        todo.setTitle(title);
//        request.setAttribute("type", type);
//
//        TodoDao todoDao = new TodoDao();
//        todoDao.insertTodo(todo);
//		
//		out.print("<tr><td>" + title + "</td><br><td>" + name + "</td><br><td>" + "</td><br><td>" + sequence
//				+ "</td><br><td>"  + "</td></tr>");
//		addlist.setId(id);
//		todo.setName(name);
//		todo.setRegdate(regdate);
//		todo.setSepuence(sequence);
//		todo.setTitle(title);
//		todo.setType(type);
		
//		response.sendRedirect("main.jsp");
//		RequestDispatcher dispathcher = request.getRequestDispatcher("main.jsp");
//		dispathcher.forward(request, response);
		return;
	}

}
