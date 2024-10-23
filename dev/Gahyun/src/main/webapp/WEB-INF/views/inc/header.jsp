<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    

<%@ page session="false" pageEncoding="UTF-8" %>

   <header>
        <a href="#" id="reserv_make"><button type="button" class="reserv_make btn">예약하기</button></a>
        <a href="/dev/"><img class="logo-small allign-center" src="${pageContext.request.contextPath}/res/images/logo1.jpg" /></a>
        <a href="/dev/login" id="user_login" class="user_login">로그인</a>
        <a href="#" id="reserv_view" class="reserv_view">예약확인</a>
    </header>
    <div class="main-nav">
        <div class="navbar">
          <div class="navbar-menu"><a href="/dev/resort">리조트소개</a></div>
          <div class="navbar-menu"><a href="/dev/facilites">시설소개</a></div>
          <div class="navbar-menu"><a href="/dev/room">객실</a></div>
          <div class="navbar-menu"><a href="#">공지사항</a></div>
        </div>
        <div class="nav-menu">
            <div class="nav-col">
                <a href="/dev/resort">리조트소개</a>
                <a href="/dev/resort">오시는길</a>
            </div>
            <div class="nav-col">
                <a href="/dev/facilites">다이닝</a>
                <a href="/dev/facilites">편의시설</a>
                <a href="/dev/facilites">ENJOY</a>
            </div>
            <div class="nav-col">
                <a href="/dev/room">타입A(2인실)</a>
                <a href="/dev/room">타입B(4인실, 침대O)</a>
                <a href="/dev/room">타입B(4인실, 침대X)</a>
            </div>
            <div class="nav-col">
                <a href="/dev/event">이벤트</a>
                <a href="#">문의사항</a>
                <a href="#">고객센터</a>
            </div>
        </div>
      </div>
      <div class="ham">
        <div></div>
        <div></div>
        <div></div>
    </div>
    <div class="ham-nav">
        <a href="/dev/login" id="ham-user-login" class="ham-user-login">로그인</a>
        <a href="/dev/mypage" id="ham-reserv-view" class="ham-reserv-view">예약확인</a>
        <div class="ham-nav-col">
            <p>리조트소개</p>
            <a href="/dev/resort">리조트소개</a>
            <a href="/dev/resort">오시는길</a>
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
            <p>공지사항</p>
            <a href="/dev/event">이벤트</a>
            <a href="#">문의사항</a>
            <a href="#">고객센터</a>
        </div>
    </div>
    <script>
    $(function(){
        $(".main-nav").hover(function(){
            $(".nav-col").stop().slideToggle(300);
        });
        $(".ham").click(function(){
            $(".ham-nav").stop().slideToggle(300);
        })
    }); //jquery
    </script>

</html>