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
                        <p>객실은 세련된 디자인과 편안한 분위기를 자랑하며, 넓은 침대와 고급 가구로 구성되어 있습니다. 
                            최신 시설을 갖춘 이 객실은 최적의 휴식을 제공하며, 투숙객의 편의를 위해 다양한 편의시설을 완비하고 있습니다.</p>
            
                        <div class="warnings">
                            <h3>주의사항</h3>
                            
                                <li>체크인은 오후 3시 이후, 체크아웃은 오전 11시까지입니다.</li>
                                <li>객실 내 금연 구역이며, 위반 시 추가 청소비가 부과됩니다.</li>
                                <li>애완동물 동반 입실은 불가합니다.</li>
                                <li>객실 내 외부 음식물 반입은 제한됩니다.</li>
                            
            
                            <h3>이용약관</h3>
                            
                                <li>예약 취소는 체크인 3일 전까지 가능합니다.</li>
                                <li>투숙 중 발생한 손해에 대한 책임은 고객에게 있습니다.</li>
                                <li>모든 투숙객은 호텔 정책과 규정을 준수해야 합니다.</li>
                                <li>호텔은 예고 없이 서비스 제공 조건을 변경할 수 있습니다.</li>
                            
                        </div>
            
                        <button class="reserve-btn">예약 바로가기</button>
                    </div>
                    <div class="room-info-B2">
                        <h2>타입 B (4인 기준, 침대X)</h2>
                        <p>객실은 세련된 디자인과 편안한 분위기를 자랑하며, 넓은 침대와 고급 가구로 구성되어 있습니다. 
                            최신 시설을 갖춘 이 객실은 최적의 휴식을 제공하며, 투숙객의 편의를 위해 다양한 편의시설을 완비하고 있습니다.</p>
            
                        <div class="warnings">
                            <h3>주의사항</h3>
                            
                                <li>체크인은 오후 3시 이후, 체크아웃은 오전 11시까지입니다.</li>
                                <li>객실 내 금연 구역이며, 위반 시 추가 청소비가 부과됩니다.</li>
                                <li>애완동물 동반 입실은 불가합니다.</li>
                                <li>객실 내 외부 음식물 반입은 제한됩니다.</li>
                            
            
                            <h3>이용약관</h3>
                            
                                <li>예약 취소는 체크인 3일 전까지 가능합니다.</li>
                                <li>투숙 중 발생한 손해에 대한 책임은 고객에게 있습니다.</li>
                                <li>모든 투숙객은 호텔 정책과 규정을 준수해야 합니다.</li>
                                <li>호텔은 예고 없이 서비스 제공 조건을 변경할 수 있습니다.</li>
                            
                        </div>
            
                        <button class="reserve-btn">예약 바로가기</button>
                    </div>
                    <div class="room-info-A">
                        <h2>타입 A (2인 기준)</h2>
                        <p>객실은 세련된 디자인과 편안한 분위기를 자랑하며, 넓은 침대와 고급 가구로 구성되어 있습니다. 
                            최신 시설을 갖춘 이 객실은 최적의 휴식을 제공하며, 투숙객의 편의를 위해 다양한 편의시설을 완비하고 있습니다.</p>
            
                        <div class="warnings">
                            <h3>주의사항</h3>
                            
                                <li>체크인은 오후 3시 이후, 체크아웃은 오전 11시까지입니다.</li>
                                <li>객실 내 금연 구역이며, 위반 시 추가 청소비가 부과됩니다.</li>
                                <li>애완동물 동반 입실은 불가합니다.</li>
                                <li>객실 내 외부 음식물 반입은 제한됩니다.</li>
                            
            
                            <h3>이용약관</h3>
                            
                                <li>예약 취소는 체크인 3일 전까지 가능합니다.</li>
                                <li>투숙 중 발생한 손해에 대한 책임은 고객에게 있습니다.</li>
                                <li>모든 투숙객은 호텔 정책과 규정을 준수해야 합니다.</li>
                                <li>호텔은 예고 없이 서비스 제공 조건을 변경할 수 있습니다.</li>
                            
                        </div>
            
                        <button class="reserve-btn">예약 바로가기</button>
                    </div>
                </div>
            </div>
        </section>
    </main>
    <script>
     $(document).ready(function() {
        $("#roomTypeA").click(function() {
            $(".room-info-A").show();
            $(".room-info-B1").hide();
            $(".room-info-B2").hide();
        });
        $("#roomTypeB1").click(function() {
            $(".room-info-A").hide();
            $(".room-info-B1").show();
            $(".room-info-B2").hide();
        });
        $("#roomTypeB2").click(function() {
            $(".room-info-A").hide();
            $(".room-info-B1").hide();
            $(".room-info-B2").show();
        });
     });
</script>