<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    

<%@ page session="false" pageEncoding="UTF-8" %>
 <div class="container">
        <main class="event-content">
            <!-- 특별 행사 섹션 -->
            <section class="event-section">
                <h2 class="left-align">특별 행사</h2>
                <div class="event-slider">
                    <img src="../../images/outside001.jpg" alt="특별 행사 1" class="active">
                    <img src="../../images/pool001.jpg" alt="특별 행사 2">
                    <img src="../../images/pool003.jpg" alt="특별 행사 3">
                </div>
            </section>
        
            <!-- 특가 프로모션 섹션 -->
            <section class="promo-section">
                <h2 class="left-align">특가 프로모션</h2>
                <div class="promo-slider">
                    <img src="../../images/outside001.jpg" alt="프로모션 1" class="active">
                    <img src="../../images/pool001.jpg" alt="프로모션 2">
                    <img src="../../images/pool003.jpg" alt="프로모션 3">
                </div>
            </section>
        </main>
    </div>