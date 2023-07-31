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


  function selectBoard(){

    $.ajax({

      url : "board/mainList",
      dataType : "json",

      success : function(boardList1){
        const bList1 = document.getElementById("bList1");

        bList1.innerText = "";

        for(let item of boardList1){
          const tr = document.createElement("tr");

          const th = document.createElement("th");
          
          const a1 = document.createElement("a");
          a1.innerText = item.boardTitle;
          a1.setAttribute("href", "board/detail?no=" + item.boardNo);

          tr.append(th);

          bList1.append(tr);

          th.append(a1);
        }


      },

      error : function(){
        console.log("에러 발생");
      }

    });
  }

















  (function(){
    selectBoard();

    window.setInterval(selectBoard, 60000);
  })();