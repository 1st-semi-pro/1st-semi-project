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
const bList1 = document.getElementById("bList1");
const bList2 = document.getElementById("bList2");
const bList3 = document.getElementById("bList3");


  function selectBoard(){

    $.ajax({

      url : "board/mainList/bd1",
      dataType : "json",

      success : function(boardList1){

        bList1.innerText = "";

        for(let item of boardList1){
          const tr = document.createElement("tr");

          const td = document.createElement("td");
          
          const a1 = document.createElement("a");
          a1.innerText = item.boardTitle;
          a1.setAttribute("href", "board/detail?no=" + item.boardNo + "&type=2");

          tr.append(td);

          bList1.append(tr);

          td.append(a1);
        }


      },

      error : function(){
        console.log("에러 발생");
      }

    });
  }



  (function(){
    selectBoard();

   
  })();




  function selectBoard2(){

    $.ajax({

      url : "board/mainList/bd2",
      dataType : "json",

      success : function(boardList2){
        

        bList2.innerText = "";

        for(let item of boardList2){
          const tr = document.createElement("tr");

          const td = document.createElement("td");
          
          const a1 = document.createElement("a");
          a1.innerText = item.boardTitle;
          a1.setAttribute("href", "board/detail?no=" + item.boardNo + "&type=3");

          tr.append(td);

          bList2.append(tr);

          td.append(a1);
        }


      },

      error : function(){
        console.log("에러 발생");
      }

    });
  }



  (function(){
    selectBoard2();

  })();


  function selectBoard3(){

    $.ajax({

      url : "board/mainList/bd3",
      dataType : "json",

      success : function(boardList3){

        bList3.innerText = "";

        for(let item of boardList3){
          const tr = document.createElement("tr");

          const td = document.createElement("td");
          
          const a1 = document.createElement("a");
          a1.innerText = item.boardTitle;
          a1.setAttribute("href", "board/detail?no=" + item.boardNo + "&type=3");

          tr.append(td);

          bList3.append(tr);

          td.append(a1);
        }


      },

      error : function(){
        console.log("에러 발생");
      }

    });
  }



  (function(){
    selectBoard3();

   
  })();


const seoul = document.getElementById("seoul");
const div1 = document.getElementById("divide1");

seoul.addEventListener("mouseover", function(){

  $.ajax({
    url : "board/mainList/festival1",
    dataType : "json",
    success : function(festivalList1){
      console.log(festivalList1);
      console.log(festivalList1);

      
      div1.innerText="";

      const div = document.createElement("div");
      const div2 = document.createElement("div");
      const img1 = document.createElement("img")
      const img2 = document.createElement("img")
      const img3 = document.createElement("img")
      const img4 = document.createElement("img")
      div1.append(div);
      div1.append(div2);
      div.append(img1);
      div.append(img2);
      div2.append(img3);
      div2.append(img4);

      img1.setAttribute("src", "resources/images/festival_infomation/122.png");
      img2.setAttribute("src", "resources/images/festival_infomation/22.png");
      img3.setAttribute("src", "resources/images/festival_infomation/22.png");
      img4.setAttribute("src", "resources/images/festival_infomation/22.png");


      

      
      
    },
    error : function(){
      console.log("에러 발생");
    }

  })
})

