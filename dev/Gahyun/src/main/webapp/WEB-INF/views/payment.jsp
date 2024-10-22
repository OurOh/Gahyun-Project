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
    <h1>결제 토큰</h1>
    <p>${token}</p>
    <button id="paymentButton">결제하기</button>
    <script type="text/javascript">
        $(document).ready(function() {
            $('#paymentButton').click(function() {
                var IMP = window.IMP; // 생략 가능
                IMP.init('imp12151020'); // 'your_imp_uid'는 포트원 가맹점 식별코드

                // 결제 요청
                IMP.request_pay({
                    pg: 'html5_inicis', // PG사 (이니시스 예시)
                    pay_method: 'card', // 결제 방법
                    merchant_uid: 'merchant_' + new Date().getTime(), // 주문번호
                    name: '주문명: 결제 테스트', // 결제창에 표시될 상품명
                    amount: 100, // 결제 금액
                    buyer_email: 'test@test.com', // 구매자 이메일
                    buyer_name: '홍길동', // 구매자 이름
                    buyer_tel: '010-1234-5678', // 구매자 전화번호
                    buyer_addr: '서울특별시 강남구 삼성동', // 구매자 주소
                    buyer_postcode: '123-456', // 구매자 우편번호
                    m_redirect_url: 'http://localhost:8080/paymentResult' // 결제 완료 후 이동할 URL
                }, function (rsp) {
                    // 결제 완료 후 콜백
                    if (rsp.success) {
                        alert('결제가 완료되었습니다.');
                        var msg = '결제가 완료되었습니다.\n' + '고유ID : ' + rsp.imp_uid + '\n' + '상점 거래ID : ' + rsp.merchant_uid + '\n' + '결제 금액 : ' + rsp.paid_amount + '\n';
                        console.log(msg);

                        // 서버로 결제 데이터 전송 (AJAX)
                        fetch('/payment/complete', {
                            method: 'POST',
                            headers: {
                                'Content-Type': 'application/json',
                            },
                            body: JSON.stringify({
                                imp_uid: rsp.imp_uid, // 결제 고유번호
                                merchant_uid: rsp.merchant_uid, // 주문번호
                                paid_amount: rsp.paid_amount // 결제 금액
                            })
                        }).then(function (response) {
                            return response.json();
                        }).then(function (data) {
                            console.log(data);
                        }).catch(function (error) {
                            console.error('Error:', error);
                        });
                    } else {
                        alert('결제에 실패하였습니다. 에러 내용: ' + rsp.error_msg);
                    }
                });
            });
        });
    </script>
</body>
</html>
