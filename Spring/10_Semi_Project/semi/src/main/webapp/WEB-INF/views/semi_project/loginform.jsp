<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>

body {
	text-align: center;
}
</style>
<script src="resources/js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function() {

	
	$("#button").on('click',function(e){
		
		$.ajax({
			url : 'login',
			data : {'id':$("#id").val(), 'password':$("#password").val()},
			type : 'post',
//			dataType : 'text',
			success : function(s) {
				if(s != "fail") { 
					$(location).attr('href','MainMenu');
				}
				else {
					alert("아이디 또는 비밀번호가 옳지 않습니다");
				}
			}
		});
	});
	// 로그인 버튼에 대한 ajax	
	

});
</script>
</head>
<body>
<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4">
			<div class="w3-center w3-large w3-margin-top">
				<h3>중고마켓에 오신 걸 환영합니다!</h3>
			</div>
<form action="login" method="post">
	<hr>
<p>
	<label>아이디</label> 
	<input type=text id="id" name="id" class="w3-input"><br>
</p>
<p> 
	<label>비밀번호</label>
	<input type=password id="password" name="password" class="w3-input"><br>
</p>
<p>
<input type=button value="로그인" id="button"  class="w3-button  w3-orange">
<input type=reset value="취소"  class="w3-button  w3-orange">
<a href="register"><input type=button value="회원가입"  class="w3-button  w3-orange"></a>
<a href="MainMenu2"><input type=button value="검색창"  class="w3-button  w3-orange"></a>
</p>
</form>
</div>
</div>
</body>
</html>