<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style type="text/css">

 table {
    width: 80%;
    height: 80%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
    margin:auto;
  }
  th, td {
    border-bottom: 1px solid #444444;
    padding: 10px;
  }
 </style>
 
<title>Insert title here</title>
<script src="resources/js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function() {

});
</script>
</head>
<body>
<table border="2" width="1000" height="900" id="table1">
<tr>
<td style="text-align:center">
<div class="w3-content w3-container w3-margin-top">
	<form action="search2" id="searchform">
			<select id="category" name="category" class="w3-select">
				<option>생활가전</option>
				<option>가구</option>
				<option>의류</option>
				<option>도서</option>
				<option>기타</option>
			</select>
			<input type=text id="search" width=300px name="search" class="w3-input">
			<input type=hidden name="id" value="${sessionID}">
			<input type=submit id="searchbutton" value="검색" width="50px" class="w3-button w3-block w3-orange w3-ripple w3-margin-top w3-round">	
	</form>
</div>
</td>
<td style="text-align: center" width="100">
	<div class="w3-content w3-container w3-margin-top">
	<h2><a href="login" style="text-decoration: none"><input type=button value="로그인" class="w3-button w3-block w3-orange w3-ripple w3-margin-top w3-round"></a></h2>
	<h2><a href="memberjoinform" style="text-decoration: none"><input type=button value="회원가입" class="w3-button w3-block w3-orange w3-ripple w3-margin-top w3-round"></a></h2>
	</div>
</td>
</tr>
<tr><td colspan="2" height="500" style="text-align:center">
	<div id="list" class="w3-content w3-container w3-margin-top">
		<table id="table2">
			<c:forEach items="${boardlist}" var="dto" varStatus="status">
			<tr>
			<td rowspan="3"><img src="resources/images/${dto.product_image}" width="150" height="150"></td>
			<td colspan="2"><a href="listdetail?seq=${dto.product_seq}" style="text-decoration: none"><input type=button value="${dto.product_title}" class="w3-button w3-block w3-orange w3-ripple w3-margin-top w3-round" ></a></td>
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
	<%request.setAttribute("boardlist", "${boardlist}");%>
	<%
	int totalboard = (Integer)request.getAttribute("totalboard");
	int totalpage = 0;
	if(totalboard % 4 ==0) {
		totalpage = totalboard/4;
	}
	else {
		totalpage = totalboard/4 + 1;
	}
	%>
	
	<%
	for(int i=1; i<= totalpage; i++) { %>
		<a href="MainMenu2?page=+<%=i%>" ><%=i%></a>
	<%}%>
	</div>
</td></tr>
</table>
</body>
</html>