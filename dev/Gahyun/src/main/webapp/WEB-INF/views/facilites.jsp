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
                <img src="${pageContext.request.contextPath}/res/images/breakfast001.webp" alt="조식뷔페" loading="lazy">
                <p>조식뷔페 <span>Tiffany</span></p>
              </div>
              <div class="facility-card">
                <img src="${pageContext.request.contextPath}/res/images/breakfast002.webp" alt="비건전문" loading="lazy">
                <p>비건전문 <span>La'bia</span></p>
              </div>
              <div class="facility-card">
                <img src="${pageContext.request.contextPath}/res/images/party001.webp" alt="파티" loading="lazy">
                <p>파티룸 <span>Party</span></p>
              </div>
              <div class="facility-card">
                <img src="${pageContext.request.contextPath}/res/images/cafe.webp" alt="카페" loading="lazy">
                <p>카페 <span>Cafe</span></p>
              </div>
              <div class="facility-card">
                <img src="${pageContext.request.contextPath}/res/images/rooftop006.webp" alt="루프탑" loading="lazy">
                <p>루프탑 <span>Rooftop</span></p>
              </div>
              <div class="facility-card">
                <img src="${pageContext.request.contextPath}/res/images/dining002.webp" alt="레스토랑" loading="lazy">
                <p>레스토랑 <span>Restaurant</span></p>
              </div>
            </div>
    
            <h3 id="facilities-convenient">편의시설</h3>
          
            <div class="facility-grid-slider">
              <div class="facility-card fffimg">
                <img src="${pageContext.request.contextPath}/res/images/gym007.webp" alt="피트니스" loading="lazy">
                <p>피트니스 <span>Tiffany</span></p>
              </div>
              <div class="facility-card">
                <img src="${pageContext.request.contextPath}/res/images/spa002.webp" alt="스파" loading="lazy">
                <p>스파 <span>Spa</span></p>
              </div>
              <div class="facility-card">
                <img src="${pageContext.request.contextPath}/res/images/yoga001.webp" alt="요가" loading="lazy">
                <p>요가 <span>Yoga</span></p>
              </div>
              <div class="facility-card">
                <img src="${pageContext.request.contextPath}/res/images/pool001.webp" alt="수영장" loading="lazy">
                <p>수영장 <span>Pool</span></p>
              </div>
              <div class="facility-card">
                <img src="${pageContext.request.contextPath}/res/images/ski.webp" alt="비건전문" loading="lazy">
                <p>스키장 <span>Ski</span></p>
              </div>
              <div class="facility-card">
                <img src="${pageContext.request.contextPath}/res/images/convenience.webp" alt="조식" loading="lazy">
                <p>편의점 <span>Store</span></p>
              </div>
            </div>
    
            <h3 id="facilities-game">ENJOY</h3>
          
            <div class="facility-grid-slider">
              <div class="facility-card fffimg">
                <img src="${pageContext.request.contextPath}/res/images/arcade1.webp" alt="조식뷔페" loading="lazy">
                <p>오락실 <span>Jolly</span></p>
              </div>
              <div class="facility-card">
                <img src="${pageContext.request.contextPath}/res/images/arcade2.webp" alt="비건전문" loading="lazy">
                <p>당구장 <span>Hit’O</span></p>
              </div>
              <div class="facility-card">
                <img src="${pageContext.request.contextPath}/res/images/arcade3.webp" alt="조식" loading="lazy">
                <p>볼링장<span>Bowling</span></p>
              </div>
              <div class="facility-card">
              <img src="${pageContext.request.contextPath}/res/images/arcade4vr.webp" alt="조식뷔페" loading="lazy">
              <p>VR존</p>
            </div>
            </div>
    
          </div>
    
        </section>
      </main>  
