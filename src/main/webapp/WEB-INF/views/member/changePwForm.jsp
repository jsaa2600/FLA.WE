<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<jsp:include page="../header.jsp" />
<style>
	form {
		width:580px;
	}
	.errMsg{
		color : #f00;
		font-weight: bold;
		font-size : 0.8em;
	}
</style>

<script>
	$(function(){
 		//확인버튼 클릭시
		$("#okBtn").on("click",function(e){
			//해당요소의 기본 이벤트 막기
			e.preventDefault();
			if($("#fromPW").val().length == 0) {
				$("#error_1").text('현재 비밀번호를 입력하세요!');
				$("#fromPW").focus();
				return false;
			};
			
			if($("#toPW").val().length == 0) {
				$("#error_2").text('새 비밀번호를 입력하세요!');
				$("#toPW").focus();
				return false;
			};
			
			if($("#toPWChk").val().length == 0) {
				$("#error_3").text('새 비밀번호 확인을 입력하세요!');
				$("#toPWChk").focus();
				return false;
			};
			
			if($("#toPW").val() != $("#toPWChk").val() ) {
				$("#error_3").text('새비밀번호와 비밀번호 확인이 일치하지 않습니다.');
				$("#toPWChk").focus();
				return false;				
			}
			
			if($("#fromPW").val() == $("#toPW").val() ) {
				$("#error_3").text('현재비밀번호와 새비밀번호가 동일합니다.');
				$("#toPW").focus();
				return false;				
			}			
			$("#passwdDTO").submit();			
		}); 
 		//취소버튼 클릭시
 		$("#cancelBtn").on("click",function(e){
			//해당요소의 기본 이벤트 막기
			e.preventDefault();
			$("#passwdDTO").each(function(){
				this.reset();
			})
 		});
 		
	});
</script>

<div class="container">
	<div class="row justify-content-center">
		<form:form modelAttribute="passwdDTO" 
							 action="${pageContext.request.contextPath }/member/changePw"
							 method="post">
		<form:hidden path="id" value="${sessionScope.user.id}"/>					 
		<div class="form-row mx-2">
			<div class="col-12 form-group my-4">
				<h3 class="text-center">비밀번호 변경</h3>
			</div>
		</div>
		<div class="form-row mx-2">
			<div class="col-12 form-group my-0">
				<form:password class="form-control" path="fromPW" placeholder="현재 비밀번호"></form:password>
			</div>
			<div class="col-12 form-group">
				<form:errors path="fromPW" class="errMsg"></form:errors>
				<span id="error_1" class="errMsg"></span>
			</div>
			
			<div class="col-12 form-group my-0">
				<form:password class="form-control" path="toPW" placeholder="새 비밀번호"></form:password>
			</div>
			<div class="col-12 form-group" >
				<form:errors  path="toPW" class="errMsg"></form:errors>
				<span id="error_2" class="errMsg"></span>			
			</div>
			
			<div class="col-12 form-group my-0">
				<input class="form-control" type="password" id="toPWChk" placeholder="새 비밀번호 확인"/>
			</div>
			<div class="col-12 form-group" >
				<span id="error_3" class="errMsg"></span>		
			</div>
			
			<div class="col-6 form-group">
				<button class="btn btn-md btn-success btn-block" id="okBtn">확인</button>
			</div>
			<div class="col-6 form-group">
				<button class="btn btn-md btn-outline-dark btn-block" id="cancelBtn">취소</button>
			</div>
		</div>
		</form:form>
	</div>
</div>
<jsp:include page="../footer.jsp" />