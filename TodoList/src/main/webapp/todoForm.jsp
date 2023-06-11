<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>할 일 등록</title>
<link rel="stylesheet" href="./register.css"></link>

</head>
<body>
<div class="wrap">
	
	
	
	
<form name="todoaddservlet" method="post" action="./todoaddservlet">
    <div class="wrap">
            <header>
                할일 등록
            </header>

            <div class="inputTitle">
                <p>할일 작성</p>
                <input type="text" name="title" size="24">
            </div>

            <div class="inputName">
                <p>이름</p>
                <input type="text" name="name" size="24">
            </div>
            
            <div class="inputSequence">
                <p>우선순위</p>
                <input type="radio" name="sequence" value='1'>1순위
                <input type="radio" name="sequence" value='2'>2순위
                <input type="radio" name="sequence" value='3'>3순위
            </div>

            <div class="buttonWrap">
                
                <div class="leftButtons">
                    <input class="backButton" type="submit" onclick="history.back()" value="이전"></input>
                </div>

                <div class="rightButtons">
                    <input class="registerButton" type="submit" value="등록">
                    <input class="resetButton" type="reset" onclick="reset()" value="초기화"></input>
                </div>
                
                
            </div>
        </div>
</form>
</body>
</html>