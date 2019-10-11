<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<jsp:include page="../header.jsp" />
<style>
	form {
		width:580px;
	}
</style>
<script>

(function(){
	window.addEventListener("load", init, false);
	function init() {
		let idTag 			= document.getElementById("id");
		let telTag 			= document.getElementById("tel");
		let regionTag 	= document.getElementById("region");
		let genderTag 	= document.getElementsByName("gender");
		let nicknameTag = document.getElementById("nickname");
		let modiBtn     = document.getElementById("modiBtn");

		idTag.addEventListener("blur"				,checkId,false);		
		idTag.addEventListener("change"			,checkId,false);
		idTag.addEventListener("keydown"		,checkId,false);		
		
		telTag.addEventListener("blur"			,checkTel,false);
		telTag.addEventListener("change"		,checkTel,false);
		telTag.addEventListener("keydown"		,checkTel,false);
		
		regionTag.addEventListener("blur"		,checkRegion,false);
		regionTag.addEventListener("change"	,checkRegion,false);
		regionTag.addEventListener("keydown",checkRegion,false);
		
		Array.from(genderTag).forEach(function(item) {
			item.addEventListener("blur"	,checkGender,false);
			item.addEventListener("change",checkGender,false);
		});
		
		nicknameTag.addEventListener("blur"		,checkNickname,false);
		nicknameTag.addEventListener("change"	,checkNickname,false);
		nicknameTag.addEventListener("keydown",checkNickname,false);
		
		modiBtn.addEventListener("click",modiBtnf,false);
				
		function validFeedback(obj, result, msg) {
			//console.log(obj.id);
			if(result){
				if(!obj.classList.contains("is-valid")) {
					obj.classList.add("is-valid");
					obj.classList.remove("is-invalid")
					obj.nextElementSibling.innerHTML = msg;
					if(!obj.classList.contains("valid-feedback")) {
						obj.nextElementSibling.classList.add("valid-feedback");
						obj.nextElementSibling.classList.remove("invalid-feedback");
					}
				}				

			}else{
				if(!obj.classList.contains("is-invalid")) {
					obj.classList.add("is-invalid");
					obj.classList.remove("is-valid")
					obj.nextElementSibling.innerHTML = msg;
					if(!obj.classList.contains("invalid-feedback")) {
						obj.nextElementSibling.classList.add("invalid-feedback");
						obj.nextElementSibling.classList.remove("valid-feedback");
					}
				}
				if(obj.id != "pwchk") {
					obj.focus();
				}
			}
		}
		
		//이메일 주소 체크   
		function checkId() {
			let emailReg = /^((?!\.)[\w-_.]*[^.])(@\w+)(\.\w+(\.\w+)?[^.\W])$/;
			let status = emailReg.test(idTag.value);
			let msg = "";
			if(status) {
				validFeedback(idTag,status,"유효성 통과");
			}else{
				validFeedback(idTag,status,"이메일 정보가 잘못되었습니다.");
			}
			return status;
		}
		
		//전화번호 체크
		function checkTel() {
			let phoneReg = /(\d{3}).*(\d{3}).*(\d{4})/;
			let status = phoneReg.test(telTag.value);
			let msg = "";
			if(phoneReg.test(telTag.value)) {
				validFeedback(telTag,status,"유효성 통과");
			}else {
				validFeedback(telTag,status,"전화번호가 잘못되었습니다!");
			}
			return status;
		}
		
		//지역 체크
		function checkRegion() {
		  let regionText = regionTag.options[regionTag.selectedIndex].text;
		  let regionValue = regionTag.options[regionTag.selectedIndex].value;
		  
      let status = regionValue != 0 ? true : false;
      if(status) {
    	  validFeedback(regionTag,status,"유효성 통과");
      }else{
    	  validFeedback(regionTag,status,"지역을 선택하세요!");
      }	
      return status;
		}
		
		//성별 체크
		function checkGender() {
			let status = false;
			Array.from(genderTag).forEach(function(item){
				if(item.checked) {
					status = true;
				}
			});
      if(status) {
    	  validFeedback(genderTag[0].parentElement.parentElement,status,"유효성 통과");
      }else{
    	  validFeedback(genderTag[0].parentElement.parentElement,status,"성별 선택하세요!");
      }		

      return status;
		}
		
		//별칭 체크
		function checkNickname() {
      let status = nicknameTag.value.trim().length != 0;
      //console.log(nicknameTag.value, status);
      if(status) {
    	  validFeedback(nicknameTag,status,"유효성 통과");
      }else{
    	  validFeedback(nicknameTag,status,"별칭을 입력하세요!");
      }			
      return status;
		}
		
		//수정하기 버튼 클릭시
		function modiBtnf(e) {	
			e.preventDefault();
			
			let result = checkId() && checkTel() && 
									 checkRegion() && checkGender() && checkNickname();
			if(result) {
      	document.getElementById("modiFrm").submit();
			}			
		}		
	}	
})();

