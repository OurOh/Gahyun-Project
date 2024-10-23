<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    

<%@ page session="false" pageEncoding="UTF-8" %>

<section class="reservation-section">
<form name="findAvailableRooms" method="POST">
            <h1>예약페이지</h1>

	            <div class="date-selection">
	                <p>날짜와 인원수를 선택하세요</p>
	                <div class="reservation-container">
	                    <div class="api-placeholder">
	                    	<div class="startdate" ></div>
	                    	<div class="enddate"  ></div>
	                    	<input type="hidden"  id="startdateval" name="startDate" class="startdateval" />
	                    	<input type="hidden"  id="enddateval" name="endDate" class="enddateval"/>
	                    	
	                    </div>
	                    
	                    <div class="guest-selection">
	                        <div class="input-group">
	                            <label>객실 수</label>
	                            <div class="control-buttons">
	                                <button class="control-button" type="button" onclick="event.preventDefault(); decrease('roomCount')">-</button>
	                                <span id="roomCount">1</span>
	                                <button class="control-button" onclick="event.preventDefault(); increase('roomCount')">+</button>
	                                <input type="hidden" type="button"  name="roomCount" class="roomCountval" id="roomCountInput" value=1 />
	                            </div>
	                        </div>
	                        <div class="input-group">
	                            <label>인원</label>
	                            <div class="control-buttons">
	                                <button class="control-button" onclick="event.preventDefault();decrease('guestCount')">-</button>
	                                <span id="guestCount">1</span>
	                                <button class="control-button" onclick="event.preventDefault(); increase('guestCount')">+</button>
	                                <input type="hidden" name="guestCount" class="guestCountval" id="guestCountInput" value=1 />
	                            </div>
	                        </div>
	                        <button class="room-search-button" type="submit">객실검색</button>
	                    </div>
	                </div>
	            </div>
</form>
            <div class="recommended-rooms">
                <h2 class="recommended-title">추천 객실</h2>
                <div class="rooms-list">
                    <div class="room-card">
   
                        <img src="${pageContext.request.contextPath}/res/images/room001.jpg" alt="객실 이미지">
                        <p>객실 타입: 타입A<br>조식: 불포함</p>
                    </div>
                    <div class="room-card">
                        <img src="${pageContext.request.contextPath}/res/images/room002.jpg" alt="객실 이미지">
                        <p>객실 타입: 타입A<br>조식: 불포함</p>
                    </div>
                    <div class="room-card">
                        <img src="${pageContext.request.contextPath}/res/images/images/room003.jpg" alt="객실 이미지">
                        <p>객실 타입: 타입A<br>조식: 불포함</p>
                    </div>
                    <div class="room-card">
                        <img src="${pageContext.request.contextPath}/res/images/images/room004.jpg" alt="객실 이미지">
                        <p>객실 타입: 타입A<br>조식: 불포함</p>
                    </div>
                    <div class="room-card">
                        <img src="${pageContext.request.contextPath}/res/images/images/room005.jpg" alt="객실 이미지">
                        <p>객실 타입: 타입A<br>조식: 불포함</p>
                    </div>
                    <div class="room-card">
                        <img src="${pageContext.request.contextPath}/res/images/images/room006.jpg" alt="객실 이미지">
                        <p>객실 타입: 타입A<br>조식: 불포함</p>
                    </div>
                </div>
                <button class="next-button" type="button" onclick="location.href='/dev/Reservation2'">다음으로</button>
            </div>
        </section>
   		