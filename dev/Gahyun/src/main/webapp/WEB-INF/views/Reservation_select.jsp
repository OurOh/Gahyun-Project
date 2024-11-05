<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    

<%@ page session="false" pageEncoding="UTF-8" %>

<main>
<section class="reservation-section">
	<h1>예약페이지</h1>
	<form name="findAvailableRooms" method="POST">
       <div class="date-selection">
	      <p>예약하실 날짜와 인원수를 선택하세요</p>
	      <div class="reservation-container">
	         <div class="api-placeholder">
	            <div class="startdate" ></div>
	            <div class="enddate"  ></div>
	            <input type="hidden"  id="startdateval" name="startDate" class="startdateval" />
	            <input type="hidden"  id="enddateval" name="endDate" class="enddateval"/>
	         </div>
	         <div class="guest-selection">
	            <div class="input-group">
	            <label>객실 수</label>
	            <div class="control-buttons">
	            <button class="control-button" type="button" onclick="event.preventDefault(); decrease('roomCount')">-</button>
	            <span id="roomCount">1</span>
	            <button class="control-button" onclick="event.preventDefault(); increase('roomCount')">+</button>
	            <input type="hidden" type="button"  name="roomCount" class="roomCountval" id="roomCountInput" value=1 />
	         </div>
	       </div>
	                        <div class="input-group">
	                            <label>인원</label>
	                            <div class="control-buttons">
	                                <button class="control-button" onclick="event.preventDefault();decrease('guestCount')">-</button>
	                                <span id="guestCount">1</span>
	                                <button class="control-button" onclick="event.preventDefault(); increase('guestCount')">+</button>
	                                <input type="hidden" name="guestCount" class="guestCountval" id="guestCountInput" value=1 />
	                            </div>
	                        </div>
	                        <button class="room-search-button" type="submit">객실검색</button>
	                    </div>
	                </div>
	            </div>
</form>
            <div class="recommended-rooms">
                <h2 class="recommended-title">추천 객실</h2>
                <div class="rooms-list">
                    <div class="room-card">
   
                        <img src="${pageContext.request.contextPath}/res/images/room001.jpg" alt="객실 이미지">
                        <p>객실 타입: 타입A<br>조식: 불포함</p>
                    </div>
                    <div class="room-card">
                        <img src="${pageContext.request.contextPath}/res/images/room002.jpg" alt="객실 이미지">
                        <p>객실 타입: 타입A<br>조식: 불포함</p>
                    </div>
                    <div class="room-card">
                        <img src="${pageContext.request.contextPath}/res/images/images/room003.jpg" alt="객실 이미지">
                        <p>객실 타입: 타입A<br>조식: 불포함</p>
                    </div>
                    <div class="room-card">
                        <img src="${pageContext.request.contextPath}/res/images/images/room004.jpg" alt="객실 이미지">
                        <p>객실 타입: 타입A<br>조식: 불포함</p>
                    </div>
                    <div class="room-card">
                        <img src="${pageContext.request.contextPath}/res/images/images/room005.jpg" alt="객실 이미지">
                        <p>객실 타입: 타입A<br>조식: 불포함</p>
                    </div>
                    <div class="room-card">
                        <img src="${pageContext.request.contextPath}/res/images/images/room006.jpg" alt="객실 이미지">
                        <p>객실 타입: 타입A<br>조식: 불포함</p>
                    </div>
                </div>
                <button class="next-button" type="button" onclick="location.href='/dev/Reservation2'">다음으로</button>
            </div>
        </section>
</main>
<script>
	$(document).ready(function() {
	  
		function getUrlParameter(name) {
	        const results = new RegExp('[?&]' + name + '=([^&#]*)').exec(window.location.href);
	        return results ? decodeURIComponent(results[1]) : null;
	    }
		
		const roomCount1 = getUrlParameter('roomCount');
		const guestCount1 = getUrlParameter('guestCount');
		const startDate1 = getUrlParameter('startDate');
		const endDate1 = getUrlParameter('endDate');
		
		if (roomCount1) {
	        $('#roomCountInput').val(roomCount1);
	        $('#roomCount').text(roomCount1);
	    }
	    if (guestCount1) {
	        $('#guestCountInput').val(guestCount1);
	        $('#guestCount').text(guestCount1);
	    }
	    if (startDate1) {
	        $('#startdateval').val(startDate1);
	        $(".startdate").datepicker("setDate", startDate1);
	    }
	    if (endDate1) {
	        $('#enddateval').val(endDate1);
	        $(".enddate").datepicker("setDate", endDate1);
	    }
		
	    	
        if (roomCount1 && guestCount1 && startDate1 && endDate1) {
            $.ajax({
                url: "/dev/available1",
                type: "POST",
                contentType: "application/json",
                data:  JSON.stringify({
                	roomCount: parseInt(roomCount1, 10),
                    guestCount: parseInt(guestCount1, 10),
                    startDate: startDate1,
                    endDate: endDate1
                }),
                success: function(response){
	   				var roomList = $('.rooms-list');
	   				roomList.empty();
	   				
	   				if (response.length > 0) {
	                   	$('.recommended-title').text('사용 가능 객실');
	               	} else {
	                   	$('.recommended-title').text('추천 객실');
	               	}
	   				
	   				
	   				//받은 데이터 표시
	   				$.each(response, function(index, room){
						
	   					console.log("Room ID:", room.roomId);
	   				    console.log("Room Name:", room.roomName);
	   				    console.log("Room Type:", room.roomType);
	   				    console.log("Price per Night:", room.pricePerNight);
	   				    console.log("Capacity:", room.capacity);
	   					
	   					
		   				const roomId = room.roomId;
		   			    const roomName = room.roomName;
		   			    const roomType = room.roomType;
		   			    const pricePerNight = room.pricePerNight;
		   			    const capacity = room.capacity;
		   			    const imageUrl = (room.photos && room.photos.length > 0) ? room.photos[0].photoUrl : '/default/image.jpg';
		 
		   			    const roomCard = 
		   			    	'<div class="room-card" data-room-id="' + room.roomId + '" onclick="toggleText(this)">' +
		   			        '<img src="/dev' + imageUrl + '" alt="객실 이미지">' +
		   			        '<p>객실 타입: ' + room.roomType + '<br>조식: 불포함</p>' +
		   			    	'</div>';
				
	   					roomList.append(roomCard);
	   				});	

	   			},
	   			error: function(xhr, status, error) {
	                console.error("에러 발생:", error);
	            }
            });
        } else {
            console.error("예약 정보를 모두 입력해주세요.");
        }
    });
</script>   		