</script>    
    <div class="container my-5" > 
    	<div class="row justify-content-center mx-2">
      <form id='modiFrm' action="${pageContext.request.contextPath }/member/memberModify" method="post">
      <input type="hidden" name="pw" value="${memberDTO.pw }" />
        <p class="h3 text-center">[ 회 원 수 정 ]</p>     
        <div class="form-row">
          <div class="col-sm-12 ">
            <label for="id" class="col-form-label-sm my-0 py-1">아이디</label>
            <input type="email" class="form-control form-control-sm" id="id" name="id" 
            	placeholder="ex)test@test.com" readonly value="${memberDTO.id }"/>
            <div class=""></div>
          </div>
        </div> 
        <div class="form-row">
          <div class="col-sm-12 mb-1">
            <label for="tel" class="col-form-label-sm my-0 py-1">전화번호</label>
            <input type="text" class="form-control form-control-sm " id="tel" name="tel" 
            	placeholder="'-'를 빼고 입력하세요" required value="${memberDTO.tel }"/>
            <div class=""></div>
          </div>
        </div> 
        <div class="form-row">
          <div class="col-sm-12 mb-1">
            <label for="region" class="col-form-label-sm my-0 py-1">지역</label>
            <select id="region" name="region" class="form-control form-control-sm ">
              <option value="0" >== 선 택 ==</option>
              <option value="서울" 
              	<c:if test="${memberDTO.region eq '서울'}">selected</c:if>>서 울</option>
              <option value="경기" 
              	<c:if test="${memberDTO.region eq '경기'}">selected</c:if>>경 기</option>
              <option value="대구" 
              	<c:if test="${memberDTO.region eq '대구'}">selected</c:if>>대 구</option>
              <option value="울산" 
              	<c:if test="${memberDTO.region eq '울산'}">selected</c:if>>울 산</option>
              <option value="기타" 
              	<c:if test="${memberDTO.region eq '기타'}">selected</c:if>>기 타</option>
            </select>          
            <div class=""></div>
                      
          </div>
        </div>
        
        <div class="form-row">
          <div class="col-sm-12 mb-1">
            <label for="gender" class="col-form-label-sm my-0 py-1 mr-3">성별</label>
            <div class="form-control form-control-sm ">
              <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" id="men" name="gender" value="남"
                	<c:if test="${memberDTO.gender eq '남' }">checked</c:if>
                />
                <label class="form-check-label" for="men">남자</label>
              </div>
              <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" id="women" name="gender" value="여"
                	<c:if test="${memberDTO.gender eq '여' }">checked</c:if>
                />
                <label class="form-check-label" for="women">여자</label>
              </div> 
            </div>       
            <div class=""></div>
          </div>
        </div>
        
        <div class="form-row">
          <div class="col-sm-12 mb-4">
            <label for="nickname" class="col-form-label-sm my-0 py-1">별칭</label>
            <input type="text" class="form-control form-control-sm " id="nickname" name="nickname" 
            	placeholder="10자리이하" required value="${memberDTO.nickname }"/>
            <div class=""></div>
          </div>
        </div> 
        <div class="form-row">
        	<div class="col-sm-12">
          <button class="btn btn-danger btn-block" type="submit" id="modiBtn">수정하기</button>
        	</div>
        </div>
      </form>    
      </div> 
    	</div>
<jsp:include page="../footer.jsp" />