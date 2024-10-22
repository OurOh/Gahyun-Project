<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    

<%@ page session="false" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
    <main class="login-content">
        <section class="login-image-section">
            <div class="login-image-slider">
                    <img src="${pageContext.request.contextPath}/res/images/pool003.jpg" alt="리조트 이미지 1" class="active">
                    <img src="${pageContext.request.contextPath}/res/images/outside001.jpg" alt="리조트 이미지 1">
                    <img src="${pageContext.request.contextPath}/res/images/yoga003.jpg" alt="리조트 이미지 3">
                </div>
            </section>

            <section class="login-section">
                <div class="login-container">
                    <h2>로그인</h2>
                    <form action="${pageContext.request.contextPath}/login" method="post">
					    <div>
					        <label for="userid">아이디:</label>
					        <input type="text" id="userid" name="userid" required>
					    </div>
					    <div>
					        <label for="password">비밀번호:</label>
					        <input type="password" id="password" name="password" required>
					    </div>
					    <div>
					        <button type="submit">로그인</button>
					    </div>
					</form>

                </div>
            </section>
        </main>
</body>
</html>