<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    

<%@ page session="false" pageEncoding="UTF-8" %>


<main>
	<div class="login-background">
	    <div class="login-image-section">
	        <img src="${pageContext.request.contextPath}/res/images/pool003.jpg" alt="리조트 이미지 1">
	        <div class="login-section">
	            <div class="login-container">
	                <h2>로그인</h2>
	                <form action="${pageContext.request.contextPath}/login" method="post">
	                    <input type="text" placeholder="아이디" id="userid" name="userid" required>
	                    <input type="password" placeholder="비밀번호" id="password" name="password" required>
	                    <button type="submit" id="loginsubmit">로그인</button>
	                    <button type="button" id="userregister">회원가입</button>
	                    <a href="#">아이디/비밀번호 찾기</a>
	                </form>
	            </div>
	        </div>
	    </div>
    </div>  
</main>
