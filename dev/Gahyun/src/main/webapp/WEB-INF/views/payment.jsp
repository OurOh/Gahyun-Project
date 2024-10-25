<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
    <title>결제 페이지</title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
</head>
<body>
    <h1>결제 페이지</h1>

     <!-- 결제 정보를 동적으로 보여줄 영역 -->
    <div id="paymentInfo">
        <p>결제 금액: <input type="text" id="paymentAmount" /></p>
        <p>구매자 이름: <input type="text" id="buyerName" /></p>
        <p>구매자 전화번호: <input type="text" id="buyerTel" /></p>
        <p>구매자 이메일: <input type="text" id="buyerEmail" /></p>
    </div>

    <!-- 결제 요청 시 사용할 데이터 -->
    <input type="hidden" id="userId" value="1"> <!-- 테스트 사용자 ID -->
    <input type="hidden" id="roomId" value="1"> <!-- 테스트 객실 ID -->
    <input type="date" id="checkInDate" value="2024-11-01">
    <input type="date" id="checkOutDate" value="2024-11-03">
    <button id="paymentButton">결제하기</button>



    <script type="text/javascript">
        $(document).ready(function () {
            var userId = $('#userId').val();

            // 페이지 로드 시 서버에서 결제 정보를 가져옴
            $.ajax({
                url: '/payment/getPaymentDetails',  // 서버에서 결제 정보를 받아올 엔드포인트
                type: 'GET',
                data: { userId: userId },
                success: function (data) {
                    if (data.error) {
                        alert(data.error);
                    } else {
                    	  // 결제 정보 업데이트
                        $('#paymentAmount').val(data.amount);  // 결제 금액
                        $('#buyerName').val(data.buyerName);   // 구매자 이름
                        $('#buyerTel').val(data.buyerTel);     // 구매자 전화번호
                        $('#buyerEmail').val(data.buyerEmail); // 구매자 이메일
                    }
                },
                error: function () {
                    alert("결제 정보를 가져오는 중 오류가 발생했습니다.");
                }
            });

            var IMP = window.IMP;
            IMP.init('imp12151020'); // 포트원 가맹점 식별코드

            $('#paymentButton').click(function () {
                var roomId = $('#roomId').val();
                var checkInDate = $('#checkInDate').val();
                var checkOutDate = $('#checkOutDate').val();

                IMP.request_pay({
                    pg: 'html5_inicis', 
                    pay_method: 'card',
                    merchant_uid: 'merchant_' + new Date().getTime(),
                    name: '객실 예약 결제 테스트',
                    amount: parseFloat($('#paymentAmount').val()),  // 서버에서 가져온 결제 금액
                    buyer_email: $('#buyerEmail').val(),  // 서버에서 가져온 구매자 이메일
                    buyer_name: $('#buyerName').val(),    // 서버에서 가져온 구매자 이름
                    buyer_tel: $('#buyerTel').val(),      // 서버에서 가져온 구매자 전화번호
                    m_redirect_url: 'http://localhost:8080/paymentResult'
                }, function (rsp) {
                    if (rsp.success) {
                        alert('결제가 완료되었습니다.');
                        
                        // 서버로 결제 데이터 전송
                        $.ajax({
                            url: '/payment/complete',
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
                                    window.location.href = "/home";
                                } else {
                                    alert('결제 정보 저장에 실패했습니다.');
                                }
                            },
                            error: function (error) {
                                alert('결제 후 처리 중 오류가 발생했습니다.');
                                console.log(error);
                            }
                        });
                    } else {
                        alert('결제에 실패했습니다. 에러 내용: ' + rsp.error_msg);
                    }
                });
            });
        });
    </script>
</body>
</html>
