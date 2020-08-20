<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--시큐리티 라이브러리를 사용하는 태그를 가져옴-->
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- 인증아이디로 로그인되었는지 아닌지 확인해서 로그인이 되면 세션에 저장-->
<sec:authorize access="isAuthenticated()">
	<!-- principal로 아이디 정보를 가져올 수 잇음 -->
	<sec:authentication property="principal"  var="principal"/>
</sec:authorize>

<!DOCTYPE html>
<html lang="en">
<head>
<title>메인 페이지</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-md bg-white navbar-light border-bottom border-light">
		<a class="navbar-brand" href="#"><img src="../image/logo.png" alt="Logo" style="width: 77px;"></a>

		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<c:choose>
				<c:when test="${empty principal }">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="/auth/joinForm">회원가입</a></li>
						<li class="nav-item"><a class="nav-link" href="/auth/loginForm">로그인</a></li>
					</ul>
				</c:when>
				<c:otherwise>
					<ul class="navbar-nav mr-auto">
						<li class="nav-item"><a class="nav-link" href="/api/write">글쓰기</a></li>
						<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">내 정보 </a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="#">내정보 수정</a> <a class="dropdown-item" href="#">내 글 목록</a> <a class="dropdown-item" href="#">즐겨찾기</a>
							</div></li>
					</ul>
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
					</ul>
				</c:otherwise>
			</c:choose>

		</div>
	</nav>
	<br>