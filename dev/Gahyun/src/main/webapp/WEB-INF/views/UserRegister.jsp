<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    

<%@ page session="false" pageEncoding="UTF-8" %>

<section class="form-section">
    <h1>회원가입</h1>
    <form action="${pageContext.request.contextPath}/register" method="POST">
    <!-- 아이디 -->
    <label for="userid">아이디</label>
    <input type="text" id="userid" name="userid" required>

    <!-- 비밀번호 -->
    <label for="password">비밀번호</label>
    <input type="password" id="password" name="password" required>

    <!-- 이름 -->
    <label for="name">이름</label>
    <input type="text" id="name" name="name" required>

    <!-- 생년월일 -->
   <label for="birthdate">생년월일</label>
<div class="birthdate">
    <input type="text" id="year" name="year" placeholder="년" required class="birth-input">
    <input type="text" id="month" name="month" placeholder="월" required class="birth-input">
    <input type="text" id="day" name="day" placeholder="일" required class="birth-input">
</div>

    <label for="phone">전화번호</label>
<div class="phone">
    <input type="text" id="phone1" name="phone1" maxlength="3" required>
    <input type="text" id="phone2" name="phone2" maxlength="4" required>
    <input type="text" id="phone3" name="phone3" maxlength="4" required>
</div>

    <button type="submit">가입하기</button>
</form>

</section>

<script>
    document.getElementById('register').addEventListener('submit', function(event) {
        const year = document.getElementById('year').value;
        const month = document.getElementById('month').value;
        const day = document.getElementById('day').value;
        const phone1 = document.getElementById('phone1').value;
        const phone2 = document.getElementById('phone2').value;
        const phone3 = document.getElementById('phone3').value;

        // 생년월일과 전화번호 결합하여 hidden 필드에 값 설정
        document.getElementById('birth').value = `${year}-${month}-${day}`;
        document.getElementById('phone').value = `${phone1}-${phone2}-${phone3}`;

        // 디버깅을 위해 console에 phone 값 출력
        console.log("Phone: " + document.getElementById('phone').value);

        // 폼 제출 전에 phone 값이 올바르게 설정되었는지 확인
        if (!document.getElementById('phone').value) {
            alert("전화번호가 설정되지 않았습니다.");
            event.preventDefault(); // 폼 제출 중단
        }

        // 비밀번호 일치 여부 확인
        const password = document.getElementById('password').value;
        const confirmPassword = document.getElementById('confirm_password').value;
        if (password !== confirmPassword) {
            alert("비밀번호가 일치하지 않습니다.");
            event.preventDefault(); // 폼 제출 중단
        }
    });
</script>
