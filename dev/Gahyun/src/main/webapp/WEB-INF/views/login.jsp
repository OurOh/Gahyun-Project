<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page session="false" pageEncoding="UTF-8" %>


<main>
	<div class="login-background">
	    <div class="login-image-section">
	        <img src="${pageContext.request.contextPath}/res/images/pool003.jpg" alt="리조트 이미지 1">
	        <div class="login-section">
	            <div class="login-container">
	                <h2>로그인</h2>
	                <form action="./login" method="post">
	                    <input type="text" placeholder="아이디" id="userid" name="username" required>
	                    <input type="password" placeholder="비밀번호" id="password" name="password" required>
	                    <button type="submit" id="loginsubmit">로그인</button> 
	                </form>
	                <button type="button" id="userregister" onclick="location.href='/dev/register'">회원가입</button>
	                <a href="#">아이디/비밀번호 찾기</a>
	            </div>
	        </div>
	    </div>
    </div>  
</main>
<c:if test="${param.error == 'true'}">
    <script>
        alert("로그인에 실패했습니다. 아이디와 비밀번호를 확인하세요.");
    </script>
</c:if>
