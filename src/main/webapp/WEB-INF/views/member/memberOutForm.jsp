<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<jsp:include page="../header.jsp" />
<style>
	form {
		width:580px;
	}
	.errMsg {
		color : #f00;
		font-size: 0.8rem;
	}
	.custom-f{
		font-size: 0.8rem;
		font-weight: bold;
	}

</style>
<script>
	window.addEventListener("load",init,false);
	function init() {
		let memberOutBtn = document.getElementById("memberOutBtn");
		memberOutBtn.addEventListener("click",memberOutBtnf,false);
	}
	function memberOutBtnf(e) {

		let pwTag = document.getElementById("pw");		
		if(pwTag.value.length == 0) {
			pwTag.nextElementSibling.innerText = "비밀번호를 입력하세요!";
			return false;
		}
		
		if(confirm("탈퇴하시겠습니까?")) {
			//양식을 서버에 전송
			document.getElementById("frm").submit();
		}
	}

</script>
</head>
<body>
	<div class="container-fluid ">
		<div class="row justify-content-center" style="margin-top:100px;">
			<form class="form-signin" id="frm" action="${pageContext.request.contextPath }/member/memberOut" method="post">
			<div class="form-row mx-2">
			
				<div class="col-12 text-center mb-4">
					<h1 class="h3 mb-3 font-weight-normal">회원탈퇴</h1>
				</div>
	
				<div class="col-12 form-label-group">
					<label for="inputEmail">아이디</label>
					<input type="email" id="id" name="id" class="form-control"
						readOnly value="${sessionScope.user.id }">
					<b class="errMsg"></b>	 
				</div>
	
				<div class="col-12 form-label-group">
					<label for="inputPassword">비밀번호</label>
					<input type="password" id="pw" name="pw" class="form-control"
						placeholder="Password" required> 
					<b class="errMsg"></b>							
				</div>
				<div class="col-12">
					<button class="btn btn-lg btn-primary btn-block my-5" id="memberOutBtn" type="button">탈퇴합니다</button>
				</div>
			</div>	
			</form>	
		</div>
	</div>
<jsp:include page="../footer.jsp" />