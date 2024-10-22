<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    

<%@ page session="false" pageEncoding="UTF-8" %>

        <section class="form-section">
            <h1>개인정보 수정</h1>
            <form>
                <label for="name">이름</label>
                <input type="text" id="name" name="name" value="홍길동" readonly>

                <label for="username">회원아이디</label>
                <input type="text" id="username" name="username" value="gildong" readonly>

                <label for="password">비밀번호</label>
                <input type="password" id="password" name="password" placeholder="비밀번호">

                <label for="confirm_password">비밀번호 확인</label>
                <input type="password" id="confirm_password" name="confirm_password" placeholder="비밀번호 확인">

                <label for="birthdate">생년월일</label>
                <div class="birthdate">
                    <select name="year" id="year">
                        <option value="1999">1999</option>
                        <option value="1999">1999</option>
                        <option value="1999">1999</option>
                        <option value="1999">1999</option>
                        <option value="1999">1999</option>
                        <option value="1999">1999</option>
                        <option value="1999">1999</option>
                        <option value="1999">1999</option>
                        <option value="1999">1999</option>
                        <option value="1999">1999</option>
                        <!-- 더 많은 연도를 추가하세요 -->
                    </select>
                    <select name="month" id="month">
                        <option value="1">1</option>
                        <option value="1">1</option>
                        <option value="1">1</option>
                        <option value="1">1</option>
                        <option value="1">1</option>
                        <option value="1">1</option>
                        <option value="1">1</option>
                        <option value="1">1</option>
                        <!-- 더 많은 월을 추가하세요 -->
                    </select>
                    <select name="day" id="day">
                        <option value="10">10</option>
                        <!-- 더 많은 날짜를 추가하세요 -->
                        <option value="10">10</option>
                        <option value="10">10</option>
                        <option value="10">10</option>
                        <option value="10">10</option>
                        <option value="10">10</option>
                        <option value="10">10</option>
                        <option value="10">10</option>
                        <option value="10">10</option>
                    </select>
                </div>

                <label for="phone">연락처</label>
                <div class="phone">
                    <input type="text" id="phone1" name="phone1" value="010" maxlength="3">
                    <input type="text" id="phone2" name="phone2" maxlength="4">
                    <input type="text" id="phone3" name="phone3" maxlength="4">
                </div>

                <div class="buttons">
                    <button type="submit" class="submit-btn">수정완료</button>
                    <button type="button" class="cancel-btn">취소</button>
                </div>
            </form>
        </section>