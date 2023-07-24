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


const label = document.querySelectorAll(".label");
const optionList = document.querySelectorAll(".optionList");
const optionItem = document.getElementsByClassName("optionItem");

const reset = document.getElementById("reset");

const span1 = document.getElementById("sp1");
const span2 = document.getElementById("sp2");
const span3 = document.getElementById("sp3");

label[0].addEventListener("click",function(){
    optionList[0].classList.toggle("active");
    optionList[1].classList.remove("active");
    optionList[2].classList.remove("active");
})
label[1].addEventListener("click",function(){
    optionList[1].classList.toggle("active");
    optionList[0].classList.remove("active");
    optionList[2].classList.remove("active");
})
label[2].addEventListener("click",function(){
    optionList[2].classList.toggle("active");
    optionList[0].classList.remove("active");
    optionList[1].classList.remove("active");
})

reset.addEventListener("click",function(){
    span1.innerText = "";
    span2.innerText = "";
    span3.innerText = "";
})

for(let i=0; i<optionItem.length; i++){
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
}