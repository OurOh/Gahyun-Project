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