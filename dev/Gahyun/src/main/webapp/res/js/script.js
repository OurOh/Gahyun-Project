function test() {
    console.log($('.startdateval').val());
    console.log($('.enddateval').val());

}

    
	// Reservation 방갯수
	function increase(id) {
	    let element = document.getElementById(id);
	    let elementClass = document.querySelector(id);
	    let value = parseInt(element.textContent);
	    if (value < 10) { // 최대 10개로 제한
	        element.textContent = value + 1;
			element.Class(val) 
	    }
	}
	
	function decrease(id) {
	    let element = document.getElementById(id);
	    let value = parseInt(element.textContent);
	    if (value > 1) { // 최소 1개로 제한
	        element.textContent = value - 1;
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
    	dateFormat: 'mm/dd/yy',
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
    	dateFormat: 'mm/dd/yy',
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

    $('.roomCount').val($('#roomcount').text());
    $('.guestCount').val($('#guestcount').text());
    
   
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
   
   
});