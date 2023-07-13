const all = document.getElementById("all"); // 전체 선택 체크박스
const checkList = document.getElementsByName("check");

all.addEventListener("click", function(){
    for(let i = 0 ; i < checkList.length ; i++){
        checkList[i].checked = all.checked;
    }
})

this.addEventListener("click", function(e){
    for(let i = 0 ; i < checkList.length ; i++){

        if(e.target == checkList[i]){

            // 취미가 전부 선택 안되어 있을 시 전체선택 체크박스 해제하기
            if(!this.checked && all.checked){
                // 전체선택이 체크되어 있으면서 현재 클릭한 체크박스가 해제되는 경우 
                all.checked = false;
            }

            // 취미가 전부 선택이 되어 있을 시 전체선택 체크박스 체크하기
            let flag = true;
            for(let j = 0 ; j < checkList.length ; j++){    // 전부 체크됐는지 확인하기위한 for문

                if(!checkList[j].checked){ // 하나라도 체크가 안되어 있을 때
                    flag = false;
                }
            }

            // 전체선택 체크박스가 체크되어 있지 않으면서
            // 취미가 전부 선택이 되어있는 경우
            if (!all.checked && flag){
                all.checked = true;
            }
        }
    }
})