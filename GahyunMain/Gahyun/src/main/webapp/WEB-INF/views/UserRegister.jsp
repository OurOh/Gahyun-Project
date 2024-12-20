<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ page session="false" pageEncoding="UTF-8" %>

<main>
    <section class="register-section">
        <h1>회원가입</h1>
        <form action="${pageContext.request.contextPath}/register" method="post" id="register-form">
            
            <!-- 아이디 입력 부분 -->
            <label for="userid">아이디</label>
            <div class="userid-field">
                <input type="text" id="userid" name="userid" placeholder="아이디를 입력하세요" required>
                <button type="button" class="duplicate-check-btn" onclick="checkUserId()">중복확인</button>
            </div>
            <p id="userIdCheckMessage" style="color: red;"></p> <!-- 중복 확인 결과 표시 -->
            
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

            <!-- 마케팅 동의 -->
            <div class="marketing-agree">
                <h2>마케팅문자수신동의</h2>
                <label>
                    <input type="checkbox" id="marketing_agree" name="marketing_agree" required> 
                    위 내용을 확인하였으며 마케팅 문자 수신에 동의합니다.
                </label>
            </div>

            <!-- 가입/취소 버튼 -->
            <div class="form-buttons">
                <button type="submit" class="submit-btn">가입하기</button>
                <a href="/dev/"><button type="button" class="cancel-btn">취소</button></a>
            </div>

        </form>
    </section>
</main>

<script>
    function checkUserId() {
        const userid = document.getElementById("userid").value;
        if (!userid) {
            alert("아이디를 입력해주세요.");
            return;
        }

        // 서버에 중복 확인 요청
        fetch("${pageContext.request.contextPath}/checkUserId?userid=" + userid)
            .then(response => response.json())
            .then(data => {
                const messageElement = document.getElementById("userIdCheckMessage");
                if (data.available) {
                    messageElement.style.color = "green";
                    messageElement.textContent = "사용 가능한 아이디입니다.";
                } else {
                    messageElement.style.color = "red";
                    messageElement.textContent = "이미 사용 중인 아이디입니다.";
                }
            })
            .catch(error => {
                console.error("아이디 중복 확인 오류:", error);
                alert("아이디 중복 확인 중 오류가 발생했습니다.");
            });
    }
</script>
