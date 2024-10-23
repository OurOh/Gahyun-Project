<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    

<%@ page session="false" pageEncoding="UTF-8" %>


<main>
        <section class="facility-title">
          <h1>리조트시설</h1>
        </section>
      
        <section class="facilities">
          <h3 id="facilities-dining">다이닝</h3>
    
          <!-- facility slider with drag functionality -->
          <div class="facility-slider-container">
            <div class="facility-grid-slider">
              <div class="facility-card fffimg">
                <img src="${pageContext.request.contextPath}/res/images/breakfast001.jpg" alt="조식뷔페">
                <p>조식뷔페 <span>Tiffany</span></p>
              </div>
              <div class="facility-card">
                <img src="${pageContext.request.contextPath}/res/images/breakfast002.jpg" alt="비건전문">
                <p>비건전문 <span>La'bia</span></p>
              </div>
              <div class="facility-card">
                <img src="${pageContext.request.contextPath}/res/images/party001.jpg" alt="파티">
                <p>파티룸 <span>Party</span></p>
              </div>
              <div class="facility-card">
                <img src="${pageContext.request.contextPath}/res/images/cafe.jpg" alt="카페">
                <p>카페 <span>Cafe</span></p>
              </div>
              <div class="facility-card">
                <img src="${pageContext.request.contextPath}/res/images/rooftop006.jpg" alt="루프탑">
                <p>루프탑 <span>Rooftop</span></p>
              </div>
              <div class="facility-card">
                <img src="${pageContext.request.contextPath}/res/images/dining002.jpg" alt="레스토랑">
                <p>레스토랑 <span>Restaurant</span></p>
              </div>
            </div>
    
            <h3 id="facilities-convenient">편의시설</h3>
          
            <div class="facility-grid-slider">
              <div class="facility-card fffimg">
                <img src="${pageContext.request.contextPath}/res/images/gym007.jpg" alt="피트니스">
                <p>피트니스 <span>Tiffany</span></p>
              </div>
              <div class="facility-card">
                <img src="${pageContext.request.contextPath}/res/images/spa002.jpg" alt="스파">
                <p>스파 <span>Spa</span></p>
              </div>
              <div class="facility-card">
                <img src="${pageContext.request.contextPath}/res/images/yoga001.jpg" alt="요가">
                <p>요가 <span>Yoga</span></p>
              </div>
              <div class="facility-card">
                <img src="${pageContext.request.contextPath}/res/images/pool001.jpg" alt="수영장">
                <p>수영장 <span>Pool</span></p>
              </div>
              <div class="facility-card">
                <img src="${pageContext.request.contextPath}/res/images/ski.jpg" alt="비건전문">
                <p>스키장 <span>Ski</span></p>
              </div>
              <div class="facility-card">
                <img src="${pageContext.request.contextPath}/res/images/convenience.jpg" alt="조식">
                <p>편의점 <span>Store</span></p>
              </div>
            </div>
    
            <h3 id="facilities-game">ENJOY</h3>
          
            <div class="facility-grid-slider">
              <div class="facility-card fffimg">
                <img src="${pageContext.request.contextPath}/res/images/arcade1.jpg" alt="조식뷔페">
                <p>오락실 <span>Jolly</span></p>
              </div>
              <div class="facility-card">
                <img src="${pageContext.request.contextPath}/res/images/arcade2.jpg" alt="비건전문">
                <p>당구장 <span>Hit’O</span></p>
              </div>
              <div class="facility-card">
                <img src="${pageContext.request.contextPath}/res/images/arcade3.jpg" alt="조식">
                <p>볼링장<span>Bowling</span></p>
              </div>
              <div class="facility-card">
              <img src="${pageContext.request.contextPath}/res/images/arcade4vr.jpg" alt="조식뷔페">
              <p>VR존</p>
            </div>
            </div>
    
          </div>
    
        </section>
      </main>  
<script>
    $(document).ready(function() {
      $('.facility-grid-slider').each(function() {
        const $slider = $(this);
        let isDragging = false;
        let startX, scrollLeft;
    
        $slider.on('mousedown', function(e) {
          isDragging = true;
          startX = e.pageX - $slider.offset().left;
          scrollLeft = $slider.scrollLeft();
          $slider.css('cursor', 'grabbing');
          e.preventDefault();
        });
    
        $(window).on('mousemove', function(e) {
          if (!isDragging) return;
          const x = e.pageX - $slider.offset().left;
          const walk = (x - startX) * 2;
          $slider.scrollLeft(scrollLeft - walk);
        });
    
        $(window).on('mouseup', function() {
          isDragging = false;
          $slider.css('cursor', 'grab');
        });
    
        $slider.on('mouseleave', function() {
          isDragging = false;
          $slider.css('cursor', 'grab');
        });
      });
    });
</script>