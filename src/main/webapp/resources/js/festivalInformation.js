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
////------------------------------------------------------------------------------------------------------------------////
function  searchValidate(){
    const search = document.getElementById("info-search");
    const festivalDate = document.getElementById("festivalDate");
    const festivalArea = document.getElementById("festivalArea");
    const festivalCat = document.getElementById("festivalCat");

    if(festivalDate.value == "" && festivalArea.value == "" && festivalCat.value == ""){
        festivalDate.focus()
        alert("최소 1개이상 선택후 검색해주세요!")
        return false;
    }
    return true;
}
////------------------------------------------------------------------------------------------------------------------////

(function(){

    // 학원에서한건 select 옵션이 한개라 키벨류 형태로 나오지만 내가한건 select옵션이 많아서 그대로값이 얻어와짐 08/01

    const select1 = document.getElementById("festivalDate");
    const select2 = document.getElementById("festivalArea");
    const select3 = document.getElementById("festivalCat");

    const option1 = document.querySelectorAll("#festivalDate > option");
    const option2 = document.querySelectorAll("#festivalArea > option");
    const option3 = document.querySelectorAll("#festivalCat > option");

    if(select1 !="" || select2 !="" || select3 !=""){ 
        
        // 현재페이지주소 쿼리스트링 얻기
        const params = new URL(location.href).searchParams;

        const key1 = params.get("festivalDate");
        const key2 = params.get("festivalArea");
        const key3 = params.get("festivalCat");
        // option을 반복 접근해서 value와 key와 같으면 selectd 속성 추가

        for(let op of option1){
            if(op.value == key1){
                op.selected = true;
            }
        }
        for(let op of option2){
            if(op.value == key2){
                op.selected = true;
            }
        }
        for(let op of option3){
            if(op.value == key3){
                op.selected = true;
            }
        }
    }
})();

    const festivalDate = document.getElementById("festivalDate");
    const festivalArea = document.getElementById("festivalArea");
    const festivalCat = document.getElementById("festivalCat");

festivalDate.addEventListener("change", function () {

    if (festivalDate.value !="") {
        festivalDate.classList.add("on");

        festivalArea.classList.remove("on");
        festivalCat.classList.remove("on");
    }
});

festivalArea.addEventListener("change",function(){

    if (festivalArea.value !="") {
        festivalArea.classList.add("on");

        festivalDate.classList.remove("on");
        festivalCat.classList.remove("on");
    }
});

festivalCat.addEventListener("change",function(){

    if (festivalCat.value !="") {
        festivalCat.classList.add("on");

        festivalDate.classList.remove("on");
        festivalArea.classList.remove("on");
    }
});

document.getElementById("reset").addEventListener("click",function(){

    document.getElementById("festivalDate").classList.remove("on");
    document.getElementById("festivalArea").classList.remove("on");
    document.getElementById("festivalCat").classList.remove("on");
});

   


