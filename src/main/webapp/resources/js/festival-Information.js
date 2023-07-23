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




//----------------------------
const label = document.querySelectorAll('.label');

const sp1 = document.getElementById("sp1");
const sp2 = document.getElementById("sp2");

label.forEach(function(lb){
    lb.addEventListener('click', e => {
        let optionList = lb.nextElementSibling;
        let optionItems = optionList.querySelectorAll('.optionItem');
        clickLabel(lb, optionItems);
    })
});

const clickLabel = (lb, optionItems) => {
    if(lb.parentNode.classList.contains('active')) {
        lb.parentNode.classList.remove('active');
        optionItems.forEach((opt) => {
            opt.removeEventListener('click', () => {
                handleSelect(lb, opt, sp1)
                handleSelect1(lb, opt, sp2)
            })
        })
    } else {
        lb.parentNode.classList.add('active');
        optionItems.forEach((opt) => {
            opt.addEventListener('click', () => {
                handleSelect(lb, opt, sp1)
                handleSelect1(lb, opt, sp2)
            })
        })
    }
}
const handleSelect = (label, item, sp1) => {
    sp1.innerHTML = item.textContent;
    label.parentNode.classList.remove('active');
}
const handleSelect1 = (label, item, sp2) => {
    sp2.innerHTML = item.textContent;
    label.parentNode.classList.remove('active');
}

/* ------------------------------------------------------------------------------- */