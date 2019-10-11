<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<script>
/*  window.addEventListener("load",init,false);
 function init() {
	 let joinBtn = document.getElementById("joinBtn");
	 joinBtn.addEventListener("click", joinBtnf, false );
	 
	 function joinBtnf() {
		 //alert('클릭!');
		 //유효성체크
		 if(validationChk()) {
		 	document.getElementById("joinFrm").submit();
		 }
	 }
	 
	 function validationChk() {		 
		 if(document.getElementById("id").value.trim().length == 0) {
			 document.getElementById("id").focus();
			 return false;
		 }
		 if(document.getElementById("nickname").value.trim().length == 0) {
			 document.getElementById("nickname").focus();
			 return false;
		 }
		 if(document.getElementById("age").value.trim().length == 0) {
			 document.getElementById("age").focus();
			 return false;
		 }		 
		 return true;
	 }
 }
 */
</script>
</head>
<body>
<form:form id="joinFrm" action="${pageContext.request.contextPath }/test/memberJoin" method="post">
	아이디 : <input type="text" id="id" name="id" value="${memberDTO.id}" /> <br>
	별 칭  : <input type="text" id="nickname" name="nickname" value="${memberDTO.nickname}" /> <br>
	나 이  : <input type="text" id="age" name="age" value="${memberDTO.age}" /><br>
	<button type="button" id="joinBtn">가입하기</button>
</form:form>
</body>
</html>







