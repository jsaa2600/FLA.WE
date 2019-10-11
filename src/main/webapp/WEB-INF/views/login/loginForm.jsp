<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../header.jsp"/>
<style>
	.errMsg {
		color : #f00;
		font-size: 0.8rem;
	}
	.custom-f{
		font-size: 0.8rem;
		font-weight: bold;
	}
	
	@media screen and (min-width:320px){
		form { width:100%; }
	}
	@media screen and (min-width:768px){
		form { width:480px; }
	}

</style>
<script>
	window.addEventListener("load",init,false);
	function init() {
		let loginBtn = document.getElementById("loginBtn");
		loginBtn.addEventListener("click",loginBtnf,false);
	}
	function loginBtnf() {
		//유효성 체크
		//1) 아이디
		let idTag = document.getElementById("id");
		if(idTag.value.length == 0) {
			idTag.nextElementSibling.innerText = "아이디를 입력하세요!";
			return false;
		}
		
		//2) 비밀번호
		let pwTag = document.getElementById("pw");		
		if(pwTag.value.length == 0) {
			pwTag.nextElementSibling.innerText = "비밀번호를 입력하세요!";
			return false;
		}
		
		//양식을 서버에 전송
		document.getElementById("frm").submit();
	}

</script>


	<div class="container">
		<div class="row justify-content-center">
			<form class="form-signin" id="frm" action="${pageContext.request.contextPath }/login/loginOk" method="post">
				<p class="h3 text-center mb-3">로 그 인</p>
	
				<div class="form-row">	
					<div class="col-sm-12 mt-3 mb-3">
						<label for="inputEmail">아이디</label>
						<input type="email" id="id" name="id" class="form-control"
							placeholder="Email address" required autofocus>
						<b class="errMsg"></b>	 
					</div>
				</div>
	
				<div class="form-row">	
					<div class="col-sm-12 mb-3">
						<label for="inputPassword">비밀번호</label>
						<input type="password" id="pw" name="pw" class="form-control"
							placeholder="Password" required> 
						<b class="errMsg"></b>							
					</div>
				</div>
	
				<div class="checkbox mb-3">
					<label> <input type="checkbox" value="remember-me">
						로그인 상태 유지
					</label>
				</div>
				<button class="btn btn-lg btn-info btn-block" id="loginBtn" type="submit">로 그 인</button>
				<div class="row justify-content-center my-3 custom-f">
					<div class="col col-md-4 text-center">
						<a href="#" class="text-decoration-none text-muted ">아이디찾기</a>
					</div>
					<div class="col col-md-4 text-center">
						<a href="#" class="text-decoration-none text-muted">비밀번호확인</a>
					</div>
					<div class="col col-md-4 text-center">
						<a href="${pageContext.request.contextPath }/member/memberJoinForm" class="text-decoration-none text-muted">회원가입</a>
					</div>				
				</div>
			</form>	
			</div>	
		</div>
	<!-- /container -->

	
<jsp:include page="../footer.jsp"/>