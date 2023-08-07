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
const gyeonggi = document.getElementById("gyeonggi");
const incheon = document.getElementById("incheon");

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

      const a1 = document.createElement("a");
      const a2 = document.createElement("a");
      const a3 = document.createElement("a");
      const a4 = document.createElement("a");

      const name1 = document.createElement("a");
      
      div.classList.add("flex");
      div2.classList.add("flex");

      a1.append(img1);
      a1.append(name1);
      a2.append(img2);
      a3.append(img3);
      a4.append(img4);

      div1.append(div);
      div1.append(div2);
      div.append(a1);
      div.append(a2);
      div2.append(a3);
      div2.append(a4);


      img1.setAttribute("src", festivalList1[0].festivalImage.substring(1));
      a1.setAttribute("href", "board/festivalDetail?festivalNo=" + festivalList1[0].festivalNo);
      img2.setAttribute("src", festivalList1[1].festivalImage.substring(1));
      a2.setAttribute("href", "board/festivalDetail?festivalNo=" + festivalList1[1].festivalNo);
      img3.setAttribute("src", festivalList1[2].festivalImage.substring(1));
      a3.setAttribute("href", "board/festivalDetail?festivalNo=" + festivalList1[2].festivalNo);
      img4.setAttribute("src", festivalList1[3].festivalImage.substring(1));
      a4.setAttribute("href", "board/festivalDetail?festivalNo=" + festivalList1[3].festivalNo);


      

      
      
    },
    error : function(){
      console.log("에러 발생");
    }

  })
})


gyeonggi.addEventListener("mouseover", function(){

  $.ajax({
    url : "board/mainList/festival2",
    dataType : "json",
    success : function(festivalList2){
      console.log("성공");
      console.log(festivalList2);
      

      
      div1.innerText="";

      const div = document.createElement("div");
      const div2 = document.createElement("div");
      const img1 = document.createElement("img")
      const img2 = document.createElement("img")
      const img3 = document.createElement("img")
      const img4 = document.createElement("img")

      const a1 = document.createElement("a");
      const a2 = document.createElement("a");
      const a3 = document.createElement("a");
      const a4 = document.createElement("a");

      const name1 = document.createElement("a");
      
      div.classList.add("flex");
      div2.classList.add("flex");

      a1.append(img1);
      a1.append(name1);
      a2.append(img2);
      a3.append(img3);
      a4.append(img4);

      div1.append(div);
      div1.append(div2);
      div.append(a1);
      div.append(a2);
      div2.append(a3);
      div2.append(a4);


      img1.setAttribute("src", festivalList2[0].festivalImage.substring(1));
      a1.setAttribute("href", "board/festivalDetail?festivalNo=" + festivalList2[0].festivalNo);
      img2.setAttribute("src", festivalList2[1].festivalImage.substring(1));
      a2.setAttribute("href", "board/festivalDetail?festivalNo=" + festivalList2[1].festivalNo);
      img3.setAttribute("src", festivalList2[2].festivalImage.substring(1));
      a3.setAttribute("href", "board/festivalDetail?festivalNo=" + festivalList2[2].festivalNo);
      img4.setAttribute("src", festivalList2[3].festivalImage.substring(1));
      a4.setAttribute("href", "board/festivalDetail?festivalNo=" + festivalList2[3].festivalNo);


      

      
      
    },
    error : function(){
      console.log("에러 발생");
    }

  })
})


incheon.addEventListener("mouseover", function(){

  $.ajax({
    url : "board/mainList/festival3",
    dataType : "json",
    success : function(festivalList3){
      console.log(festivalList3[0].festivalImage.substring(1));
      console.log(festivalList3);
      

      
      div1.innerText="";

      const div = document.createElement("div");
      const div2 = document.createElement("div");
      const img1 = document.createElement("img")
      const img2 = document.createElement("img")
      const img3 = document.createElement("img")
      const img4 = document.createElement("img")

      const a1 = document.createElement("a");
      const a2 = document.createElement("a");
      const a3 = document.createElement("a");
      const a4 = document.createElement("a");

      const name1 = document.createElement("a");
      
      div.classList.add("flex");
      div2.classList.add("flex");

      a1.append(img1);
      a1.append(name1);
      a2.append(img2);
      a3.append(img3);
      a4.append(img4);

      div1.append(div);
      div1.append(div2);
      div.append(a1);
      div.append(a2);
      div2.append(a3);
      div2.append(a4);


      img1.setAttribute("src", festivalList3[0].festivalImage.substring(1));
      a1.setAttribute("href", "board/festivalDetail?festivalNo=" + festivalList3[0].festivalNo);
      img2.setAttribute("src", festivalList3[1].festivalImage.substring(1));
      a2.setAttribute("href", "board/festivalDetail?festivalNo=" + festivalList3[1].festivalNo);
      img3.setAttribute("src", festivalList3[2].festivalImage.substring(1));
      a3.setAttribute("href", "board/festivalDetail?festivalNo=" + festivalList3[2].festivalNo);
      img4.setAttribute("src", festivalList3[3].festivalImage.substring(1));
      a4.setAttribute("href", "board/festivalDetail?festivalNo=" + festivalList3[3].festivalNo);


      

      
      
    },
    error : function(){
      console.log("에러 발생");
    }

  })
})

function selectCompanionList(){

  $.ajax({

    url : "board/mainList/companionList",
    dataType : "json",

    success : function(companionList){

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
  selectCompanionList();
})();

