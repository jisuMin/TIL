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

<h1>입력하신 아이디는 ${requestScope.loginresult.id }이고 암호는 ${requestScope.loginresult.password } 입니다.</h1>
</body>
</html>