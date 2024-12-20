<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>   

<%@ page session="false" pageEncoding="UTF-8" %>

<header>
    <a href="/dev/Reservation1" id="reserv_make"><button type="button" class="reserv_make btn">예약하기</button></a>
    <a href="/dev/"><img class="logo-small allign-center" src="${pageContext.request.contextPath}/res/images/logo1.jpg" /></a>
    <img class="ham-logo-small" src="${pageContext.request.contextPath}/res/images/logo1.jpg" />
    <sec:authorize access="isAuthenticated()">
        <a href="/dev/mypage" id="reserv_view" class="reserv_view">예약확인</a>
        <a href="${pageContext.request.contextPath}/logout" id="user_logout" class="user_logout">로그아웃</a> <!-- 로그아웃 링크 수정 -->
    </sec:authorize>

    <sec:authorize access="isAnonymous()">
        <a href="/dev/login" id="user_login" class="user_login">로그인</a>
    </sec:authorize>
</header>
<div class="main-nav">
    <div class="navbar">
        <div class="navbar-menu"><a href="/dev/resort">리조트소개</a></div>
        <div class="navbar-menu"><a href="/dev/facilites">시설소개</a></div>
        <div class="navbar-menu"><a href="/dev/room">객실</a></div>
        <div class="navbar-menu"><a href="/dev/event">이벤트</a></div>
    </div>
    <div class="nav-menu">
        <div class="nav-col">
        </div>
        <div class="nav-col">
            <a href="/dev/facilites#facilities-dining">다이닝</a>
            <a href="/dev/facilites#facilities-convenient">편의시설</a>
            <a href="/dev/facilites#facilities-game">ENJOY</a>
        </div>
        <div class="nav-col">
            <a href="/dev/room">타입A(2인실)</a>
            <a href="/dev/room">타입B(4인실, 침대O)</a>
            <a href="/dev/room">타입B(4인실, 침대X)</a>
        </div>
        <div class="nav-col">
            <a href="/dev/Customer-center">고객센터</a>
        </div>
    </div>
</div>
<div class="ham">
    <div></div>
    <div></div>
    <div></div>
</div>
<div class="ham-nav">
    <sec:authorize access="isAuthenticated()">
        <a href="/dev/mypage" id="ham-reserv-view" class="ham-reserv-view">예약확인</a>
        <a href="${pageContext.request.contextPath}/logout" id="ham-user-logout" class="ham-user-logout">로그아웃</a> <!-- 로그아웃 링크 수정 -->
    </sec:authorize>

    <sec:authorize access="isAnonymous()">
        <a href="/dev/login" id="ham-user-login" class="ham-user-login">로그인</a>
    </sec:authorize>
    <div class="ham-nav-col">
        <p>리조트소개</p>
        <a href="/dev/resort">리조트소개</a>
    </div>
    <div class="ham-nav-col">
        <p>시설소개</p>
        <a href="/dev/facilites">다이닝</a>
        <a href="/dev/facilites">편의시설</a>
        <a href="/dev/facilites">ENJOY</a>
    </div>
    <div class="ham-nav-col">
        <p>객실</p>
        <a href="/dev/room">타입A(2인실)</a>
        <a href="/dev/room">타입B(4인실, 침대O)</a>
        <a href="/dev/room">타입B(4인실, 침대X)</a>
    </div>
    <div class="ham-nav-col">
        <p>이벤트</p>
        <a href="/dev/event">이벤트</a>
        <a href="/dev/Customer-center">고객센터</a>
    </div>
</div>
<script>
    $(function(){
        // 새로고침 시 초기 상태 설정
        $(".nav-col, .ham-nav").hide();

        $(".main-nav").hover(
            function(){
                $(".nav-col").stop().slideDown(300);
            },
            function(){
                $(".nav-col").stop().slideUp(300);
            }
        );

        $(".ham").click(function(){
            // 현재 상태를 확인하고 토글 방식으로 작동
            if ($(".ham-nav").is(":visible")) {
                $(".ham-nav").stop().slideUp(300);
            } else {
                $(".ham-nav").stop().slideDown(300);
            }
        });
    });

    </script>
