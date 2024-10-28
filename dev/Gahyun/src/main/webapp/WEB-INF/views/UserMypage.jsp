<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>

 <main>
	<section class="mypage-section">
	    <h1>마이페이지</h1>
	</section>
	
	<section class="reservation-status">
        <h2>예약현황</h2>
        <c:choose>
            <c:when test="${not empty currentMypage}">
                <c:forEach var="current" items="${currentMypage}">
                    <!-- 예약 데이터 표시 -->
                   <div class="mypage-card">
                   <div class="card-info-section">
	            <img src="${pageContext.request.contextPath}${current.image}" alt="room image">
	            <div class="history-info">
	                <p><strong>예약일정:</strong> ${current.checkInDate} ~ ${current.checkOutDate}</p>
	                <p><strong>객실 타입:</strong> ${current.roomType}</p>
	                <p><strong>결제금액:</strong> ${current.totalPrice}</p>
	                </div>
	            </div>
	        </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <p>${currentMypageMessage}</p>
            </c:otherwise>
        </c:choose>
    </section>

    <section class="reservation-history">
        <h2>예약기록</h2>
        <c:choose>
            <c:when test="${not empty pastMypage}">
                <c:forEach var="past" items="${pastMypage}">
                    <!-- 과거 예약 데이터 표시 -->
                    <div class="mypage-card">
                    <div class="card-info-section">
	            <img src="${pageContext.request.contextPath}${past.image}" alt="room image">
	            <div class="history-info">
	                <p><strong>예약일정:</strong> ${past.checkInDate} ~ ${past.checkOutDate}</p>
	                <p><strong>객실 타입:</strong> ${past.roomType}</p>
	                <p><strong>결제 금액:</strong> ${past.totalPrice}</p>
	                </div>
	            </div>
	        </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <p>${pastMypageMessage}</p>
            </c:otherwise>
        </c:choose>
    </section>
 </main>