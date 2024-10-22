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
        <form name="resConfirm" action="/dev/ResComplte" method="post">
        <section class="guest-info">
            <h2>숙박자 정보</h2>
            <div class="input-fields">
                <div class="input-group">
                    <label for="guest-name">성명</label>
                    <input type="text" id="guest-name">
                    <input type="hidden" id="gname" name="gname"/>
                </div>
                <div class="input-group">
                    <label for="phone-number">휴대폰번호</label>
                    <input type="text" id="phone-number" maxlength="3"> - 
                    <input type="text" id="phone-number2" maxlength="4"> - 
                    <input type="text" id="phone-number3" maxlength="4">
                    <input type="hidden" id="gtel" name="gtel"/>
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
            <button class="payment-api">이하 결제 api 적용</button>
        </section>
        <input type="hidden" id="startDate" name="startDate" value="${startDate}">
        <input type="hidden" id="endDate" name="endDate" value="${endDate}">
        <input type="hidden" id="roomid" name="roomid" value="${resInfo.roomId}">
        <input type="hidden" id="user_id" name="user_id" value="1"><!-- 임시 테스트용 -->
        </form>
 <script>
 
	const sliceSdate  = "${startDate}"; // yyyy-mm-dd
	const sliceEdate = "${endDate}";
	const sYears = sliceSdate.substr(0, 4);
	const sMonth = sliceSdate.substr(5, 2);
	const sDay = sliceSdate.substr(8, 2);
	const eYears = sliceEdate.substr(0, 4);
	const eMonth = sliceEdate.substr(5, 2);
	const eDay = sliceEdate.substr(8, 2);
	
	
	const startMonth = parseInt(sMonth, 10);// *1 문자열값 변환
	const endMonth = parseInt(eMonth, 10);
	const startDay = parseInt(sDay, 10);
	const endDay  = parseInt(eDay, 10);

	//윤년 처리
	
	const monthDays = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
	function isYyYear(year) {
	    return (year % 4 === 0 && year % 100 !== 0) || (year % 400 === 0);
	}
	if (isYyYear(sYears)) {
	    monthDays[1] = 29;
	}




	let dayDiff = 0;

	//*1 01같은 형식으로 month값 들어오면 endMonth, 아니면 eMonth 사용
	if (startMonth < endMonth || (startMonth == endMonth && startDay < endDay)) {
	    if (startMonth == endMonth) {
	        // 같은 달
	        dayDiff = endDay - startDay;
	        console.log("같은달", dayDiff);
	    } else {
	        // 다른 달 
	        dayDiff = monthDays[startMonth - 1] - startDay; // 시작 월의 남은 일수 계산
	        for (let i = startMonth; i < endMonth - 1; i++) {
	            dayDiff += monthDays[i];
	            console.log("다른달", dayDiff);
	        }
	        dayDiff += endDay; //종료 월의 일 수 +
	    }
	} else {
	    console.log("종료 날짜가 시작 날짜보다 이전");
	}

	console.log("날짜 차이:", dayDiff);
	
	
	
	
	var reservationinfo = document.querySelector('.reservation-info');
	
	var checkInOutText = document.querySelector('.checkInOutText');
	
	var checkInOut = 
		"<strong>예약일</strong><br>"+sMonth+"월 "+sDay+"일 체크인 - "+eMonth+"월 " +eDay+"일 체크아웃 ("+(dayDiff-1)+"박"+dayDiff+"일)";
		

	checkInOutText.innerHTML = checkInOut;
	
	$(function(){
		$('form[name="resConfirm"]').on('submit',function(event){
			event.preventDefault();
			
			const tel = $("#phone-number").val() + "-" + $("#phone-number2").val() + "-" + $("#phone-number3").val();
            
			$('#gtel').val(tel);
			$('#gname').val($('#guest-name').val());
			const formData = $(this).serializeArray();
			console.log(formData);
			this.submit();
		});
	});

</script>       
   