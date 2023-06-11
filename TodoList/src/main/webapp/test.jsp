<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

${param.id }







<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">


    var request = new XMLHttpRequest();
	function ajax() {
			  request.open("POST", "./main?id=" + encodeURIComponent(document.getElementById("todoId").value, true));
			  request.send();
			 
			  /*"./ajaxservlet?id=" request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); */
	}
	
	/* function searchProcess() {
		var table = document.getElementById("todoId");
		table.innerHTML="";
		if(request.readyState == 4 && request.status == 200){
			var object = eval('(' + request.reponseText + ')');
			var result = object.result;
		}
	} */
</script>
</body>
</html>