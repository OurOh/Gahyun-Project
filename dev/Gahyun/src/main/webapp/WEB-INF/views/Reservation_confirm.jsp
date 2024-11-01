<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    

<%@ page session="false" pageEncoding="UTF-8" %>

<section class="reservation-confirmation">
    <h1>예약페이지</h1>
    <h2>예약 내역을 확인해주세요</h2>
    <div class="reservation-details" style="display: flex; align-items: flex-start; gap: 20px;">
        <div class="room-image" style="flex: 1;">
            <c:forEach var="photo" items="${resInfo.photos}">
                <img src="${pageContext.request.contextPath}${photo.photoUrl}" alt="객실 이미지" style="width: 100%; height: auto;">
            </c:forEach>
        </div>
        <div class="reservation-info" style="flex: 1;">
            <p class="checkInOutText"></p>
            <p><strong>객실 타입</strong><br>${resInfo.roomType} (${resInfo.capacity}인 / 더블침대)</p>
            <p><strong>인원</strong><br>${resGuest} 명</p>
            <p><strong>조식여부</strong><br>불포함</p>
        </div>
    </div>
</section>

<section class="guest-info">
    <form name="resConfirm" action="/dev/ResComplte" method="post">
        <h2>숙박자 정보</h2>
        <div class="input-fields">
            <div class="input-group">
                <label for="guest-name">성명</label>
                <input type="text" id="guest-name">
                <input type="hidden" id="gname" name="gname"/>
            </div>
            <div class="phone">
                <input type="text" id="phone-number" placeholder="010" maxlength="3" required>
                <input type="text" id="phone-number2" maxlength="4" required>
                <input type="text" id="phone-number3" maxlength="4" required>
                <input type="hidden" id="gtel" name="gtel"/>
            </div>
            <div class="checkbox">
                <input type="checkbox" id="same-info">
                <label for="same-info">예약자 정보와 동일</label>
            </div>
        </div>
        <input type="hidden" id="startDate" name="startDate" value="${startDate}">
        <input type="hidden" id="endDate" name="endDate" value="${endDate}">
        <input type="hidden" id="roomid" name="roomid" value="${resInfo.roomId}">
        <input type="hidden" id="price" name="price" value="${resInfo.pricePerNight}">
    
</section>

<section class="discount-info">
    <h2>할인정보</h2>
    <p>해당되는 할인이 없습니다.</p>
</section>

<section class="payment-info">
    <h2>결제방법</h2>
    <button class="payment-api">결제하기</button>
    </form>
</section>

