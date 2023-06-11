package com.TodoList.TodoList.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

//import javax.management.relation.Role;
//
//import org.eclipse.sisu.Description;

import com.TodoList.TodoList.dto.Todo;

public class TodoDao {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";
	public static TodoDao dao = new TodoDao();
	
//	instance
	public static TodoDao getInstance() {
		if(dao == null) {
			dao = new TodoDao();
		}
		return dao;
	}
	//insert
	
	public void insertTodo(String title, String name, String sequence) {
		int insertcount = 0;
		Connection conn = null;
		PreparedStatement ps = null;
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sql = "INSERT INTO todo (title, name, sequence) VALUES (?, ?, ?)"; // insert
			
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, title);
			ps.setString(2, name);
			ps.setString(3, sequence);
			System.out.println(title);
			System.out.println(name);
			System.out.println(sequence);
			System.out.println(sql);
//			ps.setString(3, todo.getRegdate());
//			ps.setString(1, todo.getId());
//			ps.setString(6, todo.getType());
			insertcount = ps.executeUpdate();
			System.out.println("리스트 업데이트 완료");
			
			
			//실행문
			//insert delete update는 executeUpdate() 메서드를 사용 
			//select문은 executeQuery()라는 메서드를 사용한다. 
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}

	//selectall
	public ArrayList<Todo> getTodos(){
		ArrayList<Todo> todolist = new ArrayList<Todo>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
//		String sql = "SELECT description, role_id FROM role order by role_id desc";
		String sql = "SELECT * from todo";
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			
			try (ResultSet rs = ps.executeQuery()){
				
				while(rs.next()) {
					Todo todo = new Todo();
					
					
//					long id = Integer.parseInt(rs.getString("id"));
//					String name = rs.getString("name");
//					d regdate = rs.getString("regdate");
//					String sequence = rs.getString("sequence");
//					String title = rs.getString("title");
//					String type = rs.getString("type");
//					System.out.println("집어넣기 전 : " + todo);
					todo.setId(rs.getInt(1));
					todo.setTitle(rs.getString(2));
					todo.setName(rs.getString(3));
					todo.setSequence(rs.getString(4));
					todo.setType(rs.getString(5));
					todo.setRegdate(rs.getDate(6));
					
//					System.out.println("집어넣은 후 : " + todo);
					todolist.add(todo);
		
					
//					String description = rs.getString(1);
//					int id = rs.getInt("role_id");
//					Todo todo = new Todo(id,  description);
//					list.add(todo);
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return todolist;
	}
	
//	delete
	public void TodoDelete(long id) {
		int deleteCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName( "com.mysql.cj.jdbc.Driver" );
			conn = DriverManager.getConnection ( dburl, dbUser, dbpasswd );
			String sql = "DELETE FROM todo WHERE id = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setLong(1,  id);

			deleteCount = ps.executeUpdate();
			System.out.println("delete success");
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(Exception ex) {}
			} // if
			
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception ex) {}
			} // if
		} // finally
		return;
	}
	
	
	
	
	
	
	//update
	
	public void updateTodo(long id) {
		int updateCount = 0;
		
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName( "com.mysql.cj.jdbc.Driver" );
			
			conn = DriverManager.getConnection ( dburl, dbUser, dbpasswd );
			
			String sql = "UPDATE todo SET type='DOING' WHERE id = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setLong(1, id);
			
			updateCount = ps.executeUpdate();
			System.out.println("update Doing success");
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(Exception ex) {}
			} // if
			
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception ex) {}
			} // if
		} // finally
		return;
	}
	
	public void DONE(long id) {
		int updateCount = 0;
		
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName( "com.mysql.cj.jdbc.Driver" );
			
			conn = DriverManager.getConnection ( dburl, dbUser, dbpasswd );
			
			String sql = "UPDATE todo SET type='DONE' WHERE id = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setLong(1, id);
			updateCount = ps.executeUpdate();
			System.out.println("update Done success");

		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(Exception ex) {}
			} // if
			
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception ex) {}
			} // if
		} // finally
		return;
	}
	
	public void doneTotodo(long id) {
		int updateCount = 0;
		
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName( "com.mysql.cj.jdbc.Driver" );
			
			conn = DriverManager.getConnection ( dburl, dbUser, dbpasswd );
			
			String sql = "UPDATE todo SET type='TODO' WHERE id = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setLong(1, id);
			updateCount = ps.executeUpdate();
			System.out.println("Done to todo success");

		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(Exception ex) {}
			} // if
			
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception ex) {}
			} // if
		} // finally
		return;
	}
//	
//
//	//delete
//	public int deleteTodo(Integer roleId) {
//		int deleteCount = 0;
//		
//		Connection conn = null;
//		PreparedStatement ps = null;
//			
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			
//			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
//			
//			String sql = "DELETE FROM role WHERE role_id = ?"; // delete
//			
//			ps = conn.prepareStatement(sql);
//			
//			ps.setInt(1, roleId);
//			
//			deleteCount = ps.executeUpdate();
//			
//			//실행문
//			//insert delete update는 executeUpdate() 메서드를 사용 
//			//select문은 executeQuery()라는 메서드를 사용한다. 
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}finally {
//			if(ps != null) {
//				try {
//					ps.close();
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//			
//			if(conn != null) {
//				try {
//					conn.close();
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//			}
//		}
//	}
//			return deleteCount;
//	}
//		
//	public Todo getTodo(Integer roleId) {
//		Todo todo = null;
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		
//		
//		//예외 처리 부분
//		//연결 했던 부분들을 닫아내는게 중요함 그런 부분들을 해주는 부분
//		try {
//			Class.forName( "com.mysql.cj.jdbc.Driver");
//			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd); //connection 객체 얻어오는 Class
//			String sql = "SELECT role_id, description FROM role WHERE role_id = ?"; //쿼리문 넣어줘야함 
//			ps = conn.prepareStatement(sql);//쿼리문 넣어줘야함
//			ps.setInt(1, roleId); //prepareStatement의 set 메서드 이용 쿼리문 1번째 파라미터는 ? 의 순서,
//								  //1번째 물음표에 roldId 를 넣어주세요 라는 뜻
//			
//			rs = ps.executeQuery();
//			if(rs.next()) { // 결과 값이 있으면 첫번째 레코드로 커서를 이동하고 true를 리턴하라는 메서드 
//				String description = rs.getString(1);//값 꺼내오기
//				int id = rs.getInt("role_id");
//				
//				todo = new Todo(id,  description);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally { //닫는 코드
//			if(rs != null) { //안전하게 예외 상황에 조건을 걸어둠 
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if(ps != null) { //안전하게 예외 상황에 조건을 걸어둠 
//				try {
//					ps.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if(conn != null) { //안전하게 예외 상황에 조건을 걸어둠 
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		
//		return todo;
//	}
}
