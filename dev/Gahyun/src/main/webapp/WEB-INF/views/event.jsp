<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    

<%@ page session="false" pageEncoding="UTF-8" %>
 <main>
         <section class="facility-title">
          <h1>EVENT</h1>
        </section>
        <div class="event-content">
            <!-- 특별 행사 섹션 -->
            <section class="event-section">
                <h2 class="left-align">특별 행사</h2>
                <div class="event-slider">
                    <img src="${pageContext.request.contextPath}/res/images/outside001.jpg" alt="특별 행사 1" class="active">
                    <img src="${pageContext.request.contextPath}/res/images/pool001.jpg" alt="특별 행사 2">
                    <img src="${pageContext.request.contextPath}/res/images/pool003.jpg" alt="특별 행사 3">
                </div>
            </section>
        
            <!-- 특가 프로모션 섹션 -->
            <section class="promo-section">
                <h2 class="left-align">특가 프로모션</h2>
                <div class="promo-slider">
                    <img src="${pageContext.request.contextPath}/res/images/outside001.jpg" alt="프로모션 1" class="active">
                    <img src="${pageContext.request.contextPath}/res/images/pool001.jpg" alt="프로모션 2">
                    <img src="${pageContext.request.contextPath}/res/images/pool003.jpg" alt="프로모션 3">
                </div>
            </section>
        </div>
    </main>
        <script>
        // 슬라이드 이미지 변경을 위한 JavaScript
        let slideIndex = 0;
        const eventSlides = document.querySelectorAll('.event-slider img');
        const promoSlides = document.querySelectorAll('.promo-slider img');
        const totalEventSlides = eventSlides.length;
        const totalPromoSlides = promoSlides.length;

        function showSlides() {
            eventSlides.forEach((slide, index) => {
                slide.style.display = (index === slideIndex) ? 'block' : 'none';
            });
            promoSlides.forEach((slide, index) => {
                slide.style.display = (index === slideIndex) ? 'block' : 'none';
            });
            slideIndex = (slideIndex + 1) % totalEventSlides; // 다음 이미지로 넘어감
        }

        // 4초마다 이미지 변경
        setInterval(showSlides, 4000);

        // 초기 첫 이미지 표시
        showSlides();
    </script>