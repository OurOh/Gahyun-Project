<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    

<%@ page session="true" pageEncoding="UTF-8" %>
<main>
<section class="form-section edit-section">
    <h1>개인정보 수정</h1>
    <form action="${pageContext.request.contextPath}/updateUserInfo" method="POST"> <!-- 정보 수정 폼 제출 경로 -->

        <label for="name">이름</label>
        <input type="text" id="name" name="name" value="${user.name}" placeholder="이름을 수정하세요" required>

        <label for="username">아이디</label>
		<input type="text" id="username" value="${user.userid}" disabled placeholder="아이디는 수정할 수 없습니다.">
		<input type="hidden" name="userid" value="${user.userid}">

        <label for="password">비밀번호</label>
        <input type="password" id="password" name="password" placeholder="새 비밀번호를 입력하세요" required>

        <label for="confirm_password">비밀번호 확인</label>
        <input type="password" id="confirm_password" name="confirm_password" placeholder="새 비밀번호를 다시 입력하세요" required>

		<label for="email">이메일</label>
        <input type="email" id="email" name="email" value="${user.email}" placeholder="이메일을 수정하세요" required>	

        <!-- 생년월일 -->
        <label for="birthdate">생년월일</label>
        <div class="birthdate">
            <input type="text" id="year" name="year" value="${user.user_birth.split('-')[0]}" placeholder="년" required class="birth-input">
            <input type="text" id="month" name="month" value="${user.user_birth.split('-')[1]}" placeholder="월" required class="birth-input">
            <input type="text" id="day" name="day" value="${user.user_birth.split('-')[2]}" placeholder="일" required class="birth-input">
        </div>

        <!-- 전화번호 -->
        <label for="phone">연락처</label>
        <div class="phone">
            <input type="text" id="phone1" name="phone1" value="${user.phone_num.split('-')[0]}" maxlength="3" placeholder="010" required>
            <input type="text" id="phone2" name="phone2" value="${user.phone_num.split('-')[1]}" maxlength="4" placeholder="1234" required>
            <input type="text" id="phone3" name="phone3" value="${user.phone_num.split('-')[2]}" maxlength="4" placeholder="5678" required>
        </div>

        <div class="buttons">
            <button type="submit" class="submit-btn">수정완료</button>
            <a href="#" class="cancel-btn">취소</a> <!-- 취소 버튼은 다른 페이지로 리다이렉트할 수 있음 -->
        </div>
    </form>
</section>
</main>

<script>
    // 비밀번호 일치 여부 확인
    document.querySelector('form').addEventListener('submit', function(event) {
        const password = document.getElementById('password').value;
        const confirmPassword = document.getElementById('confirm_password').value;

        if (password !== confirmPassword) {
            alert("비밀번호가 일치하지 않습니다.");
            event.preventDefault(); // 폼 제출 중단
        }
    });
</script>
