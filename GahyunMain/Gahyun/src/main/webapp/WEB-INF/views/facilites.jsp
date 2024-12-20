<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    

<%@ page session="false" pageEncoding="UTF-8" %>


<main>
  <section class="facility-title">
    <h1>리조트시설</h1>
  </section>

  <section class="facilities">
    <h3 id="facilities-dining">다이닝</h3>
    <div class="facility-slider-container">
      <div class="facility-grid-slider">
        <div class="facility-card" onclick="toggleText(this)">
		  <div class="img-container">
		    <img src="${pageContext.request.contextPath}/res/images/breakfast001.webp" alt="조식뷔페" loading="lazy">
		  </div>
		  <p class="facility-title">조식뷔페 <span>Tiffany</span></p>
		  <p class="facility-description">신선한 재료로 준비한 다양한 메뉴</p>
		  <p class="facility-description">든든한 아침으로 활력을 채우세요.</p>
		</div>
		
		<div class="facility-card" onclick="toggleText(this)">
		  <div class="img-container">
		    <img src="${pageContext.request.contextPath}/res/images/breakfast002.webp" alt="비건전문" loading="lazy">
		  </div>
		  <p class="facility-title">비건 전문 <span>La'bia</span></p>
		  <p class="facility-description">건강한 비건 메뉴를 만나보세요.</p>
		  <p class="facility-description">누구나 즐길 수 있는 풍성한 식탁</p>
		</div>
		
		<div class="facility-card" onclick="toggleText(this)">
		  <div class="img-container">
		    <img src="${pageContext.request.contextPath}/res/images/party001.webp" alt="파티룸" loading="lazy">
		  </div>
		  <p class="facility-title">파티룸 <span>Party</span></p>
		  <p class="facility-description">소중한 날을 함께 축하하는 공간</p>
		  <p class="facility-description">친구들과 추억을 만들어 보세요.</p>
		</div>
		
		<div class="facility-card" onclick="toggleText(this)">
		  <div class="img-container">
		    <img src="${pageContext.request.contextPath}/res/images/cafe.webp" alt="카페" loading="lazy">
		  </div>
		  <p class="facility-title">카페 <span>Cafe</span></p>
		  <p class="facility-description">커피 한잔의 여유로움을 만끽</p>
		  <p class="facility-description">다양한 음료와 디저트가 준비됨</p>
		</div>
		
		<div class="facility-card" onclick="toggleText(this)">
		  <div class="img-container">
		    <img src="${pageContext.request.contextPath}/res/images/rooftop006.webp" alt="루프탑" loading="lazy">
		  </div>
		  <p class="facility-title">루프탑 <span>Rooftop</span></p>
		  <p class="facility-description">도심 속 하늘 아래 자유로움</p>
		  <p class="facility-description">저녁 노을과 함께하는 여유로움</p>
		</div>
		
		<div class="facility-card" onclick="toggleText(this)">
		  <div class="img-container">
		    <img src="${pageContext.request.contextPath}/res/images/dining002.webp" alt="레스토랑" loading="lazy">
		  </div>
		  <p class="facility-title">레스토랑 <span>Restaurant</span></p>
		  <p class="facility-description">다채로운 요리와 정성 가득한 메뉴</p>
		  <p class="facility-description">특별한 미식 경험을 선사합니다.</p>
		</div>
      </div>
    </div>

    <h3 id="facilities-convenient">편의시설</h3>
    <div class="facility-slider-container">
      <div class="facility-grid-slider">
        <div class="facility-card" onclick="toggleText(this)">
			  <div class="img-container">
			    <img src="${pageContext.request.contextPath}/res/images/gym007.webp" alt="피트니스" loading="lazy">
			  </div>
			  <p class="facility-title">피트니스 <span>Fitness</span></p>
			  <p class="facility-description">최신 기구로 체력을 단련하세요.</p>
			  <p class="facility-description">쾌적한 환경에서 운동을 즐기세요.</p>
			</div>
			
			<div class="facility-card" onclick="toggleText(this)">
			  <div class="img-container">
			    <img src="${pageContext.request.contextPath}/res/images/spa002.webp" alt="스파" loading="lazy">
			  </div>
			  <p class="facility-title">스파 <span>Spa</span></p>
			  <p class="facility-description">휴식을 위한 스파 프로그램</p>
			  <p class="facility-description">마음을 편안하게 힐링해보세요.</p>
			</div>
			
			<div class="facility-card" onclick="toggleText(this)">
			  <div class="img-container">
			    <img src="${pageContext.request.contextPath}/res/images/yoga001.webp" alt="요가" loading="lazy">
			  </div>
			  <p class="facility-title">요가 <span>Yoga</span></p>
			  <p class="facility-description">자연 속 요가로 내면의 평화</p>
			  <p class="facility-description">심신의 안정을 느껴보세요.</p>
			</div>
			
			<div class="facility-card" onclick="toggleText(this)">
			  <div class="img-container">
			    <img src="${pageContext.request.contextPath}/res/images/pool001.webp" alt="수영장" loading="lazy">
			  </div>
			  <p class="facility-title">수영장 <span>Pool</span></p>
			  <p class="facility-description">시원한 수영장에서 여유를 즐기세요.</p>
			  <p class="facility-description">자유롭게 수영하며 더위를 피하세요.</p>
			</div>
			
			<div class="facility-card" onclick="toggleText(this)">
			  <div class="img-container">
			    <img src="${pageContext.request.contextPath}/res/images/ski.webp" alt="스키장" loading="lazy">
			  </div>
			  <p class="facility-title">스키장 <span>Ski</span></p>
			  <p class="facility-description">겨울 스포츠의 짜릿함을 느껴보세요.</p>
			  <p class="facility-description">최고의 설질을 자랑하는 스키장</p>
			</div>
			
			<div class="facility-card" onclick="toggleText(this)">
			  <div class="img-container">
			    <img src="${pageContext.request.contextPath}/res/images/convenience.webp" alt="편의점" loading="lazy">
			  </div>
			  <p class="facility-title">편의점 <span>Store</span></p>
			  <p class="facility-description">필요한 물품을 편리하게 구매하세요</p>
			  <p class="facility-description">24시간 운영하는 편의 시설</p>
			</div>
      </div>
    </div>

    <h3 id="facilities-game">ENJOY</h3>
    <div class="facility-slider-container">
      <div class="facility-grid-slider">
		<div class="facility-card" onclick="toggleText(this)">
		  <div class="img-container">
		    <img src="${pageContext.request.contextPath}/res/images/arcade1.webp" alt="오락실" loading="lazy">
		  </div>
		  <p class="facility-title">오락실 <span>Arcade</span></p>
		  <p class="facility-description">모두가 즐길 수 있는 다양한 게임</p>
		  <p class="facility-description">추억 속의 오락을 경험해보세요.</p>
		</div>
		
		<div class="facility-card" onclick="toggleText(this)">
		  <div class="img-container">
		    <img src="${pageContext.request.contextPath}/res/images/arcade2.webp" alt="당구장" loading="lazy">
		  </div>
		  <p class="facility-title">당구장 <span>Billiards</span></p>
		  <p class="facility-description">친구들과 함께 즐거운 당구 시간</p>
		  <p class="facility-description">편안한 공간에서 게임을 즐기세요.</p>
		</div>
		
		<div class="facility-card" onclick="toggleText(this)">
		  <div class="img-container">
		    <img src="${pageContext.request.contextPath}/res/images/arcade3.webp" alt="볼링장" loading="lazy">
		  </div>
		  <p class="facility-title">볼링장 <span>Bowling</span></p>
		  <p class="facility-description">함께하는 활기찬 볼링 시간</p>
		  <p class="facility-description">친구들과 신나게 공을 굴려보세요.</p>
		</div>
		
		<div class="facility-card" onclick="toggleText(this)">
		  <div class="img-container">
		    <img src="${pageContext.request.contextPath}/res/images/arcade4vr.webp" alt="VR존" loading="lazy">
		  </div>
		  <p class="facility-title">VR존 <span>VR Zone</span></p>
		  <p class="facility-description">몰입감 높은 최신 VR 게임</p>
		  <p class="facility-description">새로운 가상 현실을 경험하세요.</p>
		</div>
      </div>
    </div>
  </section>
</main>



