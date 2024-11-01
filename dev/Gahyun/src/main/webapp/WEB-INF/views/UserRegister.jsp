<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    

<%@ page session="false" pageEncoding="UTF-8" %>
<main>
<section class="register-section">
    <h1>회원가입</h1>
    <form action="${pageContext.request.contextPath}/register" method="POST" id="register-form">
    
    <!-- 아이디 -->
    <label for="userid">아이디</label>
    <input type="text" id="userid" name="userid" required>

    <!-- 비밀번호 -->
    <label for="password">비밀번호</label>
    <input type="password" id="password" name="password" required>

    <!-- 비밀번호 확인 -->
    <label for="confirm_password">비밀번호 확인</label>
    <input type="password" id="confirm_password" name="confirm_password" required>

    <!-- 이름 -->
    <label for="name">이름</label>
    <input type="text" id="name" name="name" required>

    <!-- 이메일 -->
    <label for="email">이메일</label>
	<input type="email" id="email" name="email" placeholder="이메일을 입력하세요" required>

    <!-- 생년월일 -->
   <label for="birthdate">생년월일</label>
<div class="birthdate">
    <input type="text" id="year" name="year" placeholder="년" required class="birth-input">
    <input type="text" id="month" name="month" placeholder="월" required class="birth-input">
    <input type="text" id="day" name="day" placeholder="일" required class="birth-input">
</div>

    <!-- 전화번호 -->
    <label for="phone">전화번호</label>
<div class="phone">
    <input type="text" id="phone1" name="phone1" maxlength="3" required>
    <input type="text" id="phone2" name="phone2" maxlength="4" required>
    <input type="text" id="phone3" name="phone3" maxlength="4" required>
</div>

<div class="marketing-agree">
    <h2>마케팅문자수신동의</h2>
    <span>
        <p>
            가현리조트(이하 “회사”)는 개인정보보호법 및 정보통신망법 등에 따라 회원님의 개인정보 및 서비스 이용정보를 활용한 마케팅 동의 절차를 운영하고 있으며, 
            이에 따라 회원님께서 서비스 이용 중에 개인정보 수집, 이용, 제공 동의 시 마케팅 수신동의를 하신 경우에만 마케팅 및 광고 정보를 수신하실 수 있습니다. 
            회원님은 아래 내용을 확인하고 동의 여부를 선택할 수 있습니다.
        </p>
    </span>
    <p>동의 내용:</p>
    <ol>
        <li>마케팅 정보 제공(이벤트, 혜택 안내 등), 맞춤형 서비스 제공</li>
        <li>기타 관련 서비스 및 상품에 대한 정보 제공</li>
    </ol>
    <label>
        <input type="checkbox" id="marketing_agree" name="marketing_agree" required> 
        위 내용을 확인하였으며 마케팅 문자 수신에 동의합니다.
    </label>
</div>

<div class="form-buttons">
	<button type="submit" class="submit-btn">가입하기</button>
	<a href="/dev/"><button type="button" class="cancel-btn">취소</button></a>
</div>

</form>
</section>
</main>

<script>
    document.getElementById('register').addEventListener('submit', function(event) {
        const year = document.getElementById('year').value;
        const month = document.getElementById('month').value;
        const day = document.getElementById('day').value;
        const phone1 = document.getElementById('phone1').value;
        const phone2 = document.getElementById('phone2').value;
        const phone3 = document.getElementById('phone3').value;

        // 생년월일과 전화번호 결합하여 hidden 필드에 값 설정
        document.getElementById('birth').value = ${year}-${month}-${day};
        document.getElementById('phone').value = ${phone1}-${phone2}-${phone3};

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