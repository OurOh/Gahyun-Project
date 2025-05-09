<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    

<%@ page session="false" pageEncoding="UTF-8" %>
 
 
 
<main>
        <!-- 객실소개 섹션 -->
        <section class="room-intro">
            <h1>객실소개</h1>
            <div class="room-tabs">
                <button id="roomTypeA">타입 A</button>
                <button id="roomTypeB1">타입 B(침대O)</button>
                <button id="roomTypeB2">타입 B(침대X)</button>
            </div>
        
            <!-- 이미지 슬라이드 -->
            <div class="room-content">
                <div class="showroom-slider">
                    <div class="showroom-slides">
                        <!-- 각 이미지 슬라이드를 위한 div -->
                        <div class="showroom-slide">
                            <img src="${pageContext.request.contextPath}/res/images/room001.jpg" alt="객실 이미지 1" class="showroom-image">
                        </div>
                        <div class="showroom-slide">
                            <img src="${pageContext.request.contextPath}/res/images/room008.jpg" alt="객실 이미지 2" class="showroom-image">
                        </div>
                        <div class="showroom-slide">
                            <img src="${pageContext.request.contextPath}/res/images/room009.jpg" alt="객실 이미지 3" class="showroom-image">
                        </div>
                    </div>
                </div>
                <div class="room-info-box">
    <div class="room-info-B1">
        <h2>타입 B (4인 기준, 침대O)</h2>
        <p>타입 B 객실은 넓은 퀸사이즈 침대와 고급 침구가 제공되어 가족 단위 투숙객에게 최적화된 공간입니다. 화려하면서도 모던한 인테리어가 조화를 이루며, 각종 편의시설을 통해 안락한 휴식을 제공합니다. 또한, 각종 미디어와 최신 가전이 갖추어져 있어 가족들이 함께 머물기에 부족함이 없으며, 조용하고 넓은 공간에서 여유로운 시간을 보낼 수 있는 최상의 환경을 제공합니다.</p>
        
        <div class="warnings">
            <h3>주의사항</h3>
            <ul>
                <li>체크인은 오후 3시 이후, 체크아웃은 오전 11시까지입니다.</li>
                <li>객실 내 금연 구역이며, 위반 시 추가 청소비가 부과됩니다.</li>
                <li>애완동물 동반 입실은 불가합니다.</li>
                <li>객실 내 외부 음식물 반입은 제한됩니다.</li>
            </ul>
            
            <h3>이용약관</h3>
            <ul>
                <li>예약 취소는 체크인 3일 전까지 가능합니다.</li>
                <li>투숙 중 발생한 손해에 대한 책임은 고객에게 있습니다.</li>
                <li>모든 투숙객은 호텔 정책과 규정을 준수해야 합니다.</li>
                <li>호텔은 예고 없이 서비스 제공 조건을 변경할 수 있습니다.</li>
            </ul>
        </div>
        
        <button class="reserve-btn" onclick="location.href='${pageContext.request.contextPath}/Reservation1'">예약 바로가기</button>
    </div>
    
    <div class="room-info-B2">
        <h2>타입 B (4인 기준, 침대X)</h2>
        <p>타입 B 객실(침대X)은 전통적인 한국식 온돌 바닥을 특징으로 하여 편안함을 더해줍니다. 특히 어린이를 동반한 가족 단위 고객에게 적합한 공간으로, 안락하고 따뜻한 느낌을 주는 인테리어가 돋보입니다. 넉넉한 공간에 깔끔한 디자인을 더해 가족들이 함께 휴식을 취하며 시간을 보낼 수 있습니다. 최신 시설을 갖추고 있어 편안한 투숙을 보장하며, 아이들이 놀기에도 안전하고 편리한 환경을 제공합니다.</p>
        
        <div class="warnings">
            <h3>주의사항</h3>
            <ul>
                <li>체크인은 오후 3시 이후, 체크아웃은 오전 11시까지입니다.</li>
                <li>객실 내 금연 구역이며, 위반 시 추가 청소비가 부과됩니다.</li>
                <li>애완동물 동반 입실은 불가합니다.</li>
                <li>객실 내 외부 음식물 반입은 제한됩니다.</li>
            </ul>
            
            <h3>이용약관</h3>
            <ul>
                <li>예약 취소는 체크인 3일 전까지 가능합니다.</li>
                <li>투숙 중 발생한 손해에 대한 책임은 고객에게 있습니다.</li>
                <li>모든 투숙객은 호텔 정책과 규정을 준수해야 합니다.</li>
                <li>호텔은 예고 없이 서비스 제공 조건을 변경할 수 있습니다.</li>
            </ul>
        </div>
        
        <button class="reserve-btn" onclick="location.href='${pageContext.request.contextPath}/Reservation1'">예약 바로가기</button>
    </div>
    
    <div class="room-info-A">
        <h2>타입 A (2인 기준)</h2>
        <p>타입 A 객실은 두 명이 이용하기에 이상적인 아늑한 공간으로 설계되었습니다. 자연 채광이 잘 드는 창문과 모던한 인테리어가 조화를 이루며, 조용하고 편안한 분위기를 제공합니다.
         특히 소규모 여행객이나 커플이 프라이빗하고 낭만적인 시간을 보낼 수 있는 환경을 조성하며, 안락한 침대와 고급 가구로 최상의 휴식을 제공합니다. 편리한 가전과 기본적인 어메니티가 갖추어져 있어, 
         작은 공간에서도 편안함과 안락함을 만끽할 수 있습니다.</p>
        
        <div class="warnings">
            <h3>주의사항</h3>
            <ul>
                <li>체크인은 오후 3시 이후, 체크아웃은 오전 11시까지입니다.</li>
                <li>객실 내 금연 구역이며, 위반 시 추가 청소비가 부과됩니다.</li>
                <li>애완동물 동반 입실은 불가합니다.</li>
                <li>객실 내 외부 음식물 반입은 제한됩니다.</li>
            </ul>
            
            <h3>이용약관</h3>
            <ul>
                <li> 예약 취소는 체크인 3일 전까지 가능합니다.</li>
                <li>투숙 중 발생한 손해에 대한 책임은 고객에게 있습니다.</li>
                <li>모든 투숙객은 호텔 정책과 규정을 준수해야 합니다.</li>
                <li>호텔은 예고 없이 서비스 제공 조건을 변경할 수 있습니다.</li>
            </ul>
        </div>
        
        <button class="reserve-btn" onclick="location.href='${pageContext.request.contextPath}/Reservation1'">예약 바로가기</button>
    </div>
</div>

            </div>
        </section>
    </main>
</body>

<script>
     $(document).ready(function() {

        // 버튼 클릭 시에만 슬라이드 이동
        $("#roomTypeA").click(function() {
            $(".room-info-A").show();
            $(".room-info-B1, .room-info-B2").hide();
            $(".showroom-slides").css("transform", "translateX(0)");
        });
        
        $("#roomTypeB1").click(function() {
            $(".room-info-B1").show();
            $(".room-info-A, .room-info-B2").hide();
            $(".showroom-slides").css("transform", "translateX(-33.3333%)");
        });
        
        $("#roomTypeB2").click(function() {
            $(".room-info-B2").show();
            $(".room-info-A, .room-info-B1").hide();
            $(".showroom-slides").css("transform", "translateX(-66.6666%)");
        });
        
     });
</script>