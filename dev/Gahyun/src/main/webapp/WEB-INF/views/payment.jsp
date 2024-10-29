<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
    <title>결제 페이지</title>
    <!-- jQuery 먼저 로드 -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <!-- jQuery UI 로드 -->
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>

    <!-- iamport 결제 라이브러리 로드 -->
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>

    
    
</head>
<body>
    <h1>결제 페이지</h1>

    <!-- 결제 요청 버튼 -->
    <button id="paymentButton">결제하기</button>



    <script type="text/javascript">
 // 페이지의 스크립트 상단에 기본 URL 설정
    $(document).ready(function () {
        var IMP = window.IMP;
        IMP.init('imp12151020'); // 포트원 가맹점 식별코드

        $('#paymentButton').click(function () {
            // 고정 결제 정보
            var userId = 1;
            var roomId = 1;
            var checkInDate = '2024-11-01';
            var checkOutDate = '2024-11-03';

            IMP.request_pay({
                pg: 'html5_inicis',
                pay_method: 'card',
                merchant_uid: 'merchant_' + new Date().getTime(),
                name: '객실 예약 결제 테스트',
                amount: 100, // 결제 금액 100원으로 고정
                buyer_email: 'testuser@example.com',  // 고정된 이메일
                buyer_name: '테스트 유저',            // 고정된 이름
                buyer_tel: '010-1234-5678',           // 고정된 전화번호
                m_redirect_url: 'http://localhost:8080/paymentResult'
            }, function (rsp) {
            	if (rsp.success) {
            	    alert('결제가 완료되었습니다.');
            	    
            	    $.ajax({
            	    	url: '/dev/payment/complete', // /payment/complete로 설정 (추가 경로 없음)
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
        });
    });
</script>
</body>
</html>