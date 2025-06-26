<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>주소록 수정</title>
	</head>
	<body>
		<h1>주소록</h1>
	
		<h2>전화번호 수정폼</h2>
		<p>전화번호를 수정하는 폼 입니다.</p>
		
		<form action="${pageContext.request.contextPath}/modify"  method="get">
			<label>이름(name)</label>
			<input type="text" name="name" value="${requestScope.pVO.name}">
			<br>
		
			<label>핸드폰(hp)</label>
			<input type="text" name="hp" value="${pVO.hp}">
			<br>
	
			<label>회사(company)</label>
			<input type="text" name="company" value="${pVO.company}">
			<br>
			
			<input type="hidden" name="no" value="${param.personId}">
			<br>
			
			<button>수정</button>
		</form>
	</body>
</html>