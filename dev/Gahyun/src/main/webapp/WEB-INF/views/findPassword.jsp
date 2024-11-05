<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page session="false" pageEncoding="UTF-8" %>

<main>
    <section class="form-section reset-password-section">
        <h1>비밀번호 재설정</h1>
        <form action="${pageContext.request.contextPath}/resetPassword" method="POST">
            <!-- 아이디 입력 -->
            <label for="userid">아이디</label>
            <input type="text" id="userid" name="userid" placeholder="아이디를 입력하세요" required>

            <!-- 이름 입력 -->
            <label for="name">이름</label>
            <input type="text" id="name" name="name" placeholder="이름을 입력하세요" required>

            <!-- 이메일 입력 -->
            <label for="email">이메일</label>
            <input type="email" id="email" name="email" placeholder="이메일을 입력하세요" required>

            <button type="submit" class="submit-btn">비밀번호 재설정 요청</button>
        </form>

        <!-- 메시지 출력 -->
        <c:if test="${not empty message}">
            <p class="message">${message}</p>
        </c:if>
    </section>
</main>
