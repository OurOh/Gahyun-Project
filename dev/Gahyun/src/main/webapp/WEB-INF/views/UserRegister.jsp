<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    

<%@ page session="false" pageEncoding="UTF-8" %>

        <section class="form-section">
            <h1>회원가입</h1>
            <form action="/register" method="POST">
                <label for="name">이름</label>
                <input type="text" id="name" name="name" placeholder="이름을 입력하세요">
        
                <label for="username">아이디</label>
                <div class="username-field">
                    <input type="text" id="username" name="username" placeholder="아이디를 입력하세요">
                    <button type="button" class="duplicate-check-btn">중복확인</button>
                </div>
        
                <label for="password">비밀번호</label>
                <input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요">
        
                <label for="confirm_password">비밀번호 확인</label>
                <input type="password" id="confirm_password" name="confirm_password" placeholder="비밀번호를 확인하세요">
        
                <label for="birthdate">생년월일</label>
                <div class="birthdate">
                    <select name="year" id="year">
                        <option value="1999">1999</option>
                    </select>
                    <select name="month" id="month">
                        <option value="1">1</option>
                    </select>
                    <select name="day" id="day">
                        <option value="10">10</option>
                    </select>
                </div>
        
                <label for="phone">연락처</label>
                    <div class="phone">
                        <input type="text" id="phone1" name="phone1" value="010" maxlength="3">
                        <input type="text" id="phone2" name="phone2" maxlength="4">
                        <input type="text" id="phone3" name="phone3" maxlength="4">
                    </div>

        
                <!-- 마케팅 수신동의 섹션 -->
                <div class="marketing-section">
                    <h2>마케팅문자수신동의</h2>
                    <p>
                        가현리조트(이하 “회사”)는 개인정보보호법 및 정보통신망법 등에 따라 회원님의 개인정보 및 서비스 이용정보를 활용한 마케팅 동의 절차를 운영하고 있으며, 
                        이에 따라 회원님께서 서비스 이용 중에 개인정보 수집, 이용, 제공 동의 시 마케팅 수신동의를 하신 경우에만 마케팅 및 광고 정보를 수신하실 수 있습니다. 
                        회원님은 아래 내용을 확인하고 동의 여부를 선택할 수 있습니다.
                    </p>
                    <p>동의 내용:</p>
                    <ol>
                        <li>마케팅 정보 제공(이벤트, 혜택 안내 등), 맞춤형 서비스 제공</li>
                        <li>기타 관련 서비스 및 상품에 대한 정보 제공</li>
                    </ol>
        
                    <label>
                        <input type="checkbox" id="marketing_agree" name="marketing_agree"> 
                        위 내용을 확인하였으며 마케팅 문자 수신에 동의합니다.
                    </label>
                </div>
        
                <div class="buttons">
                    <a href="/register" class="submit-btn">가입하기</a>
                    <a href="#" class="cancel-btn">취소</a>
                </div>
                
            </form>
        </section>