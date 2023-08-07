    // 검색창에 이전 검색기록 반영하기
    (function(){
        const select= document.getElementById("key");
        const input= document.getElementById("h-search");
        //const option = select.children;
        const option = document.querySelectorAll("#key > option");
    
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

function searchResultValidate(){

const input= document.getElementById("h-search");

if(input.value.trim().length==0){
    input.value="";
    input.focus();
    return false;
}

return true;
}