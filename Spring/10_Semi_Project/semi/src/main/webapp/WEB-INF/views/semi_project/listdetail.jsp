<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
  
#comment {
	text-align: center;
}

body{
	text-align: center;
}



</style>
<script src="resources/js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
	$("#deletebtn").on('click',function(){
		if("${sessionID}" == "${detail.product_member}") {
			$(location).attr('href','productdelete?seq=${detail.product_seq}');
		}
		else {
			alert("자신의 글만 삭제가 가능합니다.");
		}
	});
	
	$("#cmsubmit").on('click',function(e){
		if("${sessionID}" == null || "${sessionID}" == "" || typeof "${sessionID}" == "undefinded") {
			e.preventDefault();
			alert("댓글을 등록하려면 로그인을 하시오");
		}
	});
	
	$("#updatebtn").on('click',function(){
		if("${sessionID}" == "${detail.product_member}") {
			$(location).attr('href','productupdate?seq=${detail.product_seq}');
		}
		else {
			alert("자신의 글만 수정 가능합니다");
		}
	});
	
	$("#tomain").on('click',function(){
		if("${sessionID}" == null || "${sessionID}" == "" || typeof "${sessionID}" == "undefinded") {
			$(location).attr('href','MainMenu2');
		}
		else {
			$(location).attr('href','MainMenu');
		}
	});
	
	if("${sessionID}" == "${detail.product_member}") {
		$("#editform").show();
	}
	else if ("${sessionID}" == null || "${sessionID}" == "" || typeof "${sessionID}" == "undefinded") {
		$("#editform").hide();
	}
	
	$("#pullupbtn").on('click',function(){
		$(location).attr('href','pulluptime?seq=${detail.product_seq}');
	});
	
	
});

</script>
</head>
<body>

<div class="w3-content w3-container w3-margin-top">
<div class="w3-container w3-card-4">


<h1>제품 상세</h1>
<table >
<tr><td>제품: ${detail.product_category} / ${detail.product_name}</td></tr>
<tr><td colspan="2">가격: <fmt:formatNumber value="${detail.product_price}" pattern="###,###"/> 원</td></tr> 
<tr><td>판매자: ${detail.product_member}</td></tr> 
<tr><td colspan="2"><img src="resources/images/${detail.product_image}" width="400" height="400"></td></tr> 
<tr><td colspan="2">${detail.product_info}</td></tr> 
<tr><td colspan="2">${detail.product_time}</td></tr> 
</table>
<br>

<form id="editform">
<input type=button id="updatebtn" value="수정" class="w3-button w3-orange" >
<input type=button id="pullupbtn" value="끌어올리기" class="w3-button w3-orange">
<input type=button id="deletebtn" value="삭제" class="w3-button  w3-orange"><br><br>
</form>
<input type=button value="메인메뉴" id="tomain" class="w3-button  w3-orange"><hr>
 <div id="comment">
 
<h3>댓글</h3>
<form action="listdetail" method="post">
<input type="hidden" name="productnum" value="${detail.product_seq}">
<input type="hidden" name="seq" value="${detail.product_seq}">
<input type="hidden" name="writer" value="<%=session.getAttribute("sessionID") %>">
<textarea rows="1" cols="50" name="content" ></textarea><br>
<input type="submit" value="댓글 등록" id="cmsubmit" class="w3-button  w3-orange">
<input type="reset" value="초기화" class="w3-button  w3-orange">
<br><br>
</form>
<c:forEach items="${comment }" var="comment">
		${comment.writer}님 : ${comment.content} -${comment.ctime }<br>
</c:forEach>
</div>
</div>
</div>
</body>
</html>