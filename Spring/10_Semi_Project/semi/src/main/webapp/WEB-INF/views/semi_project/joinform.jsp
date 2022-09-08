<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="resources/js/jquery-3.6.0.min.js"></script>
<script>
	$(function(){
		$("#joinForm").submit(function(){
			if($("#password").val() !== $("#password2").val()){
				alert("비밀번호가 다릅니다.");
				$("#password").val("").focus();
				$("#password2").val("");
				return false;
			}if ($("#password").val().length < 2) {
				alert("비밀번호는 2자 이상으로 설정해야 합니다.");
				$("#password").val("").focus();
				return false;
			}else if($.trim($("#password").val()) !== $("#password").val() || $.trim($("#email").val()) !== $("#email").val() || $.trim($("#id").val()) !== $("#id").val()){
				alert("공백은 입력이 불가능합니다.");
				return false;
			}
		})
		
		$("#id").keyup(function() {
			$.ajax({
				url : "/checkid",
				type : "POST",
				data : {
					id : $("#id").val()
				},
				success : function(result) {
					if (result == 1) {
						$("#checkid").html("중복된 아이디가 있습니다.");
						$("#joinBtn").attr("disabled", "disabled");
					} else {
						$("#checkid").html("");
						$("#joinBtn").removeAttr("disabled");
					}
				},
			})
		});
		
		$("#email").keyup(function(){
			$.ajax({
				url : "/checkemail",
				type : "POST",
				data : {
					email : $("#email").val()
				},
				success : function(result) {
					if (result == 1) {
						$("#checkemail").html("중복된 이메일이 있습니다.");
					} else {
						$("#checkemail").html("");
					}
				},
			})
		$("#nickname").keyup(function(){
			$.ajax({
				url : "/checkname",
				type : "POST",
				data : {
					nickname : $("#nickname").val()
				},
				success : function(result) {
					if (result == 1) {
						$("#namecheck").html("중복된 닉네임이 있습니다.");
					} else {
						$("#namecheck").html("");
					}
				},
			})

		});
	})
</script>

<title>회원가입 폼</title>
</head>
<body>
	<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4">
			<div class="w3-center w3-large w3-margin-top">
				<h3>회원 가입</h3>
			</div>
			<div>
				<form id="joinForm" action="joinmember" method="post">
					<p>
						<label>아이디</label> 
						<input class="w3-input" type="text" id="id" name="id" required> 
						<span id="idcheck" class="w3-text-red"></span>
					</p>
					<p>
						<label>이메일</label>
						<input type="text" id="email" name="email" class="w3-input" required>
						<span id="emailcheck" class="w3-text-red"></span>
					</p>
					<p>
						<label>주소</label> 
						<input class="w3-input" id="address" name="address" type="text" required>
					</p>
					<p>
						<label>닉네임</label> 
						<input class="w3-input" id="nickname" name="nickname" type="text" required>
						<span id="namecheck" class="w3-text-red"></span>
					</p>
					<p>
						<label>비밀번호</label> 
						<input class="w3-input" id="password" name="password" type="password" required>
					</p>
					<p>
						<label>비밀번호 확인</label> 
						<input class="w3-input" id="password2" type="password" required>
					</p>
					<p class="w3-center">
						<button type="submit" id="joinBtn" class="w3-button w3-block w3-orange w3-ripple w3-margin-top w3-round">가입</button>
						<button type="button" onclick="history.go(-1);" class="w3-button w3-block w3-orange w3-ripple w3-margin-top w3-margin-bottom w3-round">취소</button>
					</p>
				</form>
			</div>
		</div>
	</div>
</body>
</html>