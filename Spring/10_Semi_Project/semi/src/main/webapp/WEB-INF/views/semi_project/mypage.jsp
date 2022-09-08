<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

<style type="text/css">

 table {
    width: 40%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
    margin:auto;
  }
  th, td {
    border-bottom: 1px solid #444444;
    padding: 10px;
  }
 </style>
 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Insert title here</title>
<script src="resources/js/jquery-3.6.0.min.js" ></script>
<script>
$(document).ready(function(){

});
</script>
</head>
<body>

<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4">
			<div class="w3-center w3-large w3-margin-top">
<table border="2" id="table1">
<tr><td><h1>${sessionID}님 환영합니다</h1></td></tr>

<tr><td>
<table id="table2" style=" width:900px; height: 100px; margin: auto; text-align: center;">
		<c:forEach items="${mylist}" var="dto" varStatus="status">
		
		<tr >
		<td rowspan="3"><img src="resources/images/${dto.product_image}" width="150" height="150"></td>
		<td colspan="2"><a href="listdetail?seq=${dto.product_seq}">${dto.product_title}</a></td>
		</tr>
		
		
		
		<tr>
		<td>판매자: ${dto.product_member}님</td>
		<td>			
		<fmt:parseDate var="parseRegDate" value="${dto.product_time}" pattern="yyyy-MM-dd"/>
		<fmt:formatDate var="resultRegDt" value="${parseRegDate}" pattern="yyyy-MM-dd"/>
		${resultRegDt}</td>
		</tr>
		
		
		
		<tr>
		<td colspan="2">가격: <fmt:formatNumber value="${dto.product_price}" pattern="###,###"/></td>
		</tr>
		
		</c:forEach>
		

	</table>
</td></tr>

</table>
  <a   class="w3-button w3-block w3-orange w3-ripple w3-margin-top w3-round" href="MainMenu">메인메뉴</a>
  <a   class="w3-button w3-block w3-orange w3-ripple w3-margin-top w3-margin-bottom w3-round" href="logout">로그아웃</a>

	</div>
		</div>
	</div>


</body>
</html>