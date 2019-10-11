<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>springFramework</title>

		<!-- 개인 CSS -->
		<link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet" type="text/css" >
  	<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" type="text/css" >

    <!-- Bootstrap core CSS -->
 		<link href="${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.css" rel="stylesheet">
   
    <!-- Fontawesome -->
		<link href="${pageContext.request.contextPath}/webjars/font-awesome/5.9.0/css/all.css" rel="stylesheet">
		
		<!-- Custom styles for this template -->
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath }/resources/css/blog.css" rel="stylesheet">
    
    <!-- Optional JavaScript -->
	  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
	  <script src="${pageContext.request.contextPath}/webjars/jquery/3.4.1/dist/jquery.js"></script>
	  <script src="${pageContext.request.contextPath}/webjars/popper.js/1.14.7/dist/umd/popper.js"></script>
	  <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/js/bootstrap.js"></script>
    
<script>
		window.onload = function init(){
      var menuTag = document.getElementById('menu_icon');
      //console.log(menuTag);
      menuTag.addEventListener("click", menuOnOff, false); 
      window.addEventListener("resize", mResize, false);
    }
    function menuOnOff(){
      var m_onOff = document.getElementById('main_menu_m');
      if(m_onOff.style.display == 'block'){
        document.getElementById('main_menu_m').style.display = 'none';
      }else{
        document.getElementById('main_menu_m').style.display = 'block';
      }
    }
   function mResize(){
     if(window.innerWidth >= 768){
      document.getElementById('main_menu_m').style.display = 'none';
     }
   }
</script>
    
    
  </head>
  <body>
    <div class="container">
  <header class="blog-header py-3">
    <div class="row flex-nowrap justify-content-between align-items-center">
      <div class="col-3 pt-1">
        <a class="text-muted" href="#"><i class="fas fa-bars fa-2x" id="menu_icon"></i></a>
      </div>
      <div class="col-3 d-flex justify-content-end">
      	<!-- 로그인 전후 -->
      	<c:choose>
      		<c:when test="${empty sessionScope.user }">
        		<a class="btn btn-sm mr-1" href="${pageContext.request.contextPath }/login/login">Login</a>
        		<a class="btn btn-sm" href="${pageContext.request.contextPath }/member/memberJoinForm">SignUp</a>
        	</c:when>
        	<c:otherwise>
		        <div class="btn-group">
		        	<button class="btn btn-sm dropdown-toggle" 
		        					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		        		${sessionScope.user.nickname }님
		        	</button>
		        	<div class="dropdown-menu dropdown-menu-right">
		        		<a href="${pageContext.request.contextPath }/member/memberModifyForm/${sessionScope.user.id}" class="dropdown-item">내정보수정</a>
		        		<a href="${pageContext.request.contextPath }/member/changePwForm" class="dropdown-item">비밀번호 변경</a>
		        		<a href="${pageContext.request.contextPath }/member/memberOutForm" class="dropdown-item">회원탈퇴</a>
		        		<a href="${pageContext.request.contextPath }/login/logout" class="dropdown-item text-danger">Logout</a>
		        		</div>
		        	</div>
        	</c:otherwise>
        </c:choose>
       </div>
        
      </div>
      <div class="row flex-nowrap justify-content-center">
      	<a class="blog-header-logo text-dark" href="${pageContext.request.contextPath}">
        	<img src="${pageContext.request.contextPath}/resources/img/logo.png" id="logo_img" href="${pageContext.request.contextPath}" alt="home_Logo" />
        </a>
      </div>
  </header>

    <!-- 모바일 -->
  <nav id="main_menu_m">
      <ul>
        <li id="m_m"><a class="text-decoration-none" href="${pageContext.request.contextPath }">Home</a></li>
        <li id="m_m">
          <a class="text-decoration-none" href="#">Flo.We</a>
          <ul>
            <li><a class="text-decoration-none" href="#">Fla.We 소개</a></li>
            <li><a class="text-decoration-none" href="#">오시는 길</a></li>
          </ul>
        </li>
        <li id="m_m">
          <a class="text-decoration-none" href="#">Natural Flower</a>
          <ul>
              <li><a class="text-decoration-none" href="#">화분</a></li>
              <li><a class="text-decoration-none" href="#">바구니</a></li>
              <li><a class="text-decoration-none" href="#">꽃다발</a></li>
          </ul>
        </li>
        <li id="m_m">
          <a class="text-decoration-none" href="#">Dry Flower</a>
          <ul>
              <li><a class="text-decoration-none" href="#">플라워리스</a></li>
              <li><a class="text-decoration-none" href="#">꽃다발</a></li>
              <li><a class="text-decoration-none" href="#">하바리움</a></li>
          </ul>
        </li>
        <li id="m_m">
          <a class="text-decoration-none" href="#">Pressed flower</a>
          <ul>
              <li><a class="text-decoration-none" href="#">책갈피</a></li>
              <li><a class="text-decoration-none" href="#">액세서리</a></li>
          </ul>
        </li>
        <li id="m_m" class="none">
          <a class="text-decoration-none" href="#">Community</a>
          <ul>
              <li><a class="text-decoration-none" href="${pageContext.request.contextPath }/bbs/list">상품문의</a></li>
              <li><a class="text-decoration-none" href="#">자주하는 질문</a></li>
              <li><a class="text-decoration-none" href="#">공지사항</a></li>
          </ul>
        </li>
      </ul>
    </nav>
    <!--------------------->
     
    <!-- 태블릿 / PC -->
    <div class="main_nav_wrap">
    <nav id="main_menu">
      <ul>
        <li><a class="text-decoration-none" href="${pageContext.request.contextPath }">Home</a></li>
        <li>
          <a class="text-decoration-none" href="#">Flo.We</a>
          <ul>
            <li><a class="text-decoration-none" href="#">Fla.We 소개</a></li>
            <li><a class="text-decoration-none" href="#">오시는 길</a></li>
          </ul>
        </li>
        <li>
          <a class="text-decoration-none" href="#">Natural Flower</a>
          <ul>
            <li><a class="text-decoration-none" href="#">화&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;분</a></li>
            <li><a class="text-decoration-none" href="#">바 구 니</a></li>
            <li><a class="text-decoration-none" href="#">꽃 다 발</a></li>
          </ul>
        </li>
        <li>
          <a class="text-decoration-none" href="#">Dry Flower</a>
          <ul>
            <li><a class="text-decoration-none" href="#">플라워리스</a></li>
            <li><a class="text-decoration-none" href="#">꽃 다 발</a></li>
            <li><a class="text-decoration-none" href="#">하바리움</a></li>
          </ul>
        </li>
        <li>
          <a class="text-decoration-none" href="#">Pressed flower</a>
          <ul>
            <li><a class="text-decoration-none" href="#">책&nbsp; 갈 &nbsp;피</a></li>
            <li><a class="text-decoration-none" href="#">액세서리</a></li>
          </ul>
        </li>
        <li>
          <a class="text-decoration-none" href="${pageContext.request.contextPath }/bbs/list">Community</a>
          <ul>
            <li><a class="text-decoration-none" href="${pageContext.request.contextPath }/bbs/list">상품문의</a></li>
            <li><a class="text-decoration-none" href="#">자주하는 질문</a></li>
            <li><a class="text-decoration-none" href="#">공지사항</a></li>
          </ul>
        </li>
      </ul>
    </nav>
    </div>
</div>