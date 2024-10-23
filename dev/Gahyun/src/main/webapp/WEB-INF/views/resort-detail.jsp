 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    

<%@ page session="false" pageEncoding="UTF-8" %>
 
 
 
 <main>
        <section class="detail-banner">
            <h1>가현리조트 소개</h1>
            <div class="detail-banner-slider">
                <div class="slides">
                    <div class="slide active">
                        <img src="${pageContext.request.contextPath}/res/images/bannerimg/resortDetail1.jpg" alt="Resort Image 1">
                    </div>
                    <div class="slide">
                        <img src="${pageContext.request.contextPath}/res/images/bannerimg/resortDetail2.jpg" alt="Resort Image 2">
                    </div>
                    <div class="slide">
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

    //카카오 지도 스크립트
        var container = document.getElementById('kakaoMap'); // 지도를 담을 영역의 DOM 레퍼런스
        var options = {
            center: new kakao.maps.LatLng(37.6459, 126.6755), // 지도의 중심좌표 (위도, 경도 변경 가능)
            level: 5 // 지도의 확대 레벨
        };
        var map = new kakao.maps.Map(container, options); // 지도 생성 및 객체 리턴
    
    
        let currentSlide = 1; // 현재 슬라이드 인덱스 (복사본을 고려하여 1로 시작)
    const slidesContainer = document.querySelector('.slides');
    const slides = document.querySelectorAll('.slide');
    const totalSlides = slides.length;
    
    // 첫 번째 슬라이드와 마지막 슬라이드를 복사하여 무한 슬라이드 효과 만들기
    const firstSlideClone = slides[0].cloneNode(true);
    const lastSlideClone = slides[totalSlides - 1].cloneNode(true);
    
    // 복사본 추가: 첫 번째 슬라이드는 마지막 뒤에, 마지막 슬라이드는 첫 번째 앞에 추가
    slidesContainer.appendChild(firstSlideClone);
    slidesContainer.insertBefore(lastSlideClone, slides[0]);
    
    // 슬라이드 초기 위치 설정 (복사된 슬라이드가 추가된 상태에서 시작)
    slidesContainer.style.transform = `translateX(-100%)`;
    
    // 슬라이드 이동 함수
    function moveToSlide(index) {
        // 슬라이드가 이동하는 부분에 애니메이션 설정
        slidesContainer.style.transition = 'transform 0.5s ease-in-out';
        slidesContainer.style.transform = `translateX(-${index * 100}%)`;
    
        // 슬라이드 전환이 끝나면 복사본에서 실제 슬라이드로 점프
        slidesContainer.addEventListener('transitionend', () => {
            // 마지막 복사본에서 첫 번째 슬라이드로 이동
            if (index === totalSlides + 1) {
                slidesContainer.style.transition = 'none'; // 애니메이션 제거
                currentSlide = 1; // 실제 첫 번째 슬라이드로 이동
                slidesContainer.style.transform = `translateX(-100%)`;
            }
    
            // 첫 번째 복사본에서 마지막 슬라이드로 이동
            if (index === 0) {
                slidesContainer.style.transition = 'none'; // 애니메이션 제거
                currentSlide = totalSlides; // 실제 마지막 슬라이드로 이동
                slidesContainer.style.transform = `translateX(-${totalSlides * 100}%)`;
            }
        }, { once: true });
    }
    
    // 슬라이드를 일정 간격으로 자동으로 이동시키는 함수
    function startAutoSlide() {
        setInterval(() => {
            currentSlide++; // 슬라이드 인덱스 증가
            moveToSlide(currentSlide); // 슬라이드 이동 호출
        }, 3000); // 3초 간격으로 슬라이드 이동
    }
    
    // 이전 슬라이드로 이동하는 함수
    function moveToPrevSlide() {
        currentSlide--;
        moveToSlide(currentSlide);
    }
    
    // 다음 슬라이드로 이동하는 함수
    function moveToNextSlide() {
        currentSlide++;
        moveToSlide(currentSlide);
    }
    
    // 자동 슬라이드 시작
    startAutoSlide();
    
    // 버튼을 눌러 슬라이드를 제어할 수 있는 이벤트 연결
    document.querySelector('.prev').addEventListener('click', moveToPrevSlide);
    document.querySelector('.next').addEventListener('click', moveToNextSlide);
    </script>