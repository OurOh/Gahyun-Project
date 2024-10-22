$(function(){
    $(".main-nav").hover(function(){
        $(".nav-col").stop().slideToggle(300);
    });
    $(".ham").click(function(){
        $(".ham-nav").stop().slideToggle(300);
    })
}); //jquery