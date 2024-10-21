<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    

<%@ page session="false" pageEncoding="UTF-8" %>

<section class="form-section">
    <h1>회원가입</h1>
    <form action="${pageContext.request.contextPath}/register" id="register" method="POST">
        <label for="name">이름</label>
        <input type="text" id="name" name="name" placeholder="이름을 입력하세요" required>

        <label for="userid">아이디</label> <!-- for 속성 수정 -->
        <div class="username-field">
            <input type="text" id="userid" name="userid" placeholder="아이디를 입력하세요" required>
            <button type="button" class="duplicate-check-btn">중복확인</button>
        </div>

        <label for="password">비밀번호</label>
        <input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요" required>

        <label for="confirm_password">비밀번호 확인</label>
        <input type="password" id="confirm_password" name="confirm_password" placeholder="비밀번호를 확인하세요" required>

        <label for="birth">생년월일</label>
        <div class="birthdate">
            <input type="text" name="year" id="year" placeholder="년" required>
            <input type="text" name="month" id="month" placeholder="월" required>
            <input type="text" name="day" id="day" placeholder="일" required>
        </div>
        <input type="hidden" name="birth" id="birth" />

        <label for="phone1">연락처</label> <!-- for 속성을 첫 번째 전화번호 필드와 일치시킴 -->
        <div class="phone">
            <input type="text" id="phone1" name="phone1" value="010" maxlength="3" required>
            <input type="text" id="phone2" name="phone2" maxlength="4" required>
            <input type="text" id="phone3" name="phone3" maxlength="4" required>
        </div>
        <input type="hidden" name="phone" id="phone" />

        <div class="buttons">
            <button type="submit" class="submit-btn">가입하기</button>
            <a href="#" class="cancel-btn">취소</a>
        </div>
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
