<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    

<%@ page session="false" pageEncoding="UTF-8" %>


<section class="reservation-confirmation">
            <h1>예약페이지</h1>
            <h2>예약 내역을 확인해주세요</h2>
            <div class="reservation-details">
                <div class="room-image">                	
					<c:forEach var="photo" items="${resInfo.photos}">
                    	<img src="${pageContext.request.contextPath}${photo.photoUrl}" alt="객실 이미지">
                    </c:forEach>
                </div>
                <div class="reservation-info">
                    <p class="checkInOutText"></p>
                    <p><strong>객실 타입</strong><br>${resInfo.roomType} (${resInfo.capacity}인 / 더블침대)</p>
                    <p><strong>인원</strong><br>${resGuest} 명</p>
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
 <script>
 
	const sliceSdate  = "${startDate}"; // yyyy-mm-dd
	const sliceEdate = "${endDate}";
	const sYears = sliceSdate.substr(0, 4);
	const sMonth = sliceSdate.substr(5, 2);
	const sDay = sliceSdate.substr(8, 2);
	const eYears = sliceEdate.substr(0, 4);
	const eMonth = sliceEdate.substr(5, 2);
	const eDay = sliceEdate.substr(8, 2);
	console.log(sMonth);
	
	var reservationinfo = document.querySelector('.reservation-info');
	
	var checkInOutText = document.querySelector('.checkInOutText');
	
	var checkInOut = 
		"<strong>예약일</strong><br>"+sMonth+"월 "+sDay+"일 체크인 - "+eMonth+"월 " +eDay+"일 체크아웃 (n박)";
		
	console.log(checkInOut);
	checkInOutText.innerHTML = checkInOut;
	
	
</script>       
   