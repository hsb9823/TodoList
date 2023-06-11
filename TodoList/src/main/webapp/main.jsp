<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TodoList</title>
<link rel="stylesheet" href="./designtodolist.css"></link>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
    var request = new XMLHttpRequest();
	function ajax() {
		  request.open("POST", "./ajaxservlet?id=" + encodeURIComponent(document.getElementById("todoId").value, true));
		  request.onreadystatechange = changeCard;
		  request.send();
	}
	/* var myJSONObject = {"bindings": [
		{"ircEvent": "PRIVMSG", "method": "newURI", "regex": "^http://.*"},
	    {"ircEvent": "PRIVMSG", "method" : "deleteURI", "regex": "^delete.*},
	    {"ircEvent": "PRIVMSG", "method" : "randomURI", "regex": "^random.*}
	   ]
	 }; */
 	function searchType() {
			printjson.innerHTML = "ajax success";
			if(request.readyState == 4 && request.status == 200){
				var jsonObject = request.responseText;
				var o = JSON.parse(jsonObject);
				console.log(o.result.length);
				console.log(typeof(o.result[0].Type));
				console.log("ajax", document.getElementById("todoId").value);
				console.log("id: ", o.result[0].Id);
				for(var i = 0; i< o.result.length; i++){
					if(o.result[i].Id == document.getElementById("todoId").value){
						//console.log("if", document.getElementById("todoCard").value);
						//console.log("if", o.result[i].Type);
						//document.getElementById("todoCard").innerHTML = 'change';
						var type = o.result[i].Type;
						console.log("type", type);
				
						var ele = document.querySelector(type);
						var ele2 = document.querySelector("#DOING");
						ele2.appendChild(ele);
						console.log("change");
						
					}
				}
			}
		}
	 
	
	
	function changeCard(){
		/* var id = document.getElementById("todoId").value;  
		console.log(id);
		var card = document.getElementsByClassName(id).id;
 		console.log(card); */
		
 	
 		/* var _this = this;
		const updateBtns = document.querySelectorAll("#todoCard");
		updateBtns.forEach(function(item){
			window.location.reload(true);
			item.addEventListener('click', addCard()); */
		
		}
		
	 	
	 	
	 	/* var id = document.getElementById("todoId").value;
	 	var classname = document.getElementById("setclass").value;
	 	
 		console.log("todoId's value : ", document.getElementById("todoId").value);
 		console.log(classname);
 		document.querySelector("#todocard") */
 		/* var classname = document.getElementById("todocard").className;
 		console.log(document.getElementById("todocard"));
 		console.log("className: ", classname); */
 		
 		
	 	function addCard(){
	 		/* var id = document.getElementById("todoId").value;
	 		console.log(document.getElementsByClassName(id).todocard);
	 		var card = document.getElementsByClassName(id).todocard; */
	 		
	 		var card = document.getElementById("todoCard");
	 		card.remove();
	 		
	 		/* if(document.getElementById("todocard").className == document.getElementById("todoId").value){
	 			
	 			
	 			console.log("move");
	 		} */
 			/* document.getElementById('todocard').remove();
 			document.getElementByClassName().innerHTML= */
	 		/* document.querySelector("#DOING").appendChild(document.querySelector("#todocard")); */

 		}
		
	
</script>
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