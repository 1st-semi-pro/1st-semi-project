// 상세조회, 게시글 작성 - 목록으로 버튼

/* 즉시실행함수 */
(function(){
    const goToListBtn = document.getElementById("goToListBtn");

    if(goToListBtn != null){ // 목록으로 버튼이 화면에 있을 때만 이벤트 추가하겠다.

        goToListBtn.addEventListener("click", function(){

            // location 객체(BOM)

            // 문자열.substring(시작, 끝) : 시작 이상 끝 미만 인덱스까지 문자열 자르기

            // 문자열.indexOf("검색 문자열", 시작 인덱스)
            // : 문자열에서 "검색 문자열"의 위치(인덱스)를 찾아서 반환
            // 단, 시작 인덱스 이후부터 검색

            const pathname = location.pathname; // 주소상에서 요청 경로 반환
            // /community/board/detail

            // 이동할 주소를 저장
            let url = pathname.substring(0, pathname.indexOf("/", 1));
            // url에 /community가 저장됨

            url += "/board/list?" // /community/board/list?

            // URL 내장 객체 : 주소 관련 정보를 나타내는 객체
            // location.href : 현재 페이지 주소 + 쿼리스트링
            // URL.searchParams : 쿼리 스트링만 별도 객체로 반환
        
            /* http://localhost:8080/community/board/detail?no=1502&cp=1&type=1 에서 */
            /* http://localhost:8080/community/board/list?type=1 으로 */
            const params = new URL(location.href).searchParams;

            const type = "type=" + params.get("type"); // type = 1
            
            let cp; 
            
            if(params.get("cp") != ""){
                cp = "cp=" + params.get("cp"); 
            
            }
            
            if(params.get("cp") == null){ 
                cp = "cp=1"; 
                
            }

            if(params.get("cp") == ""){ 
                cp = "cp=1";
            } 

            // 조립
            // /community/board/list?type=1&cp=1
            url += type + "&" + cp

            // 검색 key, query가 존재하는 경우 url에 추가 (검색을 통한 상세페이지를 들어가서 목록으로 버튼을 눌러 보드리스트로 들어가도 검색결과 리스트로 나오게됨)
            if(params.get("key") != null){
                const key="&key=" + params.get("key");
                const query="&query=" + params.get("query");

                url += key + query;
            }

            // location.href = "주소"; -> 해당 주소로 이동
            location.href = url;

        });

    }

})();

// 즉시 실행 함수 : 성능 up, 변수명 중복 X
(function(){
    const deleteBtn = document.getElementById("deleteBtn"); // 존재하지 않으면 null

    if(deleteBtn != null){ //삭제 버튼이 화면에 존재할 경우
        deleteBtn.addEventListener("click",function(){
            // /community/board/delete?no=1500&  type = 1
            //                 어느 게시글을 삭제할지 / 어느 게시판인지

            let url = "delete"; //상대경로

            // 1) 쿼리 스트링에 존재하는 모든 파라미터만 얻어오기
            const params = new URL(location.href).searchParams;

            // 2) 원하는 파라미터만 얻어와 변수에 저장
            const no = "?no="+params.get("no");//게시글 얻어오기  ?NO=1663
            const type = "&type="+params.get("type");//게시판 종류 얻어오기 &type=1
        
            // 3) url에 필요한 parameter들(쿼리스트링) 전부 저장
            url += no+type;
            
            if(confirm("정말로 삭제하시겠습니까?")){
                location.href=url; //Get방식 요청
            }
        })
    }

})();

// 검색창에 이전 검색기록 반영하기
(function(){
    const select= document.getElementById("search-key");
    const input= document.getElementById("search-query");
    //const option = select.children;
    const option = document.querySelectorAll("#search-key > option");

    if(select != null){ // 검색창 화면이 존재할 때만 코드 적용

        // 현재 주소에서 쿼리스트링(파라미터) 얻어오기
        const params = new URL(location.href).searchParams;

        const key = params.get("key");
        const query = params.get("query");

        input.value = query;

        // option을 반복 접근해서 value와 key와 같으면 selected 속성을 추가
        for(let op of option ){
            if(op.value == key ){
                op.selected = true;
            }
        }

    }


})()

// 검색 유효성 검사(검색어를 입력 했는지 확인)
function searchValidate(){
    
    const input= document.getElementById("search-query");

    if(input.value.trim().length==0){
        input.value="";
        input.focus();
        return false;
    }

    return true;
}
/* 수정 취소 */

    if(document.getElementById("goToPreviousPage") != null){

        document.getElementById("goToPreviousPage").addEventListener("click",function(){
            history.back();
        })
    }





// 검색어 추천 왜 안되지..ㅠ
$(function() {
    $("#search-query").keyup(function() {
  
      const recommendBox = document.querySelector("#suggestion_box");
      
      // invisible을 지워준다.
      recommendBox.classList.remove('invisible');
      const input_name = document.getElementById("#search-query");
      
      // 기존 검색 추천 데이터 지우고, 새로 넣어주기 안 그러면 계속 추가됨
      recommendBox.innerHTML = "";
  
      const suggestedItems = document.createElement('div')
      suggestedItems.id = "suggested_items"
  
      recommendBox.appendChild(suggestedItems);
  
      // item별 리스트
      var items = ['리스트1', '리스트2', '리스트3', '리스트4', '리스트5', '리스트6'];
      
      // for문 돌면서 item 추가
      for (var i in items) {
  
        var player_content = document.createTextNode(items[i]);
        var suggestedItem = document.createElement('div')
        suggestedItem.className = "item"
  
        suggestedItem.addEventListener('click', function(e){
          document.getElementById("search-query").value = this.textContent.split(' ')[0];
        });
  
        suggestedItem.appendChild(player_content);
        suggestedItems.appendChild(suggestedItem);
      }
    })
  })
