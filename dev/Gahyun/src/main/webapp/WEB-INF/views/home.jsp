<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    

<%@ page session="false" pageEncoding="UTF-8" %>

         <main>
        <div class="hero">
            <img class="hero-image" src="${pageContext.request.contextPath}/res/images/outside001.jpg" alt="Image Slider" />
            <img class="hero-image" src="${pageContext.request.contextPath}/res/images/pool001.jpg" alt="Image Slider" />
            <img class="hero-image" src="${pageContext.request.contextPath}/res/images/waterfall.jpg" alt="Image Slider" />
            <img class="hero-image" src="${pageContext.request.contextPath}/res/images/rooftop007.jpg" alt="Image Slider" />
        </div>
        
            <!-- 예약 바 -->
            <div class="reservation-bar">
                <h3>예약하기</h3>
                <form class="reservation-bar-form">
                    <div class="bar-group">
                        <label for="date">날짜:</label>
                        <input type="date" id="date" name="date" required>
                    </div>
                    <div class="bar-group">
                        <label for="room-type">룸 타입:</label>
                        <select id="room-type" name="room-type" required>
                            <option value="">선택하세요</option>
                            <option value="standard">타입A</option>
                            <option value="deluxe">타입B(침대O)</option>
                            <option value="suite">타입B(침대X)</option>
                        </select>
                    </div>
                    <div class="bar-group">
                        <label for="guests">인원:</label>
                        <input type="number" id="guests" name="guests" min="1" required>
                    </div>
                    <button type="submit">예약하기</button>
                </form>
            </div>
        
            
            
        
            <!-- 이벤트 섹션 -->
            <div class="main-event">
                <div class="main-event-container">
                    <div class="main-event-header">
                        <h2>이벤트</h2>
                        <p>가현리조트만의</p>
                        <p>특별한 이벤트</p>
                    </div>
                    <div class="event-slider-controls">
                        <button class="prev1">&#60;</button>
                        <button class="next1">&#62;</button>
                    </div>
                </div>
                <div class="event-slide-view">
                    <div class="event-slider1">
                        <div class="event-slider-box">
                            <div class="event">
                                <img class="img" src="${pageContext.request.contextPath}/res/images/breakfast004.jpg" alt="Event 1" />
                                <div class="event-info">
                                    <strong>특가 이벤트 1</strong><br>
                                    24.01.01 ~ 24.12.12
                                </div>
                            </div>
                            <div class="event">
                                <img class="img" src="${pageContext.request.contextPath}/res/images/breakfast003.jpg" alt="Event 2" />
                                <div class="event-info">
                                    <strong>특가 이벤트 2</strong><br>
                                    24.01.01 ~ 24.12.12
                                </div>
                            </div>
                            <div class="event">
                                <img class="img" src="${pageContext.request.contextPath}/res/images/breakfast002.jpg" alt="Event 3" />
                                <div class="event-info">
                                    <strong>특가 이벤트 3</strong><br>
                                    24.01.01 ~ 24.12.12
                                </div>
                            </div>
                        </div>
                        <div class="event-slider-box">
                            <div class="event">
                                <img class="img" src="${pageContext.request.contextPath}/res/images/arcade1.jpg" alt="Event 1" />
                                <div class="event-info">
                                    <strong>특가 이벤트 1</strong><br>
                                    24.01.01 ~ 24.12.12
                                </div>
                            </div>
                            <div class="event">
                                <img class="img" src="${pageContext.request.contextPath}/res/images/arcade2.jpg" alt="Event 2" />
                                <div class="event-info">
                                    <strong>특가 이벤트 2</strong><br>
                                    24.01.01 ~ 24.12.12
                                </div>
                            </div>
                            <div class="event">
                                <img class="img" src="${pageContext.request.contextPath}/res/images/arcade3.jpg" alt="Event 3" />
                                <div class="event-info">
                                    <strong>특가 이벤트 3</strong><br>
                                    24.01.01 ~ 24.12.12
                                </div>
                            </div>
                        </div>
                        <div class="event-slider-box">
                            <div class="event">
                                <img class="img" src="${pageContext.request.contextPath}/res/images/shopping1.jpg" alt="Event 1" />
                                <div class="event-info">
                                    <strong>특가 이벤트 1</strong><br>
                                    24.01.01 ~ 24.12.12
                                </div>
                            </div>
                            <div class="event">
                                <img class="img" src="${pageContext.request.contextPath}/res/images/shopping2.jpg" alt="Event 2" />
                                <div class="event-info">
                                    <strong>특가 이벤트 2</strong><br>
                                    24.01.01 ~ 24.12.12
                                </div>
                            </div>
                            <div class="event">
                                <img class="img" src="${pageContext.request.contextPath}/res/images/ski.jpg" alt="Event 3" />
                                <div class="event-info">
                                    <strong>특가 이벤트 3</strong><br>
                                    24.01.01 ~ 24.12.12
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            

        </div>
        
        
            
        <div class="main-facilities">
          <div class="spa-image">
              <img class="rectangle-3" src="${pageContext.request.contextPath}/res/images/spa001.jpg" alt="Spa" />
          </div>
          <div class="spa-text">
              <h2>Relaxable Spa</h2>
              <a href="#">스파에 대해 더 알아보기 &#62;</a>
          </div>
        </div>
    </main>
    
    
    <script>
    $(document).ready(function() {
        // 슬라이드 이미지 설정
        const images = $('.hero-image'); // 모든 이미지 선택
        let currentImageIndex = 0; // 현재 이미지 인덱스 초기화

        // 첫 번째 이미지를 보이게 설정
        images.eq(currentImageIndex).addClass('active');

        function changeImage() {
            images.removeClass('active'); // 현재 이미지 숨김
            currentImageIndex = (currentImageIndex + 1) % images.length; // 인덱스 증가 및 순환
            images.eq(currentImageIndex).addClass('active'); // 다음 이미지 보임
        }

        // 4초마다 이미지 변경
        setInterval(changeImage, 4000);

        /***********************************************************************************************/

        // 이벤트 슬라이더 설정
        let currentIndex = 0;

const prevButton = document.querySelector('.prev1');
const nextButton = document.querySelector('.next1');
const sliderBoxes = document.querySelectorAll('.event-slider-box');

function updateSlider() {
    sliderBoxes.forEach((box, index) => {
        box.style.transform = `translateX(${-currentIndex * 100}%)`;
    });
}

prevButton.addEventListener('click', () => {
    currentIndex = (currentIndex > 0) ? currentIndex - 1 : sliderBoxes.length - 1;
    updateSlider();
});

nextButton.addEventListener('click', () => {
    currentIndex = (currentIndex < sliderBoxes.length - 1) ? currentIndex + 1 : 0;
    updateSlider();
});

// 초기 슬라이더 상태 업데이트
updateSlider();
});
</script>