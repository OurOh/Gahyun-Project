<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>

 <main>
	<section class="mypage-section">
	    <h1>마이페이지</h1>
	</section>
	
	<section class="reservation-status">
	    <h2>예약현황</h2>
	    <c:forEach var="currentMypage" items="${currentMypage}">
	        <div class="mypage-card">
	            <img src="${pageContext.request.contextPath}/res/images/${currentMypage.image}" alt="room image">
	            <div class="history-info">
	                <p><strong>예약일정:</strong> ${currentMypage.checkInDate} ~ ${currentMypage.checkOutDate}</p>
	                <p><strong>객실 타입:</strong> ${currentMypage.roomType}</p>
	                <p><strong>인원:</strong> ${currentMypage.peopleCount}명</p>
	                <p><strong>조식여부:</strong> ${currentMypage.breakfastIncluded}</p>
	            </div>
	        </div>
	        <button class="reserv-delete">예약취소</button>
	    </c:forEach>
	</section>
	
	<section class="reservation-history">
	    <h2>예약기록</h2>
	    <c:forEach var="mypage" items="${pastMypage}">
	        <div class="mypage-card">
	        <div class="card-info-section">
	            <img src="${pageContext.request.contextPath}/res/images/${Mypage.image}" alt="room image">
	            <div class="history-info">
	                <p><strong>예약일정:</strong> ${Mypage.checkInDate} ~ ${Mypage.checkOutDate}</p>
	                <p><strong>객실 타입:</strong> ${Mypage.roomType}</p>
	                <p><strong>인원:</strong> ${Mypage.peopleCount}명</p>
	                <p><strong>조식여부:</strong> ${Mypage.breakfastIncluded}</p>
	            </div>
	            </div>
	        </div>
	    </c:forEach>
	</section>
 </main>