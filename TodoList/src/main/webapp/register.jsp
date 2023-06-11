<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="./main">
    <table>
        <tr>
            <td>어떤일인가요?</td>
            <td><input type="text" name="title" size="50"></td>
        </tr>
        <tr>
            <td>누가 할일인가요?</td>
            <td><input type="text" name="name" size="20"></td>
        </tr>
        <tr>
            <td>우선순위를 선택하세요</td>
            <td>
                <input type="radio" name="sequence" value="1">1순위
                <input type="radio" name="sequence" value="2">2순위
                <input type="radio" name="sequence" value="3">3순위
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="등록">
            </td>
        </tr>
    
    </table>
</form>
</body>
</html>