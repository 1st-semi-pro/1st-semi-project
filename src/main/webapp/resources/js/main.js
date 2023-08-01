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

      url : "board/mainList/bd1",
      dataType : "json",

      success : function(boardList1){
        const bList1 = document.getElementById("bList1");

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

    window.setInterval(selectBoard, 600000);
  })();




  function selectBoard2(){

    $.ajax({

      url : "board/mainList/bd2",
      dataType : "json",

      success : function(boardList2){
        const bList2 = document.getElementById("bList2");

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

    window.setInterval(selectBoard2, 600000);
  })();


  function selectBoard3(){

    $.ajax({

      url : "board/mainList/bd3",
      dataType : "json",

      success : function(boardList3){
        const bList3 = document.getElementById("bList3");

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

    window.setInterval(selectBoard3, 600000);
  })();