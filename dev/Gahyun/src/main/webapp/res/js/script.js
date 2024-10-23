
    
	// Reservation 방갯수
	function increase(id) {
	    let element = document.getElementById(id);
	    let inputElement = document.getElementById(id + "Input");
	    let value = parseInt(element.textContent);
	    if (value < 10) { // 최대 10개로 제한
	    	value ++;
	        element.textContent = value
			inputElement.value = value;
	    }
	}
	
	function decrease(id) {
	    let element = document.getElementById(id);
	    let inputElement = document.getElementById(id + "Input");
	    let value = parseInt(element.textContent);
	    if (value > 1) { // 최소 1개로 제한
	    	value --;
	        element.textContent = value;
	        inputElement.value = value;
	    }
	}
		


$(function(){
	//register 빈칸 검증
   $("#register").submit(function(){
      //e.preventDefault();
      
      /* 아이디 검증 */
      if(!regex.value("#userid", "아이디를 입력하세요")){ return false; }      
      if(!regex.uid("#userid", "아이디는 영문과 숫자만 가능합니다. 첫 글자에 숫자는 올 수 없어요.")){ return false;}
      if(!regex.max_length("#userid", 10, "최대 10자까지만 허용해요.")){return false;}
      
      /* 비밀번호 검증 */
      if(!regex.value("#password", "비밀번호를 입력하세요.")){ return false; }
      if(!regex.min_length("#password", 4, "비밀번호는 최소4자 까지 입니다.")){ return false; }
      if(!regex.value("#password", "비밀번호를 다시 확인해 주세요.")){ return false; }
      if(!regex.equalField("#password", "#confirm_password", "비밀번호가 일치하지 않습니다.")){ return false; }
      
      /* 이름 검증 */
      if(!regex.value("#name", "이름을 입력하세요.")){ return false; }
      
      
      /* 생년월일 검증*/
      if(!regex.value("#year", "해당하는 년도를 입력하세요.")){ return false; }
      if(!regex.value("#month", "해당하는 월을 입력하세요.")){ return false; }
      if(!regex.value("#day", "해당하는 날짜를 입력하세요.")){ return false; }
      
      
      /* 전화번호 검증 */ 
      if(!regex.value("#phone1", "전화번호를 입력하세요.")){ return false; }
      if(!regex.value("#phone2", "전화번호를 입력하세요.")){ return false; }
      if(!regex.value("#phone3", "전화번호를 입력하세요.")){ return false; }
      
      /* 전화번호 변환 */
      const tel = $("#phone1").val() + "-" + $("#phone2").val() + "-" + $("#phone3").val();
                  
                  $("#tel").val(tel);
      /* 생년월일 변환 */
      const birth = $("#year").val() + "-" + $("#month").val() + "-" + $("#day").val();
      			    $("#birth").val(birth);
      
      /* 이메일 검증 
      if(!regex.value("#useremail", "이메일을 입력하세요.")){ return false; }
      if(!regex.email("#useremail", "이메일 형식이 아닙니다.")){ return false; }
      */
      
      
   });
   
   //datepicker
   
    $('.startdate').datepicker({
    	inline: true,
    	dateFormat: 'yy-mm-dd',
    	prevText: '이전 달',
		nextText: '다음 달',
		monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		dayNames: ['일', '월', '화', '수', '목', '금', '토'],
		dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
		dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
		showMonthAfterYear: true,
		yearSuffix: '년',
		onSelect: function(selectedDate) {
            // 시작 날짜 선택 후 종료 날짜는 시작 날짜보다 이후로 설정
             $('.enddate').datepicker('option', 'minDate', selectedDate);
             $('.startdateval').val($('.startdate').val());
        }
    });
    $('.enddate').datepicker({
    	inline: true,
    	dateFormat: 'yy-mm-dd',
    	prevText: '이전 달',
		nextText: '다음 달',
		monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		dayNames: ['일', '월', '화', '수', '목', '금', '토'],
		dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
		dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
		showMonthAfterYear: true,
		yearSuffix: '년',
		onSelect: function(selectedDate) {
            // 종료 날짜 선택 후 시작 날짜는 종료 날짜보다 이전으로 설정
        	$('.startdate').datepicker('option', 'maxDate', selectedDate);
        	$('.enddateval').val($('.enddate').val());
        }
    });
	
	//날짜포멧변경
	function convertToDashFormat(dateStr) {
    	return dateStr.replace(/\//g, '-'); // '/'를 '-'로 변환
	}
	
	// 사용가능한 방 ajax 처리
	$('form[name="findAvailableRooms"]').on('submit',function(event){
		event.preventDefault();
		console.log("AJAX 요청 시작");
		
		// 날짜 형식 변환
    	var startDateFormatted = convertToDashFormat($('#startdateval').val());
    	var endDateFormatted = convertToDashFormat($('#enddateval').val());
		
		//ajax
		
		$.ajax({
			url: '/dev/available',
			type:'POST',
			data:{
				roomCount: $('#roomCountInput').val(),
				guestCount: $('#guestCountInput').val(),
				startDate: startDateFormatted,
				endDate: endDateFormatted
			},
			success: function(response){
				 console.log('Response:', response); 
				var roomList = $('.rooms-list');
				roomList.empty();
				
				if (response.length > 0) {
                	$('.recommended-title').text('사용 가능 객실');
            	} else {
                	$('.recommended-title').text('추천 객실');
            	}
				
				
				//받은 데이터 표시
				$.each(response, function(index, room){
				
					var imageUrl = (room.photos && room.photos.length > 0) ? room.photos[0].photoUrl : '/default/image.jpg';
            
				
					var roomCard = `
						<div class="room-card" data-room-id="${room.roomId}">
							<img src="/dev/${imageUrl}" alt="객실 이미지">
							<p>객실 타입: ${room.roomType}<br>조식: 불포함</p>
						</div>
						`;
					roomList.append(roomCard);
				});	
			},
			error:function(xhr, status, error){
			console.error("Error입니다.",error);
			console.log("Response Text:", xhr.responseText);  // 서버 응답 확인
    		console.log("Status:", status);  // HTTP 상태 코드 확인
			
			}
			
		});
	
	});
   // Reservation select의 값 넘기기 241021 작업중	 
   // 방선택
	let selectedRoomId = null;  // 선택된 방의 ID를 저장할 변수

	$(document).on('click', '.room-card', function () {
   
    $('.room-card').removeClass('selected');
    
    // 클릭된 방을 선택 상태로 표시
    $(this).addClass('selected');

    // 클릭된 방의 roomId를 저장
    selectedRoomId = $(this).data('room-id');

    console.log("선택된 방 ID:", selectedRoomId);  // 디버깅용 콘솔 출력
	});
   
   $('.next-button').on('click', function () {
    // 사용자가 방을 선택하지 않은 경우 경고 메시지
    if (selectedRoomId === null) {
        alert("먼저 방을 선택해 주세요!");
        return; 
    }

    // 정보 가져오기
    const startDate = $('#startdateval').val();
    const endDate = $('#enddateval').val();
	const guestCount = $('#guestCountInput').val();
    // 선택된 방 정보와 날짜 정보를 서버로 POST 요청
    const form = $('<form></form>');
    form.attr('method', 'POST');
    form.attr('action', '/dev/Reservation2');  // 정보를 전달할 서버 경로

    // 선택된 방의 ID를 폼에 추가
    const roomIdInput = $('<input>').attr('type', 'hidden').attr('name', 'roomId').val(selectedRoomId);
    form.append(roomIdInput);

    // 선택한 날짜 정보를 폼에 추가
    const startDateInput = $('<input>').attr('type', 'hidden').attr('name', 'startDate').val(startDate);
    const endDateInput = $('<input>').attr('type', 'hidden').attr('name', 'endDate').val(endDate);
    const guestCountInput = $('<input>').attr('type', 'hidden').attr('name', 'guestCount').val(guestCount);
    
    form.append(startDateInput);
    form.append(endDateInput);
	form.append(guestCountInput);
	
    // 폼을 body에 추가하고 제출
    $('body').append(form);
    form.submit();
	});
      
   
   /*
   
   $("#year").datepicker({
   	changeYear: true,
   	yearRange: "1900:" + new Date().getFullYear(),
   	dateFormat: "yy",
   	minDate: new Date(1900, 0, 1),
   	maxDate: new Date() 
   });
   $("#month").datepicker({
   	changeMonth: true,
   	MonthRange: "1" + new Date().getFullYear(),
   	dateFormat: "mm",
   });
   $("#day").datepicker({
   
   });
   */
   /*
   $(document).ready(function() {
   $('.image-grid-slider').each(function() {
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
*/   
   
});