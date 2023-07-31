var swiper = new Swiper(".mySwiper", {
    slidesPerView: "auto",
    centeredSlides: true,
    spaceBetween: 15,
    autoplay: {
        delay:4000, disableOnInteraction: false, // false-스와이프 후 자동 재생
    },
    loop :false, loopAdditionalSlides:1,
    pagination: {
      el: ".swiper-pagination",
      clickable: true,
    },
  });































/* for(let i=0; i<optionItem.length; i++){
    optionItem[i].addEventListener("click", function(){
        if(i<8){
            span1.innerText = this.innerText;
            optionList[0].classList.remove("active");
        } else if(i<12){
            span2.innerText = this.innerText;
            optionList[1].classList.remove("active");
        }else{ 
            span3.innerText = this.innerText;
            optionList[2].classList.remove("active");
        }
    })
} */