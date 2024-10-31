<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    

<%@ page session="false" pageEncoding="UTF-8" %>



         <main>
        <div class="hero">
            <img class="hero-image" src="${pageContext.request.contextPath}/res/images/outside001.jpg" alt="Image Slider"loading="lazy"/>
            <img class="hero-image" src="${pageContext.request.contextPath}/res/images/pool001.jpg" alt="Image Slider" loading="lazy"/>
            <img class="hero-image" src="${pageContext.request.contextPath}/res/images/waterfall.jpg" alt="Image Slider" loading="lazy"/>
            <img class="hero-image" src="${pageContext.request.contextPath}/res/images/rooftop007.jpg" alt="Image Slider" loading="lazy" />
        </div>
        
            <!-- 예약 바 -->
            <div class="reservation-bar">
            	<div class="resevation-bar-title">
	            	<i class="ri-hotel-bed-line"></i>
	                <p>예약하기</p>
                </div>
                <form class="reservation-bar-form">
                    <div class="bar-group">
                        <label for="date">체크인날짜:</label>
                        <input type="date" id="bar-checkin-date" name="bar-checkin-date" required>
                    </div>
                    <div class="bar-group">
                        <label for="date">체크아웃날짜:</label>
                        <input type="date" id="bar-checkout-date" name="bar-checkout-date" required>
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
                    <button type="submit" class="reservation-bar-button" onclick="location.href='/dev/Reservation1'">예약하기</button>
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
              <a href="/dev/facilites">시설 더 알아보기 <i class="ri-arrow-right-line"></i></a>
          </div>
        </div>
    </main>
   
    
    
    