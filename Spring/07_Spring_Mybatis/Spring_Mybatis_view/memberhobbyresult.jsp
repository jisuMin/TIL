<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){

});

</script>
</head>
<body>
<h1>${param.id} 님 ${param.age}살 입니다.</h1> 
<!--@ModelAttribute("dto") =>  ${dto.id} ${dto.age} ${dto.hobby}-->
<h1>취미는
<c:forEach items="${paramValues.hobby}" var="h">
	${h },
</c:forEach>
입니다.</h1>
<h3>${result }</h3> <!-- controller가 보내는 값은 param을 안 붙여야한다-->
</body>
</html>