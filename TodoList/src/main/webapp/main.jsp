<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TodoList</title>
<link rel="stylesheet" href="./designtodolist.css"></link>
</head>
<body>
    <div class="wrap">
        <header>
            <button class="regbuttoon" onclick="location.href='./todoformservlet'">새로운 할일 등록</button>
        </header>
        <section class="container">
            <div id="type" class="type">
                <div id="TODO" class="TODO">
                    <div class="box">
                        TODO
                    </div>
                    
	                   		
			                <c:forEach var="todo" items="${todolist }" varStatus="status">
			   					
			   					<c:if test="${todo.type == 'TODO' }">
				                   	<div id="todoCard" class="${todo.id }">
					                    <div class="card">
					                        <div class="title">
					                            <p class="inner">${todo.title }</p>
					                        </div>
					                        <div class="date">
					                            <p>등록 날짜: <a id="date">${todo.regdate }</a>,<a id="name">이름 : ${todo.name }</a>, <a id="sequence">우선순위 : ${todo.sequence }</a></p>
						                        <form action="./todoupdate" method="post">
				                                    <input type="hidden" name="id" value="${todo.id}">
				                                    <input class="movebutton" id="submit" type="submit" value="->">
				                                </form>
												<form action= "./tododelete" method="post">
													<input type="hidden" name="id" value="${todo.id}"/>
													<input class="deletebutton" type="submit" value="x"/>
												</form>
												
					                    	</div>
					                    </div>
				               		</div>
			                    </c:if>
			                </c:forEach>
                </div>
                
                <div id="DOING" class="DOING">  
                    <div class="box">
                        DOING
                    </div>
                    
   				<c:forEach var="todo" items="${todolist }" varStatus="status">
   					
   					<c:if test="${todo.type == 'DOING' }">
	                    <div class="card">
	                        <div class="title">
	                            <p class="inner">${todo.title }</p>
	                        </div>
	                        <div class="date">
	                            <p class="item">등록 날짜: <a id="date">${todo.regdate }</a>,<a id="name">이름 : ${todo.name }</a>, <a id="sequence">우선순위 : ${todo.sequence }</a></p>
		                        <form action="./doneservlet" method="post">
                                    <input type="hidden" name="id" value="${todo.id}"/>
                                    <input class="movebutton" type="submit" value="->"/>
                                </form>
								<form action= "./tododelete" method="post">
									<input type="hidden" name="id" value="${todo.id}"/>
									<input class="deletebutton" type="submit" value="x"/>
								</form>
								
	                    	</div>
	                    </div>
                    </c:if>
                </c:forEach>
                </div>
                
                <div id="DONE" class="DONE">
                    <div class="box">
                    DONE
                    </div>
                    
                <c:forEach var="todo" items="${todolist }" varStatus="status">
   					
   					<c:if test="${todo.type == 'DONE' }">
	                    <div class="card">
	                        <div class="title">
	                            <p class="inner">${todo.title }</p>
	                        </div>
	                        <div class="date">
	                            <p>등록 날짜: <a id="date">${todo.regdate }</a>,<a id="name">이름 : ${todo.name }</a>, <a id="sequence">우선순위 : ${todo.sequence }</a></p>
		                        <form action="./donetodoingservlet" method="post">
                                    <input type="hidden" name="id" value="${todo.id}"/>
                                    <input class="movebutton" type="submit" value="->"/>
                                </form>
		                       		
								<form action= "./tododelete" method="post">
									<input type="hidden" name="id" value="${todo.id}"/>
									<input class="deletebutton" type="submit" value="x"/>
								</form>
								
	                    	</div>
	                    </div>
                    </c:if>
                </c:forEach>
                </div>
            </div>
        
        </section>
    </div>
    
</body>
</html>