<script>
    const sliceSdate = "${startDate}"; // yyyy-mm-dd
    const sliceEdate = "${endDate}";
    const sYears = sliceSdate.substr(0, 4);
    const sMonth = sliceSdate.substr(5, 2);
    const sDay = sliceSdate.substr(8, 2);
    const eYears = sliceEdate.substr(0, 4);
    const eMonth = sliceEdate.substr(5, 2);
    const eDay = sliceEdate.substr(8, 2);

    const startMonth = parseInt(sMonth, 10);
    const endMonth = parseInt(eMonth, 10);
    const startDay = parseInt(sDay, 10);
    const endDay = parseInt(eDay, 10);

    const monthDays = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    function isYyYear(year) {
        return (year % 4 === 0 && year % 100 !== 0) || (year % 400 === 0);
    }
    if (isYyYear(sYears)) {
        monthDays[1] = 29;
    }

    let dayDiff = 0;

    if (startMonth < endMonth || (startMonth == endMonth && startDay < endDay)) {
        if (startMonth == endMonth) {
            dayDiff = endDay - startDay;
            console.log("같은달", dayDiff);
        } else {
            dayDiff = monthDays[startMonth - 1] - startDay;
            for (let i = startMonth; i < endMonth - 1; i++) {
                dayDiff += monthDays[i];
                console.log("다른달", dayDiff);
            }
            dayDiff += endDay;
        }
    } else {
        console.log("종료 날짜가 시작 날짜보다 이전");
    }

    console.log("날짜 차이:", dayDiff);

    var reservationinfo = document.querySelector('.reservation-info');
    var checkInOutText = document.querySelector('.checkInOutText');
    var checkInOut = "<strong>예약일</strong><br>" + sMonth + "월 " + sDay + "일 체크인 - " + eMonth + "월 " + eDay + "일 체크아웃 (" + (dayDiff - 1) + "박" + dayDiff + "일)";
    checkInOutText.innerHTML = checkInOut;

    $(function () {
    	//포트원
    	var IMP = window.IMP;
    	IMP.init('imp12151020'); // 포트원 가맹점 식별코드
    	
        console.log($('#roomid').val());
        $('form[name="resConfirm"]').on('submit', function (event) {
            event.preventDefault();
            const tel = $("#phone-number").val() + "-" + $("#phone-number2").val() + "-" + $("#phone-number3").val();
            
            const price = Math.floor(${resInfo.pricePerNight} * dayDiff);
            console.log(price);
            $('#price').val(price);
            $('#gtel').val(tel);
            $('#gname').val($('#guest-name').val());
            const formData = $(this).serializeArray();
            console.log(formData);
            
            //결제처리
       		// 고정 결제 정보
            var userId = ${user_id};
            var roomId = ${resInfo.roomId};
            var checkInDate = '${startDate}';
            var checkOutDate = '${endDate}';
            const uname = $('#gname').val();
            

            IMP.request_pay({
                pg: 'html5_inicis',
                pay_method: 'card',
                merchant_uid: 'merchant_' + new Date().getTime(),
                name: '객실 예약 결제 테스트',
                amount: price, // 결제 금액 100원으로 고정
                buyer_email: 'testuser@example.com',  // 고정된 이메일
                buyer_name: uname,            // 고정된 이름
                buyer_tel: tel,           // 고정된 전화번호
                m_redirect_url: 'http://localhost:8080/paymentResult'
            }, function (rsp) {
            	if (rsp.success) {
            	    alert('결제가 완료되었습니다.');
            	    
            	    $.ajax({
            	    	url: '/dev/complete', 
            	        type: 'POST',
            	        contentType: 'application/json',
            	        data: JSON.stringify({
            	            imp_uid: rsp.imp_uid,
            	            merchant_uid: rsp.merchant_uid,
            	            paid_amount: rsp.paid_amount,
            	            userId: userId,
            	            roomId: roomId,
            	            checkInDate: checkInDate,
            	            checkOutDate: checkOutDate
            	        }),
            	        success: function (data) {
            	            if (data.result === "success") {
            	                window.location.href = "/dev/home"; // 성공시 리다이렉트
            	                alert('결제에 성공 했습니다.');
            	                
            	            } else {
            	                alert('결제 정보 저장에 실패했습니다.');
            	                console.log("결제 실패 이유: ", data.message); // 로그 추가
            	            }
            	        },
            	        error: function (xhr, status, error) {
            	            alert('결제 후 처리 중 오류가 발생했습니다.');
            	            console.log("AJAX 오류: ", xhr.responseText); // 로그 추가
            	        }
            	    });
      	    
            	} else {
            	    alert('결제에 실패했습니다.');
            	}
            });
            
            
            //this.submit();
        });
    });

    $(document).ready(function () {
        $('#same-info').change(function () {
            if ($(this).is(':checked')) {
                console.log("checkbox 체크 ajax전송");
                $.ajax({
                    url: '/dev/samePerson',
                    type: 'POST',
                    success: function (response) {
                        var sPhoneNum = response.phoneNum;
                        var sName = response.name;
                        $("#guest-name").val(sName);
                        var phoneParts = sPhoneNum.split('-');
                        $("#phone-number").val(phoneParts[0]);
                        $("#phone-number2").val(phoneParts[1]);
                        $("#phone-number3").val(phoneParts[2]);
                    },
                    error: function (xhr, status, error) {
                        console.error("Error입니다.", error);
                        console.log("Response Text:", xhr.responseText);
                        console.log("Status:", status);
                    }
                });
            } else {
                $('#guest-name').val('');
                $("#phone-number").val('');
                $("#phone-number2").val('');
                $("#phone-number3").val('');
            }
        });
    });
</script>
