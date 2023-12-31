function com(){

    // contextPath, boardNo, memberNo 전역 변수 사용
   
    $.ajax({
        url : contextPath + "/companionList/companionList",
        data : {"type" : type, "cp" : cp },
        type : "get",
        dataType : "JSON", // JSON 형태의 문자열 응답 데이터를 JS 객체로 자동 변환
        success : function(cList){
            // rList : 반환 받은 댓글 목록
            
            // 화면에 출력되어 있는 댓글 목록 삭제
            const maincontent = document.getElementById("main-content"); // 첫세션
            maincontent.innerHTML = "";

            // rList에 저장된 요소를 하나씩 접근
            for(let companionList of cList){
                
                const maincontentbox = document.createElement("article");
                maincontentbox.classList.add("main-content-box");

            //////////////////////////////////////////////////////////////

                const ftcontent = document.createElement("div");
                ftcontent.classList.add("ft-content");

            //////////////////////////////////////////////////////////////

                const ftimg = document.createElement("div")
                ftimg.classList.add("ft-img")

                const fimg = document.createElement("img");
                fimg.setAttribute("src",contextPath + "/resources/images/festival_infomation/"+companionList.festivalNo +".png");

            //////////////////////////////////////////////////////////////

                ftimg.append(fimg);
                
            //////////////////////////////////////////////////////////////

                const fttext = document.createElement("div");
                fttext.classList.add("ft-text");

                const h1 = document.createElement("h1");
                h1.innerText = companionList.festivalTitle;

                const span1 = document.createElement("span");
                span1.classList.add("s1");
                span1.innerText = companionList.festivalArea;

                const span2 = document.createElement("span");
                span2.classList.add("margin");
                span2.innerText = "l";

                const span3 = document.createElement("span");
                span3.classList.add("s3");
                span3.innerText = companionList.festivalDate;

            //////////////////////////////////////////////////////////////

                fttext.append(h1,span1,span2,span3);

            //////////////////////////////////////////////////////////////

                const myimg = document.createElement("div");
                myimg.classList.add("my-img");

                const mimg = document.createElement("img");
                mimg.setAttribute("src",contextPath + "/resources/images/festival_infomation/181.gif" );

                const mytext = document.createElement("div");
                mytext.classList.add("my-text");

                const myspan = document.createElement("span")
                myspan.innerHTML = "안녕하세요.<br>저는 문광민입니다 <br> 나이는 29살이고 요즘에 너무피곤합니다 ㅎㅎ";

                const mbutton = document.createElement("button")
                mbutton.setAttribute("type","button");


            //////////////////////////////////////////////////////////////

                mytext.append(myspan,mbutton);
            
            //////////////////////////////////////////////////////////////

               
                mbutton.innerText="채팅하기"
                myimg.append(mimg,mytext);

            //////////////////////////////////////////////////////////////

                ftcontent.append(ftimg,fttext,myimg);


            //////////////////////////////////////////////////////////////
                if(loginMemberNo == companionList.memberNo){

                    const updatebox = document.createElement("div");
                    updatebox.classList.add("update-box");

                    const insertbutton = document.createElement("button");
                    insertbutton.classList.add("update");
                    insertbutton.innerText="게시글수정";

                    const deletebtn = document.createElement("button");
                    deletebtn.classList.add("update");
                    deletebtn.innerText="게시글삭제"

                    deletebtn.setAttribute("onclick", "deleteCompanion("+companionList.boardNo+",'"+companionList.festivalTitle+"')");

                    updatebox.append(insertbutton,deletebtn);

                    ftcontent.append(updatebox);

                    maincontentbox.append(ftcontent)

                    maincontent.append(maincontentbox);
                    
                }else{
                    maincontentbox.append(ftcontent);

                    maincontent.append(maincontentbox);
                }
                
               
            }

        },
        error: function(){
            console.log("에러 발생");
        }

    });
}


function deleteCompanion(boardNo,festivalTitle){
    Swal.fire({
			title: festivalTitle,
			text: "삭제하시겠습니까?",
			icon: 'warning',
			showCancelButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			confirmButtonText: '삭제',
			cancelButtonText: '취소'
			}).then((results) => {

    if(results.value !=null){

        $.ajax({

           url : contextPath + "/companionList/delete",
           
           data : {"boardNo" : boardNo , "festivalTitle" : festivalTitle},

           type : "GET",
        
           success : function(result){
            console.log("aaa=== "+ result);
            if(result > 0 ){
                
                Swal.fire(
                    festivalTitle,"삭제되었습니다!",
                    'success'
                )
               com();
            
            }else{
                alert("삭제를 실패했습니다.");
            }

           },

           error : function(req, status, error){
            console.log("게시글삭제 실패");
            console.log(req.responseText);
          }   

           })

    } })
}