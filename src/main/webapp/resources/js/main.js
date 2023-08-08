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


      img1.setAttribute("src", festivalList1[0].festivalImage.substring(2));
      a1.setAttribute("href", "board/festivalDetail?festivalNo=" + festivalList1[0].festivalNo);
      img2.setAttribute("src", festivalList1[1].festivalImage.substring(2));
      a2.setAttribute("href", "board/festivalDetail?festivalNo=" + festivalList1[1].festivalNo);
      img3.setAttribute("src", festivalList1[2].festivalImage.substring(2));
      a3.setAttribute("href", "board/festivalDetail?festivalNo=" + festivalList1[2].festivalNo);
      img4.setAttribute("src", festivalList1[3].festivalImage.substring(2));
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


      img1.setAttribute("src", festivalList2[0].festivalImage.substring(2));
      a1.setAttribute("href", "board/festivalDetail?festivalNo=" + festivalList2[0].festivalNo);
      img2.setAttribute("src", festivalList2[1].festivalImage.substring(2));
      a2.setAttribute("href", "board/festivalDetail?festivalNo=" + festivalList2[1].festivalNo);
      img3.setAttribute("src", festivalList2[2].festivalImage.substring(2));
      a3.setAttribute("href", "board/festivalDetail?festivalNo=" + festivalList2[2].festivalNo);
      img4.setAttribute("src", festivalList2[3].festivalImage.substring(2));
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
      console.log(festivalList3[0].festivalImage.substr(1));
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


      img1.setAttribute("src", festivalList3[0].festivalImage.substring(2));
      a1.setAttribute("href", "board/festivalDetail?festivalNo=" + festivalList3[0].festivalNo);
      img2.setAttribute("src", festivalList3[1].festivalImage.substring(2));
      a2.setAttribute("href", "board/festivalDetail?festivalNo=" + festivalList3[1].festivalNo);
      img3.setAttribute("src", festivalList3[2].festivalImage.substring(2));
      a3.setAttribute("href", "board/festivalDetail?festivalNo=" + festivalList3[2].festivalNo);
      img4.setAttribute("src", festivalList3[3].festivalImage.substring(2));
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

      const bList4 = document.getElementById("bList4");
      const div4 = document.getElementsByClassName("board-content4")[0];

      console.log(companionList);

      div4.innerText = "";

      for(let item of companionList){
        const ul = document.createElement("ul");

        const li = document.createElement("li");

        const img = document.createElement("img");
        
        const div1 = document.createElement("div");
        const div2 = document.createElement("div");

        const a1 = document.createElement("a")
        const a2 = document.createElement("a")
        const a3 = document.createElement("a")

        const p1 = document.createElement("p")
        const p2 = document.createElement("p")

        div4.append(ul);
        ul.append(li);

        li.append(div1);
        li.append(div2);

        div1.append(a1);
        a1.append(img);

        div2.append(a2);
        div2.append(p1);
        div2.append(p2);

        li.classList.add("li")
        ul.classList.add("list");
        ul.classList.add("img");
        div1.classList.add("imgbox");
        a1.setAttribute("href", "member/myPage2?memberNo=" + item.memberNo);
        img.setAttribute("src", item.memberProfile.substring(2));
        
        div2.classList.add("txtbox")
        a2.setAttribute("href", "board/companion?type=5&cp=1");
        a2.innerText = item.festivalTitle;
        p1.classList.add("dsctxt");
        p1.innerText = item.createDate;
        p2.classList.add("dsctxt-sub");
        p2.innerText = item.festivalDate;


      }

     /*  const container = document.createElement("div");
for(let i = 0; i < companionList.length; i += 2){
  const row = document.createElement("div");
  row.classList.add("row");

  const item1 = companionList[i];
  const item2 = companionList[i + 1];

  const col1 = createCol(item1);
  const col2 = createCol(item2);

  row.append(col1);
  row.append(col2);

  container.append(row);
}

function createCol(item){
  const col = document.createElement("div");
  col.classList.add("col");

  const ul = document.createElement("ul");
  ul.classList.add("list");

  const li = document.createElement("li");

  const div1 = document.createElement("div");
  const div2 = document.createElement("div");

  const a1 = document.createElement("a")
  const a2 = document.createElement("a")
  const a3 = document.createElement("a")

  const img = document.createElement("img");
  img.setAttribute("src", item.memberProfile.substring(1));

  const p1 = document.createElement("p")
  const p2 = document.createElement("p")

  ul.append(li);

  li.append(div1);
  li.append(div2);

  div1.append(a1);
  a1.append(img);

  div2.append(a2);
  div2.append(p1);
  div2.append(p2);

  a1.setAttribute("href", "member/myPage2?memberNo=" + item.memberNo);
  a2.setAttribute("href", "board/companion?type=5&cp=1");
  a2.innerText = item.festivalTitle;
  p1.classList.add("dsctxt");
  p1.innerText = item.createDate;
  p2.classList.add("dsctxt-sub");
  p2.innerText = item.festivalDate;

  col.append(ul);

  return col;
}

bList4.append(container);
 */

    },

    error : function(){
      console.log("컴패니언에러 발생");
    }

  });
}



(function(){
  selectCompanionList();
})();

