$(function(){
        $(".main-nav").hover(function(){
            $(".nav-col").stop().slideToggle(300);
        });
        $(".ham").click(function(){
            $(".ham-nav").stop().slideToggle(300);
        })
    }); //jquery
    
    
    
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