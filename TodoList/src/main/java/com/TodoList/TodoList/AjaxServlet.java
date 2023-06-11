package com.TodoList.TodoList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TodoList.TodoList.dao.TodoDao;
import com.TodoList.TodoList.dto.Todo;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/ajaxservlet")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjaxServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("id");
		TodoDao dao = TodoDao.getInstance();
		System.out.println(id);
//		update
		dao.updateTodo(Integer.parseInt(id));
		System.out.println("success");
//		json 저장
		
		response.getWriter().write(getJSON(id));

	}
	 public String getJSON(String id) { 
		 if(id == null) id=""; 
		 StringBuffer result = new StringBuffer("");
		 result.append("{\"result\":[");
		 TodoDao todoDao = new TodoDao();
		 TodoDao dao = TodoDao.getInstance();
	     ArrayList<Todo> todolist = dao.getTodos();
		 for(int i = 0; i< todolist.size(); i++) {
			 result.append("{\"Id\": \"" + todolist.get(i).getId() + "\",");
			 result.append("\"Title\": \"" + todolist.get(i).getTitle() + "\",");
			 result.append("\"Name\": \"" + todolist.get(i).getName() + "\",");
			 result.append("\"Sequence\": \"" + todolist.get(i).getSequence() + "\",");
			 result.append("\"Type\": \"" + todolist.get(i).getType() + "\",");
			 result.append("\"Regdate\": \"" + todolist.get(i).getRegdate() + "\"},");
			 if(i == todolist.size()-1) {
				 result.append("{\"Id\": \"" + todolist.get(i).getId() + "\",");
				 result.append("\"Title\": \"" + todolist.get(i).getTitle() + "\",");
				 result.append("\"Name\": \"" + todolist.get(i).getName() + "\",");
				 result.append("\"Sequence\": \"" + todolist.get(i).getSequence() + "\",");
				 result.append("\"Type\": \"" + todolist.get(i).getType() + "\",");
				 result.append("\"Regdate\": \"" + todolist.get(i).getRegdate() + "\"}");
			 }
		 }
		 result.append("]}");
		 return result.toString();
	 }
}
//		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
//		dispatcher.forward(request, response);
//		response.sendRedirect("http://localhost:8080/Todo/main");
//		response.getWriter().write(id);
