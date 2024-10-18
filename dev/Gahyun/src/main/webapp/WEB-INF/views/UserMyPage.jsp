<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>

<section class="page-header">
    <h1>마이페이지</h1>
</section>

<section class="reservation-status">
    <h2>예약현황</h2>
    <c:forEach var="currentReservation" items="${currentReservations}">
        <div class="reservation-card">
            <img src="${pageContext.request.contextPath}/res/images/${currentReservation.image}" alt="room image">
            <div class="reservation-info">
                <p><strong>예약일정:</strong> ${currentReservation.checkInDate} ~ ${currentReservation.checkOutDate}</p>
                <p><strong>객실 타입:</strong> ${currentReservation.roomType}</p>
                <p><strong>인원:</strong> ${currentReservation.peopleCount}명</p>
                <p><strong>조식여부:</strong> ${currentReservation.breakfastIncluded}</p>
            </div>
        </div>
    </c:forEach>
</section>

<section class="reservation-history">
    <h2>예약기록</h2>
    <c:forEach var="reservation" items="${pastReservations}">
        <div class="reservation-card">
            <img src="${pageContext.request.contextPath}/res/images/${reservation.image}" alt="room image">
            <div class="reservation-info">
                <p><strong>예약일정:</strong> ${reservation.checkInDate} ~ ${reservation.checkOutDate}</p>
                <p><strong>객실 타입:</strong> ${reservation.roomType}</p>
                <p><strong>인원:</strong> ${reservation.peopleCount}명</p>
                <p><strong>조식여부:</strong> ${reservation.breakfastIncluded}</p>
            </div>
        </div>
    </c:forEach>
</section>
