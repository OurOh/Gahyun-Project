<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.gahyun.dev.model.UserDto" %>  <!-- UserDto 임포트 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<main class="main-content">
    <section class="image-section">
        <div class="image-slider">
            <img src="${pageContext.request.contextPath}/res/images/pool003.jpg" alt="리조트 이미지 1" class="active">
            <img src="${pageContext.request.contextPath}/res/images/outside001.jpg" alt="리조트 이미지 1">
            <img src="${pageContext.request.contextPath}/res/images/yoga003.jpg" alt="리조트 이미지 3">
        </div>
    </section>

    <section class="login-section">
        <div class="login-container">
            <% 
                UserDto user = (UserDto) session.getAttribute("user");
                if (user != null) { 
                	 %>
                     <!-- 로그인 성공 시 이미지 표시 -->
                     <h2>환영합니다, <%= user.getName() %>님!</h2>
                     <img src="${pageContext.request.contextPath}/res/images/your_image.jpg" alt="로그인 후 이미지"> <!-- 원하는 이미지-->
                     <a href="${pageContext.request.contextPath}/logout">로그아웃</a>
                 <% 
                 
                } else { 
            %>
                <!-- 로그인되지 않은 상태 -->
                <h2>로그인</h2>
                <form action="${pageContext.request.contextPath}/login" method="post">
                    <input type="text" name="userid" placeholder="아이디">
                    <input type="password" name="password" placeholder="비밀번호">
                    <button type="submit" id="loginsubmit">로그인</button>
                    <button type="button" id="userregister">회원가입</button>
                    <a href="#">아이디/비밀번호 찾기</a>
                </form>
            <% 
                } 
            %>
        </div>
    </section>
</main>
</body>
</html>
