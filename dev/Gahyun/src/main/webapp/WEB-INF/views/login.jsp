<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
                    <h2>로그인</h2>
                    <form>
                        <input type="text" placeholder="아이디">
                        <input type="password" placeholder="비밀번호">
                        <button type="submit" id="loginsubmit">로그인</button>
                        <button type="button" id="userregister">회원가입</button>
                        <a href="#">아이디/비밀번호 찾기</a>
                    </form>
                </div>
            </section>
        </main>
</body>
</html>