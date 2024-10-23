<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    

<%@ page session="false" pageEncoding="UTF-8" %>

<section class="reservation-confirmation">
            <h1>예약페이지</h1>
            <h2>예약 내역을 확인해주세요</h2>
            <div class="reservation-details">
                <div class="room-image">
                    <img src="../images/room001.jpg" alt="객실 이미지">
                </div>
                <div class="reservation-info">
                    <p><strong>예약일</strong><br>n월 n일 체크인 - n월 n일 체크아웃 (n박)</p>
                    <p><strong>객실 타입</strong><br>타입 A (2인 / 더블침대)</p>
                    <p><strong>인원</strong><br>2 명</p>
                    <p><strong>조식여부</strong><br>불포함</p>
                </div>
            </div>
        </section>
        <section class="guest-info">
            <h2>숙박자 정보</h2>
            <div class="input-fields">
                <div class="input-group">
                    <label for="guest-name">성명</label>
                    <input type="text" id="guest-name">
                </div>
                <div class="input-group">
                    <label for="phone-number">휴대폰번호</label>
                    <input type="text" id="phone-number" maxlength="3"> - 
                    <input type="text" maxlength="4"> - 
                    <input type="text" maxlength="4">
                </div>
                <div class="checkbox">
                    <input type="checkbox" id="same-info">
                    <label for="same-info">예약자 정보와 동일</label>
                </div>
            </div>
        </section>
        <section class="discount-info">
            <h2>할인정보</h2>
            <p>해당되는 할인이 없습니다.</p>
        </section>
        <section class="payment-info">
            <h2>결제방법</h2>
            <div class="payment-api">이하 결제 api 적용</div>
        </section>
        
   