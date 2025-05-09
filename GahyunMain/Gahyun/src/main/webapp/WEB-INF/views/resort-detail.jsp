 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    

<%@ page session="false" pageEncoding="UTF-8" %>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> <!-- jQuery 최신 버전 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4c182db7c64c150bf09b9c0fd8b9c8b0"></script>
 
 
 <main>
        <section class="detail-banner">
            <h1>가현리조트 소개</h1>
            <div class="detail-banner-slider">
                <div class="slidesR">
                    <div class="slideR">
                        <img src="${pageContext.request.contextPath}/res/images/bannerimg/resortDetail1.jpg" alt="Resort Image 1">
                    </div>
                    <div class="slideR">
                        <img src="${pageContext.request.contextPath}/res/images/bannerimg/resortDetail2.jpg" alt="Resort Image 2">
                    </div>
                    <div class="slideR">
                        <img src="${pageContext.request.contextPath}/res/images/bannerimg/resortDetail3.jpg" alt="Resort Image 3">
                    </div>
                </div>
                <button class="prev" onclick="moveSlide(-1)">&#10094;</button>
                <button class="next" onclick="moveSlide(1)">&#10095;</button>
            </div>
            
        </section>

        <section class="info">
            <h2>오시는 길</h2>
            <div class="location-info">
                <div class="map">
                    <div id="kakaoMap" style="width:100%;height:300px;"></div> <!-- 카카오 지도 영역 -->
                </div>
                <div class="public-transport">
                    <h3>대중교통</h3>
                    <p>버스: nnn번 버스</p>
                    <p>지하철: nnn호선 nnn역</p>
                    <p>nn역과 nnn역에서 리조트까지 왕복하는 셔틀버스 운행 (10:00 - 22:00)</p>
                </div>
            </div>
        </section>
    </main>
</body>
<script>
	var container = document.getElementById('kakaoMap'); // 지도를 담을 영역의 DOM 레퍼런스
	var options = {
	    center: new kakao.maps.LatLng(37.6459, 126.6755), // 지도의 중심좌표
	    level: 5 // 지도의 확대 레벨
	};
	var map = new kakao.maps.Map(container, options); // 지도 생성 및 객체 리턴
	
	
	
   

</script>




    
    
    