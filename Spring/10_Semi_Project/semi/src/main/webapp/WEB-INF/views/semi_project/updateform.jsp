<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Insert title here</title>
<script src="resources/js/jquery-3.6.0.min.js" ></script>
<script>
$(document).ready(function(){
 	
	$("table").css({position:'absolute'}).css({

        left: ($(window).width() - $("table").outerWidth())/2,
        top: ($(window).height() - $("table").outerHeight())/2
    });
	// form에 대한 가운데 정렬
	
	$(window).resize(function(){
  		$("table").css({position:'absolute'}).css({
    		left: ($(window).width() - $("table").outerWidth())/2,
        	top: ($(window).height() - $("table").outerHeight())/2
	    });
	});

});
</script>
</head>
<body>
<form action="productupdate" method=post>

<table border='2'  style="margin-left: auto; margin-right: auto;">
<tr><td style="text-align:center">글 번호</td>
<td><input type=text name="product_seq" value="${update.product_seq}" readonly="readonly" class="w3-input"></td></tr>

<tr><td style="text-align:center">작성자</td>
<td><input type=text value="${update.product_member}" readonly="readonly" class="w3-input"></td></tr>

<tr><td style="text-align:center">제   목</td>
<td><input type=text name="product_title" value="${update.product_title}" class="w3-input"></td></tr>

<tr>
<td>제품명</td>
<td><input type=text name="product_name" value="${update.product_name}" class="w3-input">
<select name="product_category" class="w3-input">
	<option>생활가전</option>
	<option>가구</option>
	<option>의류</option>
	<option>도서</option>
	<option>기타</option>
</select></td></tr>

<tr><td style="text-align:center">내  용</td>
<td><textarea rows="15" cols="45" name="product_info" class="w3-input">${update.product_info}</textarea></td></tr>

<tr><td style="text-align:center">이미지</td>
<td><input type=file name="product_image" id="image"></td></tr>

<tr><td style="text-align:center">가  격</td>
<td><input type=text name="product_price" value="${update.product_price }" class="w3-input"></td></tr>

<tr class="w3-center w3-large w3-margin-top">
<td colspan="2"><input type=submit id="updatebtn" value="게시글 수정" class="w3-button w3-block w3-orange w3-ripple w3-margin-top w3-round">
<a href="MainMenu" style="text-decoration: none"><input type=button value="메인메뉴" class="w3-button w3-block w3-orange w3-ripple w3-margin-top w3-round"></a></td>
</tr>

</table>
</form>
</body>
</html>