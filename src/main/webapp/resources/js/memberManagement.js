const all = document.getElementById("all"); 
const checkList = document.getElementsByName("checkRow");
const deleteSet = new Set();

all.addEventListener("click", function(){
    for(let i = 0 ; i < checkList.length ; i++){
        checkList[i].checked = all.checked;
    }
});

this.addEventListener("click", function(e){
    for(let i = 0 ; i < checkList.length ; i++){

        if(e.target == checkList[i]){

            if(!this.checked && all.checked){
                all.checked = false;
            }

            let flag = true;
            for(let j = 0 ; j < checkList.length ; j++){   

                if(!checkList[j].checked){ 
                    flag = false;
                }
            }

            if (!all.checked && flag){
                all.checked = true;
            }
        }
    }
});



function searchValidate(){

    if(document.getElementById("mem-search").value.trim().length == 0){
        alert("검색어를 입력해주세요.");
        return false;
    }
    return true;
};



(function(){
    const select = document.getElementById("ctg");

    const input = document.getElementById("mem-search");

    const option = select.children;

    if(select != null){ 

        const params = new URL(location.href).searchParams;

        const ctg = params.get("ctg");
        const search = params.get("search");

        input.value = search;

        // option을 반복 접근해서 value와 key와 같으면 selected 속성 추가
        for(let op of option){
            if(op.value == ctg){
                op.selected = true;
            }
        }

    }

})();

function goToDeleteMember(){
    if(confirm("정말 탈퇴시키겠습니까?")){
        const checkRow = document.getElementsByName("checkRow");
        flag = false;

        for(i = 0 ; i < checkRow.length ; i++){
            if(checkRow[i].checked){
                flag = true;
               /*  deleteSet.add(checkRow[i].value); */
            }
        }
        /* const deleteList = document.getElementById("deleteList");
        deleteList.value = Array.from(deleteSet); */

        if(flag == false){
            alert("하나 이상 선택되어야 삭제 가능합니다.")
            return;
        }

       

        document.memberform.submit();
            
        alert("탈퇴시켰습니다.");
            
        
        
    }
};
