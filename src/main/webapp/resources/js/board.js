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

            const type = "type=" + params.get("type"); // type = 1
            let cp; 

            if(params.get("cp") != ""){ // 쿼리스트링에 cp가 있을 경우
                cp = "cp=" + params.get("cp");
            } else{
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

// ------------------------------------------------------------------------------------------------------------------------//
// 삭제 버튼
