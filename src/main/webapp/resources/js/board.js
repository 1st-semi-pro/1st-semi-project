// ------------------------------------------------------------------------------------------------------------------------//
//목록으로

(function(){
    const goToListBtn = document.getElementById("goToListBtn");

    if(goToListBtn != null){ // 목록으로 버튼이 화면에 있을 때만 이벤트 추가하겠다. 

        // 상세조회, 게시글 작성에 둘다 같은 id의 목록으로 버튼이있음 둘다 board.js와 연결되어있음

        goToListBtn.addEventListener("click", function(){

            const pathname = location.pathname; 

            // "/festival/board/detail"(상세조회) 나 /festival/board/write(게시글 작성) [현재 페이지]의 경로를 반환

            let url = pathname.substring(0, pathname.indexOf("/", 1));
            // url에 /festival이 저장됨
            
            url += "/board/list?" 
            // /festival/board/list? 

            const params = new URL(location.href).searchParams;
            // 현재 페이지의 쿼리 스트링 부분만 담겠다.

            let type = "type=" + params.get("type"); // type = 1
            let cp; 

            if(params.get("cp") != ""){ // 쿼리스트링에 cp가 있을 경우
                cp = "cp=" + params.get("cp");
            } else{
                cp = "cp=1";
            } 

            if(params.get("type") == null){
                type = "1";
            }

            if(params.get("cp") == null){
                cp = "cp=1";
            }
            
            url += type + "&" + cp // 다합치기

            // 검색 key,query가 존재하는 경우 url에 추가
            if(params.get("key") != null){
                const key = "&key=" + params.get("key");
                const query = "&query=" + params.get("query");

                url += key + query; 

            }
            
            location.href = url;


        });

    }

})();

(function(){
    const goToPreviousPage = document.getElementById("goToPreviousPage");

    if(goToPreviousPage != null){ // 수정 취소버튼 

        goToPreviousPage.addEventListener("click", function(){

            alert("test");

            history.back(); // 이전페이지로


        });

    }

})();



// ------------------------------------------------------------------------------------------------------------------------//
// 삭제 버튼
(function(){

    const deleteBtn = document.getElementById("deleteBtn"); 

    if(deleteBtn != null){ // 버튼이 화면이 존재할 때만 

        deleteBtn.addEventListener("click",function(){
            // 현재 위치 : /community/board/detail?no=1500&cp=1&type=1
            // 목표 위치 : /community/board/delete?no=1500&type=1
            // 상대 경로 -> delete

            let url = "delete"; 

            // 주소에 작성된 쿼리스트링에서 필요한 파라미터만 얻어오기

            // 현재 페이지 주소에서 쿼리스트링에 존재하는 파라미터만 얻어온다.
            const params = new URL(location.href).searchParams; 

            const no = "?no=" + params.get("no");

            const type = "&type=" + params.get("type");

            url += no + type;

            if(confirm("정말로 삭제하시겠습니까?")){
                location.href = url; // get방식으로 url에 요청
            }
        
        });
    
    }

})();

// 조회수 증가 비동기

// ------------------------------------------------------------------------------------------------------------------------//
// 조회수 비동기 증가
/* 
(function(){   
   
    console.log("test::" + boardNo);
    console.log("readCount::" + readCount);
    $.ajax({

        url : "detailtest",
        data : {"boardNo" : boardNo},
        type : "GET",
        success : function(result){
            if(result == 1){
                readCount = readCount + 1;
            }else{
                console.log("에러");
            }
        },
        error : function(){
            console.log("완전 에러");
        }
    })
})();    */  

/* const title = document.getElementById("title");

console.log("dd");

    if(title != null){

        title.addEventListener("click",function(){
                
            $.ajax({

                url : "test",

                data : {"boardTitle" : boardTitle},

                type : "get",

                success : function(result){
                    if(result == 1){
                        console.log("성공");
                    }else{
                        console.log("에러");
                    }
                },

                error : function(){
                    console.log("완전에러");
                }

            })




        })

} */
